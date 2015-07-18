package atest;

/**
http://www.mamicode.com/info-detail-585474.html
 * @author qifuguang
 * @date 15/4/21 20:44
 */
public class GcTest {
    private static final int SIZE = 6 * 1024 * 1024;

    public static void localVarGc1() {
        //申请了一个6M大小的空间
        byte[] b = new byte[SIZE];
        //申请了一个6M大小的空间，赋值给b引用，然后调用gc函数，因为此时这个6M的空间还被b引用着，所以不能顺利gc；
        System.gc();
        //[Full GC 6457K->6296K(15872K), 0.0056976 secs]
    }

    public static void localVarGc2() {
        //申请了一个6M大小的空间，赋值给b引用，然后将b重新赋值为null，此时这个6M的空间不再被b引用，所以可以顺利gc；
        byte[] b = new byte[SIZE];
        b = null;
        System.gc();
        //[Full GC 6457K->152K(15872K), 0.0053850 secs]
    }

    public static void localVarGc3() {
        //申请了一个6M大小的空间，赋值给b引用，过了b的作用返回之后调用gc函数，但是因为此时b并没有被销毁，还存在于栈帧中，这个空间也还被b引用，所以不能顺利gc；
        {
            byte[] b = new byte[SIZE];
        }
        System.gc();
        //--------回收前空间-回收后的空间   仅仅释放了161k的空间
        //[Full GC 6457K->6296K(15872K), 0.0067954 secs]
    }

    public static void localVarGc4() {
        //申请了一个6M大小的空间，赋值给b引用，过了b的作用返回之后重新创建一个变量c，
        //此时这个新的变量会复用已经失效的b变量的槽位，所以b被迫销毁了，
        //所以6M的空间没有被任何变量引用，于是能够顺利gc；
        {
            byte[] b = new byte[SIZE];
        }
        int c = 0;
        System.gc();
        //[Full GC 6457K->152K(15872K), 0.0051130 secs]
    }

    public static void localVarGc5() {
        //首先调用localVarGc1()，很显然不能顺利gc，函数调用结束之后再调用gc函数，
        //此时因为localVarGc1这个函数的栈帧已经随着函数调用的结束而被销毁，b也就被销毁了，
        //所以6M大小的空间不被任何对象引用，于是能够顺利gc。
        localVarGc1();
        System.gc();
        //[Full GC 6457K->6296K(15872K), 0.0071203 secs]
        //[Full GC 6296K->152K(15936K), 0.0048699 secs]
    }

    public static void main(String[] args) {
        localVarGc1(); // 没有GC
//        localVarGc2(); // GC
//        localVarGc3(); // 没有GC
//        localVarGc4(); // GC
//        localVarGc5(); // GC
    }
}