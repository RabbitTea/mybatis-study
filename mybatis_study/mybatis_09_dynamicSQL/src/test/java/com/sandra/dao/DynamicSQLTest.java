package com.sandra.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandra.pojo.Blog;
import com.sandra.utils.IdUtil;
import com.sandra.utils.MybatisUtil;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class DynamicSQLTest {

    @Test
    public void addInitBlog() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        String id = IdUtil.genId();
        Date createTime = new Date();
        Blog blog = new Blog(id, "mybatis", "sandra", createTime, 66);
        int addRes = blogMapper.addBlog(blog);

        if (addRes > 0) {
            System.out.println("插入博客信息成功");
        }

        blog.setId(IdUtil.genId());
        blog.setTitle("spring");
        blogMapper.addBlog(blog);

        blog.setId(IdUtil.genId());
        blog.setTitle("springMVC");
        blogMapper.addBlog(blog);

        blog.setId(IdUtil.genId());
        blog.setTitle("spring boot");
        blogMapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIF() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "spring");
        List<Blog> blogs = blogMapper.queryBlogIF(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void queryBlogChoose() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "spring");
        map.put("views", 66);
        List<Blog> blogs = blogMapper.queryBlogChoose(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "637c5efa4f364f61a14bb85e967143f3");
        map.put("title", "好好学习");
        map.put("author", "yue");
        int updateRes = blogMapper.updateBlog(map);

        if (updateRes > 0) {
            System.out.println("更新博客成功...");
        }

        sqlSession.close();
    }

    @Test
    public void queryBlogForeach() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        //ids.add(3);
        map.put("ids", ids);
        List<Blog> blogs = blogMapper.queryBlogForeach(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
