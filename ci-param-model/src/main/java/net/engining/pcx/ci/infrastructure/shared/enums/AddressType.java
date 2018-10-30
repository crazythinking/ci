package net.engining.pcx.ci.infrastructure.shared.enums;

import net.engining.pg.support.meta.EnumInfo;

@EnumInfo({
	"H|家庭地址",
	"C|公司地址",
	"S|户籍地址",
	"R|企业注册地址",
	"O|企业运营地址",
	"M|收货地址",
	"N|其他地址2"
})
public enum AddressType {

	/**
	 * 家庭地址
	 */
	H,
	/**
	 * 公司地址
	 */
	C,
	/**
	 * 户籍地址
	 */
	S,
	/**
	 * 企业注册地址
	 */
	R,
	/**
	 * 企业运营地址
	 */
	O,
	/**
	 * 其他收货地址
	 */
	M,
	/**
	 * 其他地址2
	 */
	N
}
