package com.czy.admin.czyproject.Gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czy on 2017/3/13.
 */

public class User {
    public User(String name,String age,String emailAddress){
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String name;

    public String age;

    @SerializedName("email_address")
    public String emailAddress;
}
