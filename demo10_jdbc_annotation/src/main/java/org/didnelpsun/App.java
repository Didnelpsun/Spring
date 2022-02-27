// App.java
package org.didnelpsun;
// 引入ApplicationContext容器
import org.didnelpsun.entity.User;
import org.didnelpsun.service.UserService;
import org.springframework.context.ApplicationContext;
// 引入支持XML配置的context容器
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.util.Calendar;
import java.util.List;

@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan
//项目入口
public class App
{
    public static void main(String[] args){
        // 1.获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        // 2.执行操作
        UserService userService = applicationContext.getBean("userService", UserService.class);
        List<User> users = userService.selectAllUsers();
        printList(users);
        User user = userService.selectUser(1);
        user.setSex("男");
        userService.updateUser(user);
        System.out.println("更新后：");
        users = userService.selectAllUsers();
        printList(users);
        System.out.println("模糊查询：");
        users = userService.selectUsersByName("黄");
        printList(users);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.APRIL,14);
        user = new User("测试","男", calendar.getTime(),"测试" );
        userService.insertUser(user);
        System.out.println("插入后：");
        users = userService.selectAllUsers();
        printList(users);
        user = userService.selectUsersByName("测").get(0);
        userService.deleteUser(user.getId());
        System.out.println("删除后：");
        users = userService.selectAllUsers();
        printList(users);
    }
    // 打印函数
    static public <T> void printList(List<T> list){
        for(T item : list){
            System.out.println(item);
        }
    }
}