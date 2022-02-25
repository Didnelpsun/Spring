// TransactionManager.java
package org.didnelpsun.utils;

import java.sql.SQLException;

// 事务管理工具类，包括开启事务、提交事务、回滚事务、释放连接
public class TransactionManager {
    // 获取连接，需要Spring注入
    private ConnectionThread connectionThread;
    public void setConnectionThread(ConnectionThread connectionThread) {
        this.connectionThread = connectionThread;
    }
    public void begin() throws SQLException {
        // 将获取到的连接的自动提交关闭
        this.connectionThread.getThreadConnection().setAutoCommit(false);
    }
    public void commit() throws SQLException {
        this.connectionThread.getThreadConnection().commit();
    }
    public void rollback() throws SQLException {
        this.connectionThread.getThreadConnection().rollback();
    }
    public void release() throws SQLException {
        // 将连接还回连接池
        this.connectionThread.getThreadConnection().close();
        // 将连接与线程解绑
        this.connectionThread.removeThreadConnection();
    }
}
