package net.engining.pcx.ci.infrastructure.shared.enums;

import net.engining.pg.support.meta.EnumInfo;

@EnumInfo({
	"A|国家机关、党群组织、企业、事业单位负责人",
	"B|专业技术人员室内装饰设计师企业人力资源管理人员",
	"C|办事人员和有关人员",
	"D|商业、服务业人员工",
	"E|农、林、牧、渔、水利业生产人员",
	"F|生产、运输设备操作人员及有关人员",
	"G|军人",
	"H|其他从业人员"
})
public enum OccupationType {

	/**
	 * 国家机关、党群组织、企业、事业单位负责人
	 */
	A("国家机关、党群组织、企业、事业单位负责人"),
	/**
	 * 专业技术人员室内装饰设计师企业人力资源管理人员
	 */
	B("专业技术人员室内装饰设计师企业人力资源管理人员"),
	/**
	 * 办事人员和有关人员
	 */
	C("办事人员和有关人员"),
	/**
	 * 商业、服务业人员工
	 */
	D("商业、服务业人员工"),
	/**
	 * 农、林、牧、渔、水利业生产人员
	 */
	E("农、林、牧、渔、水利业生产人员"),
	/**
	 * 生产、运输设备操作人员及有关人员
	 */
	F("生产、运输设备操作人员及有关人员"),
	/**
	 * 军人
	 */
	G("军人"),
	/**
	 * 其他从业人员
	 */
	H("其他从业人员")
	;
	
	private String desc;
	
	private OccupationType(String desc)
	{
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}

}
