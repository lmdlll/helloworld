package work.FactoryTest;

//抽象工厂
//CPU接口
interface Cpu {
    void run();

    class Cpu940 implements Cpu {
        @Override
        public void run() { System.out.println("我的CPU是麒麟940呦"); }
    }

    class Cpu970 implements Cpu {
        @Override
        public void run() { System.out.println("我的CPU是麒麟970"); }
    }
}
//屏幕接口
interface Screen {
    void size();

    class Screen5 implements Screen {
        @Override
        public void size() { System.out.println("我的屏幕是5寸"); }
    }

    class Screen6 implements Screen {
        @Override
        public void size() { System.out.println("我的屏幕是6寸"); }
    }
}
//工厂接口
interface PhoneFactory {
    Cpu getCpu();//使用的cpu
    Screen getScreen();//使用的屏幕
}

//具体实现类：
//Nova3
class Nova3Factory implements PhoneFactory {
    @Override
    public Cpu getCpu() { return new Cpu.Cpu970(); }

    @Override
    public Screen getScreen() { return new Screen.Screen6(); }
}
//荣耀10
class HonorFactory implements PhoneFactory {
    @Override
    public Cpu getCpu() { return new Cpu.Cpu940(); }

    @Override
    public Screen getScreen() { return new Screen.Screen5(); }
}


public class AbstFactory {
    public static void main(String[] args) {
        PhoneFactory phone = new Nova3Factory();
        phone.getCpu().run();
        phone.getScreen().size();

    }
}
