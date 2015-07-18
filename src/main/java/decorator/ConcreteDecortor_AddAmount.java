package decorator;

import java.util.List;

public class ConcreteDecortor_AddAmount extends Decorator_News {
    public String AddAmount() {
        // 新闻人气加一
        System.out.println("新闻人气已经加一");
        return "新闻人气已经加一";
    }

    public ConcreteDecortor_AddAmount(Component_News _Component_News) {
        super(_Component_News);
    }

    // / 重写父类中读取新闻的方法
    @Override
    public List<News> getListOfNews() {
        // 此处加入扩展代码:新闻人气加一
        AddAmount();
        return super.getListOfNews();
    }
}