
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
        for(int i = 0; i<5; i++){
            System.out.println(currentThread().getName()+" "+i);
        }
    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<5; i++){
            System.out.println(i);
        }
    }
}



public class Review {
    public static void main(String[] args) {
        MyThread1 mt = new MyThread1();
        mt.start();

        Thread th = new Thread(new MyThread2());
        th.start();

    }
}
