//1.饿汉式单例：上来就new
class Singlerton1{
    //1.构造方法私有化，类外部无法产生实例化对象
        private Singlerton1(){}
   //2.类内部提供实例化对象，类外部无法改变，所有声明为全局常量
        private static final Singlerton1 sg = new Singlerton1();
    //3.通过getter（）方法取得类内部的私有化
        public static Singlerton1 getSinglerton(){
            return sg;
        }
        public void fun(){
            System.out.println(this);
        }
}



//2.懒汉式单例：用时再new（可能存在多线程安全问题， 解决方法：双重加锁单例模式）1
class Singlerton2{
     //1.构造方法私有化，类外部无妨访问，限制了对象的产生
        private Singlerton2(){}
    //2.类内部提供实例化对象，类外部无法改变，所有声明为全局常量
        private static Singlerton2 sg2;
    //3.通过getter（）方法取得类内部的私有化
        public static Singlerton2 getSinglerton(){
            if (sg2==null){
                sg2 = new Singlerton2();
                }
            return sg2;
        }
        public void fun(){
            System.out.println(this);
        }
}

class Singleton3{
    private static volatile Singleton3 sin;
    private Singleton3(){}
    public static Singleton3 get(){
        if(sin==null){
            synchronized(Singleton3.class){
                if(sin==null){
                    sin = new Singleton3();
                }
            }
        }
        return sin;
    }
}

public class Singleton{
    public static void main(String[]args){
            Singlerton1 sg = Singlerton1.getSinglerton();
            Singlerton1 sg1 = Singlerton1.getSinglerton();
            sg.fun();
            sg1.fun();
			Singlerton2 sg21 = Singlerton2.getSinglerton();
            Singlerton2 sg22 = Singlerton2.getSinglerton();
            sg21.fun();
            sg22.fun();
			Singlerton3 sg31 = Singlerton3.getSinglerton();
            Singlerton3 sg32 = Singlerton3.getSinglerton();
            sg31.fun();
            sg32.fun();
       }
}