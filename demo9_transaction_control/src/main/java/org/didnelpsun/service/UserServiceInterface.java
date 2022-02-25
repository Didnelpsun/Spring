// UserServiceImplement.java
package org.didnelpsun.service;

import java.sql.SQLException;

// 用户业务层接口
public interface UserServiceInterface {
    // 插入用户
    boolean insertUser() throws SQLException;
}
