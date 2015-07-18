package atest;

import org.junit.Test;

/**
 * -Xss1M
 * 栈空间溢出
 * 递归导致栈空间溢出：java.lang.StackOverflowError
 */
public class TestStack {
    private int count = 0;

    public void recursion() throws InterruptedException {
        count++;
        recursion();
    }

    @Test
    public void testStack() {
        try {
            recursion();
        } catch (Throwable e) {
            System.out.println("deep of stack is " + count);
            e.printStackTrace();
        }
    }
}