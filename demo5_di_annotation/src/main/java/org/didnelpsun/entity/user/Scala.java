// Scala.java
package org.didnelpsun.entity.user;

import org.didnelpsun.entity.utils.HelloWorld;
import org.springframework.stereotype.Component;

@Component
public class Scala extends User{
    public Scala(){
        this.name = "Scala";
        this.helloWorld = new HelloWorld(this);
        System.out.println("ScalaClass");
    }
}
