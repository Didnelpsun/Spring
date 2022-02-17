// App.java
package org.didnelpsun;
// 项目入口

import org.didnelpsun.entity.Message;
import org.didnelpsun.entity.User;
import org.didnelpsun.factory.ObjectFactory;
import org.didnelpsun.service.Register;

public class App
{
    public static void main(String args[]){
//        //利用工厂模式来构造一个Didnelpsun的User实例
//        User Didnelpsun = UserFactory.getUserFactory("Didnelpsun","0824", "1234","man","13566444",20);
//        //注册这个用户
//        Register.registerUser(Didnelpsun);
        //利用工厂模式来构造一个Didnelpsun的User实例
//        User Didnelpsun = (User) UserFactory.getUserFactory();
//        //注册这个用户
//        Didnelpsun.setName("Didnelpsun");
//        Didnelpsun.setPassword("0824");
//        Register.registerUser(Didnelpsun);
        User Didnelpsun = (User) ObjectFactory.getObjectFactory("User");
        //注册这个用户
        Didnelpsun.setName("Didnelpsun");
        Didnelpsun.setPassword("0824");
        Message message = (Message) ObjectFactory.getObjectFactory("Message");
        message.setAge(19);
        message.setSex("男");
        Didnelpsun.setMessage(message);
        Register.registerUser(Didnelpsun);
        System.out.println(Didnelpsun);
        User test = (User) ObjectFactory.getObjectFactory("User");
        test.setName("test");
        System.out.println(test);
    }
}