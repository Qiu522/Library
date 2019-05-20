package org.model;

public class ChargeInfo {
	private int id;
	private int readerID;
	private int bookId;
	private int chargeDate;
	private double fee;
	
	private double unitPrice = 0.1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReaderID() {
		return readerID;
	}

	public void setReaderID(int readerID) {
		this.readerID = readerID;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getChargeDate() {
		return chargeDate;
	}

	public void setChargeDate(int chargeDate) {
		this.chargeDate = chargeDate;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
