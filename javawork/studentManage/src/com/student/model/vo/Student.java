package com.student.model.vo;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
	private static final long serialVersionUID = 2309470036282437672L;
	private long studentNo;
	private String name;
	private int age;
	private char gender;
	private String address;
	private String phone;
	private String email;
	private String major;
	int count = 0;
	
	{
		studentNo = ++count;
	}
	
	public Student() {}
	
	public Student(String name, int age, char gender, String address, String phone, String email, String major) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.major = major;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public String studentInfo() {
		return name + " " + age + " " + gender + " " + phone + " " + email + " " + address + " " + major;
	}
	
	public static String[] removeElement(String[] arr, int index) {
        String[] result = new String[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, index);
        if (arr.length != index) {
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
        }
        return result;
    }
	
	// 모든 필드가 같아야 동등비교가 true..
	@Override
	public boolean equals(Object o) {
		Student student = (Student)o;
		
		if (this.name.equals(student.name)
				&& this.age == student.age
				&& this.gender == student.gender
				&& this.phone.equals(student.phone)
				&& this.email.equals(student.email)
				&& this.address.equals(student.address)
				&& this.major.equals(student.major)) {
			return true;
		}
		
		return false;
	}
	
	// 모든 필드가 같으면 hashCode도 같음.
	@Override
	public int hashCode() {
		return Objects.hash(name, age, gender, phone, email, address, major);
	}
	
	// 출력 override
	@Override
	public String toString() {
		return name + " " + age + " " + gender + " " + phone + " " + email + " " + address + " " + major;
	}
	
}
