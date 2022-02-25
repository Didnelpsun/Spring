// UserService.java
package org.didnelpsun.service;

import org.didnelpsun.dao.UserDAO;
import org.didnelpsun.utils.ConnectionThread;
import org.didnelpsun.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;

public class UserService implements UserServiceInterface{
    // 业务层调用持久层，需要依赖注入
    private UserDAO userDAO;
    // 需要业务管理，需要依赖注入
//    private TransactionManager transactionManager;
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
//    public void setTransactionManager(TransactionManager transactionManager) {
//        this.transactionManager = transactionManager;
//    }
    @Override
    public boolean insertUser() throws SQLException {
        System.out.println("UserService-insertUser");
//        try{
//            // 开启事务
//            transactionManager.begin();
//            // 执行操作
//            userDAO.insertUser();
//            // 提交事务
//            transactionManager.commit();
//            // 返回结果
//            return true;
//        }
//        catch (Exception e){
//            // 回滚事务
//            System.out.println(e);
//            transactionManager.rollback();
//            return false;
//        }
//        finally {
//            // 释放连接
//            transactionManager.release();
//        }
        userDAO.insertUser();
        return true;
    }
}
