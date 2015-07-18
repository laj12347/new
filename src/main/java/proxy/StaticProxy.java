package proxy;

/**
 * 静态代理模式(代理模式).
 * 
 * 观察代码可以发现每一个代理类只能为一个接口服务，这样一来程序开发中必然会产生过多的代理，
 * 而且，所有的代理操作除了调用的方法不一样之外，其他的操作都一样，则此时肯定是重复代码。
 * 解决这一问题最好的做法是可以通过一个代理类完成全部的代理功能，那么此时就必须使用动态代理完成。
 */

public class StaticProxy {
    public static void main(String[] args) {
        CountImpl countImpl = new CountImpl();
        CountProxy countProxy = new CountProxy(countImpl);
        countProxy.updateCount();
        countProxy.queryCount();
    }
}

/**
 * 定义一个账户接口
 */
interface Count {
    // 查看账户方法
    public String queryCount();

    // 修改账户方法
    public void updateCount();
}

/**
 * 委托类(包含业务逻辑)
 */
class CountImpl implements Count {

    @Override
    public String queryCount() {
        System.out.println("查看账户方法...");
        return "查看账户方法...";
    }

    @Override
    public void updateCount() {
        System.out.println("修改账户方法...");
    }
}

/**
 * 这是一个代理类（增强CountImpl实现类）
 */
class CountProxy implements Count {
    private CountImpl countImpl;

    /**
     * 覆盖默认构造器
     * 
     * @param countImpl
     */
    public CountProxy(CountImpl countImpl) {
        this.countImpl = countImpl;
    }

    @Override
    public String queryCount() {
        System.out.println("----------事务处理之前----------");
        // 调用委托类的方法;
        String str = countImpl.queryCount();
        System.out.println("----------事务处理之后----------");
        return str;
    }

    @Override
    public void updateCount() {
        System.out.println("----------事务处理之前----------");
        // 调用委托类的方法;
        countImpl.updateCount();
        System.out.println("----------事务处理之后----------");
    }
}