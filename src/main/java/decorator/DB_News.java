package decorator;

import java.util.ArrayList;
import java.util.List;

public class DB_News extends Component_News {
    // / 从数据库中取新闻
    // / <returns></returns>
    @Override
    public List<News> getListOfNews() {
        List<News> _list = new ArrayList<News>();
        // 从数据库中取得数据填充到_list 中
        System.out.println("从数据库中取得数据填充到_list 中");
        return _list;
    }
}