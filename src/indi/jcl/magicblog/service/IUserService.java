package indi.jcl.magicblog.service;

import indi.jcl.magicblog.vo.User;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
public interface IUserService {
    public User getUser(int userId);

    public User login(String userName, String pwd);

    public List<User> getList(User user);

    public void update(User user);

    public void insert(User user);

    public void delete(int userId);
}
