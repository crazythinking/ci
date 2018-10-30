package net.engining.pcx.ci.process;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQueryFactory;

import net.engining.pcx.ci.entity.model.CiAddress;
import net.engining.pcx.ci.entity.model.CiCustomer;
import net.engining.pcx.ci.entity.model.QCiCustomer;
import net.engining.pcx.ci.process.interfaces.CiCustomerModify;
import net.engining.pcx.ci.process.model.CustomerAll;

/**
 * 客户信息更新服务实现
 * 
 * @author Ronny
 *
 */
@Service
public class CiCustomerModifyImpl implements CiCustomerModify {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public String mergeCustomerAll(CustomerAll customerAll) {
		// 更新客户信息
		String custId = mergeCustomer(customerAll.getCustomer());

		// 更新地址列表
		for (CiAddress addr : customerAll.getAddressList()) {
			if ((addr.getCustId() != null && addr.getCustId() != custId)) {
				throw new IllegalArgumentException("客户ID与地址信息中的不一致");
			} else {
				addr.setCustId(custId);
			}
		}
		mergeAddressList(customerAll.getAddressList());

		return custId;
	}

	@Override
	@Transactional
	public String mergeCustomer(CiCustomer customer) {
		CiCustomer origCust = null;
		// 判断Merge的对象是否已存在custId,如果不存在，判断是否存在相同证件号，证件类型的用户
		if (customer.getCustId() != null) {
			origCust = em.find(CiCustomer.class, customer.getCustId());
			if (origCust == null) {
				throw new IllegalArgumentException("输入的用户编号不存在");
			}
			merge(CiCustomer.class, origCust, customer);

		} else {
			// 根据证件号、证件类型查找客户信息
			// 如果客户不存在，则新建用户，否则合并客户信息
			QCiCustomer q = QCiCustomer.ciCustomer;
			origCust = new JPAQueryFactory(em).select(q).from(q)
					.where(q.idNo.eq(customer.getIdNo()), q.idType.eq(customer.getIdType())).fetchOne();

			if (origCust == null) {
				em.persist(customer);
				origCust = customer;
			} else {
				merge(CiCustomer.class, origCust, customer);
			}
		}
		return origCust.getCustId();
	}

	@Override
	@Transactional
	public Integer mergeAddress(CiAddress address) {
		if (address.getCustId() == null) {
			throw new IllegalArgumentException("用户编号未输入");
		}

		// 除主键外，暂时不根据其他条件找寻相似记录
		if (address.getAddrId() == null) {
			em.persist(address);
			return address.getAddrId();
		} else {
			CiAddress addr = em.find(CiAddress.class, address.getAddrId());
			if (addr == null) {
				throw new IllegalArgumentException("地址编号找不到对应记录");
			}

			// 判定数据库中的客户号与机构号是否与传送入目标信息一致
			if (addr.getCustId() != address.getCustId()) {
				throw new IllegalArgumentException("地址信息对应的用户不同");
			}
			merge(CiAddress.class, addr, address);
			return addr.getAddrId();
		}
	}

	@Override
	public void mergeAddressList(List<CiAddress> addressList) {
		for (CiAddress addr : addressList) {
			mergeAddress(addr);
		}
	}

	private <T> void merge(Class<T> objClass, T orig, T update) {
		Field[] fields = objClass.getFields();
		for (Field f : fields) {

			try {
				Object a = f.get(update);

				if (a != null) {
					f.set(orig, a);
				}
			} catch (IllegalArgumentException e) {
				logger.error("incredible", e);
			} catch (IllegalAccessException e) {
				logger.error("incredible", e);
			}
		}
	}

}
