// ServiceProxy.java
package org.didnelpsun.proxy;

import org.didnelpsun.service.UserService;
import org.didnelpsun.service.UserServiceInterface;
import org.didnelpsun.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceProxy {
    private UserService userService;
    // Spring依赖注入
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    private TransactionManager transactionManager;
    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    // 获取用户代理
    // 获取的对象必须是委托类的接口而不是委托类，因为实现类是与Proxy同级的
    public UserServiceInterface getUserService() {
        return (UserServiceInterface) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        try{
                            // 开启事务
                            transactionManager.begin();
                            // 执行操作
                            System.out.println("ServiceProxy-getUserService-Before-Invoke");
                            returnValue = method.invoke(userService,args);
                            System.out.println("ServiceProxy-getUserService-After-Invoke");
                            // 提交事务
                            transactionManager.commit();
                        }
                        catch (Exception e){
                            // 回滚事务
                            System.out.println(e);
                            transactionManager.rollback();
                        }
                        finally {
                            // 释放连接
                            transactionManager.release();
                        }
                        return returnValue;
                    }
                }
        );
    }
}
