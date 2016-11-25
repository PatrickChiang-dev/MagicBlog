package indi.jcl.magicblog.service.impl;

import indi.jcl.magicblog.dao.IUserDAO;
import indi.jcl.magicblog.service.IUserService;
import indi.jcl.magicblog.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2016/9/26.
 */
@Service
public class UserServiceImpl implements IUserService{
    @Resource
    private IUserDAO userDAO;

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }
}
