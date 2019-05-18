package org.controller;

import org.service.LendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class LendBook {
	@Autowired LendInfoService lendInfoService;
	
	@RequestMapping("/lendBook.action")
	public String lendBooks(@RequestParam("readerId") int readerId, @RequestParam("bookId") int bookId){
		int res = lendInfoService.insertLendInfo(readerId, bookId);
		
		if(res == 1){
			System.out.println("借书成功");
			return "success";
		}else {
			if(res == 2){
				System.out.println("已借");
			}else{
				System.out.println("shibai");
			}
			return "error";
		}
		
		
	}
}
