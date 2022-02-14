// App.java
package org.didnelpsun;
import org.didnelpsun.entity.dao.UserDAO;
import org.didnelpsun.entity.user.Didnelpsun;
import org.didnelpsun.entity.user.User;
import org.didnelpsun.entity.utils.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

//@ComponentScan(value = {"org.didnelpsun.entity.user", "org.didnelpsun.entity.dao"})
//@ComponentScan(basePackageClasses = {Didnelpsun.class, UserDAO.class})
//@ComponentScan(value = "org.didnelpsun.entity.user", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class)
//}, useDefaultFilters = false)
//@ComponentScan(value = "org.didnelpsun.entity", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {User.class})
//}, useDefaultFilters = false)
//@ComponentScan(value = "org.didnelpsun.entity", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {HelloWorld.class})
//}, useDefaultFilters = true)
@ComponentScan
public class App
{
    private static ApplicationContext welcomeContext;
    public static void main(String[] args){
        welcomeContext = new AnnotationConfigApplicationContext(App.class);
//        Didnelpsun didnelpsun = welcomeContext.getBean(Didnelpsun.class);
//        didnelpsun.helloWorld.setWords("nmsl");
//        didnelpsun.helloWorld.saySomeThing();
    }
}