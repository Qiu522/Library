package org.model;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Book {
	
	//定义实体类的属性
	private Integer id;
	private String title;
	private String describe;
	private Integer categoryId;
	private String simgUrl;
	private String bimgUrl;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date includeDate;	//
	private Integer total;
	private Integer remain;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date publishDate;	//
	private String publisher;
	private Short lendable;
	private String site;
	private Integer lendCount;
	private Integer bookAuthorId;
	
	//定义author属性
	private Author author; //bookAuthorId -> book.id
	//定义category属性
	private Category category; //categoryId -> category.id
	
	// Constructors

	/** default constructor */
	public Book() {
	}

	/** full constructor */
	public Book(String title, String describe, Integer categoryId, String simgUrl, String bimgUrl,
			Date includeDate, Integer total, Integer remain, Date publishDate, String publisher,
			Short lendable, String site, Integer lendCount, Integer bookAuthorId) {
		this.title = title;
		this.describe = describe;
		this.categoryId = categoryId;
		this.simgUrl = simgUrl;
		this.bimgUrl = bimgUrl;
		this.includeDate = includeDate;
		this.total = total;
		this.remain = remain;
		this.publishDate = publishDate;
		this.publisher = publisher;
		this.lendable = lendable;
		this.site = site;
		this.lendCount = lendCount;
		this.bookAuthorId = bookAuthorId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getSimgUrl() {
		return this.simgUrl;
	}

	public void setSimgUrl(String simgUrl) {
		this.simgUrl = simgUrl;
	}

	public String getBimgUrl() {
		return this.bimgUrl;
	}

	public void setBimgUrl(String bimgUrl) {
		this.bimgUrl = bimgUrl;
	}

	public Date getIncludeDate() {
		return this.includeDate;
	}

	public void setIncludeDate(Date includeDate) {
		this.includeDate = includeDate;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRemain() {
		return this.remain;
	}

	public void setRemain(Integer remain) {
		this.remain = remain;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Short getLendable() {
		return this.lendable;
	}

	public void setLendable(Short lendable) {
		this.lendable = lendable;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Integer getLendCount() {
		return this.lendCount;
	}

	public void setLendCount(Integer lendCount) {
		this.lendCount = lendCount;
	}

	public Integer getBookAuthorId() {
		return this.bookAuthorId;
	}

	public void setBookAuthorId(Integer bookAuthorId) {
		this.bookAuthorId = bookAuthorId;
	}
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
