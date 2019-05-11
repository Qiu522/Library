package org.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookCategory {
	@RequestMapping(value="/bookCategory.action")
	public void gotoBook(HttpServletRequest request, HttpServletResponse response){
		//System.out.println(request.getParameter("pid"));
		int pid = Integer.parseInt( request.getParameter("pid") );
		try {
			response.sendRedirect("book.jsp?pid=" + pid );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
