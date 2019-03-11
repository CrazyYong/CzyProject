package com.czy.admin.czyproject.jetPack.dataBinding;

/**
 * @author Create by cpSir on 2019/3/8
 */
public class User {
    private final String firstName;

    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
