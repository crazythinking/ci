package net.engining.pcx.ci.infrastructure.shared.enums;

import net.engining.pg.support.meta.EnumInfo;

@EnumInfo({
	"C|已婚有子女",
	"M|已婚无子女",
	"S|未婚",
	"W|丧偶",
	"D|离异"
})
public enum MaritalStatus {

	/**
	 *	已婚有子女
	 */
	C,
	/**
	 *	已婚无子女
	 */
	M,
	/**
	 *	未婚
	 */
	S,
	/**
	 *	丧偶
	 */
	W,
	/**
	 *	离异
	 */
	D
}
