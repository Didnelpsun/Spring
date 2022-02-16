// PrintHandler.java
package org.didnelpsun.event;
import org.springframework.context.ApplicationListener;

public class PrintHandler implements ApplicationListener<PrintEvent> {
    @Override
    public void onApplicationEvent(PrintEvent event) {
        System.out.println("PrintHandlerClass");
    }
}