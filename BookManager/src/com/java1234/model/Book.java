package com.java1234.model;

/**
 * bookʵ����
 * @author ������˧
 *
 */
public class Book {
	private int id;
	private String name;
	private String describe;
	
	
	
	public Book() {  // û�����������û�������޲ε�Book
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Book(String name) {
		super();
		this.name = name;
	}


	public Book(String name, String describe) {
		super();
		this.name = name;
		this.describe = describe;
	}
	
	


	public Book(int id, String name, String describe) {
		super();
		this.id = id;
		this.name = name;
		this.describe = describe;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}


	@Override
	public String toString() {
		return name;
	}
	
	

}
