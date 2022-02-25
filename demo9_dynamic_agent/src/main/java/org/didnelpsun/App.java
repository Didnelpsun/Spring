// App.java
package org.didnelpsun;
// 引入依赖类HelloWorld
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.didnelpsun.cglib.HelloWorld;
import org.didnelpsun.entity.DynamicHandler;
import org.didnelpsun.entity.HelloStaticProxy;
//import org.didnelpsun.entity.HelloWorld;

// 引入ApplicationContext容器
import org.didnelpsun.entity.Say;
import org.springframework.context.ApplicationContext;
// 引入支持XML配置的context容器
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//项目入口
public class App
{
    //获取私有属性，这个属性是应用文档属性
//    private static ApplicationContext applicationContext;
    public static void main(String[] args){
//        applicationContext = new ClassPathXmlApplicationContext("SpringBeans.xml");
//        HelloStaticProxy helloStaticProxy = (HelloStaticProxy) applicationContext.getBean("helloStaticProxy");
        // 这个方法是HelloWorld的Setter所以用不了
//        helloStaticProxy.setWords("nmsl");
        // 调用实例方法
//        helloStaticProxy.saySomeThing();
        // 将委托类转换为接口
//        Say helloWorld = new HelloWorld();
//        // 获取处理器，并传入委托对象
//        InvocationHandler handler = new DynamicHandler(helloWorld);
//        // 获取代理对象
//        Say helloDynamicProxy = (Say) Proxy.newProxyInstance(
//                helloWorld.getClass().getClassLoader(),
//                helloWorld.getClass().getInterfaces(),
//                handler
//                );
//        helloDynamicProxy.saySomeThing();
//        HelloWorld helloWorld = new HelloWorld();
//        HelloWorld HelloEnhancer = (HelloWorld) Enhancer.create(
//                helloWorld.getClass(),
//                new MethodInterceptor() {
//                    @Override
//                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                        System.out.println("HelloEnhancer-saySomeThing-Before-Intercept");
////                        method.invoke(helloWorld, objects);
//                        System.out.println("HelloEnhancer-saySomeThing-After-Intercept");
//                        return null;
//                    }
//                }
//        );
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(HelloWorld.class);
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                System.out.println("HelloEnhancer-saySomeThing-Before-Intercept");
//                Object returnValue = method.invoke(o, objects);
//                System.out.println("HelloEnhancer-saySomeThing-After-Intercept");
//                return returnValue;
//            }
//        });
//        HelloWorld helloEnhancer = (HelloWorld) enhancer.create();
//        helloEnhancer.saySomeThing();
    }
}