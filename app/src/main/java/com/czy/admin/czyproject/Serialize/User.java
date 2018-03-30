package com.czy.admin.czyproject.Serialize;

import java.io.Serializable;

/**
 * Created by cmx on 2018/3/28.
 */

public class User implements Serializable{
    private static final long serialVersionUID=8711368828010083044L;
    public int userId;
    public String userName;
    public boolean isMale;

    public User(int userId, String userName, boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

//    @Override
//    public String toString() {
//        return userId+"--"+userName+"--"+isMale;
//    }
}
