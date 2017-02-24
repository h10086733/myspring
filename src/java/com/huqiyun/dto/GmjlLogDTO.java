package com.huqiyun.dto;
/**
 * 购买基金日志表
 * @author huqiyun
 *
 */
public class GmjlLogDTO extends BaseDTO  {

	 private String jjdm;//购买基金代码
	 private String jjmc;//购买基金名称
	 private String gmcb;//购买成本
	 private String bugDate;//购买时间
	 private String gmStatus;//购买状态1买入2已售出
	 private String saleDate;//售出时间
	 private String yldw;//盈利点位
	 private String currentPrice;//当前价格
	
	 public void setJjdm(String jjdm) {
        this.jjdm = jjdm == null ? null : jjdm.trim();
     }
	 public String getJjdm(){
         return jjdm;
     }
	 public void setJjmc(String jjmc) {
        this.jjmc = jjmc == null ? null : jjmc.trim();
     }
	 public String getJjmc(){
         return jjmc;
     }
	 public void setGmcb(String gmcb) {
        this.gmcb = gmcb == null ? null : gmcb.trim();
     }
	 public String getGmcb(){
         return gmcb;
     }
	 public void setGmStatus(String gmStatus) {
        this.gmStatus = gmStatus == null ? null : gmStatus.trim();
     }
	 public String getGmStatus(){
         return gmStatus;
     }
	 public void setYldw(String yldw) {
        this.yldw = yldw == null ? null : yldw.trim();
     }
	 public String getYldw(){
         return yldw;
     }
	public String getBugDate() {
		return bugDate;
	}
	public void setBugDate(String bugDate) {
		this.bugDate = bugDate;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public String getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}
}