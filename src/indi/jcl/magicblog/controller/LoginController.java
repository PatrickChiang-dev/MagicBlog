package indi.jcl.magicblog.controller;

import indi.jcl.magicblog.vo.Response;
import indi.jcl.magicblog.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "login")
	@ResponseBody
	public Response login( String userName,String pwd,HttpSession session)throws Exception{
		logger.info("user:"+userName+" ---> login......");
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(pwd)){
			return new Response(Response.FAIL,"用户名或密码不能为空");
		}
		if(!("user0".equals(userName)&&"123456".equals(pwd))){
			return new Response(Response.FAIL,"用户名或密码错误");
		}
		User user = new User();
		user.setUserName(userName);
		session.setAttribute("session",user);
		return new Response(Response.SUCCESS,"登录成功");

	}
}