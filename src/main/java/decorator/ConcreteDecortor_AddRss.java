package decorator;

import java.util.List;

public class ConcreteDecortor_AddRss extends Decorator_News {
    // / 将新闻标题加入到RSS中
    public String AddRss() {
        // 新闻标题已经被RSS收录
        System.out.println("新闻标题已经加入到RSS中");
        return "";
    }

    public ConcreteDecortor_AddRss(Component_News _Component_News) {
        super(_Component_News);
    }

    // / 重写父类中读取新闻的方法
    @Override
    public List<News> getListOfNews() {
        // 此处加入扩展代码:将新闻标题加入到RSS中
        AddRss();
        return super.getListOfNews();
    }
}