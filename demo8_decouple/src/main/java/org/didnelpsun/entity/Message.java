// Message.java
package org.didnelpsun.entity;

public class Message {
    private String id;
    private String sex;
    private String phone;
    private Integer age;
    public Message(){
        System.out.println("MessageClass");
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}