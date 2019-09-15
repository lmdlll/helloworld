package work.SingletonTest;

//饿汉式单例
class Singleton1{
    private static final Singleton1 sin = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getSin(){
        return sin;
    }
}

//懒汉式单例
class Singlerton{
    private static volatile Singlerton sin;
    private Singlerton(){}
    public static Singlerton getSin(){
        if(sin==null){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Singlerton.class) {
                if (sin == null) {
                    sin = new Singlerton();
                }
            }
        }
        return sin;
    }
}
public class SinglertonTest {
    public static void main(String[] args) {
//
        for(int i=0; i<10; i++) {
            new Thread(()-> {
                System.out.println(Singlerton.getSin().hashCode());
            }).start();
        }
        System.out.println(Singlerton.getSin().hashCode());
        System.out.println(Singlerton.getSin().hashCode());
        System.out.println(Singlerton.getSin().hashCode());
        System.out.println(Singlerton.getSin().hashCode());
        System.out.println(Singlerton.getSin().hashCode());
        System.out.println(Singlerton.getSin().hashCode());
        System.out.println(Singlerton.getSin().hashCode());
        System.out.println(Singlerton.getSin().hashCode());
        System.out.println(Singlerton.getSin().hashCode());
        System.out.println(Singlerton.getSin().hashCode());

    }
}
