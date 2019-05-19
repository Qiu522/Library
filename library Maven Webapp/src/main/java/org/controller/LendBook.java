package org.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.LendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class LendBook {
	@Autowired LendInfoService lendInfoService;
	
	@RequestMapping("/lendBook.action")
	public void lendBooks(@RequestParam("readerId") int readerId, @RequestParam("bookId") int bookId, HttpServletResponse response) throws IOException{
		int res = lendInfoService.insertLendInfo(readerId, bookId);
		
		if(res == 1){
			System.out.println("借书成功");
			response.sendRedirect("bookResult.jsp?tab=1");
		}else {
			if(res == 2){
				System.out.println("已借");
				response.sendRedirect("bookResult.jsp?tab=2");
			}else{
				System.out.println("shibai");
				response.sendRedirect("bookResult.jsp?tab=0");
			}
		}
		
	}
	
	
	@RequestMapping("/returnBook.action")
	public void returnBooks(@RequestParam("readerId") int readerId, @RequestParam("bookId") int bookId, HttpServletResponse response) throws IOException{
		
		
		//int res = lendInfoService.insertLendInfo(readerId, bookId);
		
		/*if(res == 1){
			System.out.println("借书成功");
			response.sendRedirect("bookResult.jsp?tab=1");
		}else {
			if(res == 2){
				System.out.println("已借");
				response.sendRedirect("bookResult.jsp?tab=2");
			}else{
				System.out.println("shibai");
				response.sendRedirect("bookResult.jsp?tab=0");
			}
		}*/
		
	}
}
