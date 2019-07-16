
//变量转换运算
//class test7{
//    byte b1=2, b2=2, b5, b8;
//    final byte b3=4, b4=5, b7=8;
//    public void test(){
//        //语句1
//        b5 = (b1+b2);           //b1 b2 都是byte类型，都会被转为int型   int转byte会造成数据丢失
////改正：b5 = （byte）（b1+b2）;
//        //语句2
//        b8 = b3+b4;            //正确
//        //语句3
//        b3 = b1+b5;             //b3是final类型，不能改变b3的值
//        //语句4
//        b5 = b3+b8;             //b3是byte型， b8是int，int+byte->int
////改正：b5 = （byte）（b1+b2）;
//    }
//}


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

abstract class Person{
    public Person(){                             //3
        this.print();                                //4
    }
    public abstract void print();
}

class Student extends Person{
    private int num = 100;                   //8
    public Student(int num){                //2
        this.num = num;                         //9
    }
    public void print(){                         //5        //10
        System.out.println(this.num);     //6        //11
    }
}

@FunctionalInterface
interface Com{
    int add(int a, int b);
}

class MyThread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(currentThread().getName() + " " + i);
        }
    }
}

class MyThread2 implements Runnable{
    private String title;
    public MyThread2(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.title+ " " + i);
        }
    }
}

class MyThread3 implements Callable<String>{

    @Override
    public String call() throws Exception {
        for(int i=0; i<5; i++){
            System.out.println(i);
        }
        return "你是猪吗？";
    }
}

class Task implements Runnable{
    //this
    public synchronized void testA(){
        System.out.println("A");
        testB();
//        while (true){}
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //this
    public synchronized void testB(){
        System.out.println("B");
    }
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("A")){
            testA();
        }else
            testB();
    }
}

public class Review {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("lmd");
        list.add("lmx");
        list.add("world");
        Iterator<String> interator = list.iterator();
        while (interator.hasNext()){
            String str = interator.next();
            if (str.equals("lmd")){
                list.remove(str);
            }
            System.out.println(str);
        }


        Task ts = new Task();
        Thread th1 = new Thread(ts,"A");
        Thread th2 = new Thread(ts,"B");
        th1.start();
        th2.start();



        MyThread1 mt = new MyThread1();
        MyThread1 mt2 = new MyThread1();
        mt.start();
        mt2.start();
        System.out.println("----------------------------------");
        Thread th11 = new Thread(new MyThread2("one"));
        Thread th12 = new Thread(new MyThread2("two"));
        th11.start();
        th12.start();

        System.out.println("************************************");
        Thread cl = new Thread(new FutureTask<String>(new MyThread3()));
        cl.start();
        MyThread3 mtc1 = new MyThread3();
        FutureTask<String> ft = new FutureTask<>(mtc1);
        new Thread(ft).start();
        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("=====================================");

        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = "ab";
        String str4 = "c";
        String str5 = str3+str4;
        String str6 = str3+str4;
        String str7 = str3+"c";
        String str8 = "ab"+"c";

        System.out.println(str1==str2);
        System.out.println(str1==str5);
        System.out.println(str5==str6);
        System.out.println(str5==(str3+str4));
        System.out.println(str1==str7);
        System.out.println(str5==str7);
        System.out.println(str1==str8);
        System.out.println(str5==str8);




    }



}
