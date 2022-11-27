package com.Inherit.model.vo;

public class Teacher extends Person {
	private String major;
	private String[] className;
	private int exp;
	
	public Teacher() {}

	public Teacher(String name, int age, char gender, String address, String major, String[] className, int exp) {
		super(name, age, gender, address);
		this.major = major;
		this.className = className;
		this.exp = exp;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String[] getClassName() {
		return className;
	}

	public void setClassName(String[] className) {
		this.className = className;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
	

	
	
	
}
