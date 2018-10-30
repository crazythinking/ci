package net.engining.pcx.ci.param.model;

import java.io.Serializable;

import net.engining.pg.support.meta.PropertyInfo;

public class CityInfo implements Serializable {
	private static final long serialVersionUID = -6269570583675512698L;
	@PropertyInfo(name = "城市编码")
	private String cityId;
	@PropertyInfo(name = "城市名称")
	private String cityName;
	@PropertyInfo(name = "省份编码")
	private String provinceId;
	@PropertyInfo(name = "区域编码")
	private String regionId;
	@PropertyInfo(name = "区域名称")
	private String regionName;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
