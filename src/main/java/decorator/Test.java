package decorator;

public class Test {
    
    public static void main(String[] args) {
      //数据库方式取新闻
        Component_News _Component_News = new DB_News();
        //扩展了展示新闻标题的同时增加此新闻人气的方法
        Decorator_News _Decorator_News = new ConcreteDecortor_AddAmount(_Component_News);
        //扩展了展示新闻标题的同时同时将新闻标题加入RSS中的方法
        _Decorator_News = new ConcreteDecortor_AddRss(_Decorator_News);
        _Decorator_News.getListOfNews();
        //Console.ReadKey();
    }
}
