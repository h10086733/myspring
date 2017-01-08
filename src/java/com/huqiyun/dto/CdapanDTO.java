package com.huqiyun.dto;

/**
 * 大盘数据
 *
 */
public class CdapanDTO extends BaseDTO{

	private String cName;// 股票名称
	private String cDaima;// 股票代码
	private String cDate;// 更新日期
	private Double cZhishu;// 收盘价格
	private Double c20Zuigao;// 20日最低价格
	private Double c20Zuidi;// 20日最高价格
	private Double cZuoriYinzi;// 当前复权因子
	private String cStatus;// 当前状态

	public void setCName(String cName) {
		this.cName = cName == null ? null : cName.trim();
	}

	public String getCName() {
		return cName;
	}

	public void setCDaima(String cDaima) {
		this.cDaima = cDaima == null ? null : cDaima.trim();
	}

	public String getCDaima() {
		return cDaima;
	}

	public void setCDate(String cDate) {
		this.cDate = cDate == null ? null : cDate.trim();
	}

	public String getCDate() {
		return cDate;
	}

	public void setCZhishu(Double cZhishu) {
		this.cZhishu = cZhishu == null ? null : cZhishu;
	}

	public Double getCZhishu() {
		return cZhishu;
	}

	public void setC20Zuigao(Double c20Zuigao) {
		this.c20Zuigao = c20Zuigao == null ? null : c20Zuigao;
	}

	public Double getC20Zuigao() {
		return c20Zuigao;
	}

	public void setC20Zuidi(Double c20Zuidi) {
		this.c20Zuidi = c20Zuidi == null ? null : c20Zuidi;
	}

	public Double getC20Zuidi() {
		return c20Zuidi;
	}

	public void setCZuoriYinzi(Double cZuoriYinzi) {
		this.cZuoriYinzi = cZuoriYinzi == null ? null : cZuoriYinzi;
	}

	public Double getCZuoriYinzi() {
		return cZuoriYinzi;
	}

	public String getcStatus() {
		return cStatus = cStatus == null ? null : cStatus;
	}

	public void setcStatus(String cStatus) {
		this.cStatus = cStatus;
	}
}