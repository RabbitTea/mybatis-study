package com.sandra.pojo;

/**
 * 学生实体类
 */
public class Student {

    /**
     * 学生id
     */
    private int id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 这里测试【一对多】；学生关联老师就是一个基本类型
     */
    private int tid;

    public Student() {

    }

    public Student(int id, String name, int tid) {
        this.id = id;
        this.name = name;
        this.tid = tid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", tid=" + tid +
            '}';
    }
}
