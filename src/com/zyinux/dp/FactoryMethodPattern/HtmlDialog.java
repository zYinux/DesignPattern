package com.zyinux.dp.FactoryMethodPattern;

/**
 * HtmlDialog
 *
 * @author zyinux
 * @Desc
 * @date 2020/12/1
 */
public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
