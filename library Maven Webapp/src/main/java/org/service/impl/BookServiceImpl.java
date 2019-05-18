package org.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dao.BookDao;
import org.model.Author;
import org.model.Book;
import org.model.Category;
import org.model.Pagebean;
import org.service.AuthorService;
import org.service.BookService;
import org.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService{
	private @Autowired BookService bookService;
	private @Autowired CategoryService categoryService;
	private @Autowired AuthorService authorService;
	private Pagebean page;
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public Book queryOneBook(int id) {
		return bookDao.queryOneBook(id);
	}
	
	@Override
	public List<Book> queryHotBooks(String columnName, int limit) {
		return bookDao.queryHotBooks(columnName, limit);
	}

	@Override
	public Pagebean queryBooksByCategory(int PageNum, int id){
		
		List idList = new ArrayList<Integer>();
		page = new Pagebean();
		page.setPageNum(PageNum);
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
		List<Book> books = bookDao.queryBooksByCategory(idList, startNum, page.getSizePage());
		for(int i = 0; i < books.size(); i++){
			int authorId = books.get(i).getBookAuthorId();
			Author author = authorService.queryAuthorById(authorId);
			books.get(i).setAuthor(author);
		}
		page.setBooks(books);
		page.setTotalCount(allBooks.size());
		page.setTotalPage( page.getTotalPage() );
		
		return page;
	}

	@Override
	public List<Book> queryAllBooksByCategory(List<Integer> categories) {
		
		return bookDao.queryAllBooksByCategory(categories);
	}

	@Override
	public List<Book> queryBookByKey(String key) {
		
		return bookDao.queryBookByKey(key);
	}

	@Override
	public List<Book> queryBookByAuthor(List<Integer> ids) {
		return bookDao.queryBookByAuthor(ids);
	}
	
	
}
