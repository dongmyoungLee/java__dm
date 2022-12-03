package com.inter.model.vo;

import java.util.Objects;

public abstract class Animal {
	
	private String name;
	private int x;
	private int y;
	private String area;
	private String type;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String name, int x, int y, String area, String type) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.area = area;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	// toString Override 단축  : alt + s + s + s + enter;
	@Override
	public String toString() {
		return "Animal [name=" + name + ", x=" + x + ", y=" + y + ", area=" + area + ", type=" + type + "]";
	}

	
	// hashCode, equals Override 단축 alt + s + h + h + enter
	@Override
	public int hashCode() {
		return Objects.hash(area, name, type, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(area, other.area) && Objects.equals(name, other.name) && Objects.equals(type, other.type)
				&& x == other.x && y == other.y;
	}
	
	 
	
	
	
	
}
