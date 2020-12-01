package com.zyinux.dp.FactoryMethodPattern;

/**
 * FactroyMethodPattern
 *
 * @author zyinux
 * @Desc
 * @date 2020/12/1
 */
public class FactroyMethodPattern {

    /**
     * 产品 （Product） 将会对接口进行声明。
     * 对于所有由创建者及其子类构建的对象， 这些接口都是通用的。
     */
    interface Product{
        /**
         * 每个产品都会做一些事情
         */
        void doSomeThing();
    }

    /**
     * 创建者 （Creator） 类声明返回产品对象的工厂方法。
     * 该方法的返回对象类型必须与产品接口相匹配。
     *
     * 你可以将工厂方法声明为抽象方法， 强制要求每个子类以不同方式实现该方法。
     * 或者， 你也可以在基础工厂方法中返回默认产品类型。
     *
     * 注意， 尽管它的名字是创建者， 但他最主要的职责并不是创建产品。
     * 一般来说， 创建者类包含一些与产品相关的核心业务逻辑。
     * 工厂方法将这些逻辑处理从具体产品类中分离出来。
     * 打个比方， 大型软件开发公司拥有程序员培训部门。
     * 但是， 这些公司的主要工作还是编写代码， 而非生产程序员。
     */
    interface Creator{

        /**
         * 内个创建者都有个用来创造Product的方法
         * @return 具体的Product
         */
        Product createProduct();
    }

    /**
     * 具体产品 （Concrete Products） 是产品接口的不同实现。
     */
    static class ProductA implements Product{

        @Override
        public void doSomeThing() {
            System.out.println("A Product!");
        }
    }

    /**
     * 具体产品 （Concrete Products） 是产品接口的不同实现。
     */
    static class ProductB implements Product{

        @Override
        public void doSomeThing() {
            System.out.println("B Product!");
        }
    }

    /**
     * 具体创建者 （Concrete Creators） 将会重写基础工厂方法， 使其返回不同类型的产品。
     *
     * 注意， 并不一定每次调用工厂方法都会创建新的实例。
     * 工厂方法也可以返回缓存、 对象池或其他来源的已有对象。
     */
    static class CreatorA implements Creator{

        @Override
        public Product createProduct() {
            return new ProductA();
        }
    }

    static class CreatorB implements Creator{

        @Override
        public Product createProduct() {
            return new ProductB();
        }
    }

    public static void main(String[] args) {
        /**
         * 客户端（使用工厂方法的人）并不关心具体的创建逻辑
         * 也无需了解不同子类返回实际对象之间的差别
         * 只需要知道所有的产品都有对外提供的接口（doSomeThing）功能
        **/
        Creator creator =new CreatorA();
        Product product = creator.createProduct();
        product.doSomeThing();
    }
}
