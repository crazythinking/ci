package net.engining.pcx.ci.process.interfaces;

import java.util.List;

import net.engining.pcx.ci.entity.model.CiAddress;
import net.engining.pcx.ci.entity.model.CiCustomer;
import net.engining.pcx.ci.process.model.CustomerAll;

/**
 * 更新客户信息
 * @author Ronny
 *
 */
public interface CiCustomerModify {

	/**
	 * 合并客户信息
	 * 首先判断内部客户号是否存在，如存在，更合并信息
	 * 不存在时判断客户证件号
	 * @param customer 客户信息
	 * @return 内部客户编号
	 */
	String mergeCustomerAll(CustomerAll customerAll);

	/**
	 * 根据内部客户号更新客户基本信息
	 * 首先判断内部客户号是否存在，如存在，更合并信息
	 * 不存在时判断客户证件号
	 * @param customer
	 * @return 内部客户编号
	 */
	String mergeCustomer(CiCustomer customer);
	
	/**
	 * 合并地址信息
	 * 首先判断地址编号和客户编号是否存在和对应，存在则直接更新
	 * 不存在则新增地址信息
	 * @param address
	 * @return 地址编号
	 */
	Integer mergeAddress(CiAddress address);

	/**
	 * 合并地址信息列表
	 * @param addressList
	 */
	void mergeAddressList(List<CiAddress> addressList);
	
}
