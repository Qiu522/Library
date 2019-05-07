package org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookCategory {
	@RequestMapping(value="/bookCategory.action")
	public String gotoBook(){
		return "book.jsp?1";
	}
	
}
