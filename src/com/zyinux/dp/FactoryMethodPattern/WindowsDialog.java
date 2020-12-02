package com.zyinux.dp.FactoryMethodPattern;

/**
 * WIndowsDialog
 *
 * @author zyinux
 * @Desc
 * @date 2020/12/1
 */
public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
