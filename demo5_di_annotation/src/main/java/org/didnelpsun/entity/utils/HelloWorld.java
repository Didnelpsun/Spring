// HelloWorld.java
package org.didnelpsun.entity.utils;

import org.didnelpsun.entity.user.User;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
    public HelloWorld (User user) {
        this.user = user;
        System.out.println("HelloWorldClass");
    }
    private String words;
    private User user;
    public void setWords(String word){
        this.words = word;
    }
    public void saySomeThing(){
        System.out.println(this.user.name +" says "+ this.words);
    }
    public void init(){
        System.out.println("init");
    }
    public void destroy(){
        System.out.println("destroy");
    }
}
