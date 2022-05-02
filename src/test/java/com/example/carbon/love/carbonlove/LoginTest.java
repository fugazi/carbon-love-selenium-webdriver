package com.example.carbon.love.carbonlove;

import com.example.carbon.love.carbonlove.Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Test
    public void loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.setupUrl();
    }
}
