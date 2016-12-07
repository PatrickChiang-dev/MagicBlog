package indi.jcl.magicblog.service.impl;

import indi.jcl.magicblog.dao.IUserDao;
import indi.jcl.magicblog.mapper.UserMapper;
import indi.jcl.magicblog.service.IUserService;
import indi.jcl.magicblog.vo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Magic Long on 2016/9/26.
 */
@Service
@Transactional
public class UserService implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private IUserDao userDao;

    @Override
    public User query(int userId) {
        return userMapper.selectOne(userId);
    }

    @Override
    public User login(String userName, String pwd) {
        User u = new User();
        u.setUserName(userName);
        u.setPwd(pwd);
        List<User> list = userMapper.select(u);
        if(list!=null&&list.size()==0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<User> query(User user) {
        return userMapper.select(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void delete(int userId) {
        userMapper.delete(userId);
    }


}
