// UserService.java
package org.didnelpsun.service;

import org.didnelpsun.dao.UserDAO;
import org.didnelpsun.entity.User;
import java.util.List;

public class UserService implements UserServiceInterface{
    // 业务层调用持久层，需要依赖注入
    private UserDAO userDAO;
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public void test(){
        System.out.println("UserService-test");
    }
    @Override
    public List<User> selectUsers() {
        System.out.println("UserService-selectUsers");
        return userDAO.selectUsers();
    }
    @Override
    public Integer insertUser(User user){
        System.out.println("UserService-insertUser");
        return userDAO.insertUser(user);
    }
    @Override
    public Integer deleteUser(int id) {
        System.out.println("UserService-deleteUser");
        return userDAO.deleteUser(id);
    }
}
