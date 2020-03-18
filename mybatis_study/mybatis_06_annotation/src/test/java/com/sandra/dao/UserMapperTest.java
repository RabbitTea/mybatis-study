package com.sandra.dao;

import com.sandra.pojo.User;
import com.sandra.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class UserMapperTest {

    /**
     * Logger文件可在多个方法中使用，放在这里提升作用域
     */
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserById() {
        int uid = 2;
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(uid, "李四");
        System.out.println(user);

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(5, "乔峰", "666");
        int addRes = userMapper.addUser(user);

        if (addRes > 0) {
            System.out.println("插入用户成功");
        }

        sqlSession.close();
    }

}
