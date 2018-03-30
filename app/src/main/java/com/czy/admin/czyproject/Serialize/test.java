package com.czy.admin.czyproject.Serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by czy on 2018/3/28.
 */

public class test {
    public static void main(String args[]){
        testSerialize();
    }

     public static void testSerialize(){
        //序列化
        User user = new User(0, "lgl", true);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cache.txt"));
            out.writeObject(user);
            out.getClass();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //反序列化
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("cache.txt"));
            User newUser = (User) in.readObject();
            newUser.toString();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
