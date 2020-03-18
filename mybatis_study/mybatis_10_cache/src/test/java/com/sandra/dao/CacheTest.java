package com.sandra.dao;

import com.sandra.pojo.User;
import com.sandra.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CacheTest {

    @Test
    public void queryUserById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int id = 1;

        User user1 = userMapper.queryUserById(id);
        System.out.println(user1);

        System.out.println("==========================");

        /**
         * 手动清理缓存
         */
        sqlSession.clearCache();

        /**
         * 二次查询时测试缓存
         */
        User user2 = userMapper.queryUserById(id);
        System.out.println(user2);

        /**
         * 测试两次查询结果是否相同
         */
        System.out.println(user1==user2);

        sqlSession.close();
    }


    @Test
    public void testacheLevel2() {

        /**
         * 为测试二级缓存，开启两个session
         */
        SqlSession sqlSession1 = MybatisUtil.getSqlSession();
        SqlSession sqlSession2 = MybatisUtil.getSqlSession();


        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);


        User user1 = userMapper1.queryUserById(1);
        System.out.println(user1);

        /**
         * 一级缓存关闭了，会将查询保存到二级
         */
        sqlSession1.close();


        System.out.println("==========================");


        /**
         * 同样的id查询测试缓存
         */
        User user2 = userMapper2.queryUserById(1);
        System.out.println(user2);


        /**
         * 测试两次查询结果是否相同
         */
        System.out.println(user1==user2);


        sqlSession2.close();
    }
}
