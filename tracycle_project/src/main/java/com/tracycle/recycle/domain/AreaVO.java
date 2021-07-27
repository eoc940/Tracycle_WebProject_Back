package com.tracycle.recycle.domain;

public class AreaVO {
	private int areaId;
	private String areaName;
	private String url;
	private String telephone;
	
	public AreaVO() { }
	
	public AreaVO(int areaId) {
		super();
		this.areaId = areaId;
	}
	
	
	public AreaVO(int areaId, String areaName) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
	}
	
	public AreaVO(int areaId, String areaName, String url, String telephone) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		this.url = url;
		this.telephone = telephone;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "AreaVO [areaId=" + areaId + ", areaName=" + areaName + ", url=" + url + ", telephone=" + telephone
				+ "]";
	}

	
	

	
	
}
