package com.zyinux.dp.FactoryMethodPattern;

/**
 * Dialog
 *
 * @author zyinux
 * @Desc
 * @date 2020/12/1
 */
public abstract class Dialog {

    /**
     * 请注意，创建者的主要职责并非是创建产品。
     * 其中通常会包含一些核心业务逻辑，这些逻辑依赖于由工厂方法返回的产品对象。
     * 子类可通过重写工厂方法并使其返回不同类型的产品来间接修改业务逻辑。
     */
    public void renderWindow() {
        // ... other code ...

        //调用工厂方法创建一个产品
        Button okButton = createButton();
        //现在使用产品
        okButton.render();
    }

    /**
     * 子类重写这个方法来返回需要的button对象
     *
     */
    public abstract Button createButton();
}
