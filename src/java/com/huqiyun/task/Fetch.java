package com.huqiyun.task;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.io.IOUtils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.JavaScriptPage;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Fetch {
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
	static DecimalFormat    df   = new DecimalFormat("######0.00");   
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		Map<String,String> hm=new HashMap<String, String>();
		//军工
		String jungong="sz000519,sz000547,sz000561,sz000733,sz000738,sz000748,sz000768,sz000801,sz000901,sz002013,sz002023,sz002025,sz002049,sz002111,sz002151,sz002179,sz002214,sz002253,sz002260,sz002268,sz002338,sz002368,sz002413,sz002414,sz002465,sz002519,sz002544,sz300008,sz300034,sz300045,sz300053,sz300065,sz300101,sz300114,sz300123,sz300159,sz300177,sz300252,sz300324,sz300354,sz300447,sz300474,sh600038,sh600118,sh600150,sh600151,sh600184,sh600316,sh600343,sh600372,sh600391,sh600435,sh600480,sh600501,sh600523,sh600562,sh600677,sh600685,sh600765,sh600855,sh600879,sh600893,sh600967,sh600990,sh601989,sh603678";
		hm.put("军工", jungong);
		//新能车
		String xinnengche="000400, 000541, 000559, 000762, 000868, 000957, 002012, 002056, 002070, 002074, 002091, 002108, 002176, 002179, 002196, 002227, 002245, 002249, 002276, 002284, 002335, 002340, 002358, 002364, 002389, 002407, 002418, 002454, 002460, 002466, 002484, 002518, 002533, 002580, 002594, 002600, 002664, 002709, 300001, 300014, 300037, 300048, 300073, 300100, 300124, 300141, 300198, 300207, 300224, 300376, 300491, 600006, 600066, 600114, 600151, 600166, 600220, 600237, 600366, 600386, 600405, 600418, 600478, 600482, 600563, 600580, 600680, 600686, 600699, 600773, 600846, 600869, 600884, 601126, 601311, 601777, 603766, 603799";
		hm.put("新能车", xinnengche);
		//中证汽车
		String zzqiche="000025, 000559, 000572, 000581, 000599, 000625, 000700, 000753, 000757, 000760, 000800, 000868, 000957, 000980, 000996, 001696, 002031, 002048, 002085, 002126, 002190, 002213, 002239, 002265, 002283, 002284, 002328, 002355, 002363, 002406, 002434, 002448, 002454, 002472, 002488, 002510, 002536, 002537, 002553, 002590, 002592, 002593, 002594, 002602, 002607, 002625, 002662, 002664, 002703, 002708, 002765, 300022, 300100, 300304, 300432, 300473, 300507, 600006, 600066, 600081, 600104, 600148, 600166, 600178, 600297, 600303, 600335, 600386, 600418, 600480, 600523, 600623, 600653, 600660, 600676, 600686, 600699, 600741, 600742, 600877, 600960, 601058, 601127, 601258, 601311, 601633, 601689, 601777, 601799, 601966, 603023, 603701, 603766, 603997";
		hm.put("中证汽车", zzqiche);
		//中证传媒
		String zzchuanmei="000156, 000503, 000681, 000793, 000839, 000917, 002027, 002095, 002123, 002131, 002174, 002195, 002261, 002343, 002354, 002400, 002439, 002517, 002555, 002624, 002739, 300017, 300027, 300058, 300059, 300104, 300113, 300133, 300251, 300291, 300315, 300336, 300359, 300364, 300383, 300418, 300431, 600037, 600373, 600633, 600637, 600715, 600804, 600959, 600986, 601098, 601801, 601928, 601929, 603000";
		hm.put("中证传媒", zzchuanmei);
		//移动互联
		String yidonghulian="000050, 000555, 000558, 000793, 000829, 000861, 000887, 000901, 000977, 000988, 000997, 002008, 002024, 002055, 002065, 002131, 002153, 002174, 002195, 002223, 002230, 002241, 002261, 002266, 002268, 002273, 002279, 002284, 002308, 002325, 002326, 002344, 002373, 002405, 002414, 002416, 002429, 002439, 002444, 002446, 002456, 002467, 002477, 002488, 002491, 002642, 002701, 002707, 002739, 300003, 300010, 300015, 300017, 300088, 300098, 300100, 300113, 300133, 300136, 300166, 300168, 300178, 300188, 300212, 300222, 300229, 300253, 300271, 300273, 300287, 300291, 300296, 300302, 300336, 300359, 300367, 300369, 300392, 300458, 600037, 600074, 600158, 600270, 600271, 600335, 600373, 600487, 600498, 600570, 600588, 600699, 600703, 600718, 600804, 600845, 600978, 600998, 601098, 601801, 603000";
		hm.put("移动互联", yidonghulian);
		//创业成长
		String cycz="000005, 000018, 000034, 000036, 000150, 000546, 000796, 000836, 000928, 000957, 002019, 002027, 002036, 002071, 002074, 002085, 002099, 002107, 002169, 002172, 002174, 002179, 002180, 002202, 002221, 002252, 002270, 002314, 002323, 002354, 002357, 002373, 002411, 002415, 002426, 002450, 002460, 002466, 002475, 002504, 002508, 002517, 002555, 002572, 002573, 002579, 002581, 002594, 002602, 002624, 002635, 002640, 002643, 002709, 002714, 300017, 300023, 300032, 300033, 300059, 300072, 300085, 300100, 300104, 300113, 300115, 300118, 300131, 300136, 300144, 300156, 300182, 300199, 300207, 300208, 300219, 300237, 300252, 300253, 300267, 300292, 300296, 300302, 300317, 300319, 300324, 300367, 300376, 300431, 300450, 300484, 300498, 600093, 600113, 600131, 600273, 600779, 600856, 600891, 603006";
		hm.put("创业成长", cycz);
		//工业4.0
		String gy40="000821, 000961, 000988, 000997, 002008, 002009, 002073, 002161, 002184, 002185, 002224, 002230, 002232, 002367, 002380, 002426, 002472, 002527, 002529, 002559, 002577, 002698, 002721, 002747, 300024, 300034, 300048, 300076, 300097, 300115, 300124, 300161, 300170, 300171, 300173, 300221, 300223, 300293, 300337, 300358, 300367, 300400, 600172, 600588, 600699, 600765, 600835, 600845";
		hm.put("工业4.0", gy40);
		//申万证券
		String swzq="000166, 000686, 000712, 000728, 000750, 000776, 000783, 002500, 002673, 002736, 002797, 600030, 600061, 600109, 600369, 600837, 600958, 600999, 601099, 601198, 601211, 601377, 601555, 601688, 601788, 601901";
		hm.put("申万证券", swzq);
		//申万电子
		String swdz="000049, 000050, 000413, 000536, 000541, 000636, 000725, 000727, 000988, 002005, 002008, 002025, 002036, 002049, 002055, 002056, 002079, 002106, 002129, 002137, 002138, 002141, 002156, 002161, 002179, 002180, 002185, 002188, 002217, 002241, 002273, 002288, 002371, 002384, 002389, 002402, 002414, 002436, 002456, 002463, 002475, 002484, 002547, 002618, 002635, 002636, 002638, 002782, 300032, 300053, 300077, 300078, 300083, 300088, 300115, 300128, 300131, 300136, 300162, 300183, 300207, 300219, 300256, 300269, 300296, 300317, 300322, 300373, 300408, 300433, 300438, 300458, 300476, 300502, 300516, 600074, 600171, 600183, 600360, 600363, 600460, 600563, 600584, 600651, 600666, 600667, 600703, 600707, 601231, 603005, 603328, 603989";
		hm.put("申万电子", swdz);
		//申万高铁
		String swgt="000008, 000796, 000925, 002122, 002152, 002161, 002296, 002376, 002421, 002480, 002501, 300001, 300011, 300041, 300044, 300177, 300213, 300351, 300367, 300411, 300440, 300455, 300462, 600169, 600219, 600458, 600495, 600528, 600580, 600820, 600967, 601002, 601186, 601390, 601668, 601766, 601800, 603111, 603508";
		hm.put("申万高铁", swgt);
		
		//中证1000    1000只股票
//		String zzyiqian="000005, 000010, 000011, 000014, 000016, 000018, 000022, 000029, 000034, 000035, 000036, 000038, 000040, 000042, 000043, 000048, 000055, 000058, 000059, 000065, 000070, 000096, 000150, 000151, 000159, 000404, 000407, 000409, 000410, 000416, 000419, 000428, 000498, 000506, 000514, 000516, 000518, 000520, 000523, 000531, 000532, 000533, 000536, 000537, 000545, 000546, 000548, 000551, 000553, 000554, 000561, 000564, 000570, 000571, 000573, 000576, 000584, 000591, 000601, 000603, 000607, 000626, 000637, 000650, 000657, 000665, 000666, 000673, 000676, 000682, 000683, 000687, 000688, 000700, 000701, 000705, 000722, 000731, 000733, 000735, 000739, 000751, 000752, 000757, 000760, 000766, 000767, 000782, 000789, 000790, 000795, 000796, 000797, 000801, 000802, 000807, 000811, 000819, 000821, 000828, 000836, 000837, 000838, 000851, 000863, 000868, 000875, 000882, 000885, 000886, 000889, 000893, 000899, 000901, 000902, 000905, 000909, 000910, 000915, 000918, 000920, 000922, 000925, 000928, 000932, 000936, 000948, 000952, 000957, 000958, 000965, 000966, 000971, 000987, 000989, 000990, 000996, 001896, 002009, 002016, 002017, 002020, 002021, 002023, 002031, 002033, 002036, 002037, 002042, 002043, 002047, 002055, 002060, 002062, 002067, 002070, 002071, 002079, 002080, 002086, 002089, 002090, 002091, 002094, 002095, 002097, 002099, 002100, 002102, 002103, 002104, 002107, 002108, 002111, 002114, 002115, 002117, 002121, 002124, 002126, 002130, 002135, 002137, 002138, 002139, 002141, 002144, 002145, 002147, 002148, 002151, 002154, 002156, 002157, 002162, 002166, 002167, 002170, 002171, 002172, 002177, 002178, 002182, 002184, 002185, 002188, 002192, 002196, 002197, 002198, 002203, 002206, 002212, 002214, 002215, 002218, 002222, 002224, 002226, 002227, 002228, 002229, 002231, 002232, 002234, 002235, 002239, 002245, 002246, 002247, 002253, 002255, 002256, 002259, 002260, 002262, 002263, 002270, 002274, 002279, 002283, 002284, 002287, 002288, 002296, 002298, 002301, 002302, 002303, 002307, 002313, 002314, 002318, 002320, 002321, 002322, 002323, 002324, 002326, 002328, 002329, 002331, 002334, 002335, 002337, 002338, 002339, 002341, 002343, 002346, 002348, 002349, 002351, 002355, 002356, 002359, 002362, 002363, 002364, 002367, 002369, 002372, 002376, 002378, 002380, 002381, 002383, 002387, 002388, 002389, 002393, 002401, 002402, 002406, 002411, 002413, 002418, 002421, 002425, 002427, 002429, 002432, 002433, 002434, 002436, 002438, 002441, 002443, 002445, 002446, 002447, 002448, 002449, 002451, 002452, 002453, 002454, 002457, 002462, 002464, 002467, 002468, 002471, 002472, 002474, 002476, 002481, 002483, 002484, 002487, 002488, 002494, 002496, 002497, 002499, 002501, 002502, 002504, 002509, 002510, 002511, 002515, 002516, 002518, 002519, 002520, 002521, 002522, 002524, 002527, 002528, 002529, 002531, 002535, 002537, 002538, 002539, 002540, 002542, 002543, 002546, 002547, 002550, 002554, 002556, 002559, 002564, 002565, 002567, 002570, 002571, 002574, 002575, 002577, 002579, 002583, 002584, 002585, 002586, 002590, 002592, 002596, 002597, 002600, 002601, 002604, 002605, 002606, 002609, 002610, 002611, 002612, 002614, 002617, 002618, 002619, 002622, 002625, 002626, 002630, 002631, 002636, 002638, 002643, 002644, 002649, 002650, 002651, 002655, 002658, 002660, 002662, 002664, 002666, 002667, 002668, 002670, 002671, 002675, 002677, 002684, 002689, 002697, 002703, 002709, 002711, 002712, 002713, 002716, 002717, 002721, 002724, 002726, 002733, 002737, 002741, 002747, 002750, 002751, 002752, 002756, 002762, 002763, 002769, 002771, 002772, 002777, 002781, 002782, 002783, 002786, 002788, 002790, 002791, 002792, 002801, 002802, 300004, 300005, 300006, 300007, 300008, 300009, 300011, 300012, 300014, 300016, 300018, 300020, 300021, 300028, 300030, 300031, 300034, 300036, 300037, 300038, 300041, 300044, 300045, 300047, 300048, 300049, 300050, 300051, 300052, 300053, 300054, 300056, 300063, 300064, 300065, 300066, 300068, 300071, 300073, 300074, 300075, 300076, 300077, 300078, 300079, 300083, 300084, 300086, 300090, 300096, 300098, 300100, 300101, 300102, 300109, 300110, 300111, 300114, 300118, 300119, 300128, 300130, 300131, 300135, 300137, 300139, 300140, 300142, 300148, 300149, 300151, 300152, 300155, 300157, 300160, 300162, 300165, 300170, 300171, 300172, 300173, 300175, 300177, 300178, 300181, 300183, 300185, 300187, 300188, 300190, 300191, 300193, 300195, 300197, 300198, 300203, 300204, 300205, 300206, 300207, 300208, 300209, 300212, 300213, 300215, 300216, 300217, 300219, 300221, 300222, 300223, 300224, 300226, 300227, 300228, 300229, 300231, 300232, 300236, 300237, 300238, 300245, 300246, 300248, 300252, 300254, 300255, 300256, 300262, 300263, 300269, 300271, 300276, 300278, 300284, 300285, 300288, 300292, 300293, 300294, 300295, 300298, 300300, 300302, 300303, 300307, 300309, 300310, 300311, 300312, 300314, 300316, 300317, 300318, 300322, 300326, 300328, 300332, 300333, 300334, 300336, 300337, 300339, 300342, 300343, 300347, 300348, 300349, 300350, 300351, 300352, 300353, 300355, 300356, 300358, 300359, 300360, 300363, 300364, 300366, 300367, 300368, 300369, 300373, 300376, 300377, 300378, 300379, 300380, 300381, 300383, 300384, 300386, 300388, 300389, 300392, 300399, 300403, 300406, 300409, 300413, 300419, 300424, 300426, 300429, 300431, 300432, 300436, 300438, 300439, 300440, 300443, 300444, 300447, 300448, 300449, 300450, 300451, 300456, 300457, 300458, 300463, 300465, 300467, 300468, 300471, 300473, 300474, 300476, 300482, 300484, 300485, 300494, 300495, 300496, 300497, 300502, 300506, 300507, 300508, 300511, 300512, 300516, 300518, 300519, 300520, 300522, 300523, 600007, 600012, 600020, 600033, 600035, 600052, 600055, 600057, 600063, 600072, 600077, 600080, 600081, 600082, 600084, 600090, 600093, 600096, 600101, 600105, 600106, 600107, 600110, 600113, 600114, 600116, 600119, 600123, 600126, 600128, 600129, 600130, 600133, 600135, 600136, 600149, 600159, 600162, 600165, 600168, 600172, 600173, 600185, 600186, 600190, 600191, 600192, 600193, 600197, 600206, 600207, 600209, 600210, 600218, 600226, 600227, 600229, 600237, 600238, 600239, 600246, 600255, 600257, 600261, 600269, 600273, 600278, 600279, 600283, 600285, 600287, 600288, 600290, 600303, 600310, 600313, 600318, 600321, 600322, 600323, 600326, 600330, 600331, 600336, 600343, 600354, 600359, 600360, 600363, 600382, 600386, 600391, 600396, 600399, 600400, 600401, 600405, 600420, 600438, 600439, 600449, 600459, 600467, 600470, 600477, 600480, 600486, 600490, 600491, 600495, 600501, 600502, 600508, 600515, 600523, 600526, 600527, 600530, 600531, 600533, 600548, 600550, 600552, 600555, 600559, 600560, 600562, 600567, 600568, 600571, 600577, 600589, 600590, 600592, 600595, 600602, 600604, 600613, 600616, 600620, 600621, 600622, 600624, 600626, 600629, 600630, 600634, 600638, 600641, 600650, 600652, 600653, 600658, 600661, 600662, 600667, 600668, 600676, 600677, 600680, 600683, 600684, 600686, 600692, 600707, 600708, 600711, 600713, 600716, 600724, 600726, 600728, 600730, 600735, 600738, 600740, 600742, 600744, 600745, 600756, 600763, 600767, 600771, 600775, 600777, 600782, 600784, 600789, 600794, 600798, 600800, 600807, 600814, 600818, 600824, 600830, 600834, 600836, 600838, 600843, 600845, 600846, 600848, 600855, 600856, 600865, 600868, 600876, 600877, 600885, 600963, 600965, 600973, 600986, 600987, 600988, 600990, 600995, 601007, 601011, 601015, 601020, 601028, 601038, 601058, 601069, 601107, 601199, 601218, 601222, 601339, 601368, 601388, 601566, 601588, 601599, 601636, 601700, 601789, 601799, 601890, 601968, 603008, 603012, 603020, 603026, 603100, 603108, 603111, 603116, 603117, 603118, 603126, 603128, 603166, 603168, 603227, 603299, 603308, 603309, 603338, 603339, 603368, 603398, 603456, 603508, 603566, 603588, 603599, 603600, 603609, 603618, 603636, 603669, 603678, 603686, 603718, 603737, 603779, 603789, 603799, 603800, 603808, 603818, 603861, 603898, 603936, 603939, 603958, 603959, 603979, 603989, 603996, 603997, 603999";
//		hm.put("zzyiqian", zzyiqian);
		
		for(Entry<String, String> en: hm.entrySet() ){
			final String path=en.getKey();
			final String dm=en.getValue();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						toalCount(dm, path);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
	}
	//15分钟数据
	static Map<String,TreeMap<String,Integer>> shiwu=new  HashMap<String,TreeMap<String,Integer>>(); 
	
	//统计板块的新高新低  
	public static void toalCount(String jg,String saveDateFile) throws IOException,
			FileNotFoundException, InterruptedException {
		String[] jgList = jg.split(",");
		//得到行业的数据
		Map<String,Map<String,Double>> map=new HashMap<String,Map<String,Double>>();
		//军工
		for (String s : jgList) {
			s=s.replaceAll("sh|sz| ", "");
			//初始化股票最高最低点
			initGp(s,map);
		}
//		String mp="{'600677'={zuigao=128.893, yinzi=6.72, zuidi=112.227}, '002414'={zuigao=54.773, yinzi=2.109, zuidi=46.337}, '002413'={zuigao=65.775, yinzi=4.931, zuidi=56.505}, 600343={zuigao=78.708, yinzi=3.038, zuidi=65.98}, '002519'={zuigao=158.653, yinzi=6.706, zuidi=145.175}, 600990={zuigao=204.462, yinzi=2.658, zuidi=180.463}, '000901'={zuigao=128.416, yinzi=3.63, zuidi=113.897}, 600184={zuigao=73.101, yinzi=3.171, zuidi=65.331}, '000561'={zuigao=34.607, yinzi=2.562, zuidi=30.176}, '002179'={zuigao=175.152, yinzi=4.547, zuidi=166.331}, 603678={zuigao=89.529, yinzi=1.006, zuidi=74.938}, 300159={zuigao=305.338, yinzi=18.218, zuidi=280.197}, 300053={zuigao=84.461, yinzi=5.106, zuidi=72.104}, 300252={zuigao=131.973, yinzi=3.771, zuidi=114.779}, 300447={zuigao=116.372, yinzi=2.004, zuidi=88.021}, 600893={zuigao=124.502, yinzi=3.553, zuidi=114.233}, '002544'={zuigao=194.511, yinzi=6.234, zuidi=179.86}, 600435={zuigao=203.414, yinzi=13.409, zuidi=175.925}, 300114={zuigao=107.744, yinzi=3.89, zuidi=88.49}, 600685={zuigao=65.186, yinzi=2.021, zuidi=55.807}, '002253'={zuigao=116.242, yinzi=3.71, zuidi=90.53}, '000768'={zuigao=186.858, yinzi=8.286, zuidi=170.699}, 300354={zuigao=91.18, yinzi=3.189, zuidi=74.309}, '000738'={zuigao=48.434, yinzi=1.805, zuidi=42.461}, 600855={zuigao=47.178, yinzi=1.601, zuidi=45.961}, 600372={zuigao=58.412, yinzi=2.974, zuidi=54.397}, '002214'={zuigao=52.741, yinzi=4.153, zuidi=45.847}, '000733'={zuigao=42.433, yinzi=2.181, zuidi=37.505}, 300177={zuigao=122.543, yinzi=8.137, zuidi=105.862}, 600523={zuigao=33.941, yinzi=1.384, zuidi=28.723}, 300045={zuigao=130.831, yinzi=8.162, zuidi=114.426}, '002260'={zuigao=58.17, yinzi=2.31, zuidi=53.365}, 600038={zuigao=138.755, yinzi=2.989, zuidi=129.848}, 601989={zuigao=12.837, yinzi=1.678, zuidi=11.495}, 300474={zuigao=130.199, yinzi=2.003, zuidi=104.861}, 600765={zuigao=139.912, yinzi=8.838, zuidi=127.538}, '002023'={zuigao=161.162, yinzi=10.117, zuidi=136.679}, 300101={zuigao=184.976, yinzi=8.152, zuidi=155.057}, 300324={zuigao=368.028, yinzi= 16.401, zuidi=324.075}, '002368'={zuigao=136.359, yinzi=3.762, zuidi=116.648}, '002465'={zuigao=81.474, yinzi=6.487, zuidi=74.208}, 300034={zuigao=77.052, yinzi=3.626, zuidi=66.138}, 600562={zuigao=175.302, yinzi=5.231, zuidi=155.894}, '002268'={zuigao=182.106, yinzi=5.288, zuidi=166.084}, '002013'={zuigao=244.95, yinzi=12.825, zuidi=224.301}, 600967={zuigao=72.287, yinzi=5.197, zuidi=65.895}, 600391={zuigao=92.227, yinzi=2.359, zuidi=80.292}, 600316={zuigao=108.42, yinzi=5.37, zuidi=97.465}, '002338'={zuigao=87.702, yinzi=1.6, zuidi=83.061}, '002049'={zuigao=158.448, yinzi=4.385, zuidi=137.091}, 600118={zuigao=555.21, yinzi=16.485, zuidi=515.976}, '002111'={zuigao=80.186, yinzi=3.235, zuidi=69.867}, 600879={zuigao=296.206, yinzi=18.251, zuidi=268.466}, 600150={zuigao=95.595, yinzi=3.292, zuidi=76.898}, 600151={zuigao=53.328, yinzi=4.719, zuidi=50.874}, '000801'={zuigao=163.184, yinzi=14.34, zuidi=141.961}, '000519'={zuigao=118.184, yinzi=8.062, zuidi=105.366}, 600501={zuigao=90.371, yinzi=4.727, zuidi= 80.918}, '002151'={zuigao=185.166, yinzi=5.795, zuidi=179.428}, 300008={zuigao=117.221, yinzi=4.563, zuidi=94.726}, 300065={zuigao=148.781, yinzi=3.862, zuidi=141.597}}";
//		JSONObject  jasonObject = JSONObject.fromObject(mp);
//		Map<String,Map<String,Double>> map=(Map<String,Map<String,Double>>)jasonObject;
		//读取前面的历史均值
		File file = new File("D://指数/"+saveDateFile+".csv");
		if(!file.exists()){
			file.createNewFile();
		}
		int old = oldAVG(file);//历史系数均值
		Date date = new Date();//当日的收盘时间
		date.setHours(15);
		date.setMinutes(0);
		date.setSeconds(0);
		//需要定时
		int sum = 0;
		do{
			Thread.sleep(900000);
			sum = getXishu(map);
			String x = saveDateFile+sdf.format(new Date());
			if(sum>0){
				System.err.println("行业板块:"+x+"当前系数："+sum+",三天系数均值:"+df.format((old+sum)/4));
				
			}else{
				System.out.println("行业板块:"+x+"当前系数："+sum+",三天系数均值:"+df.format((old+sum)/4));
			}
			
			if(shiwu.get(jg)==null||shiwu.get(jg).isEmpty()){
				shiwu.put(jg,new TreeMap<String,Integer>());
			}
			Map<String, Integer> map2 = shiwu.get(jg);
			map2.put(x, sum);
			
		}while(new Date().before(date));
		//3点后    保存当日sum的数据到本地
		System.out.println(sdf.format(date)+"当日收盘的系数为:"+sum);
		System.out.println(map);
		FileWriter fw=new FileWriter(file,true);
		fw.append(sdf.format(date)+","+sum+"\n");
		fw.flush();
		fw.close();
	}
	//3日前均价
	public static int oldAVG(File file) throws IOException,
			FileNotFoundException {
		List<String> readLines = IOUtils.readLines(new FileInputStream(file));
		int old=0;
		if(readLines.size()>3){
			for (int i = readLines.size()-1; i < readLines.size()-4; i--) {
				double current=Double.parseDouble(readLines.get(i).split(",")[1]);
				old+=current;
			}
		}
		return old;
	}
	public static int getXishu(Map<String, Map<String, Double>> map) {
		int sum=0;
		int h=0;
		int l=0;
		int o=0;
		for(Entry<String, Map<String,Double>> entry:map.entrySet()){
			//得到实时价格
			String g = entry.getKey();
			if(g.matches("^6.*")){
				g="sh"+g;
			}else if(g.matches("^(300|002|000).*")){
				g="sz"+g;
			}
			String s = getJavaScriptPage("http://hq.sinajs.cn/list="+g);
			if(s.split(",").length<3){
//				System.out.println("没有获取到数据.股票:"+s);
				continue;
			}
			double current=Double.parseDouble(s.split(",")[3]);
			if(current==0){
//				map.remove(entry.getKey());
//				System.out.println("停牌中.股票:"+g);
				continue;
			}
			double zuigao = entry.getValue().get("zuigao");
			double zuidi =entry.getValue().get("zuidi");
			double yinzi =entry.getValue().get("yinzi")==null?1:entry.getValue().get("yinzi");
			double d=yinzi==0?current:Double.parseDouble(df.format(current*yinzi));
//			System.out.println("current:"+current+",复权后:"+d+",最高:"+zuigao+",最低:"+zuidi+"，股票代码:"+g+",因子:"+yinzi);
			if(d>zuigao){
				++sum;
				++h;
//				System.out.println("当前股票:"+g+"新高");
			}else if(d<zuidi){
				--sum;
				++l;
//				System.out.println("当前股票:"+g+"新低");
			}else{
				o++;
			}
		}
//		System.out.println("新高:"+h+"，新低:"+l);
		return sum;
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
	public static HtmlElement getHtmlParset(String url) {
		try {
			WebClient client  = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
			initClient(client);  
			return ((HtmlPage)client.getPage(url)).getDocumentElement();
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
	public static HtmlPage getHtml(String url) {
		try {
			WebClient client  = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
			initClient(client);  
			return (HtmlPage)client.getPage(url);
		} catch (Exception e) {
			return null;
		}
	}
	public static void initClient(WebClient client) {
		client.getOptions().setThrowExceptionOnScriptError(false);
		client.getOptions().setUseInsecureSSL(true);
		client.getOptions().setJavaScriptEnabled(true);
		client.getOptions().setThrowExceptionOnFailingStatusCode(false);
		client.getOptions().setCssEnabled(false);
		client.getOptions().setRedirectEnabled(true);
		client.getOptions().setActiveXNative(false); 
		client.setAjaxController(new NicelyResynchronizingAjaxController());
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

	public static void initGp(String gpdm,Map<String,Map<String,Double>> map) {
		HtmlPage html = getHtml("http://money.finance.sina.com.cn/corp/go.php/vMS_FuQuanMarketHistory/stockid/"+gpdm+".phtml");
		DomElement table = html.getElementById("FundHoldSharesTable");
		DomElement children = table.getLastElementChild();
		DomNodeList<DomNode> childNodes = children.getChildNodes();
		if(childNodes.size()<19){
//			System.out.println("股票停牌中:"+gpdm);
			return ;
		}
		Map<String,Double> mp=new HashMap<String, Double>();
		for (int i = 1; i < 20; i++) {
			DomNodeList<DomNode> tds = childNodes.get(i).getChildNodes();
			double shoupanjia=Double.parseDouble(tds.get(3).asText());
			String yinzi=tds.get(7).asText();
			double zuigao = mp.get("zuigao")==null?0:mp.get("zuigao");
			if(zuigao==0||zuigao<shoupanjia){
				mp.put("zuigao",shoupanjia);
			}
			double zuidi = mp.get("zuidi")==null?0:mp.get("zuidi");
			if(zuidi==0||zuidi>shoupanjia){
				mp.put("zuidi",shoupanjia);
			}
			if(i==1){
				mp.put("yinzi",Double.parseDouble(yinzi));
			}
		}
		map.put(gpdm, mp);
	}
}
