package com.Inherit.model.vo;

public class Employee extends Person {
	private int salary;
	private String department;
	private String job;
	
	public Employee() {}

	public Employee(int salary, String department, String job) {
		super();
		this.salary = salary;
		this.department = department;
		this.job = job;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	
	
	
}
