package com.zyinux.dp.PrototypePattern;

import java.util.HashMap;

/**
 * PrototypePattern
 *
 * @author zyinux
 * @Desc 原型模式将克隆过程委派给被克隆的实际对象。
 * 模式为所有支持克隆的对象声明了一个通用接口， 该接口让你能够克隆对象， 同时又无需将代码和对象所属类耦合。
 * 通常情况下， 这样的接口中仅包含一个 克隆方法。
 * java 的Object 的clone方法
 * @date 2020/12/7
 */
public class PrototypePattern {

    interface Prototype{
        /**
         * 由于Object自带clone方法，这里做个区分改成clone_，其实真实项目中建议直接使用Object的clone方法
         * @return
         */
        Prototype clone_();

        /**
         * 原型带有的方法
         * @return
         */
        String getColor();
    }

    /**
     * 具体的继承了原型的对象
     */
    static class Button implements Prototype{

        int x,y;

        String color;

        public Button(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public Button(Button button) {
            this.x = button.x;
            this.y = button.y;
            this.color = button.color;
            //对于非基本对象是否需要考虑将clone分发下去呢？
//            this.prototype=button.prototype.clone_();
        }

        @Override
        public Prototype clone_() {
            return new Button(this);
        }

        @Override
        public String getColor() {
            return color;
        }
    }

    /**
     * 原型注册中心
     */
    static class PrototypeRegistry{
        HashMap<String,Prototype> prototypeHashMap=new HashMap<>();

        public void addItem(String id,Prototype prototype){
            prototypeHashMap.put(id,prototype);
        }

        public Prototype getById(String id){
            if (prototypeHashMap.containsKey(id)){
                return prototypeHashMap.get(id).clone_();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        PrototypeRegistry registry=new PrototypeRegistry();

        Prototype prototype=new Button(100,100,"#ffacac");
        registry.addItem("normal",prototype);

        Prototype clone = registry.getById("normal");

        //原型克隆出来的是一个新对象，和原本的对象并不相同，但是内部属性和值都是相同的
        //false
        System.out.println("objectEquals? \n"+(clone==prototype));
        System.out.println();
        //true
        System.out.println("colorEquals? \n"+(clone.getColor().equals(prototype.getColor())));
    }

}
