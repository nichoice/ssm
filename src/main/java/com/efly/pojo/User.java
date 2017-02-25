package com.efly.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Nic on 2017/1/23.
 * 用户信息类。
 */
public class User implements Serializable {

    private static final long serialVersionUID = 436349711080247861L;

    private int id;
    private String username;
    private String password;
    private Date date;

    public User(){
        super();
    }

    public User(String username , String password){
        this.username = username;
        this.password = password;
    }

    public User(int id , String username , String password , Date date){
        this.id = id;
        this.username = username;
        this.password = password;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
