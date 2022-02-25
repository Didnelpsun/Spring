// UserDAOInterface.java
package org.didnelpsun.dao;

import org.didnelpsun.entity.User;
import java.util.List;

public interface UserDAOInterface {
    // 获取用户方法
    List<User> selectUsers();
    // 插入用户方法
    int insertUser(User user);
    // 删除用户方法
    int deleteUser(int id);
}
