//// User.java
//package org.didnelpsun.entity;
//
//public class User {
//    private String name;
//    private String password;
//    private Message message;
//    public User(){
//        System.out.println("UserClass");
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setPassword(String password) {
//        this.password = password;
//    }
//    public String getPassword() {
//        return password;
//    }
//    public void setMessage(Message message) {
//        this.message = message;
//    }
//    public Message getMessage() {
//        return message;
//    }
//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                ", message=" + message +
//                '}';
//    }
//}

// User.java
package org.didnelpsun.entity;

import org.springframework.beans.factory.BeanFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class User {
    private String name;
    private String password;
    // 由于Message没有引用所以直接使用Object
    private Object message;
    public User(){
        System.out.println("UserClass");
        this.name = "";
        this.password = "";
        // 由于是实例化所以不能用静态方式
        try {
            // 定义对应配置文件
            Properties props = new Properties();
            InputStream inStream = BeanFactory.class.getClassLoader().getResourceAsStream("Factory.properties");
            props.load(inStream);
            String messagePath = props.getProperty("Message");
            this.message = Class.forName(messagePath).getDeclaredConstructor().newInstance();
        }
        catch (IOException e) {
            System.out.println("初始化异常");
            e.printStackTrace();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setMessage(Object message) {
        this.message = message;
    }
    public Object getMessage() {
        return message;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", message=" + message +
                '}';
    }
}