// CloseHandler.java
package org.didnelpsun.event;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class CloseHandler implements ApplicationListener<ContextClosedEvent>{
    @Override
    public void onApplicationEvent(ContextClosedEvent ContextClosedEvent){
        System.out.println("The application is closing...");
    }
}