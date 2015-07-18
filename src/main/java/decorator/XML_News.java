package decorator;

import java.util.ArrayList;
import java.util.List;

public class XML_News extends Component_News {
    //从XML中取新闻
    @Override
    public List<News> getListOfNews() {
        List<News> _list = new ArrayList<News>();
        // 从XML中取得数据填充到_list 中
        System.out.println("从XML中取得数据填充到_list 中");
        return _list;
    }
}
