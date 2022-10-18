package org.example;

import org.assertj.core.api.Assertions;
import org.example.model.User;
import org.example.pages.MainPage;
import org.testng.annotations.Test;

public class LoginUserTest extends BaseTest {

    @Test
    public void loginUserTest() {
        User user = User.builder().buildRandomUser();

        MainPage mainPage = new MainPage(getWebDriver())
                .open()
                .registerUser(user)
                .logout();

        mainPage.login(user);

        Assertions.assertThat(mainPage.loggedUserLink.getValue())
                .isEqualTo("Logged in as %s %s", user.getFirstName(), user.getLastName());
    }
}
