package indi.jcl.magicblog.dao;

import indi.jcl.magicblog.vo.User;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */

@MapperScan
public interface IUserDAO {

    public User getUser(int userId);

    public User login(String userName, String pwd);

    public List<User> getList(User user);

    public void update(User user);

    public void insert(User user);

    public void delete(int userId);

}
