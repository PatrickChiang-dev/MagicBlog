package indi.jcl.magicblog.controller;

import indi.jcl.magicblog.service.IUserService;
import indi.jcl.magicblog.vo.Response;
import indi.jcl.magicblog.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("query")
    @ResponseBody
    public Response query(User user) throws Exception {
        List<User> list = userService.query(user);
        return Response.SUCCESS().setResult(list);
    }
}