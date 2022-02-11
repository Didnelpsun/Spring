// App.java
package org.didnelpsun;
// 项目入口
import org.didnelpsun.entity.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App
{
    // 获取私有属性，这个属性是应用文档属性
    private static ApplicationContext welcomeContext;
    public static void main(String[] args){
        // 将Spring beans配置文件引入，使里面的配置可以被使用
        welcomeContext = new ClassPathXmlApplicationContext("SpringBeans.xml");
        // 获取HelloWorldBean并命名为hello1
//        HelloWorld hello1 = (HelloWorld) welcomeContext.getBean("HelloWorldBean");
//        hello1.saySomeThing();
        // 获取HelloWorldBean并命名为hello2
        HelloWorld hello2 = (HelloWorld) welcomeContext.getBean("HelloWorldBean2");
        hello2.saySomeThing();
//        //将主方法变成下面的代码
//        HelloWorld hello1 = (HelloWorld) welcomeContext.getBean("HelloWorldBean");
//        HelloWorld hello2 = (HelloWorld) welcomeContext.getBean("HelloWorldBean");
//        hello1.saySomeThing();
//        hello2.setWords("get out");
//        hello2.saySomeThing();
    }
}