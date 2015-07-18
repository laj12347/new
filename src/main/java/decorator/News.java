package decorator;

public class News {
    // / 新闻标题
    private String _news_title;
    // / 新闻内容
    private String _news_content;

    public String get_news_title() {
        return _news_title;
    }

    public void set_news_title(String _news_title) {
        this._news_title = _news_title;
    }

    public String get_news_content() {
        return _news_content;
    }

    public void set_news_content(String _news_content) {
        this._news_content = _news_content;
    }

}