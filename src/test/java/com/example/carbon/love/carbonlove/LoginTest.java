package com.example.carbon.love.carbonlove;

import com.example.carbon.love.carbonlove.BaseUtility.BaseLogin;
import com.example.carbon.love.carbonlove.Pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.example.carbon.love.carbonlove.BaseUtility.LoginCredentials.*;
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

    /**
     * Test login with error message credentials: LOCKED_OUT_USER
     */
    @Test
    @DisplayName("Login with error message credentials: LOCKED_OUT_USER")
    @Tag("Smoke")
    void loginWithErrorMessageLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        BaseLogin baseLogin = new BaseLogin(loginPage);
        loginPage.setupUrl();
        baseLogin.authenticateLockedOutUser(LOCKED_OUT_USER);
        assertSoftly(softly -> {
            softly.assertThat(loginPage.getErrorMessage())
                    .describedAs("The error message is not as expected.")
                    .isEqualTo("Epic sadface: Sorry, this user has been locked out.");
        });
        loginPage.tearDown();
    }

    /**
     * Test login with invalid credentials: INVALID_USER
     */
    @Test
    @DisplayName("Login with invalid credentials: INVALID_USER")
    @Tag("Smoke")
    void loginWithInvalidCredentialsInvalidUser() {
        LoginPage loginPage = new LoginPage(driver);
        BaseLogin baseLogin = new BaseLogin(loginPage);
        loginPage.setupUrl();
        baseLogin.authenticateInvalidUser(INVALID_USER);
        assertSoftly(softly -> {
            softly.assertThat(loginPage.getTitle())
                    .describedAs("Product title is displayed")
                    .contains("PRODUCTS");
        });
        loginPage.tearDown();
    }
}
