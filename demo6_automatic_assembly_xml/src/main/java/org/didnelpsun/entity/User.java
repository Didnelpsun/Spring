// User.java
package org.didnelpsun.entity;

public class User {
    private String name;
    private Integer age;
    private HelloWorld helloWorld;
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
    public User(HelloWorld helloWorld){
        this();
        this.helloWorld = helloWorld;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public HelloWorld getHelloWorld() {
        return helloWorld;
    }
    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }
}
