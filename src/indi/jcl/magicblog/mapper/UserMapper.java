package indi.jcl.magicblog.mapper;

import indi.jcl.magicblog.vo.User;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */

public interface UserMapper {

    public User selectOne(int userId);

    public List<User> select(User user);

    public void update(User user);

    public void insert(User user);

    public void delete(int userId);



}
