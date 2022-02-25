// UserServiceImplement.java
package org.didnelpsun.service;

import org.didnelpsun.entity.User;
import java.util.List;

// 用户业务层接口
public interface UserServiceInterface {
    void test();
    // 获取用户，返回用户列表
    List<User> selectUsers();
    // 插入用户，返回用户数
    Integer insertUser(User user);
    // 删除用户，返回用户数
    Integer deleteUser(int id);
}
