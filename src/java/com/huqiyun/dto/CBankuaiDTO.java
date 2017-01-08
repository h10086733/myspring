package com.huqiyun.dto;

/**
 * 板块关联的股票
 *
 */
public class CBankuaiDTO extends BaseDTO{

	 private String cBkmc;//板块名称
	 private String cBkdm;//板块代码
	 private String cGupiaoid;//股票代码
	
	
	
	 public void setCBkmc(String cBkmc) {
        this.cBkmc = cBkmc == null ? null : cBkmc.trim();
     }
	 public String getCBkmc(){
         return cBkmc;
     }
	 public void setCBkdm(String cBkdm) {
        this.cBkdm = cBkdm == null ? null : cBkdm.trim();
     }
	 public String getCBkdm(){
         return cBkdm;
     }
	public String getcGupiaoid() {
		return cGupiaoid;
	}
	public void setcGupiaoid(String cGupiaoid) {
		this.cGupiaoid = cGupiaoid;
	}
   	
}