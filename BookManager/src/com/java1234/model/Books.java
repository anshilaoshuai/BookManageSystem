package com.java1234.model;

/**
 * 图书实体
 * @author 安是老帅
 *
 */
public class Books {
	
	public Books(int id) {
		super();
		this.id = id;
	}
	private int id;
	private String name;
	private String author;
	private String sex;
	private Float price;
	private Integer typeid;
	private String describe;
	private String type;
	
	

	public Books(int id, String name, String author, String sex, Float price, Integer typeid, String describe) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.typeid = typeid;
		this.describe = describe;
	}

	public Books(String name, String author, int typeid) {
		super();
		this.name = name;
		this.author = author;
		this.typeid = typeid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Books() {
		super();
	}

	public Books(String name, String author, String sex, Float price, Integer typeid, String describe) {
		super();
		this.name = name;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.typeid = typeid;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	

}
