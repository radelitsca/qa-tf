package org.example.pages;

import io.qameta.allure.Step;
import org.example.elements.Button;
import org.example.elements.TextField;
import org.example.elements.TextLink;
import org.example.model.User;
import org.example.utils.ConfigProvider;
import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage extends Page {


    private final Logger LOGGER = LoggerFactory.getLogger(MainPage.class);

    public static final String TITLE = "WeaveSocks";

    public final TextLink registerLink = new TextLink(driver, By.xpath("//li[@id='register']/a"), "Register link");
    public final TextLink loginLink = new TextLink(driver, By.xpath("//li[@id='login']/a"), "login link");
    public final TextLink loggedUserLink = new TextLink(driver, By.xpath("//li[@id='howdy']/a"), "LoggedUser link");
    public final TextLink logoutLink = new TextLink(driver, By.id("logout"), "logout link");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn() {
        return logoutLink.getWebElement().isDisplayed();
    }

    public MainPage registerUser(User user) {
        clickRegister();
        new RegisterForm().fillResisterForm(user);
        return this;
    }

    @Override
    public MainPage open() {
        LOGGER.info("Main  Page is about to open");
        driver.get(ConfigProvider.BASE_URL);
        ensureOpen();
        LOGGER.info("Main Page is opened");
        return this;
    }

    @Override
    public void ensureOpen() {
        WaitUtils.waitUntilElementIsDisplayed(registerLink.getWebElement());
    }

    @Override
    public String getTitle() {
        return TITLE;
    }


    public RegisterForm clickRegister() {
        registerLink.click();
        return new RegisterForm();
    }

    public LoginForm clickLogin() {
        loginLink.click();
        return new LoginForm();
    }

    public MainPage registerRandomUser() {
        registerUser(User.builder().buildRandomUser());
        LOGGER.info("User is registered");
        return this;
    }

    public MainPage login(User user) {
        clickLogin().fillInLoginForm(user);
        LOGGER.info("User is logged in");
        return this;
    }

    public MainPage logout() {
        logoutLink.click();
        WaitUtils.waitUntilElementIsDisplayed(registerLink.getWebElement());
        LOGGER.info("User is logged out");
        return this;
    }

    public class RegisterForm {

        public final TextField userName = new TextField(driver, By.id("register-username-modal"), "userName");
        public final TextField firstName = new TextField(driver, By.id("register-first-modal"), "firstName");
        public final TextField lastName = new TextField(driver, By.id("register-last-modal"), "lastname");
        public final TextField email = new TextField(driver, By.id("register-email-modal"), "email");
        public final TextField password = new TextField(driver, By.id("register-password-modal"), "password");
        public final Button registerButton = new Button(driver, By.xpath("//button[normalize-space()='Register']"));

        @Step("Fill the register form with [{user}]")
        public void fillResisterForm(User user) {
            userName.setValue(user.getUserName());
            firstName.setValue(user.getFirstName());
            lastName.setValue(user.getLastName());
            email.setValue(user.getEmail());
            password.setValue(user.getPassword());
            LOGGER.info("Register form is filled in");
            registerButton.click();
            WaitUtils.waitElementToDisappear(driver, registerButton.getWebElement());
        }
    }

    public class LoginForm {
        public final TextField userNameLogin = new TextField(driver, By.id("username-modal"), "UserName Login");
        public final TextField passwordLogin = new TextField(driver, By.id("password-modal"), "Password Login");
        public final Button loginButton = new Button(driver, By.xpath("//button[@onclick='return login()']"));

        public void fillInLoginForm(User user) {
            userNameLogin.setValue(user.getUserName());
            passwordLogin.setValue(user.getPassword());
            LOGGER.info("Login form is filled in");
            loginButton.click();
            WaitUtils.waitElementToDisappear(driver, loginButton.getWebElement());
        }
    }
}
