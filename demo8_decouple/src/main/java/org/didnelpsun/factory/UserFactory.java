//// UserFactory.java
//package org.didnelpsun.factory;
//
//import org.didnelpsun.entity.User;
//import org.didnelpsun.entity.Message;
//
//public class UserFactory {
//    public UserFactory(){
//        System.out.println("UserFactoryClass");
//    }
//    // 为了方便，所以返回实例的getUserFactory方法直接使用static作为静态方法，就不用实例化UserFactory了
//    // 即静态实例工厂模式
//    public static User getUserFactory(String name, String password, Message message){
//        User user = new User();
//        user.setName(name);
//        user.setPassword(password);
//        user.setMessage(message);
//        return user;
//    }
//    // 重构方法
//    public static User getUserFactory(String name, String password, String id,String sex,String telephone,Integer age){
//        User user = new User();
//        user.setName(name);
//        user.setPassword(password);
//        Message message = new Message();
//        message.setId(id);
//        message.setSex(sex);
//        message.setPhone(telephone);
//        message.setAge(age);
//        user.setMessage(message);
//        return user;
//    }
//    public static String[] getUserMessage(User user){
//        String name = user.getName();
//        String password = user.getPassword();
//        Message message = user.getMessage();
//        String id = message.getId();
//        String sex = message.getSex();
//        String telephone = message.getPhone();
//        Integer age = message.getAge();
//        return new String[]{name,password,id,sex,telephone,age.toString()};
//    }
//}

// UserFactory.java
package org.didnelpsun.factory;

// 只在这里用到了Spring框架的函数
import org.springframework.beans.factory.BeanFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserFactory {
    // 使用properties格式的配置文件，所以使用到了java.util.properties的包
    private static Properties props;
    // 因为是配置文件的导入，所以需要使用静态代码块来优先导入
    static {
        try {
            // 实例化一个配置文件对象
            props = new Properties();
            // 获取配置文件流对象
            // 这里无法使用FileInputStream对象来创建数据流对象
            // 因为这个配置文件不应该是绝对路径，后期可能会更改根路径，所以应该是相对路径
            // BeanFactory是Spring容器，class代表对应的实例化类，
            // getClassLoader就是找到对应的工程中包含Class的Java源文件夹，getResourceAsStream就是找到配置文件夹并以流形式传入，参数为对应的配置文件地址
            InputStream inStream = BeanFactory.class.getClassLoader().getResourceAsStream("Factory.properties");
            // 使用load方法导入对应的配置文件
            props.load(inStream);
        }
        catch (IOException e) {
            System.out.println("初始化异常");
            e.printStackTrace();
            // 可以使用下面的初始化异常
//            throw new ExceptionInInitializerError("初始化异常");
        }
    }
    // 为了方便，所以返回实例的getUserFactory方法直接使用static作为静态方法，就不用实例化UserFactory了
    public static Object getUserFactory(){
        // 因为我们没有直接导入User和Message类，所以对应的返回值类型以及就无法使用User和Message了
        // 所以将原来的类型改为Object类型，做泛型处理
        // 同时，user返回值将变为Object类型
        try{
            String userPath = props.getProperty("User");
            // Class.forName即通过全限定类名获取对应的类
            // getDeclaredConstructor根据他的参数对该类的构造函数进行搜索并返回对应的构造函数，没有参数就返回该类的无参构造函数，
            // 然后再通过newInstance进行实例化。且返回的是Object类型
            return Class.forName(userPath).getDeclaredConstructor().newInstance();
            // 反射后这些私有方法都将失效，如果要设置就必须不能在反射的地方调用私有方法
//            user.setName(Name);
//            user.setPassword(password);
//            user.setMessage(userMessage);
        }
        catch (Exception e){
            e.printStackTrace();
            return new Object();
        }
    }
    // 同理下面另一个方法也因为没有User和Message依赖而无法Setter或者Getter
}