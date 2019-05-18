package org.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.model.Author;
import org.model.Book;
import org.model.Pagebean;
import org.service.AuthorService;
import org.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Search {
	@Autowired BookService bookServer;
	@Autowired AuthorService authorServer;
	
	@RequestMapping(value = "/search.action")
	public void gotosearch(@RequestParam("searchWay") String searchWay, @RequestParam("name") String name, HttpServletResponse response) throws IOException{
		response.sendRedirect("search.jsp?searchWay=" + searchWay + "&name=" + URLEncoder.encode(name,"utf-8") );
		
	}
	
	@RequestMapping(value = "/getSearchResult.action")
	public @ResponseBody List<Book> getResult(@RequestParam("searchWay") String searchWay, @RequestParam("name") String name){
		//System.out.println(searchWay.equals("bookName"));
		//System.out.println(name);
		List<Book> list = new ArrayList<Book>();
		
		if( searchWay.equals("bookName") ){
			list = bookServer.queryBookByKey(name);
			//System.out.println(list.size());
		}else {
			List<Integer> ids = authorServer.queryAuthorByName(name);
			if(ids.size() != 0){
				list = bookServer.queryBookByAuthor(ids);
				
			}
		}
		for(int i = 0; i < list.size(); i++){
			Book book = (Book)list.get(i);
			int id = book.getBookAuthorId();
			Author author = authorServer.queryAuthorById(id);
			System.out.println(author);
			list.get(i).setAuthor(author);
		}
		return list;
	}
	
}
