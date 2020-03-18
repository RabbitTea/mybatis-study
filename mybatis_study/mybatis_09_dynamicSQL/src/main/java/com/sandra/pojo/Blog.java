package com.sandra.pojo;

import java.util.Date;

/**
 * 博客实体类
 */
public class Blog {

    /**
     * 博客id
     */
    private String id;

    /**
     * 博客题目
     */
    private String title;

    /**
     * 博客作者
     */
    private String author;

    /**
     * 博客创建时间；
     * 使用java.util包中的Date，sql包中的查不出时间；
     * 这里createTime和数据表列名create_time不一致，可在Settings中开启自动驼峰命名映射
     */
    private Date createTime;

    /**
     * 博客浏览量；
     */
    private int views;

    public Blog() {

    }

    public Blog(String id, String title, String author, Date createTime, int views) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createTime = createTime;
        this.views = views;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    /**
     * 如果不重写toString方法会在sout输出时返回一个对象实例
     */
    @Override
    public String toString() {
        return "Blog{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", createTime=" + createTime +
            ", views=" + views +
            '}';
    }
}
