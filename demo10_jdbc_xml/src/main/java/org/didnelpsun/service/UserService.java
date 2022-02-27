// UserService.java
package org.didnelpsun.service;

import org.didnelpsun.dao.UserDAO;
import org.didnelpsun.entity.User;
import java.util.List;

public class UserService implements UserServiceInterface {
    // 私有的DAO
    private UserDAO userDAO;
    // Spring注入
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public User selectUser(Integer id) {
        return userDAO.selectUser(id);
    }
    @Override
    public List<User> selectUsersByName(String name) {
        return userDAO.selectUsersByName(name);
    }
    @Override
    public List<User> selectAllUsers() {
        return userDAO.selectAllUsers();
    }
    @Override
    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }
    @Override
    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }
    @Override
    public int deleteUser(Integer id) {
        return userDAO.deleteUser(id);
    }
}
