// UserDAO.java
package org.didnelpsun.dao;

import org.didnelpsun.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDAO implements UserDAOInterface{
    // 定义一个JdbcTemplate进行操作
    private JdbcTemplate jdbcTemplate;
    // Spring注入
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
}
