package com.rui.vo;

public class Area {
	private int areaid;
	private String areaname;
	private String areaLevel;
	private String status;
	private int parentid;
	
	public Area(int areaid, String areaname, String areaLevel, String status, int parentid) {
		super();
		this.areaid = areaid;
		this.areaname = areaname;
		this.areaLevel = areaLevel;
		this.status = status;
		this.parentid = parentid;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public Area() {
		super();
	}
	public int getAreaid() {
		return areaid;
	}
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getAreaLevel() {
		return areaLevel;
	}
	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Area [areaid=" + areaid + ", areaname=" + areaname + ", areaLevel=" + areaLevel + ", status=" + status
				+ "]";
	}
	
}
