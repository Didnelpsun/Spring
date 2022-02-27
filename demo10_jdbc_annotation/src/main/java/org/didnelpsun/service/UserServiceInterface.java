// UserServiceInterface.java
package org.didnelpsun.service;

import org.didnelpsun.entity.User;
import java.util.List;

public interface UserServiceInterface {
    User selectUser(Integer id);
    List<User> selectUsersByName(String name);
    List<User> selectAllUsers();
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(Integer id);
}
