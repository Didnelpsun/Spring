// UserService.java
package org.didnelpsun.service;

import org.didnelpsun.dao.UserDAO;
import org.didnelpsun.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("userService")
public class UserService implements UserServiceInterface {
    // 私有的DAO
    private UserDAO userDAO;
    // Spring注入
    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public User selectUser(Integer id) {
        return userDAO.selectUser(id);
    }
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<User> selectUsersByName(String name) {
        return userDAO.selectUsersByName(name);
    }
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<User> selectAllUsers() {
        return userDAO.selectAllUsers();
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int deleteUser(Integer id) {
        return userDAO.deleteUser(id);
    }
}
