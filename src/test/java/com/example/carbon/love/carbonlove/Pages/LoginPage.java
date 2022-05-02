package com.example.carbon.love.carbonlove.Pages;

import com.example.carbon.love.carbonlove.BaseUtility.BaseLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPage extends BaseLogin {

    By loginLogo = By.id("login_logo");
    By username = By.xpath("//*[@data-test='username']");
    By password = By.xpath("//*[@data-test='password']");
    By loginButton = By.xpath("//*[@data-test='login-button']");

    /**
     * Constructor stub to initialize the driver object
     *
     */
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Initialize the WebDriverManager and EdgeDriver.
     * Go to the website and maximize the browser window.
     *
     * @return driver
     */
    @BeforeEach
    public WebDriver setupUrl() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        return driver;
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * This method will check on the login logo
     * If the login logo is present then the page is loaded, otherwise return false
     *
     */
    public Boolean checkLoginLogo() {
        return isDisplayed(loginLogo);
    }

    /**
     * This method will enter the username
     *
     */
    public void addUserName(String username) {
        sendKeys(this.username, username);
    }

    /**
     * This method will enter the password
     *
     */
    public void addPassword(String password) {
        sendKeys(this.password, password);
    }

    /**
     * This method will click on the login button
     *
     */
    public void clickLoginButton() {
        click(loginButton);
    }
}
