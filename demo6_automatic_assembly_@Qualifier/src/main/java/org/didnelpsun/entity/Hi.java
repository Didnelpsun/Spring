// Hi.java
package org.didnelpsun.entity;

import jdk.jfr.Name;
import org.springframework.stereotype.Component;

@Component("Hi")
public class Hi extends HelloWorld{
    public Hi(){
        System.out.println("HiClass");
        this.setWords("hi");
    }
}
