package org.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LendInfo {
	//定义实体类的属性
	private int id;
	private int readerId;
	private int bookId;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lendDate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date returnDate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date deadLine;
	private int hasCharge = 0;
	
	//定义借书期限
	private int timeLimite = 90;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getLendDate() {
		return lendDate;
	}
	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public int getHasCharge() {
		return hasCharge;
	}
	public void setHasCharge(int hasCharge) {
		this.hasCharge = hasCharge;
	}
	public int getTimeLimite() {
		return timeLimite;
	}
	public void setTimeLimite(int timeLimite) {
		this.timeLimite = timeLimite;
	}
	
	
}
