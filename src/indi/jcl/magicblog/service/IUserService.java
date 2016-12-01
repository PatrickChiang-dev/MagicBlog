package indi.jcl.magicblog.service;

import indi.jcl.magicblog.vo.User;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
public interface IUserService {
    public User query(int userId);

    public User login(String userName, String pwd);

    public List<User> query(User user);

    public void update(User user);

    public void add(User user);

    public void delete(int userId);


}
