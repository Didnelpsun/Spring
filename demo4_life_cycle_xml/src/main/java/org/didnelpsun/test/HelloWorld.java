// HelloWorld.java
package org.didnelpsun.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class HelloWorld implements InitializingBean,DisposableBean, BeanPostProcessor {
    private String words = "words";
    private String user = "Didnelpsun";
    public HelloWorld(){
        this.words = "constructor";
        System.out.println("HellowWorldClass");
    }
    public void setWords(String words){
        this.words = words;
    }
    public void afterPropertiesSet() throws Exception{
        this.words = "afterPropertiesSet";
        System.out.println("afterPropertiesSet");
    }
    public void init(){
        this.words = "init-method";
        System.out.println("init-method");
    }
    public void defaultInit(){
        this.words="default-init";
        System.out.println("default-init-method");
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        return null;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization");
        return null;
    }
    public void saySomeThing(){
        System.out.println(this.user +" says "+ this.words);
    }
    public void destroyMethod(){
        System.out.println("destroy-method");
    }
    public void defaultDestroy(){
        System.out.println("default-destroy-method");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }
}