package net.engining.pcx.ci.param.model;

import java.io.Serializable;

import net.engining.pg.support.meta.PropertyInfo;

public class ProvinceInfo implements Serializable {

	private static final long serialVersionUID = -5286089123946247258L;

	@PropertyInfo(name = "省份编码")
	public String provinceId;

	@PropertyInfo(name = "省份名称")
	public String provinceName;

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}
