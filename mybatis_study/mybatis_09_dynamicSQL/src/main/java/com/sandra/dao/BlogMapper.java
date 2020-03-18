package com.sandra.dao;

import java.util.List;
import java.util.Map;

import com.sandra.pojo.Blog;

/**
 * 博客实体类对应的数据库操作接口
 */
public interface BlogMapper {

    /**
     * 插入数据
     */
    int addBlog(Blog blog);

    /**
     * 查询博客；
     * 使用动态SQL的if标签，在符合条件时，追加一个SQL查询条件
     */
    List<Blog> queryBlogIF(Map<String, Object> map);

    /**
     * 查询；
     * choose（when，otherwise）标签；
     */
    List<Blog> queryBlogChoose(Map<String, Object> map);

    /**
     * 更新博客；
     * 动态SQL：set标签；
     */
    int updateBlog(Map<String, Object> map);

    /**
     * 查询第1-2-3号id的博客
     */
    List<Blog> queryBlogForeach(Map<String, Object> map);
}
