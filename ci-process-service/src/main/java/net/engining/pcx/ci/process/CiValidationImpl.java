package net.engining.pcx.ci.process;

import net.engining.pcx.ci.infrastructure.shared.enums.IdType;
import net.engining.pcx.ci.process.interfaces.CheckReason;
import net.engining.pcx.ci.process.interfaces.CiValidation;

import org.springframework.stereotype.Service;

@Service
public class CiValidationImpl implements CiValidation {

	@Override
	public CheckReason validName(String name, String custName) {
		return !name.equals( custName ) ? CheckReason.CI001 : null;
	}

	@Override
	public CheckReason validId(IdType idType, String id, IdType custIdType,
			String custId) {
		// 证件号码证件类型未上送,直接返回CI002
		if (idType == null || id == null){
			return CheckReason.CI002;
		}
		return !idType.equals( custIdType ) && !id.equals( custId ) ? CheckReason.CI002 : null;
	}

	@Override
	public CheckReason validMobilePhone(String mobilePhone,
			String custMobilePhone) {
		return !mobilePhone.equals( custMobilePhone ) ? CheckReason.CI003 : null;
	}

}
