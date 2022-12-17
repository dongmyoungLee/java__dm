package com.generic.controller;
// E, T , K , V
public class MyGeneric<T> {
	private T data;
	
	public MyGeneric() {
		// TODO Auto-generated constructor stub
	}

	public MyGeneric(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
