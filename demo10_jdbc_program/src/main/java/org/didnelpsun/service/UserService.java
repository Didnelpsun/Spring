// UserService.java
package org.didnelpsun.service;

import org.didnelpsun.dao.UserDAO;
import org.didnelpsun.entity.User;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class UserService implements UserServiceInterface {
    // 私有的DAO
    private UserDAO userDAO;
    private TransactionTemplate transactionTemplate;
    // Spring注入
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
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
        // 使用了闭包，所以必须给一个引用类型
        final int[] returnValue = new int[1];
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                // 在这个方法里面放入DAO操作
                returnValue[0] =  userDAO.insertUser(user);
                return null;
            }
        });
        return returnValue[0];
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
