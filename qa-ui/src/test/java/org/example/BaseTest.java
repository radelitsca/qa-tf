package org.example;

import org.example.browser.WebDriverFactory;
import org.example.constants.TestConstants;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
public final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod(description = "Set up the browser")
    public void beforeMethod(ITestContext iTestContext) {
        WebDriver webdriver = new WebDriverFactory().getDriver();
        setWebDriver(webdriver);
        setDriverToContext(iTestContext, webdriver);
    }

    @AfterMethod(description = "Quit the browser")
    public void afterMethod() {
        getWebDriver().quit();
    }

    private void setWebDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public WebDriver getWebDriver() {
        return driverThreadLocal.get();
    }

    public void setDriverToContext (ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute(TestConstants.WEB_DRIVER, driver);
    }
}
