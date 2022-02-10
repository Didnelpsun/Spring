// HelloWorld.java
package org.didnelpsun.test;
public class HelloWorld {
    // 定义两个私有属性
    private String words;
    private String user;
    // 定义属性的setter方法
    public void setWords(String words){
        this.words = words;
    }
    public void setUser(String user){
        this.user=user;
    }
    // 定义打印属性的方法
    public void saySomeThing(){
        System.out.println(this.user +" says "+ this.words);
    }
}