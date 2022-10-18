package org.example.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public abstract Page open();

    public abstract void ensureOpen();

    public abstract String getTitle();
}
