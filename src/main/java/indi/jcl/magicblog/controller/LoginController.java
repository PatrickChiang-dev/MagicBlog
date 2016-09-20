package indi.jcl.magicblog.controller;

import indi.jcl.magicblog.util.JsonUtil;
import indi.jcl.magicblog.vo.Response;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class LoginController {
	@RequestMapping(value = "login")
	@ResponseBody
	public String hello( String userName,String pwd)throws Exception{
		Response resp = new Response();
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(pwd)){
			resp.setCode(Response.FAIL);
			resp.setMsg("用户名与密码不能为空");
			return JsonUtil.getJsonString(resp);
		}
		if("user0".equals(userName)&&"123456".equals(pwd)){
			resp.setCode(Response.SUCCESS);
			resp.setMsg("登录成功");
			return JsonUtil.getJsonString(resp);
		}else{
			resp.setCode(Response.FAIL);
			resp.setMsg("登录失败");
			return JsonUtil.getJsonString(resp);
		}
	}
}