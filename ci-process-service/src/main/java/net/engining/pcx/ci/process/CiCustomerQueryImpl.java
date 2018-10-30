package net.engining.pcx.ci.process;

import java.text.MessageFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

import net.engining.pcx.ci.entity.model.CiAddress;
import net.engining.pcx.ci.entity.model.CiCustomer;
import net.engining.pcx.ci.entity.model.QCiAddress;
import net.engining.pcx.ci.entity.model.QCiCustomer;
import net.engining.pcx.ci.infrastructure.shared.enums.IdType;
import net.engining.pcx.ci.process.interfaces.CiCustomerQuery;
import net.engining.pcx.ci.process.model.CustAuthInfo;
import net.engining.pcx.ci.process.model.CustomerAll;

@Service
public class CiCustomerQueryImpl implements CiCustomerQuery {

	@PersistenceContext
	private EntityManager em;

	private QCiAddress qCiAddress = QCiAddress.ciAddress;

	private QCiCustomer qCiCustomer = QCiCustomer.ciCustomer;

	@Override
	public CustAuthInfo getCustInfo(String custId) {
		CiCustomer customer = getCustomerByCustId(custId);
		CustAuthInfo info = new CustAuthInfo();
		info.setCustId(custId);
		info.setIdNo(customer.getIdNo());
		info.setIdType(customer.getIdType());
		info.setMobilePhone(customer.getMobileNo());
		info.setName(customer.getName());
		return info;
	}

	@Override
	public CustomerAll getAllByCustId(String custId) {
		CustomerAll cust = new CustomerAll();
		cust.setCustomer(getCustomerByCustId(custId));
		cust.setAddressList(getAddressByCustId(custId));
		return cust;
	}

	@Override
	public CustomerAll getAllbyIdAndIdType(String idNo, IdType idType) {
		CustomerAll cust = new CustomerAll();
		CiCustomer customer = new JPAQueryFactory(em).select(qCiCustomer).from(qCiCustomer)
				.where(qCiCustomer.idNo.eq(idNo), qCiCustomer.idType.eq(idType)).fetchOne();
		if (customer == null)
			throw new IllegalArgumentException(MessageFormat.format("客户信息未找到,证件号码{0},证件类型{1}", idNo, idType));
		cust.setCustomer(customer);
		cust.setAddressList(getAddressByCustId(customer.getCustId()));
		return cust;
	}

	@Override
	public List<CiAddress> getAddressByCustId(String custId) {
		return new JPAQueryFactory(em).select(qCiAddress).from(qCiAddress).where(qCiAddress.custId.eq(custId)).fetch();
	}

	@Override
	public CiCustomer getCustomerByCustId(String custId) {
		CiCustomer customer = em.find(CiCustomer.class, custId);
		if (customer == null) {
			throw new IllegalArgumentException(MessageFormat.format("客户编号{0}未找到对应记录", custId));
		}
		return customer;
	}

}
