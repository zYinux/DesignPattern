package com.zyinux.dp.AbstractFactoryPattern;

/**
 * AbstractFactoryPattern
 *
 * @author zyinux
 * @Desc
 * @date 2020/12/2
 */
public class AbstractFactoryPattern {

    /**
     * 特意设计两个产品的两个方法不一样，突出抽象工厂模式不需要产品之间有很多的共同点
     * 但是这几个Product应该是可以按一定的规则（风格，比如春装和夏装中的衣裤。比如windows和mac系统上的button和checkbox）搭配配套使用的
     */
    interface ProductA{
        void fly();
    }

    interface ProductB{
        void walk();
    }

    /**
     * 抽象工厂接口
     */
    interface AbstractFactory{
        /**
         * 有多个方法创建不同的产品。
         * @return 注意返回的是顶层的Product接口，而不是具体的某些个Product
         */
        ProductA createProductA();
        ProductB createProductB();
    }

    static class StyleXProductA implements ProductA{

        @Override
        public void fly() {
            System.out.println("StyleXProductA.fly()!");
        }
    }
    static class StyleYProductA implements ProductA{

        @Override
        public void fly() {
            System.out.println("StyleYProductA.fly()!");
        }
    }

    static class StyleXProductB implements ProductB{
        @Override
        public void walk() {
            System.out.println("StyleXProductB.walk()!");
        }
    }

    static class StyleYProductB implements ProductB{
        @Override
        public void walk() {
            System.out.println("StyleYProductB.walk()!");
        }
    }

    static class StyleXFactory implements AbstractFactory{

        @Override
        public ProductA createProductA() {
            return new StyleXProductA();
        }

        @Override
        public ProductB createProductB() {
            return new StyleXProductB();
        }
    }

    static class StyleYFactory implements AbstractFactory{

        @Override
        public ProductA createProductA() {
            return new StyleYProductA();
        }

        @Override
        public ProductB createProductB() {
            return new StyleYProductB();
        }
    }

    public static void main(String[] args) {
        AbstractFactory factory=new StyleYFactory();
        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();

        productA.fly();
        productB.walk();
    }

}
