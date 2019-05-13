package org.model;

import java.util.List;

public class Pagebean {
	private int totalCount=0; //总条数
	private int totalPage=0;//总页数 总条数/每页条数
	private int sizePage=3;//每页显示数  默认 
	private int pageNum=0;//第几页  默认
	private List<Book> books;//查询返回的结果集
	
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalCount%sizePage==0?totalCount/sizePage:totalCount/sizePage+1;//总页数 总条数/每页条数;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getSizePage() {
		return sizePage;
	}
	public void setSizePage(int sizePage) {
		this.sizePage = sizePage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
}
