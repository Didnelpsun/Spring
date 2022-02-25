// DynamicHandler.java
package org.didnelpsun.entity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicHandler implements InvocationHandler {
    // 委托类，通过委托对象建立代理处理方法
    private Object delegate;
    public DynamicHandler(Object delegate){
        this.delegate = delegate;
    }
    // 拦截引用委托接口的方法从而实现动态代理
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println( proxy.getClass().getName() + "-" + method.getName() + "-Before-Invoke");
        // 获取代理所调用的方法即为method，将委托对象的方法拦截并调用
        method.invoke(delegate, args);
        System.out.println( proxy.getClass().getName() + "-"  + method.getName() + "-After-Invoke ");
        return null;
    }
}
