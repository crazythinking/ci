package net.engining.pcx.ci.process.model;

import net.engining.pcx.ci.infrastructure.shared.enums.IdType;

/**
 * 客户授权信息
 * @author zhaojin
 *
 */
public class CustAuthInfo {
	/**
	 * 客户编号
	 */
	private String custId;
	
	/**
	 * 证件号码
	 */
	private String idNo;
	
	/**
	 * 证件类型
	 */
	private IdType idType;
	
	/**
	 * 手机号
	 */
	private String mobilePhone;
	
	/**
	 * 客户姓名
	 */
	private String name;
	
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	
	public String getIdNo() {
		return idNo;
	}
	
	public IdType getIdType() {
		return idType;
	}

	public void setIdType(IdType idType) {
		this.idType = idType;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
