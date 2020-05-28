package com.example.smartparker.data.model;

public class Registerr {
    private String username;
    private String password;
    private String name;
    private String mobile;
    private String car_no;

    public Registerr(String username, String password,String name,String mobile,String car_no){
        this.username=username;
        this.password=password;
        this.name=name;
        this.mobile=mobile;
        this.car_no=car_no;
    }
}
