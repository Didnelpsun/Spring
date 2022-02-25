// ConnectionThread.java
package org.didnelpsun.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// 从数据源获取连接并实现和线程的绑定
public class ConnectionThread {
    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();
    // 不能自己定义，只能等待Spring的注入
    private DataSource dataSource;
    public void setConnectionThreadLocal(ThreadLocal<Connection> connectionThreadLocal) {
        this.connectionThreadLocal = connectionThreadLocal;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    // 获取当前线程上的连接
    public Connection getThreadConnection() throws SQLException {
        // 从ThreadLocal上获取连接
        Connection connection = connectionThreadLocal.get();
        // 判断当前线程上是否有连接
        if (connection == null){
            // 没有就从数据源获取一个连接并存入ThreadLocal中绑定
            connection = dataSource.getConnection();
            // 把连接存入线程
            connectionThreadLocal.set(connection);
        }
        return connection;
    }
    // 将连接从线程上移除解绑
    public void removeThreadConnection(){
        connectionThreadLocal.remove();
    }
    // 增强的空方法
    public void begin(){

    }
    public void commit() {

    }
    public void rollback() {

    }
    public void release(){

    }
}
