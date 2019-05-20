package org.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.model.Reader;
import org.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// 这里用了@SessionAttributes，可以直接把model中的reader(也就key)放入其中
// 这样保证了session中存在user这个对象
@SessionAttributes("reader")
public class ReaderLRController {
	@Autowired
	private ReaderService readerServivce;

	@RequestMapping("checkLogin.action")
	public @ResponseBody String checkLogin(Reader reader, Model model, HttpServletResponse response,HttpServletRequest request) throws IOException {
		// 调用service方法
		HttpSession session = request.getSession();
		String code1 = (String) session.getAttribute("code_key");
		String code = request.getParameter("code");
		System.out.println(reader.getReaderName() + " " + reader.getPassword() );
		if(code.equals(code1)){
		reader = readerServivce.checkLogin(reader.getReaderName(),
				reader.getPassword());
		
		session.setAttribute("reader", reader);
		// 若有user则添加到model里并且跳转到成功页面
		if (reader != null) {
			model.addAttribute("reader", reader);
			return "success";
//			response.sendRedirect("index.jsp");
		}
		return "error";
//		response.sendRedirect("login.jsp");
		}
		return "codeError";
	}

	@RequestMapping("/regist.action")
	  public @ResponseBody String doRegist(Reader reader, Model model, HttpServletResponse response,HttpServletRequest request){
		HttpSession session = request.getSession();
		String code1 = (String) session.getAttribute("code_key");
		String readername = request.getParameter("readername");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		if(code1.equals(code)){
			int n = readerServivce.Regist(readername,password);
			if(n != 0){
				return "success";
			}else{
				return "error";
			}
	        
		}else{
			return "codeError";
		} 
    }
}
