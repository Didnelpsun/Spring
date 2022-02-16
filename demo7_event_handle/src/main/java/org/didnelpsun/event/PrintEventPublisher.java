// PrintEventPublisher.java
package org.didnelpsun.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class PrintEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
    public PrintEventPublisher(){
        System.out.println("PrintEventPublisherClass");
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
        System.out.println("setApplicationEventPublisher");
    }
    public void publishPrintEvent(){
        PrintEvent printEvent = new PrintEvent(this);
        publisher.publishEvent(printEvent);
        System.out.println("publishPrintEvent");
    }
}