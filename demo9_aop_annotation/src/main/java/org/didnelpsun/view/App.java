// App.java
package org.didnelpsun.view;
// 引入ApplicationContext容器
import org.didnelpsun.entity.User;
import org.didnelpsun.service.UserService;
import org.springframework.context.ApplicationContext;
// 引入支持注释类的context容器
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("org.didnelpsun")
@EnableAspectJAutoProxy(proxyTargetClass = true)
//项目入口
public class App
{
    public static void main(String[] args){
        // 获取私有属性，这个属性是应用文档属性
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.test();
        userService.selectUsers();
        userService.insertUser(new User());
        userService.deleteUser(0);
    }
}