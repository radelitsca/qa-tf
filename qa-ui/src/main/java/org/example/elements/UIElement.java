package org.example.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class UIElement {

    protected WebDriver driver;
    protected By by;

    public UIElement(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
    }

    public WebElement getWebElement() {
        return driver.findElement(by);
    }
}
