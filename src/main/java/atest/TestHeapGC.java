package atest;


/**
 * -XX:+PrintGCDetails  -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -Xms40M -Xmx40M -Xmn20M
 *@author Administrator
 *@-XX:SurvivorRatio    Eden区与Survivor区的大小比值
 *@-XX:MaxTenuringThreshold 垃圾最大年龄
 *@-Xms 初始堆大小
 *@-Xmx 最大堆大小
 *@-Xmn 年轻代大小(1.4or lator)
 */
public class TestHeapGC {
    public static void main(String args[]){
        byte[] b1=new byte[1024*1024/2];
        byte[] b2=new byte[1024*1024*8];
        b2=null;
        b2=new byte[1024*1024*8];
        System.gc();
    }
}