package org.didnelpsun;
//项目入口
import org.didnelpsun.test.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@ComponentScan
public class App
{
    //获取私有属性，这个属性是应用文档属性
    private static ApplicationContext welcomeContext;
    public static void main(String args[]){
        //表明实例后的对象都将放到welcomeContext的容器中，后面这一串的方法是
        //利用config来构造context的意思，参数是主类名.class
        welcomeContext = new AnnotationConfigApplicationContext(App.class);
        //使用getBean方法来从容器中获取实例，参数为想要取得的实例类名.class
        HelloWorld hello = welcomeContext.getBean(HelloWorld.class);
        //定义实例属性
        hello.setWords("nmsl");
        hello.saySomeThing();
    }
}