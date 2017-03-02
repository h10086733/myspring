package com.huqiyun.dto;
/**
 * 15分钟系数
 * @author huqiyun
 *
 */
public class CBankuaiXishu15DTO extends BaseDTO  {

	 private String cDate;//15分钟数据
	 private Integer cValue;//值
	 private String bankuaiName;//板块名称
	 private String bankuaiDaima;//板块代码
	
	 public void setCDate(String cDate) {
        this.cDate = cDate == null ? null : cDate.trim();
     }
	 public String getCDate(){
         return cDate;
     }
   	 public void setCValue(Integer cValue) {
        this.cValue = cValue == null ? null : cValue;
     }
	 public Integer getCValue(){
         return cValue;
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
	
}