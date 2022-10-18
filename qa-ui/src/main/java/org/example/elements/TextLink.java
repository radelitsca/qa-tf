package org.example.elements;

import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextLink extends UIElement {

    public TextLink(WebDriver driver, By by) {
        super(driver, by);
    }

    public void click() {
        WaitUtils.waitUntilElementIsDisplayed(getWebElement());
        getWebElement().click();
    }

    public String getValue() {
        WaitUtils.waitUntilElementIsDisplayed(getWebElement());
        return getWebElement().getAttribute("textContent");
    }
}
