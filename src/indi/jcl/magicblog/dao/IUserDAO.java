package indi.jcl.magicblog.dao;

import indi.jcl.magicblog.vo.User;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by Administrator on 2016/9/26.
 */

@MapperScan
public interface IUserDAO {
    public User getUser(int id);

}
