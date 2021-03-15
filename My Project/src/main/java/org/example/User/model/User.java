package org.example.User.model;

import org.example.BaseCondition;

public class User extends BaseCondition {
    private Integer id;
    private Integer age;
    private String name;
    private String dept;

    public User(Integer age, String name,String dept) {
        this.age = age;
        this.name = name;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public User() {
    }

    public void getCondition(){
        add(age,"and age=? ");
        add(id,"and id=? ");
        add(name,"and name like ? ",2);
        add(dept,"and dept=? ",1);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
