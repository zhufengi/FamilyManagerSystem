package com.zf.fms.bean;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2018/4/17 0017.
 * 用户
 */
public class FamilyUser {
    private int userId;
    private String name;
    private String sex;
    private String age;
    private String password;
    private String phone;
    private String work;
    private Timestamp birthTime;
    private String birthAddress;
    private int role;//权限级别

    public FamilyUser( String password) {
        this.password = password;
    }

    public FamilyUser(int userId, String name, String sex, String age, String phone, String work, Timestamp birthTime, String birthAddress) {
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.work = work;
        this.birthTime = birthTime;
        this.birthAddress = birthAddress;
    }
    public FamilyUser(int userId, String name, String sex, String age, String password, String phone, String work, Timestamp birthTime, String birthAddress,  int role) {
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.password = password;
        this.phone = phone;
        this.work = work;
        this.birthTime = birthTime;
        this.birthAddress = birthAddress;
        this.role = role;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Timestamp getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(Timestamp birthTime) {
        this.birthTime = birthTime;
    }

    public String getBirthAddress() {
        return birthAddress;
    }

    public void setBirthAddress(String birthAddress) {
        this.birthAddress = birthAddress;
    }


    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "FamilyUser{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", work='" + work + '\'' +
                ", birthTime=" + birthTime +
                ", birthAddress='" + birthAddress + '\'' +
                ", role=" + role +
                '}';
    }
}
