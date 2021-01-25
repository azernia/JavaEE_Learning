package com.rui.pojo;
/**
 * 用户实体类
 * @author Rui
 * Date 2021年1月21日 下午3:14:49
 */
public class User {
	/** 用户ID */
	private int uid;
	/** 用户名 */
	private String uname;
	/** 密码 */
	private String pwd;
	/** 性别 */
	private String sex;
	/** 年龄 */
	private int age;
	/** 生日 */
	private String birthday;
	public User() {
		super();
	}
	public User(int uid, String uname, String pwd, String sex, int age, String birthday) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
	}
	public User(String uname, String pwd, String sex, int age, String birthday) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUid() {
		return uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return uid + ":" + uname;
	}
	
}
