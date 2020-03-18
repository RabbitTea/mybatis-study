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
     * 关联的老师id；
     * 学生需要关联一个老师，如果用int tid去关联，没有一对多，多对一的价值了；就是在这里写死了，不灵活；
     * 如果建模是需要学生关联一个老师，不管是关联老师的哪个属性，就用这种引入实体类对象的方式；
     */
    private Teacher teacher;

    public Student() {

    }

    public Student(int id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", teacher=" + teacher +
            '}';
    }
}
