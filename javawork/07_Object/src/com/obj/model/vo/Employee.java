package com.obj.model.vo;

public class Employee {
	public String name;
	public String department;
	public String job;
	public int pay;
	public double bonus;
	public final int EMPLOY_NUM;
	private static int count;
	
	static {
		count = 100;
	}
	
	{
		EMPLOY_NUM = ++count;
	}
	
	public Employee(String emp_name, String emp_department, String emp_job, int emp_pay, double emp_bonus) {
		System.out.println(EMPLOY_NUM + " " + emp_name + " " + emp_department + " " + emp_job + " " + emp_pay + " " + emp_bonus);
		
		name = emp_name;
		department = emp_department;
		job = emp_job;
		pay = emp_pay;
		bonus = emp_bonus;
	}
}
