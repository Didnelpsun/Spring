// UserDAO.java
package org.didnelpsun.dao;

import org.didnelpsun.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import java.util.List;

@PropertySource("classpath:data.properties")
@Repository("userDAO")
public class UserDAO implements UserDAOInterface{
    // 配置DataSource
    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${name}")
    private String username;
    @Value("${password}")
    private String password;
    private DriverManagerDataSource dataSource;
    // 定义一个JdbcTemplate进行操作
    private JdbcTemplate jdbcTemplate;
    // 此时注入必须用@Qualifier标明名字，因为setJdbcTemplate会默认找名为jdbcTemplate的实例
    // JdbcTemplate实例化必须同时设置datasource，否则会报错，所以必须在getJdbcTemplate方法中设置
    @Autowired
    @Qualifier("template")
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Bean("template")
    @Autowired
    @Qualifier("dataSource")
    public JdbcTemplate getJdbcTemplate(DriverManagerDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Bean("dataSource")
    public DriverManagerDataSource getDataSource(){
        this.dataSource = new DriverManagerDataSource();
        this.dataSource.setDriverClassName(this.driver);
        this.dataSource.setUrl(this.url);
        this.dataSource.setUsername(this.username);
        this.dataSource.setPassword(this.password);
        return this.dataSource;
    }
    @Override
    public User selectUser(Integer id) {
        return jdbcTemplate.query("select * from user where id = ?",
                new BeanPropertyRowMapper<>(User.class), id).get(0);
    }
    @Override
    public List<User> selectUsersByName(String name) {
        return jdbcTemplate.query("select * from user where name like \'%" + name + "%\'",
                new BeanPropertyRowMapper<>(User.class));
    }
    @Override
    public List<User> selectAllUsers() {
        return jdbcTemplate.query("select * from user",
                new BeanPropertyRowMapper<>(User.class));
    }
    @Override
    public int insertUser(User user) {
        return jdbcTemplate.update("insert into user(name,sex,birthday,address) values (?,?,?,?);",
                user.getName(), user.getSex(),user.getBirthday(),user.getAddress());
    }
    @Override
    public int updateUser(User user) {
        return jdbcTemplate.update("update user set name=?,sex=?,birthday=?,address=? where id=?;",
                user.getName(), user.getSex(),user.getBirthday(),user.getAddress(), user.getId());
    }
    @Override
    public int deleteUser(Integer id) {
        return jdbcTemplate.update("delete from user where id=?", id);
    }
    //注册事务管理器
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(this.dataSource);
    }
}