// UserDAO.java
package org.didnelpsun.dao;

import org.didnelpsun.entity.User;
import java.util.List;

public class UserDAO implements UserDAOInterface{
    @Override
    public List<User> selectUsers() {
        System.out.println("UserDAO-selectUsers");
        return null;
    }
    @Override
    public int insertUser(User user) {
        System.out.println("UserDAO-insertUser");
        return 0;
    }
    @Override
    public int deleteUser(int id) {
        System.out.println("UserDAO-deleteUser");
        return 0;
    }
}
