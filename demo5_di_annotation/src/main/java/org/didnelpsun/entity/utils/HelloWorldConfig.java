// HelloWorldConfig.java
package org.didnelpsun.entity.utils;

import org.didnelpsun.entity.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public HelloWorld HelloWorld(){
        System.out.println("HelloWorldClass-Config");
        return new HelloWorld(User());
    }
    @Bean
    public User User(){
        return new User();
    }
}