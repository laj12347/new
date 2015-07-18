package decorator;

import java.util.List;

public abstract class Decorator_News extends Component_News {
    // 取新闻
    private Component_News _Component_News;

    public Decorator_News(Component_News _Component_News2) {
        this._Component_News = _Component_News2;
    }

    @Override
    public List<News> getListOfNews() {
        return this._Component_News.getListOfNews();
    }
}