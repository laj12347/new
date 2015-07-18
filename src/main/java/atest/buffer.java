package atest;

import java.nio.ByteBuffer;

public class buffer {
    public static void main(String[] args) {
        ByteBuffer b=ByteBuffer.allocate(15);
        System.out.println("limit="+b.limit()+" capacity="+b.capacity()+" postion="+b.position());
        for (int i = 0; i < b.capacity()-6; i++) {
            b.put((byte)i);
        }
        System.out.println("插入10个 limit="+b.limit()+" capacity="+b.capacity()+" postion="+b.position());
        b.flip();
        System.out.println("flip  limit="+b.limit()+" capacity="+b.capacity()+" postion="+b.position());
        for (int i = 0; i < b.limit()-1; i++) {
            System.out.print (b.get(i)  + "  ");
        }
        System.out.println("");
        System.out.println("取出5个  limit="+b.limit()+" capacity="+b.capacity()+" postion="+b.position());
        b.flip();
        System.out.println("重置 limit="+b.limit()+" capacity="+b.capacity()+" postion="+b.position());
        for (int i = 0; i < b.limit(); i++) {
            System.out.println(b.get(i));
        }
    }
}
