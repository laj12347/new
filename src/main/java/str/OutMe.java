package str;

import java.util.ArrayList;
import java.util.List;
/**
* String的substring是直接拷贝一份原有数据，然后做前后的表示，会浪费大量的内存空间，此算法是以空间换时间。.
* <br>详细说明
* @author liyuan
* @date 2015年7月8日 上午10:05:42
 */
public class OutMe {
    public static void main(String[] args) {
        List<String> handler = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            HugeStr h = new HugeStr(); //会出现内存溢出：java.lang.OutOfMemoryError: Java heap space
//          ImprovedHugeStr h=new ImprovedHugeStr();
            handler.add(h.getSubString(1, 5));
        }
    }
}
class HugeStr {
    private String str = new String(new char[100000]);
    public String getSubString(int begin, int end) {
        return str.substring(begin, end);
    }
}
class ImprovedHugeStr {
    private String str = new String(new char[100000]);
    public String getSubString(int begin, int end) {
        return new String(str.substring(begin, end));
    }
}
