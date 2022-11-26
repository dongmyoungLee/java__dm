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
	
	// 생성자 선언 생성만하는 default 값
	public Employee() {
		name = "유병승";
		department = "강사부";
		job = "강사";
		pay = 100;
		bonus = 0.1;
	}
	
	
	public Employee(String name1) {
		name = name1;
	}
	
	public Employee(String name1, String department1, String job1, int pay1, double bonus1) {
		name = name1;
		department = department1;
		job = job1;
		pay = pay1;
		bonus = bonus1;
	}
	
	
	/*
	public Employee(String emp_name, String emp_department, String emp_job, int emp_pay, double emp_bonus) {
		System.out.println(EMPLOY_NUM + " " + emp_name + " " + emp_department + " " + emp_job + " " + emp_pay + " " + emp_bonus);
		
		name = emp_name;
		department = emp_department;
		job = emp_job;
		pay = emp_pay;
		bonus = emp_bonus;
	}
	*/
	
	
}
