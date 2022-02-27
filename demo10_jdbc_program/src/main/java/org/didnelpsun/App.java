// App.java
package org.didnelpsun;
// 引入ApplicationContext容器
import org.didnelpsun.entity.User;
import org.didnelpsun.service.UserService;
import org.springframework.context.ApplicationContext;
// 引入支持XML配置的context容器
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

//项目入口
public class App
{
    public static void main(String[] args){
//        // 准备Spring的内部数据源
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/data");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        // 1.创建JdbcTemplate对象
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        // 设置数据源
//        jdbcTemplate.setDataSource(dataSource);
        // 1.获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringBeans.xml");
//        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 2.执行操作
//        jdbcTemplate.execute("select * from user");
//        List<User> users = jdbcTemplate.query("select * from user",new UserRowMapper());
//        List<User> users = jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<User>(User.class));
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

class UserRowMappper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(resultSet.getInt("id"), resultSet.getString("name"),
                resultSet.getString("sex"), resultSet.getDate("birthday"),
                resultSet.getString("address"));
    }
}