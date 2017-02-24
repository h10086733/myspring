package com.huqiyun.dto;
/**
 * 板块每日收盘价格
 * @author huqiyun
 *
 */
public class CBankuaiValueDTO extends BaseDTO  {

	 private String bankuaiJiancheng;//板块简称
	 private String bankuaiName;//板块名称
	 private String bankuaiDaima;//板块代码
	 private String bankuaiShoupanjia;//收盘价
	 private String cDate;//日期
	
	 public void setBankuaiJiancheng(String bankuaiJiancheng) {
        this.bankuaiJiancheng = bankuaiJiancheng == null ? null : bankuaiJiancheng.trim();
     }
	 public String getBankuaiJiancheng(){
         return bankuaiJiancheng;
     }
	 public void setBankuaiName(String bankuaiName) {
        this.bankuaiName = bankuaiName == null ? null : bankuaiName.trim();
     }
	 public String getBankuaiName(){
         return bankuaiName;
     }
	 public void setBankuaiDaima(String bankuaiDaima) {
        this.bankuaiDaima = bankuaiDaima == null ? null : bankuaiDaima.trim();
     }
	 public String getBankuaiDaima(){
         return bankuaiDaima;
     }
	 public void setBankuaiShoupanjia(String bankuaiShoupanjia) {
        this.bankuaiShoupanjia = bankuaiShoupanjia == null ? null : bankuaiShoupanjia.trim();
     }
	 public String getBankuaiShoupanjia(){
         return bankuaiShoupanjia;
     }
	 public void setCDate(String cDate) {
        this.cDate = cDate == null ? null : cDate.trim();
     }
	 public String getCDate(){
         return cDate;
     }
	
}