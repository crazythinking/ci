package net.engining.pcx.ci.process.interfaces;

import net.engining.pcx.ci.infrastructure.shared.enums.IdType;


/**
 * 客户信息验证服务
 *
 */
public interface CiValidation {
	/**
	 * 验证客户姓名
	 * 如果传入的姓名与数据库中的姓名不符返回CI001
	 * @param name 交易报文上送的姓名
	 * @param custnName 数据库中存放的客户姓名
	 * @return
	 */
	CheckReason validName(String name, String custName);
	
	/**
	 * 验证客户证件类型号码
	 * 如果传入的证件类型号码与数据库不符返回CI002
	 * @param idType 报文上送的证件类型
	 * @param id 报文上送的证件号码
	 * @param custIdType 数据库中的客户证件类型
	 * @param custId 数据库中的客户证件号码
	 * @return
	 */
	CheckReason validId(IdType idType, String id, IdType custIdType, String custId);
	
	/**
	 * 验证客户手机号码
	 * 如果传入的手机号码与数据库中的不符，返回CI003
	 * @param mobilePhone 报文上送的手机号码
	 * @param custMobilePhone 数据库中存放的手机号码
	 * @return
	 */
	CheckReason validMobilePhone(String mobilePhone, String custMobilePhone);
}
