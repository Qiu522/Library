package org.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.model.Author;
import org.model.Book;
import org.model.Category;
import org.model.Pagebean;
import org.service.AuthorService;
import org.service.BookService;
import org.service.CategoryService;
import org.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BooksPage {
	private @Autowired BookService bookService;
	private @Autowired CategoryService categoryService;
	private @Autowired AuthorService authorService;
	private Pagebean page;
	
	
	@RequestMapping("/bookPage.action")
	public @ResponseBody Pagebean getPageNum(HttpServletRequest request){
		int id = Integer.parseInt( request.getParameter("id") );
		int pageNum = Integer.parseInt( request.getParameter("pageNum") );
		
		
		
		/*List idList = new ArrayList<Integer>();
		page = new Pagebean();
		page.setPageNum(pageNum);
		int startNum = (page.getPageNum()-1)*page.getSizePage();;
		List<Category> categoryList = categoryService.queryCategory(id);
		
		if(categoryList.isEmpty()){//如果传入的id不是父id
			idList.add(id);
		}else {
			for(int i = 0; i < categoryList.size(); i++){
				idList.add(categoryList.get(i).getId());
			}
		}
		List<Book> allBooks = bookService.queryAllBooksByCategory(idList);
		List<Book> books = bookService.queryBooksByCategory(idList, startNum, page.getSizePage(), id);
		for(int i = 0; i < books.size(); i++){
			int authorId = books.get(i).getBookAuthorId();
			Author author = authorService.queryAuthorById(authorId);
			books.get(i).setAuthor(author);
		}
		page.setBooks(books);
		page.setTotalCount(allBooks.size()); //wrong
		page.setTotalPage( page.getTotalPage() );*/
		//TODO
		
		return bookService.queryBooksByCategory( pageNum, id);
	}
	
	
}	
