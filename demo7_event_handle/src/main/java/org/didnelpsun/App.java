// App.java
package org.didnelpsun;
//项目入口
import org.didnelpsun.entity.HelloWorld;
import org.didnelpsun.event.PrintEvent;
import org.didnelpsun.event.PrintEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    private static ConfigurableApplicationContext welcomeContext;
    public static void main(String[] args){
        welcomeContext = new ClassPathXmlApplicationContext("SpringBeans.xml");
//        welcomeContext.start();
//        HelloWorld hello = (HelloWorld) welcomeContext.getBean("HelloWorldBean");
//        System.out.println("HelloWorldBean has been build.");
//        welcomeContext.stop();
//        hello.saySomeThing();
//        welcomeContext.close();
        PrintEventPublisher printEventPublisher = (PrintEventPublisher) welcomeContext.getBean("PrintEventPublisher");
        printEventPublisher.publishPrintEvent();
    }
}