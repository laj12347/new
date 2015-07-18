package atest;

public class Size {
    public static void main(String[] args) {
        test3();
    }

    public static void test() {
        {
            byte[] b=new byte[6*1024*1024];
        }
        System.gc();
        System.out.println("test fist explict gc over");
    }
    
    public static void test2() {
        {
            byte[] b=new byte[6*1024*1024];
            b=null;
        }
        System.gc();
        System.out.println("test2 fist explict gc over");
    }
    
    public static void test3() {
        {
            byte[] b=new byte[6*1024*1024];
        }
        int a=0;
        System.gc();
        System.out.println("test2 fist explict gc over");
    }
}































