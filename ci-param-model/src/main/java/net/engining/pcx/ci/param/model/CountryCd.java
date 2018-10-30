package net.engining.pcx.ci.param.model;

import java.io.Serializable;

import net.engining.pg.support.meta.PropertyInfo;

/**
 * 国家代码
 * 主键 - countryCd
 * 
 * 如中国
 * COUNTRY_CD        为156
 * COUNTRY_CD_SHORT  为CN
 * DESCRIPTION       为中华人民共和国
 * CURRENCY_CD       为156
 */
public class CountryCd implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3742700493647799127L;

	/**
	 * 国家代码， 为ISO 3166-1标准的三位数字代码，参见 http://en.wikipedia.org/wiki/ISO_3166-1
	 */
	@PropertyInfo(name="国家代码", length=3)
	public String countryCd;
	
	/**
	 * 两位字母国家代码缩写，参见ISO 3166-1
	 */
	@PropertyInfo(name="代码缩写", length=2)
	public String countryCdShort;
	
	/**
	 * 国家中文名
	 */
	@PropertyInfo(name="中文名", length=100)
	public String description;
	
	/**
	 * 国家币种
	 */
	@PropertyInfo(name="币种", length=12)
	public String currencyCd;
}
