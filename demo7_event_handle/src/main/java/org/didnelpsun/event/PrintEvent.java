// PrintEvent.java
package org.didnelpsun.event;

import org.springframework.context.ApplicationEvent;

public class PrintEvent extends ApplicationEvent {
    public PrintEvent(Object father){
        super(father);
        System.out.println("PrintEventClass");
    }
    public String toString(){
        return "PrintEvent";
    }
}