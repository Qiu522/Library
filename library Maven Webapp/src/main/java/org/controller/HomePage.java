package org.controller;

import java.util.ArrayList;
import java.util.List;

import org.model.Author;
import org.model.Book;
import org.model.LendInfo;
import org.model.Reader;
import org.service.AuthorService;
import org.service.BookService;
import org.service.LendInfoService;
import org.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
public class HomePage {
	@Autowired ReaderService readerService;
	@Autowired LendInfoService lendInfoService;
	@Autowired BookService bookService;
	@Autowired AuthorService authorService;
	
	@RequestMapping("/getReaderInfo.action")
	public @ResponseBody Reader getReader(@RequestParam("readerId") int readerId){
		Reader reader = readerService.queryReaderById(readerId);
		
		return reader;
	}
	
	/*
	 * tab = 1 查询在借
	 * 	   = 2查询逾期
	 *     = 3所有记录
	 * */
	@RequestMapping("/getBorrowInfo.action")
	public @ResponseBody List<LendInfo> getBorrowInfo(@RequestParam("readerId") int readerId, @RequestParam("tab") int tab){
		List<LendInfo> list = new ArrayList<LendInfo>();
		
		switch (tab) {
		case 1:
			list = lendInfoService.queryLendInfoByReaderId(readerId);
			
			break;
		case 2:
			list = lendInfoService.queryLateBorrowByReaderId(readerId);
			
			break;
		case 3:
			list = lendInfoService.queryAllByReaderId(readerId);
			
			break;
		default:
			break;
		}
		for(int i = 0; i < list.size(); i++){
			Book book = bookService.queryOneBook( list.get(i).getBookId() ); 
			Author author = authorService.queryAuthorById(book.getBookAuthorId());
			book.setAuthor(author);
			list.get(i).setBook(book);
			
		}
		return list;
	}
}
