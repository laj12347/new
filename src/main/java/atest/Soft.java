package atest;

import java.lang.ref.SoftReference;

public class Soft {

    public static void main(String[] args) {
        MyObject obj=new MyObject();
        SoftReference<MyObject> softqueue=new SoftReference<MyObject>(obj);
        
    }
}

class MyObject{
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("MyObject finalize");
    }
    public String toString(){
        return "MyObject";
    }
}