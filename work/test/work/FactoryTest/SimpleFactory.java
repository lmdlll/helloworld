//package work;
//
////简单工厂模式
//
//import java.util.Scanner;
//
////定义一个抽象类,假设这是一个生产电脑的机器
//interface factory{
//    void create();
//}
//
////定义一个产品类，使用此机器生产品牌电脑
//class MacBook implements factory{
//    @Override
//    public void create() {
//        System.out.println("生产一个MacBook电脑");
//    }
//}
//
//class Acer implements factory{
//    @Override
//    public void create() {
//        System.out.println("生产一个Acer电脑");
//    }
//}
//
//class Aline implements factory{
//    @Override
//    public void create() {
//        System.out.println("生产一个Aline电脑");
//    }
//}
//
////定义一个工厂类，拥有几条流水线工程来生产不同品牌的电脑
//class RealFactory{
//    public static factory produce(String name) {
//        if (name.equals("MacBook")) {
//            return new MacBook();
//        } else if (name.equals("Acer")) {
//            return new Acer();
//        } else if (name.equals("Aline")) {
//            return new Aline();
//        }
//        System.out.println("此工厂不生产"+name);
//        return null;
//    }
//}
//
//public class SimpleFactory {
//    public static void main(String[] args) {
//        RealFactory fac = new RealFactory();
//        System.out.println("请输入你想要的电脑：");
//        Scanner in = new Scanner(System.in);
//        String name = in.next();
//        fac.produce(name).create();
//
////        factory mac = fac.produce("MacBook");
////        factory ace = fac.produce("Acer");
////        factory aline = fac.produce("Aline");
////        factory huawei = fac.produce("HUAWEI");
////        try {
////            mac.create();
////            ace.create();
////            aline.create();
////            huawei.create();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//    }
//
//}
//
