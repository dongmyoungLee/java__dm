package com.collection.model.vo;

import java.io.Serializable;
import java.util.Objects;

public class Food implements Serializable {
	
	
	private static final long serialVersionUID = 991725894934200825L;
	private String name;
	private int price;
	private String type;
	
	public Food() {
		// TODO Auto-generated constructor stub
	}

	public Food(String name, int price, String type) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", price=" + price + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return Objects.equals(name, other.name) && price == other.price && Objects.equals(type, other.type);
	}
	
	
	
}
