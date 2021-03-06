package com.sandra.pojo;

import java.util.List;

/**
 * 老师实体类
 */
public class Teacher {
    /**
     * 老师id
     */
    private int id;

    /**
     * 老师名称
     */
    private String name;

    /**
     * 【一对多】集合关系；一个老师拥有多个学生
     */
    private List<Student> students;

    public Teacher() {

    }

    public Teacher(int id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", students=" + students +
            '}';
    }
}
