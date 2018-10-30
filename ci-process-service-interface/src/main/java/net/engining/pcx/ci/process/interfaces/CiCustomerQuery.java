package net.engining.pcx.ci.process.interfaces;

import java.util.List;

import net.engining.pcx.ci.entity.model.CiAddress;
import net.engining.pcx.ci.entity.model.CiCustomer;
import net.engining.pcx.ci.infrastructure.shared.enums.IdType;
import net.engining.pcx.ci.process.model.CustAuthInfo;
import net.engining.pcx.ci.process.model.CustomerAll;

/**
 * 客户查询服务
 * @author Ronny
 *
 */
public interface CiCustomerQuery {

	/**
	 * 根据客户编号获取客户信息(授权服务接口)
	 * @param custId 客户编号
	 * @return CustAuthInfo 客户信息
	 */
	CustAuthInfo getCustInfo(String custId);
	

	/**
	 * 根据客户编号查询客户所有信息
	 * @param custId
	 * @return
	 */
	CustomerAll getAllByCustId(String custId);
	
	/**
	 * 根据证件号码查询客户所有信息
	 * @param IdNo
	 * @param idType
	 * @return
	 */
	CustomerAll getAllbyIdAndIdType(String idNo, IdType idType);
	
	/**
	 * 根据客户编号查询地址列表
	 * @param custId
	 * @return
	 */
	List<CiAddress> getAddressByCustId(String custId);
	
	/**
	 * 根据客户号查询客户信息
	 * @param custId
	 * @return
	 */
	CiCustomer getCustomerByCustId(String custId);
	
}
