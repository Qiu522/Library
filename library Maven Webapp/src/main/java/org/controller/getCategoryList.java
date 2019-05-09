package org.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.model.Category;
import org.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class getCategoryList {
	@Autowired
    private CategoryService categoryService;
	
	
	@RequestMapping("/getCategory.action")
    public @ResponseBody List<Category> getCategory(HttpServletRequest request) {
		
		int pid = Integer.parseInt( request.getParameter("pid") );
		List<Category> list = null;
		try {
			list = categoryService.queryCategory(pid);
			System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
     }
}
