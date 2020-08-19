// App.java
package org.didnelpsun;
// 引入依赖类HelloWorld
import org.didnelpsun.test.HelloWorld;
// 引入ApplicationContext容器
import org.springframework.context.ApplicationContext;
// 引入支持XML配置的context容器
import org.springframework.context.support.ClassPathXmlApplicationContext;

//项目入口
public class App
{
    //获取私有属性，这个属性是应用文档属性
    private static ApplicationContext welcomeContext;
    public static void main(String args[]){
        //将Spring beans配置文件引入，使里面的配置可以被使用
        // 因为项目中我们已经标注了Rosource文件夹，所以默认会去对应的文件夹中寻找配置文件
        // 并让ClassPathXmlApplicationContext根据配置生成对应的实例
        welcomeContext = new ClassPathXmlApplicationContext("SpringBeans.xml");
        // 从context容器中取出名为HelloWorldBean的实例，转型为HelloWorld
        HelloWorld hello = (HelloWorld) welcomeContext.getBean("HelloWorldBean");
        // 定义实例属性
        hello.setWords("nmsl");
        // 调用实例方法
        hello.saySomeThing();
    }
}
//// App.java
//package org.didnelpsun;
//// 引入依赖类HelloWorld
//import org.didnelpsun.test.HelloWorld;
//// 引入ApplicationContext容器
//import org.springframework.context.ApplicationContext;
//// 引入支持注释类的context容器
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//// 引入ComponentScan注释
//import org.springframework.context.annotation.ComponentScan;
//
//@ComponentScan
////项目入口
//public class App
//{
//    // 获取私有属性，这个属性是应用文档属性
//    private static ApplicationContext welcomeContext;
//    public static void main(String args[]){
//        // 表明实例后的对象都将放到welcomeContext的容器中，后面这一串的方法是
//        // 利用注释的config来构造context容器的意思，参数是主类名.class
//        welcomeContext = new AnnotationConfigApplicationContext(App.class);
//        // 使用getBean方法来从容器中获取实例，参数为想要取得的实例类名.class
//        HelloWorld hello = welcomeContext.getBean(HelloWorld.class);
//        // 定义实例属性
//        hello.setWords("nmsl");
//        // 调用实例方法
//        hello.saySomeThing();
//    }
//}