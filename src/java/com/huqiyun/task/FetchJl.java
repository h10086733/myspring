package com.huqiyun.task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.JavaScriptPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.huqiyun.com.CommonEnum;
import com.huqiyun.dto.CBankuaiDTO;
import com.huqiyun.dto.CBankuaiValueDTO;
import com.huqiyun.dto.CBankuaiXishuDTO;
import com.huqiyun.dto.CdapanDTO;
import com.huqiyun.service.ICBankuaiService;
import com.huqiyun.service.ICBankuaiValueService;
import com.huqiyun.service.ICBankuaiXishuService;
import com.huqiyun.service.ICdapanService;
import com.huqiyun.util.DateUtil;
import com.huqiyun.util.StringUtil;

@Component
public class FetchJl {

	@Autowired
	ICdapanService cdapanService;

	@Autowired
	ICBankuaiService cbankuaiService;
	
	@Autowired
	ICBankuaiXishuService cbankuaixishuService;
	
	@Autowired
	ICBankuaiValueService cbankuaiBankuaiValueService;
	
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
	static DecimalFormat    df   = new DecimalFormat("######0.00");   

	public void initGp(String gpdm, String gpName, String hangye, String hangyemc) {
		HtmlPage html = getHtml(
				"http://money.finance.sina.com.cn/corp/go.php/vMS_FuQuanMarketHistory/stockid/" + gpdm + ".phtml");
		List<DomNode> childNodes=new ArrayList<DomNode>();
		String g=gpdm;
		g = getHead(g);
		//判断是否停牌了!!!!!!!
		String s = getJavaScriptPage("http://hq.sinajs.cn/list="+g);
		if(s.split(",").length<3){
			System.out.println(g+"没有获取到数据.股票:"+s);
		}else{
			double current=Double.parseDouble(s.split(",")[1]);
			double c=Double.parseDouble(s.split(",")[3]);
			if(current>0&&c>0){
				childNodes = get20History(gpdm, html);
			}
		}
		CdapanDTO cdapan = new CdapanDTO();
		cdapan.setCDaima(gpdm.trim());
		if(StringUtils.isBlank(gpName)){
			String gpNamePath="//*[@id=\"toolbar\"]/div[1]/h1/a";
			HtmlElement x = html.getFirstByXPath(gpNamePath);
			if(x!=null){
				cdapan.setCName(x.asText());
			}
		}else{
			cdapan.setCName(gpName);
		}
		cdapan.setDeleteTag("1");
		cdapan.setCDate(DateUtil.getDate());
		for (int i = childNodes.size()-1;i>=0;i-- ) {
			if(!childNodes.get(i).getChildNodes().get(3).asText().matches("\\d*\\.?\\d*")){
				childNodes.remove(i);
			}
		}
		if (childNodes.size() < 10) {
			// 未获取到 停牌
			cdapan.setcStatus("2");
		} else {
			for (int i = 0; i < (childNodes.size()>20?20:childNodes.size()); i++) {
				DomNodeList<DomNode> tds = childNodes.get(i).getChildNodes();
				double shoupanjia = Double.parseDouble(tds.get(3).asText());
				String yinzi = tds.get(7).asText();
				double zuigao = cdapan.getC20Zuigao() == null ? 0 : cdapan.getC20Zuigao();
				if (zuigao < shoupanjia) {
					cdapan.setC20Zuigao(shoupanjia);
				}
				double zuidi = cdapan.getC20Zuidi() == null ? 0 : cdapan.getC20Zuidi();
				if (zuidi > shoupanjia) {
					cdapan.setC20Zuidi(shoupanjia);
				}
				if (i == 0) {
					cdapan.setCZuoriYinzi(Double.parseDouble(yinzi));
					cdapan.setCZhishu(shoupanjia);
					cdapan.setC20Zuigao(shoupanjia);
					cdapan.setC20Zuidi(shoupanjia);
				}
			}
			cdapan.setcStatus("1");
		}

		// 先查询是否有该股票数据
		CdapanDTO q = new CdapanDTO();
		q.setCDaima(gpdm);
		q.setDeleteTag("1");
		try {
			CdapanDTO d = cdapanService.queryListGetFirst(q);
			d.setUpdateDate(new Date());
			d.setCDate(DateUtil.getDate());
			if (d.getId() != null) {// 已存在 进行修改
				d.setC20Zuidi(cdapan.getC20Zuidi());
				d.setcStatus(cdapan.getcStatus());
				d.setC20Zuigao(cdapan.getC20Zuigao());
				d.setCZuoriYinzi(cdapan.getCZuoriYinzi());
				d.setCZhishu(cdapan.getCZhishu());
				cdapanService.update(d);
			} else {// 新增
				cdapanService.insert(cdapan);
			}
			if (!StringUtils.isBlank(hangye)) {
				// 该票和该行业是否已经存在
				CBankuaiDTO c = new CBankuaiDTO();
				c.setCBkdm(hangye);
				c.setDeleteTag("1");
				c.setcGupiaoid(gpdm);
				c.setCBkmc(hangyemc);
				CBankuaiDTO bankuai = cbankuaiService.queryListGetFirst(c);
				if (bankuai.getId() == null) {
					cbankuaiService.insert(c);
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
	
	//获取20日历史 
	private List<DomNode> get20History(String gpdm, HtmlPage html) {
		List<DomNode> childNodes=new ArrayList<DomNode>();
		try {
			DomElement table = html.getElementById("FundHoldSharesTable");
			DomElement children = table.getLastElementChild();
			List<DomNode> d = children.getChildNodes();
			for (DomNode domNode : d) {
				childNodes.add(domNode);
			}
		} catch (Exception e) {
		}
		
		if(childNodes.size()<20){
			//计算季度  获取上赛季的数据
			Date s=new Date();
			int month=s.getMonth()+1;
			int year=1900+s.getYear();
			int sj=(int) Math.ceil(month/3.0);
			if(sj==1){
				year--;
				sj=4;
			}else{
				sj--;
			}
			HtmlPage html2 = getHtml(
					"http://money.finance.sina.com.cn/corp/go.php/vMS_FuQuanMarketHistory/stockid/" + gpdm + ".phtml?year="+year+"&jidu="+sj);
			try {
				DomElement table2 = html2.getElementById("FundHoldSharesTable");
				DomElement children2 = table2.getLastElementChild();
				List<DomNode> childNodes2 = children2.getChildNodes();
				for (DomNode domNode : childNodes2) {
					childNodes.add(domNode);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return childNodes;
	}
	/***
	 * 定时更新大盘20日信息 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
//	 @Scheduled(cron="0 5 15 * * ?")
	public void dingshitime() throws FileNotFoundException, IOException, SQLException {
		//所有票代码和名称
		CdapanDTO cdapan = new CdapanDTO();
		cdapan.setDeleteTag("1");
		List<CdapanDTO> queryList = cdapanService.queryList(cdapan);
		for (CdapanDTO cdapanDTO : queryList) {
			// 更新所有票的最新20日数据
			if(cdapanDTO.getCDate().equals(DateUtil.getDate()))continue;
			try {
				initGp(cdapanDTO.getCDaima(), cdapanDTO.getCName(), "", "");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/***
	 * 定时更新最新日的20日 最高最低值
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
//	 @Scheduled(cron="0 5 15 * * ?")
	public void getFirstDpan() throws FileNotFoundException, IOException, SQLException {
		//所有票代码和名称
		CdapanDTO cdapan = new CdapanDTO();
		cdapan.setDeleteTag("1");
		List<CdapanDTO> queryList = cdapanService.queryList(cdapan);
		String date=DateUtil.getDate();
		for (CdapanDTO cdapanDTO : queryList) {
			// 更新所有票的最新20日数据
			if(cdapanDTO.getCDate().equals(date))continue;
			if(cdapanDTO.getcStatus().equals("2")){
				//停牌需要重新获取下
				try {
					initGp(cdapanDTO.getCDaima(), cdapanDTO.getCName(), "", "");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				String g=cdapanDTO.getCDaima();
				g = getHead(g);
				String s = getJavaScriptPage("http://hq.sinajs.cn/list="+g);
				if(s.split(",").length<3){
					System.out.println(g+"没有获取到数据.股票:"+s);
					continue;
				}
				String cdate=StringUtil.fecth(s, ".*?(\\d{4}-\\d{2}-\\d{2}),", 1).replace("-","");
				if(!cdate.equals(date)){
					//当前价格非今天价格。代表今日并非交易日,结束当日
					System.out.println(date+"当前并非股票交易日,上一个交易日："+cdate);
					break;
				}
				cdapanDTO.setCDate(date);
				double current=Double.parseDouble(s.split(",")[3]);
				if(current==0){
					System.out.println("停牌中.股票:"+g);
					cdapanDTO.setcStatus("2");
					cdapanService.update(cdapanDTO);
					continue;
				}
				//当前复权因子    需要定时更新复权因子
				double yinzi =cdapanDTO.getCZuoriYinzi()==null?0:cdapanDTO.getCZuoriYinzi();
				//复权后价格
				double d=yinzi==0?current:Double.parseDouble(df.format(current*yinzi));
				Double c20Zuidi = cdapanDTO.getC20Zuidi();
				if(c20Zuidi>d){
					cdapanDTO.setC20Zuidi(current);
				}
				Double c20Zuigao = cdapanDTO.getC20Zuigao();
				if(c20Zuigao<d){
					cdapanDTO.setC20Zuigao(current);
				}
				cdapanDTO.setCZhishu(current);
				cdapanService.update(cdapanDTO);
			}
		}
	}

	private String getHead(String g) {
		if(g.matches("^6.*")){
			g="sh"+g;
		}else if(g.matches("^(300|002|000|001|301).*")){
			g="sz"+g;
		}
		return g;
	}
	 /***
	 * 定时更新每日行业系数
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	 @Scheduled(cron="0 05 15 * * ?")
	public void dingshiFetchAllXs(){
		Map<String, String> hm = CommonEnum.hm;
		for (Entry<String, String> set : hm.entrySet()) {
			try {
				String key=set.getKey();
				CBankuaiXishuDTO cBankuaiXishu=new CBankuaiXishuDTO();
				cBankuaiXishu.setBankuaiDaima(key);
				cBankuaiXishu.setDeleteTag("1");
				cBankuaiXishu.setCDate(DateUtil.getDate());
				//查询当前是否存在
				List<CBankuaiXishuDTO> queryList = cbankuaixishuService.queryList(cBankuaiXishu);
				if(queryList.size()==0){
					int xs=getXishu(set.getValue().split(","));
					cBankuaiXishu.setCValue(xs);
					cBankuaiXishu.setBankuaiName(CommonEnum.hmName.get(key));
					cbankuaixishuService.insert(cBankuaiXishu);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	 /***
		 * 打印全部系数
		 * @throws FileNotFoundException
		 * @throws IOException
		 * @throws SQLException
		 */
	 @Scheduled(cron="0 40 11 * * ?")
	public void gengxin20ri(){
		ExecutorService es=Executors.newFixedThreadPool(5);
		Map<String, String> hm = CommonEnum.hm;
		for (final Entry<String, String> set : hm.entrySet()) {
			es.execute(new Runnable() {
				@Override
				public void run() {
					getXishu(set.getValue().split(","));
				}
			});
		}
	}
	 /***
		 * 每日收盘收录行业系数收盘价格
		 * @throws FileNotFoundException
		 * @throws IOException
		 * @throws SQLException
		 */
	 @Scheduled(cron="0 05 15 * * ?")
	public void hangyeshoupanjia(){
		Map<String, String> hm = CommonEnum.hmCode;
		for (Entry<String, String> set : hm.entrySet()) {
			String key = set.getKey();//jg
			String value = set.getValue();//399967
			String date = DateUtil.getDate();
			try {
				CBankuaiValueDTO cBankuaiValue=new CBankuaiValueDTO();
				cBankuaiValue.setBankuaiDaima(value);
				cBankuaiValue.setBankuaiJiancheng(CommonEnum.hmName.get(key));
				cBankuaiValue.setBankuaiName(key);
				cBankuaiValue.setDeleteTag("1");
				cBankuaiValue.setCDate(date);
				CBankuaiValueDTO f = cbankuaiBankuaiValueService.queryListGetFirst(cBankuaiValue);
				if(f==null){
					String s = getJavaScriptPage("http://hq.sinajs.cn/list=sz"+value);
					if(s.split(",").length<3){
						System.out.println(key+"...没有获取到数据.股票:"+s);
						continue;
					}
					double current=Double.parseDouble(s.split(",")[3]);
					cBankuaiValue.setBankuaiShoupanjia(current+"");
					cbankuaiBankuaiValueService.insert(cBankuaiValue);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	 //李鹏提供所有A股信息
	public void dingshitime2() throws FileNotFoundException, IOException {
		List<String> list = IOUtils.readLines(new FileInputStream("D:\\指数\\20161227所有a股.csv"), "gbk");
		for (int i = list.size() - 1; i > 1; i--) {
			String[] gp = list.get(i).split(",");
			System.out.println(gp[1].replace("'", "") + "=" + gp[2]);
			try {
				initGp(gp[1].replace("'", ""), gp[2], "", "");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/***
	 * 票所属行业
	 * 
	 * @throws SQLException
	 */
	public String fetchCurrentXs(String type) throws SQLException {
		String allGp = CommonEnum.hm.get(type);
		if(StringUtils.isBlank(allGp)){
			return "暂时不支持该函数";
		}
		String[] p=allGp.split(",");
		return sdf.format(new Date())+"当前行业系数为:"+getXishu(p);
	}
	
	/**
	 * 得到系数
	 * @param gpList
	 * @return
	 */
	public int getXishu(String[] gpList) {
		int sum=0;
		int h=0;
		int l=0;
		int o=0;
		for (int i = 0; i < gpList.length; i++) {
			String g=gpList[i].trim();
			g=g.replaceAll("\\D","");
			CdapanDTO cdapan = new CdapanDTO();
			cdapan.setDeleteTag("1");
			cdapan.setCDaima(g);
			
			CdapanDTO c=new CdapanDTO();
			try {
				c = cdapanService.queryListGetFirst(cdapan);
			} catch (SQLException e) {
			}
			if(c.getId()==null){
				System.out.println("cdapan 不存在该票，进行存储!!!!"+g);
				try {
					initGp(g,"", "", "");
					c = cdapanService.queryListGetFirst(cdapan);
				} catch (Exception e) {
				}
				if(c.getId()==null){
					//存储失败
					System.out.println("cdapan 存储失败!!!!"+g);
					continue;
				}
			}else if(!c.getCDate().equals(DateUtil.getDate())){
				try {
					initGp(g,"", "", "");
					c = cdapanService.queryListGetFirst(cdapan);
				} catch (Exception e) {
				}
				if(c.getId()==null){
					//存储失败
					System.out.println("cdapan 存储失败!!!!"+g);
					continue;
				}
			}
			if(c.getcStatus().equals("2")){
				System.out.println("停牌中.股票:"+g);
				continue;
			}
			g = getHead(g);
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
			}
			String s = getJavaScriptPage("http://hq.sinajs.cn/list="+g);
			if(s.split(",").length<3){
				System.out.println(g+"没有获取到数据.股票:"+s);
				continue;
			}
			double current=Double.parseDouble(s.split(",")[3]);
			if(current==0){
				System.out.println("停牌中.股票:"+g);
				continue;
			}
			double zuigao = c.getC20Zuigao();
			double zuidi =c.getC20Zuidi();
			double yinzi =c.getCZuoriYinzi()==null?0:c.getCZuoriYinzi();
			double d=yinzi==0?current:Double.parseDouble(df.format(current*yinzi));
			System.out.println("current:"+current+",复权后:"+d+",最高:"+zuigao+",最低:"+zuidi+"，股票代码:"+g+",因子:"+yinzi);
			if(d>zuigao){
				++sum;
				++h;
				System.out.println("当前股票:"+g+"新高");
			}else if(d<zuidi){
				--sum;
				++l;
				System.out.println("当前股票:"+g+"新低");
			}else{
				o++;
			}
		}
		System.out.println("新高:"+h+"，新低:"+l);
		return sum;
	}
	
	/**
	 * 获得Html 页面
	 * 
	 * @param url
	 *            链接
	 * @return
	 * @throws IOException
	 * @throws MalformedURLException
	 * @throws FailingHttpStatusCodeException
	 * @throws IOException
	 *             流异常
	 * @throws UnsupportedEncodingException
	 *             不支持的编码
	 * @throws ParserException
	 *             转换成XML结构异常
	 */
	public static HtmlPage getHtml(String url) {
		try {
			WebClient client = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
			initClient(client);
			return (HtmlPage) client.getPage(url);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获得Html 页面
	 * @param url 链接
	 * @return
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws FailingHttpStatusCodeException 
	 * @throws IOException 流异常
	 * @throws UnsupportedEncodingException 不支持的编码
	 * @throws ParserException 转换成XML结构异常
	 */
	public static String getJavaScriptPage(String url) {
		try {
			WebClient client  = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
			initClient(client);  
			return ((JavaScriptPage)client.getPage(url)).getContent();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void initClient(WebClient client) {
		client.getOptions().setThrowExceptionOnScriptError(false); // js运行错误时，是否抛出异常
		client.getOptions().setUseInsecureSSL(true);
		client.getOptions().setJavaScriptEnabled(true);
		client.getOptions().setThrowExceptionOnFailingStatusCode(false);
		client.getOptions().setCssEnabled(false);
		client.getOptions().setRedirectEnabled(true);
		client.getOptions().setActiveXNative(false);
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");   
		java.util.logging.Logger.getLogger("net.sourceforge.htmlunit").setLevel(java.util.logging.Level.OFF);
		 java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(java.util.logging.Level.OFF);
		 org.apache.log4j.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(org.apache.log4j.Level.FATAL);
		 java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.SEVERE);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//计算当前季度
		Date s=new Date();
		int month=s.getMonth()+1;
		int year=s.getYear();
		int sj=(int) Math.ceil(month/3.0);
		if(sj==1){
			year--;
			sj=4;
		}else{
			sj--;
		}
		
		System.out.println(1900+year+"=="+sj);
		System.out.println("sz200 00".replaceAll("\\D",""));
		HtmlPage html = getHtml(
				"http://money.finance.sina.com.cn/corp/go.php/vMS_FuQuanMarketHistory/stockid/" + 002707 + ".phtml");
		
		HtmlElement xcurrent =html.getFirstByXPath("//*[@id=\"itemCurrent\"]");
		List<DomNode> childNodes=new ArrayList<DomNode>();
		System.out.println(xcurrent.asText());
	}
}
