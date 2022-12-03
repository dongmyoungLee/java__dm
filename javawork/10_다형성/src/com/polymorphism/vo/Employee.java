package com.polymorphism.vo;

public class Employee extends Person {
	private int salary;
	private double bonus;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int age, double height, int salary, double bonus) {
		super(name, age, height);
		this.salary = salary;
		this.bonus = bonus;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	
	
}
