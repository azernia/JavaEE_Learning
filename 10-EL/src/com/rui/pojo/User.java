package com.rui.pojo;

public class User {
	private int uid;
	private String uname;
	private String fav;
	private Address addr;
	public User() {
		super();
	}
	
	public User(int uid, String uname, String fav, Address address) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.fav = fav;
		this.addr = address;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getFav() {
		return fav;
	}
	public void setFav(String fav) {
		this.fav = fav;
	}
	public Address getAddress() {
		return addr;
	}
	public void setAddress(Address address) {
		this.addr = address;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", fav=" + fav + ", address=" + addr + "]";
	}
	
}
