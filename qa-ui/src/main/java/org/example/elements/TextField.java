package org.example.elements;

import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextField extends UIElement {

    public TextField(WebDriver driver, By by) {
        super(driver, by);
    }

    public void setValue(String value) {
        WaitUtils.waitUntilElementIsDisplayed(getWebElement());
        getWebElement().clear();
        getWebElement().sendKeys(value);
    }

    public String getValue() {
        WaitUtils.waitUntilElementIsDisplayed(getWebElement());
        return getWebElement().getAttribute("value");
    }
}
