package com.huqiyun.dto;

import java.io.Serializable;
import java.util.Date;



public class BaseDTO implements Serializable {
	
	private static final long serialVersionUID = 2212984706714655082L;

	/**
	 * 主键：数据库标示
	 */
	protected Integer id;
	
	/**
	 * 编码:业务标示
	 */
	private String code;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	private Date createDate;
	
    private String createBy;
    
    private Date updateDate;
    
    private String updateBy;
    
    private String deleteTag;
    
    

	public String getDeleteTag() {
		return deleteTag;
	}

	public void setDeleteTag(String deleteTag) {
		this.deleteTag = deleteTag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	private Integer pageCount ; //总页数
	private Integer totalCount; //总条数
	private Integer pageNo ;//当前页数
	private Integer pageSize ;//每页数据条数
	
	private Integer begin; //开始记录条数
	
	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getBegin() {
		if(pageNo != null && pageSize != null){
			this.begin = (pageNo-1)*pageSize;
		}else{
			return null;
		}
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getEnd() {
		return pageSize;
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}
}
