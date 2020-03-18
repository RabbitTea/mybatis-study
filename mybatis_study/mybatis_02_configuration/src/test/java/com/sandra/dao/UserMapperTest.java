package com.sandra.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandra.pojo.User;
import com.sandra.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {

    @Test
    public void getUserList() {
        // 传统的数据库操作要获取PrepareStatement去执行SQL语句

        /**初始代码
         */
        // mybatis数据库操作获取SqlSession即可（可使用项目中封装的方法）
        // 1.得到SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        if (sqlSession == null) {
            System.out.println("sqlSession is null");
            return;
        }

        // 2.找到sql执行语句（Mapper接口和mapper.xml是一致的，一般通过接口获取）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 3.执行sql
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        // 4.关闭SqlSession
        sqlSession.close();
    }

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

    /**
     * 增删改需要提交事务
     */
    @Test
    public void addUser() {
        User user = new User(4, "赵六", "101");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int addResult = userMapper.addUser(user);

        if (addResult == 1) {
            System.out.println("插入用户成功 {" + user.toString() + "}");
        } else {
            System.out.println("插入用户失败 {" + user.toString() + "}");
        }

        //提交事务
        sqlSession.commit();

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        User user = new User(4, "李六", "110");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int updateRes = userMapper.updateUser(user);

        if (updateRes > 0) {
            System.out.println("修改用户成功 {" + user.toString() + "}");
        } else {
            System.out.println("修改用户失败 {" + user.toString() + "}");
        }

        //提交事务
        sqlSession.commit();

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        int id = 4;
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int deleteRes = userMapper.deleteUser(id);
        if (deleteRes > 0) {
            System.out.println("删除用户成功：id=" + id);
        } else {
            System.out.println("删除用户失败");
        }

        //提交事务
        sqlSession.commit();

        //关闭sqlSession
        sqlSession.close();
    }
}
