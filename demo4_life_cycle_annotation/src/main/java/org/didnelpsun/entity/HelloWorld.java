// HelloWorld.java
package org.didnelpsun.entity;
// 引入Components注释
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// 这种标注被放在被管理和引用的类上
@Component
//@Scope("prototype")
@PropertySource("classpath:helloworld.properties")
public class HelloWorld implements InitializingBean,DisposableBean, BeanPostProcessor {
    @Value("${words}")
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
    @PostConstruct
    public void postConstruct(){
        this.words = "@PostConstruct";
        System.out.println("@PostConstruct");
    }
    // 定义方法调用对应属性并输出
    public void saySomeThing(){
        System.out.println(this.user +" says "+ this.words);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization");
        return null;
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        return null;
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }
}


