// App.java
package org.didnelpsun;
import org.didnelpsun.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    private static ApplicationContext welcomeContext;
    public static void main(String args[]){
        welcomeContext = new ClassPathXmlApplicationContext("SpringBeans.xml");
        User Didnelpsun = (User) welcomeContext.getBean("Didnelpsun");
        Didnelpsun.SayHello();
    }
}