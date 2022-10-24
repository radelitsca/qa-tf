package org.example;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.example.pages.MainPage;
import org.testng.annotations.Test;

public class RegisterUserTest extends BaseTest {

    @Test
    @Description("This test checks if user can register into the system")
    public void registerUserTest() {
        MainPage mainPage = new MainPage(getWebDriver())
                .open()
                .registerRandomUser();
        Assertions.assertThat(mainPage.isUserLoggedIn())
                .withFailMessage("User cannot register")
                .isTrue();
    }
}
