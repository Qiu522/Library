package org.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.model.Category;
import org.service.CategoryService;
import org.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class getCategoryList {
	@Autowired
    private CategoryService categoryService;
	
	
	@RequestMapping(value="/aaa.action")
    public @ResponseBody List<Category> hello(HttpServletRequest request) {
		
		int pid = Integer.parseInt( request.getParameter("pid") );
		List<Category> list = null;
		try {
			list = categoryService.queryCategory(pid);
			System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        //System.out.println("pid为：" + pid);
        
        return list;
     }
}
