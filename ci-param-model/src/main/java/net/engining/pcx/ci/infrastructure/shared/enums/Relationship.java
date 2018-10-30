package net.engining.pcx.ci.infrastructure.shared.enums;

import net.engining.pg.support.meta.EnumInfo;

@EnumInfo({
	"C|配偶",
	"F|父亲",
	"M|母亲",
	"B|兄弟",
	"S|姐妹",
	"L|亲属",
	"W|同事",
	"O|其他",
	"Q|配偶或直系亲属",
	"D|财务负责人",
	"P|朋友"
})
public enum Relationship {
	
	/**
	 *	配偶
	 */
	C,
	/**
	 *	父亲 
	 */
	F,
	/**
	 *	母亲 
	 */
	M,
	/**
	 *	兄弟 
	 */
	B,
	/**
	 *	姐妹 
	 */
	S,
	/**
	 *	亲属 
	 */
	L,
	/**
	 *	同事 
	 */
	W,
	/**
	 *	其他 
	 */
	O,
	/**
	 * 配偶或直系亲属
	 */
	Q,
	/**
	 * 财务负责人
	 */
	D,
	/**
	 * 朋友
	 */
	P
}
