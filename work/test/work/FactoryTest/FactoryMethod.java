package work.FactoryTest;

interface Computre{
    void create();
}
//----------------------   多个具体产品类  -------------------------------------
class MacBook implements Computre{
    @Override
    public void create() { System.out.println("生产一个MacBook电脑"); }
}
class Aline implements Computre{
    @Override
    public void create() {System.out.println("生产一个外星人电脑");}
}
class SurfaceBook implements Computre{
    @Override
    public void create() {System.out.println("生产一个SurfaceBook电脑"); }
}
//------------------------------------------------------------------------------

interface ComputerFactory{
    Computre createComputer();
}

//----------------------   多个具体工厂   -------------------------------------
//微软产品工厂
class msFactory implements ComputerFactory{
    @Override
    public Computre createComputer() {
        return new SurfaceBook();
    }
}
//苹果产品工厂
class AppleFactory implements ComputerFactory{
    @Override
    public Computre createComputer() {
        return new MacBook();
    }
}
//弘基电脑工厂
class AcerFactory implements ComputerFactory{
    @Override
    public Computre createComputer() {
        return new MacBook();
    }
}
//------------------------------------------------------------------------------

public class FactoryMethod{
    public static void main(String[] args) throws InterruptedException {
        ComputerFactory computerFactory = new AppleFactory();
        Computre computre = computerFactory.createComputer();
        computre.create();
    }
}