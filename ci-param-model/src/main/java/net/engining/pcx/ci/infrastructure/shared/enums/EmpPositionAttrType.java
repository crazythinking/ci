package net.engining.pcx.ci.infrastructure.shared.enums;

import net.engining.pg.support.meta.EnumInfo;

@EnumInfo({
	"A|高层管理人员",
	"B|中层管理人员",
	"C|基层管理人员",
	"D|一般员工",
	"E|内勤",
	"F|后勤",
	"G|工人",
	"H|销售/中介/业务代表",
	"I|营业员/服务员",
	"Z|其他"
})
/*
 * 申请人职务
 */
public enum EmpPositionAttrType {

	/**
	 * 高层管理人员
	 */
	A("高层管理人员"),
	/**
	 * 中层管理人员
	 */
	B("中层管理人员"),
	/**
	 * 基层管理人员
	 */
	C("基层管理人员"),
	/**
	 * 一般员工
	 */
	D("一般员工"),
	/**
	 * 内勤
	 */
	E("内勤"),
	/**
	 * 后勤
	 */
	F("后勤"),
	/**
	 * 工人
	 */
	G("工人"),
	/**
	 * 销售/中介/业务代表
	 */
	H("销售/中介/业务代表"),
	/**
	 * 营业员/服务员
	 */
	I("营业员/服务员"),
	/**
	 * 其他
	 */
	Z("其他")
	;
	
	private String desc;
	
	public String getDesc() {
		return desc;
	}

	private EmpPositionAttrType(String desc){
		this.desc = desc;
	}
	
}
