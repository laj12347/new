package decorator;

import java.util.List;
/**
* 装饰者模式.
* <br>http://www.cnblogs.com/ASPNET2008/archive/2008/06/22/1227556.html
* @date 2015年7月8日 上午10:03:35
 */
public abstract  class Component_News
{
   /// <summary>
    /// 取新闻
    /// </summary>
    /// <returns></returns>
   public abstract List<News> getListOfNews();
}