package com.hassan.aicam.common;


public class Queries {
 
    public static final String LOGIN_CHECK = "SELECT USERNAME FROM USERS_ WHERE USERNAME = ? OR PASSWORD_ = ? ";
    public static final String INSERT_USER = "INSERT INTO users_(FNAME, SNAME, LNAME, TNAME, COUNTRY, CITY, DIS, BIRTHDAY, USERNAME, PASSWORD_, EMAIL, PHONE, LANDLINENUM) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
  
    public static final String INSERT_APPDATA = "INSERT INTO APPDATA(STATUS, LOGDATE) VALUES(?,?)";
    public static final String INSERT_SERVELTCREATE = "INSERT INTO USERSERVELT(USERNAME ,CREATION_DATE ) VALUES(?,?)";
}
