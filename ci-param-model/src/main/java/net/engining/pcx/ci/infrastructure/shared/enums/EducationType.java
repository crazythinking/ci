package net.engining.pcx.ci.infrastructure.shared.enums;

import net.engining.pg.support.meta.EnumInfo;

@EnumInfo({
	"A|博士及以上",
	"B|硕士",
	"C|本科",
	"D|大专",
	"E|中专及技校",
	"F|高中",
	"G|初中及以下"
})
/*
 * 教育状况
 */
public enum EducationType {

	/**
	 * 博士及以上
	 */
	A,
	/**
	 * 硕士
	 */
	B,
	/**
	 * 本科
	 */
	C,
	/**
	 * 大专
	 */
	D,
	/**
	 * 中专及技校
	 */
	E,
	/**
	 * 高中
	 */
	F,
	/**
	 * 初中及以下
	 */
	G
	
}
