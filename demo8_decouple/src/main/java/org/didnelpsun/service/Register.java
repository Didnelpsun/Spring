// Register.java
package org.didnelpsun.service;

import org.didnelpsun.entity.User;
import org.didnelpsun.factory.UserFactory;

public class Register {
    public Register(){
        System.out.println("RegisterClass");
    }
    public static void registerUser(User user){
        if(user.getName()!=null && user.getPassword()!=null){
            System.out.println("注册成功！\n");
//            String[] userMessage = UserFactory.getUserMessage(user);
//            System.out.println("注册信息：\n");
//            for (String message : userMessage) {
//                System.out.println(message + " ");
//            }
        }
    }
}