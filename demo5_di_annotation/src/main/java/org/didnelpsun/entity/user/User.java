// User.java
package org.didnelpsun.entity.user;

import org.didnelpsun.entity.utils.HelloWorld;
import org.springframework.stereotype.Component;

@Component
public class User {
    public String name;
    public Integer age;
    public HelloWorld helloWorld;
    public User(){
        this.name = "";
        this.age = 0;
        this.helloWorld = null;
        System.out.println("UserClass");
    }
    public User(int age){
        this();
        this.age = age;
    }
}
