package com.example.carbon.love.carbonlove;

import com.example.carbon.love.carbonlove.BaseUtility.BaseLogin;
import com.example.carbon.love.carbonlove.Pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.example.carbon.love.carbonlove.BaseUtility.LoginCredentials.STANDARD_USER;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class LoginTest {

    public WebDriver driver;

    /**
     * Test login with valid credentials: STANDARD_USER
     */
    @Test
    @DisplayName("Login with valid credentials: STANDARD_USER")
    @Tag("Smoke")
    void loginWithValidCredentialsStandardUser() {
        LoginPage loginPage = new LoginPage(driver);
        BaseLogin baseLogin = new BaseLogin(loginPage);
        loginPage.setupUrl();
        baseLogin.authenticateStandardUser(STANDARD_USER);
        assertSoftly(softly -> {
            softly.assertThat(loginPage.checkAppLogo())
                    .describedAs("Swag-lab is loaded. Heading logo is displayed")
                    .isTrue();
        });
        loginPage.tearDown();
    }
}
