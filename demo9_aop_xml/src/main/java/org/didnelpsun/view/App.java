// App.java
package org.didnelpsun.view;

import org.didnelpsun.entity.User;
import org.didnelpsun.service.UserServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.SQLException;
import java.util.List;

//项目入口
public class App
{
    public static void main(String[] args) throws SQLException {
        // 表现层调用业务层
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringBeans.xml");
        // 使用AOP时也必须转为委托类的接口而不是委托类
        UserServiceInterface userService = (UserServiceInterface) applicationContext.getBean("userService");
        userService.test();
        userService.selectUsers();
        userService.insertUser(new User());
        userService.deleteUser(0);
    }
}