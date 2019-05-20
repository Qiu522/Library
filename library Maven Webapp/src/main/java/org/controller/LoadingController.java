package org.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.model.Reader;
import org.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
public class LoadingController {
	@Autowired ReaderService readerService;
	
	@RequestMapping("loading.action")
	public @ResponseBody Reader loading(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		Reader readerObj = (Reader)session.getAttribute("reader");
		
		readerObj.setPassword("");
		System.out.println(readerObj.getId());
		return readerObj;
		
	}
}
