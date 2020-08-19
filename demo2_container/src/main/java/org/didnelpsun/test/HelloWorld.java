//HelloWorld.java
package org.didnelpsun.test;

import org.springframework.stereotype.Component;

// 这种标注被放在被管理和引用的类上
@Component
public class HelloWorld {
    // 私有变量words
    private String words;
    private String user = "Didnelpsun";
    //如果我们要对这个类的属性赋值，那么一定要是set开头，如果需要参数就要传入参数
    //参数的配置在resource的xml配置文件中，参数的名字应该对应
    public void setWords(String word){
        this.words = word;
    }
    public void saySomeThing(){
        System.out.println(this.user +"says"+ this.words);
    }
}