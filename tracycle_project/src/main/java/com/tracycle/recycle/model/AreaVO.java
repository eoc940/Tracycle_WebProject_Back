package com.tracycle.recycle.model;

public class AreaVO {
	private int areaId;
	private String areaName;
	
	public AreaVO() { }
	
	public AreaVO(int areaId, String areaName) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
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

	@Override
	public String toString() {
		return "AeraVO [areaId=" + areaId + ", areaName=" + areaName + "]";
	}
	
	

	
	
}
