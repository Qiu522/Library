package org.model;

public class Reader {
	private int id;
	private String readerName;
	private String password;
	private int age;
	private short sex;
	private double acount;
	private int bookCount;
	
	private int totalBookNum = 6;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public short getSex() {
		return sex;
	}
	public void setSex(short sex) {
		this.sex = sex;
	}
	public double getAcount() {
		return acount;
	}
	public void setAcount(double acount) {
		this.acount = acount;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public int getTotalBookNum() {
		return totalBookNum;
	}
	public void setTotalBookNum(int totalBookNum) {
		this.totalBookNum = totalBookNum;
	}
	
}
