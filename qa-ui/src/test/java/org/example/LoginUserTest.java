package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.assertj.core.api.Assertions;
import org.example.model.User;
import org.example.pages.MainPage;
import org.testng.annotations.Test;

public class LoginUserTest extends BaseTest {
    @Issue("BUG-2067")
    @Epic("Some epic")
    @Feature("Some feature")
    @Test
    @Description("This test checks if user can register and login into the system")
    public void loginUserTest() {
        User user = User.builder().buildRandomUser();

        MainPage mainPage = new MainPage(getWebDriver())
                .open()
                .registerUser(user)
                .logout();

        mainPage.login(user);

        Assertions.assertThat(mainPage.loggedUserLink.getValue())
                .withFailMessage("User cannot login")
                .isEqualTo("Logged in as %s %s", user.getFirstName(), user.getLastName());
    }
}
