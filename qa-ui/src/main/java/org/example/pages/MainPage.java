package org.example.pages;

import org.example.elements.Button;
import org.example.elements.TextField;
import org.example.elements.TextLink;
import org.example.model.User;
import org.example.utils.ConfigProvider;
import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {

    public static final String TITLE = "WeaveSocks";

    public final TextLink registerLink = new TextLink(driver, By.xpath("//li[@id='register']/a"));
    public final TextLink loginLink = new TextLink(driver, By.xpath("//li[@id='login']/a"));
    public final TextLink loggedUserLink = new TextLink(driver, By.xpath("//li[@id='howdy']/a"));
    public final TextLink logoutLink = new TextLink(driver, By.id("logout"));

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
        driver.get(ConfigProvider.BASE_URL);
        ensureOpen();
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
        return this;
    }

    public MainPage login(User user) {
        clickLogin().fillInLoginForm(user);
        return this;
    }

    public MainPage logout() {
        logoutLink.click();
        WaitUtils.waitUntilElementIsDisplayed(registerLink.getWebElement());
        return this;
    }

    public class RegisterForm {

        public final TextField userName = new TextField(driver, By.id("register-username-modal"));
        public final TextField firstName = new TextField(driver, By.id("register-first-modal"));
        public final TextField lastName = new TextField(driver, By.id("register-last-modal"));
        public final TextField email = new TextField(driver, By.id("register-email-modal"));
        public final TextField password = new TextField(driver, By.id("register-password-modal"));
        public final Button registerButton = new Button(driver, By.xpath("//button[normalize-space()='Register']"));

        public void fillResisterForm(User user) {
            userName.setValue(user.getUserName());
            firstName.setValue(user.getFirstName());
            lastName.setValue(user.getLastName());
            email.setValue(user.getEmail());
            password.setValue(user.getPassword());
            registerButton.click();
            WaitUtils.waitElementToDisappear(driver, registerButton.getWebElement());
        }
    }

    public class LoginForm {
        public final TextField userNameLogin = new TextField(driver, By.id("username-modal"));
        public final TextField passwordLogin = new TextField(driver, By.id("password-modal"));
        public final Button loginButton = new Button(driver, By.xpath("//button[@onclick='return login()']"));

        public void fillInLoginForm(User user) {
            userNameLogin.setValue(user.getUserName());
            passwordLogin.setValue(user.getPassword());
            loginButton.click();
            WaitUtils.waitElementToDisappear(driver, loginButton.getWebElement());
        }
    }
}
