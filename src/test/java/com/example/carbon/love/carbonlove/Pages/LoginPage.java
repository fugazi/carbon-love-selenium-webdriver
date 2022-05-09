package com.example.carbon.love.carbonlove.Pages;

import com.example.carbon.love.carbonlove.BaseUtility.BaseLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPage extends BaseLogin {

    By loginLogo = By.id("login_logo");
    By username = By.xpath("//*[@data-test='username']");
    By password = By.xpath("//*[@data-test='password']");
    By loginButton = By.xpath("//*[@data-test='login-button']");
    By appLogo = By.cssSelector(".app_logo");

    /**
     * Constructor stub to initialize the driver object
     *
     */
    public WebDriver driver;
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
    public void setupUrl() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * This method will check on the login logo
     * If the login logo is present then the page is loaded, otherwise return false
     */
    public void checkLoginLogo() {
        try {
            driver.findElement(this.loginLogo).isDisplayed();
        } catch (NoSuchElementException ignored) {
        }
    }

    /**
     * This method will enter the username
     *
     */
    public void addUserName(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    /**
     * This method will enter the password
     */
    public void addPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    /**
     * This method will click on the login button
     *
     */
    public void clickLoginButton() {
        driver.findElement(this.loginButton).click();
    }

    /**
     * This method will check on the app logo
     * If the app logo is present then the page is loaded, otherwise return false
     * @return boolean
     */
    public boolean checkAppLogo() {
        try {
            driver.findElement(this.appLogo).isDisplayed();
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }
}
