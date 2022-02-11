//// HelloWorld.java
//package org.didnelpsun.test;
//// 引入Components注释
//import org.springframework.stereotype.Component;
//
//// 这种标注被放在被管理和引用的类上
//@Component
//public class HelloWorld {
//    // 默认构造函数，一旦HelloWorld类被实例化就会被调用
//    HelloWorld () {
//        System.out.println("HelloWorldClass...");
//    }
//    // 私有变量words
//    private String words;
//    private String user = "Didnelpsun";
//    // 如果我们要对这个类的属性赋值，那么一定要是set开头，这是符合settergetter规范的
//    // 如果需要参数就要传入参数
//    public void setWords(String word){
//        this.words = word;
//    }
//    // 定义方法调用对应属性并输出
//    public void saySomeThing(){
//        System.out.println(this.user +" says "+ this.words);
//    }
//}

// HelloWorld.java
package org.didnelpsun.entity;

public class HelloWorld {
    // 私有变量words
    private String words;
    private String user = "Didnelpsun";
    public HelloWorld(){
        System.out.println("HelloWorldClass");
    }
    //如果我们要对这个类的属性赋值，那么一定要是set开头，如果需要参数就要传入参数
    //set开头是因为这是对应的setter方法，用来设置属性
    //还有getter方法用来处理获取相关数据
    //参数的配置在resource的xml配置文件中，参数的名字应该对应
    public void setWords(String word){
        this.words = word;
    }
    public void saySomeThing(){
        System.out.println(this.user +" says "+ this.words);
    }
}

