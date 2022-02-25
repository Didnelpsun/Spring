// HelloStaticProxy.java
package org.didnelpsun.entity;

public class HelloStaticProxy implements Say {
    private Say say = new HelloWorld();
    @Override
    public void saySomeThing() {
        System.out.println("HelloStaticProxy-saySomeThing-Before-Invoke");
        say.saySomeThing();
        System.out.println("HelloStaticProxy-saySomeThing-After-Invoke");
    }
}
