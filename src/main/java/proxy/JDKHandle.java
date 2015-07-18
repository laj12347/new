package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理. <br>
 * 
 * 动态代理比代理模式还是灵活很多的，比如统一给类加日志，加事物。如果使用代理类就需要给每个类写一个代理类。而是用动态代理就省略了很多类。
 * 
 * JDK的动态代理机制只能代理实现了接口的类，而不能实现接口的类就不能实现JDK的动态代理
 * 
 * @author liyuan
 * @date 2015年7月2日 上午9:03:50
 */
public class JDKHandle {

    public static void main(String[] args) {
        IDBquery jdkBquery = (IDBquery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[] { IDBquery.class }, new LoggerProxy(new DBquery()));

        jdkBquery.request();
        jdkBquery.response();
    }
}

class LoggerProxy implements InvocationHandler {

    Object target = null;

    public LoggerProxy() {

    }

    public LoggerProxy(Object target) {
        this.target = target;
    }

    /**
     * 绑定委托对象并返回一个代理类
     * 
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        // 取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        // 要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
    }

    /**
     * 执行目标对象的方法
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 在目标对象的方法执行之前简单的打印一下
        System.out.println("------------------before  记录日志------------------");
        // 执行目标对象的方法
        Object result = method.invoke(target, args);
        // 在目标对象的方法执行之后简单的打印一下
        System.out.println("-------------------after  记录日志------------------");

        return result;
    }
}

class JianKongProxy implements InvocationHandler {

    Object target = null;

    public JianKongProxy() {

    }

    public JianKongProxy(Object target) {
        this.target = target;
    }

    /**
     * 执行目标对象的方法
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 在目标对象的方法执行之前简单的打印一下
        System.out.println("------------------before  监控------------------");

        // 执行目标对象的方法
        Object result = method.invoke(target, args);

        // 在目标对象的方法执行之后简单的打印一下
        System.out.println("-------------------after  监控------------------");

        return result;
    }
}

interface IDBquery {
    public String request();

    public String response();
}

class DBquery implements IDBquery {

    public String request() {
        System.out.println("request string");
        return "request string";
    }

    public String response() {
        System.out.println("response string");
        return "response string";
    }

}
