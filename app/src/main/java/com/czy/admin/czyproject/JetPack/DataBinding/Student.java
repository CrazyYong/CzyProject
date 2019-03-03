package com.czy.admin.czyproject.JetPack.DataBinding;

/**
 * Created by cpsir on 2019/3/4
 */
public class Student {
    public Student(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    private String addr;
}
