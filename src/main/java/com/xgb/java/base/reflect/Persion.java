package com.xgb.java.base.reflect;

public class Persion {
	private int id;
	private int age;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Persion [id=" + id + ", age=" + age + ", name=" + name + "]";
	}
	public Persion(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	public Persion() {
		super();
	}
	
	public static String getStaticName() {
		System.out.println("zhang");
		return "zhang";
	}
}
