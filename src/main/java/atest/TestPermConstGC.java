package atest;

import org.junit.Test;

/**
 * --------------------常量区大小
 * -XX:PermSize=2M -XX:MaxPermSize=4M -XX:+PrintGCDetails
 * @author Administrator
 *
 */
//* [Full GC [Tenured: 300K->300K(10944K), 0.0142116 secs] 3526K->300K(15936K), 
//==常量区达到最大值就回收一次
//* [Perm : 4096K->938K(4096K)], 0.0144090 secs] 
//* [Times: user=0.02 sys=0.00, real=0.01 secs] 
public class TestPermConstGC {
    @Test
    public void permGenGC() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String t = String.valueOf(i).intern();
        }
    }
}