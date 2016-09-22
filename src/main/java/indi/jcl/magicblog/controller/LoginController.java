package indi.jcl.magicblog.controller;

import indi.jcl.magicblog.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {
	@RequestMapping(value = "login")
	public String login( String userName,String pwd,HttpSession session)throws Exception{
		System.out.println("login.......");
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(pwd)){
			return "redirect:login.html";
		}
		if(!("user0".equals(userName)&&"123456".equals(pwd))){
			return "redirect:login.html";
		}
		User user = new User();
		user.setUserName(userName);
		session.setAttribute("session",user);
		return "redirect:index.html";
	}
}