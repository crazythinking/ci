package net.engining.pcx.ci.process.interfaces;

import net.engining.pg.support.meta.EnumInfo;

/**
 * 为解除依赖，从tc复制过来，待清理
 * @author binarier
 *
 */
@EnumInfo({
		"CI001|姓名不正确",
		"CI002|证件类型号码验证错误",
		"CI003|手机号码验证错误"
})
public enum CheckReason {
	/**
	 * 姓名不正确
	 */
	CI001("姓名不正确","05"),
	/**
	 * 证件类型号码验证错误
	 */
	CI002("证件类型号码验证错误","05"),
	/**
	 * 手机号码验证错误
	 */
	CI003("手机号码验证错误","05");
	
	private String description;
	
	private String cupRespCd;
	
	private CheckReason(String description, String cupRespCd){
		this.description = description;
		this.cupRespCd = cupRespCd;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public String getCupRespCd(){
		return this.cupRespCd;
	}
}
