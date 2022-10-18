package org.example.elements;

import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends UIElement {

    public Button(WebDriver driver, By by) {
        super(driver, by);
    }

    public void click() {
        WaitUtils.waitUntilElementIsDisplayed(getWebElement());
        getWebElement().click();
    }
}
