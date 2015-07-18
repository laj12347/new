package flyweight;
/**
* 享元模式，String中是用了。减少字符串的创建.
* <br>详细说明
* @author liyuan
* @date 2015年7月8日 上午10:03:53
 */
public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight fly = factory.factory(new Character('a'));
        fly.operation("First Call");
        
        fly = factory.factory(new Character('b'));
        fly.operation("Second Call");
        
        fly = factory.factory(new Character('a'));
        fly.operation("Third Call");
    }

}