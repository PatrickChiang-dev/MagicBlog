package indi.jcl.magicblog.service.impl;

import indi.jcl.magicblog.dao.IUserDAO;
import indi.jcl.magicblog.service.IUserService;
import indi.jcl.magicblog.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Administrator on 2016/9/26.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDAO userDAO;

    @Override
    public User getUser(int userId) {
        return userDAO.getUser(userId);
    }

    @Override
    public User login(String userName, String pwd) {
        return userDAO.login(userName, pwd);
    }

    @Override
    public List<User> getList(User user) {
        return userDAO.getList(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void insert(User user) {
        userDAO.insert(user);
    }

    @Override
    public void delete(int userId) {
        userDAO.delete(userId);
    }
}
