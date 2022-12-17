package com.extra.model.vo;

import java.util.Objects;

import com.extra.common.Gender;

public class Student {
	private long studentNo;
	private String name;
	private int age;
	private double height;
	private Gender gender; // enum
	private String address;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(long studentNo, String name, int age, double height, Gender gender, String address) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.age = age;
		this.height = height;
		this.gender = gender;
		this.address = address;
	}

	public long getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(long studentNo) {
		this.studentNo = studentNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, gender, height, name, studentNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && age == other.age && gender == other.gender
				&& Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& Objects.equals(name, other.name) && studentNo == other.studentNo;
	}

	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", name=" + name + ", age=" + age + ", height=" + height
				+ ", gender=" + gender + ", address=" + address + "]";
	}
	
	// Builder 패턴으로 클래스 생성하게 하기
	
	public static class Builder {
		private long stdNo;
		private String name;
		private int age;
		private double height;
		private Gender gender;
		private String address;
		
		public Builder() {}
		
		public Builder stdNo(long val) {
			stdNo = val;
			return this;
		}
		
		public Builder name(String val) {
			name = val;
			return this;
		}
		
		public Builder age(int val) {
			age = val;
			return this;
		}
		
		public Builder height(double val) {
			height = val;
			return this;
		}
		
		public Builder gender(Gender val) {
			gender = val;
			return this;
		}
		
		public Builder address(String val) {
			address = val;
			return this;
		}
		public Student build() {
			return new Student(this);
		}
		
	}//	Builder 클래스 닫기
	
	private Student(Builder builder) {
		this.studentNo = builder.stdNo;
		this.name = builder.name;
		this.age = builder.age;
		this.height = builder.height;
		this.gender = builder.gender;
		this.address = builder.address;
	}
	
	public static Builder builder() {
		return new Student.Builder();
	}
	

	
	
	
	
	
	
	
}
