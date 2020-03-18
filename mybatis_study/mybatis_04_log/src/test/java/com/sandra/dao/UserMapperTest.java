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
        int id = 2;
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(id);
        System.out.println(user);

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info：进入了testLog4j");
        logger.debug("debug：进入了testLog4j");
        logger.error("error：进入了testLog4j");
    }
}
