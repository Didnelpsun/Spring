// StartHandler.java
package org.didnelpsun.event;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class StartHandler implements ApplicationListener<ContextStartedEvent>{
    @Override
    public void onApplicationEvent(ContextStartedEvent ContextStartedEvent){
        System.out.println("The application is starting...");
    }
}