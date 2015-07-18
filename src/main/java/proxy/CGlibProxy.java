package proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
* Cglib动态代理.
* <br>详细说明
* 
* cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，
* 但因为采用的是继承，所以不能对final修饰的类进行代理。 
* @date 2015年7月2日 上午10:23:18
 */
public class CGlibProxy {
    public static void main(String[] args) {
        CglibDBQueryProxy proxy = new CglibDBQueryProxy();
        IDBquery dbQuery = (IDBquery) proxy.getInstance(new DBquery());
        dbQuery.request();
    }
}

class CglibDBQueryProxy implements MethodInterceptor {

    Object target;

    /**
     * 创建代理对象
     * 
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        if (target == null)
            return null;
        System.out.println("事物开始");
        Object result = arg3.invokeSuper(arg0, arg2);
        System.out.println("事物结束");
        return result;
    }

}
