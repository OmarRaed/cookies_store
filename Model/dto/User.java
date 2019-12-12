package com.hassan.aicam.dto;

import java.util.Date;

public class User {
    public User() {
        super();
    }
     
    private String fName,sName,tName,lName,country,city,dis;
    private Date birthDay;
    private String userName,password; 
    private String email;
    private String phone,landLineNum;
    // true for male false for female 
    //private boolean gender;

    public void setTName(String tName) {
        this.tName = tName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public String getDis() {
        return dis;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setLandLineNum(String landLineNum) {
        this.landLineNum = landLineNum;
    }

    public String getLandLineNum() {
        return landLineNum;
    }

    public String getTName() {
        return tName;
    }
 

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    } 
 
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFName() {
        return fName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSName() {
        return sName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getLName() {
        return lName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
 
 
}
