package com.sandra.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandra.pojo.User;
import com.sandra.utils.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
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

    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", 2);
        map.put("pageSize", 3);
        List<User> userList = userMapper.getUserByLimit(map);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        /**
         * 通过Java代码层面实现分页；
         * 这里SQL的执行不再用sqlSession.getMapper()方法，而是用select...方法；（现在不建议使用）；
         * 这里使用selectList的第三种重载，提供了RowBounds对象参数；
         */
        // RowBounds
        RowBounds rowBounds = new RowBounds(1,2);

        // 第一个参数为全限定类名加方法名，第二个对象为空则设为null
        List<User> userList = sqlSession.selectList("com.sandra.dao.UserMapper.getUserByRowBounds", null, rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
