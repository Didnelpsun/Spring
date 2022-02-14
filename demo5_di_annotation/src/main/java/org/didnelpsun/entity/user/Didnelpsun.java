// Didnelpsun.java
package org.didnelpsun.entity.user;

import org.didnelpsun.entity.utils.HelloWorld;
import org.springframework.stereotype.Component;

@Component
public class Didnelpsun extends User{
    public Didnelpsun(){
        this.name = "Didnelpsun";
        this.helloWorld = new HelloWorld(this);
        System.out.println("DidnelpsunClass");
    }
}
