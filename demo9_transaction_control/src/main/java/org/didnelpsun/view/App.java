// App.java
package org.didnelpsun.view;

import org.didnelpsun.service.UserService;
import org.didnelpsun.service.UserServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

//项目入口
public class App
{
    public static void main(String[] args) throws SQLException {
        // 表现层调用业务层
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringBeans.xml");
//        UserService userService = (UserService) applicationContext.getBean("userService");
        // 使用代理时必须转为委托类的接口而不是委托类
        UserServiceInterface userService = (UserServiceInterface) applicationContext.getBean("userServiceProxy");
        Boolean result = userService.insertUser();
        System.out.println(result);
    }
}