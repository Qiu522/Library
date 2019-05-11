package org.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.Author;
import org.model.Book;
import org.model.Category;
import org.service.AuthorService;
import org.service.BookService;
import org.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetBookById {
	private @Autowired BookService bookService;
	private @Autowired AuthorService authorService;
	private @Autowired CategoryService categoryService;
	
	@RequestMapping(value="/bookDetail.action")
	public void gotoBookDetail(HttpServletRequest request, HttpServletResponse response){
		int id = Integer.parseInt( request.getParameter("id") );
		try {
			response.sendRedirect("bookdetail.jsp?id=" + id );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("getBookDetail.action")
	public @ResponseBody Book getBookDetail(HttpServletRequest request, HttpServletResponse response){
		int id = Integer.parseInt( request.getParameter("id") );
		Book book = null;
		
		book = bookService.queryOneBook(id);
		Author author = authorService.queryAuthorById( book.getBookAuthorId() );
		System.out.println(author);
		book.setAuthor(author);
		Category category = categoryService.queryCategoryById( book.getCategoryId() );
		book.setCategory(category);
		
		return book;
	}
	
}
