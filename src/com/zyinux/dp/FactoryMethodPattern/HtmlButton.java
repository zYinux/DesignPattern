package com.zyinux.dp.FactoryMethodPattern;

import java.util.HashMap;

/**
 * HtmlButton
 *
 * @author zyinux
 * @Desc
 * @date 2020/12/1
 */
public class HtmlButton implements Button{
    @Override
    public void render() {

        System.out.println("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
