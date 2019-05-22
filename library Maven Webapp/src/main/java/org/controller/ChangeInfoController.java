package org.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.model.Reader;
import org.service.ChangeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChangeInfoController {

	@Autowired
	private ChangeInfoService changeInfoServivce;

	@RequestMapping("/changInfo.action")
	public @ResponseBody
	String changeInfo(Reader reader, Model model) {
		Reader reader1 = changeInfoServivce.queryByReaderName(reader);
		if(reader1 != null){
			return "failed";
		}
		// System.out.println(readerName + " " + sex + " " + age);
		int n = changeInfoServivce.updateInfo(reader);

		if (n != 0) {
			return "success";
		}
		return "error";

	}

	@RequestMapping("/changePassword.action")
	public @ResponseBody
	String changePassword(Reader reader, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String code1 = (String) session.getAttribute("code_key");

		String code = request.getParameter("code");
		if (code1.equals(code)) {
			int n = changeInfoServivce.uadatePassword(reader);
			if (n != 0) {
				return "success";
			}
			return "error";
		}
		return "codeError";
	}
}
