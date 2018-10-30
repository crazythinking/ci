package net.engining.pcx.ci.process.model;

import java.util.List;

import net.engining.pcx.ci.entity.model.CiAddress;
import net.engining.pcx.ci.entity.model.CiCustomer;

/**
 * 客户全信息
 * @author Ronny
 *
 */
public class CustomerAll {

	/**
	 * 客户基本信息
	 */
	CiCustomer customer;
 
	/**
	 * 地址信息列表
	 */
	List<CiAddress> addressList;
	
	public CiCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(CiCustomer customer) {
		this.customer = customer;
	}

	public List<CiAddress> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<CiAddress> addressList) {
		this.addressList = addressList;
	}

}
