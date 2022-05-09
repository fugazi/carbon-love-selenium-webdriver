package com.example.carbon.love.carbonlove.BaseUtility;

import com.example.carbon.love.carbonlove.Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class BaseLogin {

    public WebDriver driver;
    public LoginPage loginPage;

    /**
     * Create the constructor stub for the BaseLogin class.
     */

    public BaseLogin(WebDriver driver) {
        this.driver = driver;
    }

    public BaseLogin(LoginPage aLoginPage) {
        this.loginPage = aLoginPage;
    }

    /**
     * Adds the user and password to the login page and clicks on the login button
     * @param userName the username
     * @param password the password
     */
    public void authenticate(String userName, String password) {
        loginPage.checkLoginLogo();
        loginPage.addUserName(userName);
        loginPage.addPassword(password);
        loginPage.clickLoginButton();
    }

    /**
     * Adds the user and password to the login page using the STANDARD_USER credentials
     */
    public void authenticateStandardUser(LoginCredentials accessCredentials) {
        authenticateAs(LoginCredentials.STANDARD_USER);
    }

    /**
     * Adds the user and password to the login page using the LOCKED_OUT_USER credentials
     * @return the LoginPage class
     */
    public LoginPage authenticateLockedOutUser(LoginCredentials accessCredentials) {
        return authenticateAs(LoginCredentials.LOCKED_OUT_USER);
    }

    /**
     * Adds the user and password to the login page using the INVALID_USER credentials
     * @return the LoginPage class
     */
    public LoginPage authenticateInvalidUser(LoginCredentials accessCredentials) {
        return authenticateAs(LoginCredentials.INVALID_USER);
    }

    /**
     * Authenticates the application using the credentials
     * @param accessCredentials the credentials to use
     * @return the LoginPage class
     */
    private LoginPage authenticateAs(LoginCredentials accessCredentials) {
        authenticate(accessCredentials.getUserName(), accessCredentials.getPassword());
        return new LoginPage(driver);
    }

    private void threadSleep(int i) {
    }
}
