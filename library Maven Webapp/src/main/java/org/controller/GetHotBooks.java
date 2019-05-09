package org.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.model.Author;
import org.model.Book;
import org.model.Category;
import org.service.AuthorService;
import org.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetHotBooks {
	@Autowired BookService bookService;
	@Autowired AuthorService authorService;
	
	@RequestMapping("/getHotBook.action")
	public @ResponseBody List<Book> getHotBook(){
		
		List<Book> list = null;
		try {
			list = bookService.queryHotBooks();
			for(int i = 0; i < list.size(); i++){
				Book book = (Book)list.get(i);
				int id = book.getBookAuthorId();
				Author author = authorService.queryAuthorById(id);
				
				list.get(i).setAuthor(author);
			}

			System.out.println(list);
			
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		return list;
	}
	
}
