package com.rui.pojo;

public class Address {
	private String pre;
	private String city;
	private String town;
	public Address() {
		super();
	}
	public String getPre() {
		return pre;
	}
	public void setPre(String pre) {
		this.pre = pre;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public Address(String pre, String city, String town) {
		super();
		this.pre = pre;
		this.city = city;
		this.town = town;
	}
	@Override
	public String toString() {
		return "Address [pre=" + pre + ", city=" + city + ", town=" + town + "]";
	}
	
}
