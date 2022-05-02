package com.example.carbon.love.carbonlove.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.jetbrains.com/
public class MainPage {

    @FindBy(xpath = "//*[@data-test='site-logo']")
    public WebElement siteLogo;

    @FindBy(tagName = "h1")
    public WebElement siteTitle;

    @FindBy(xpath = "//*[@data-test='site-header-search-action']")
    public WebElement searchAction;

    @FindBy(css = "input[data-test='search-input']")
    public WebElement searchField;

    @FindBy(css = "button[data-test='full-search-button']")
    public WebElement searchSubmit;

    @FindBy(css = "input[data-test='search-input']")
    public WebElement searchPageAction;

    @FindBy(css = "a.wt-button_mode_primary")
    public WebElement seeAllToolsButton;

    /**
     * Constructor for MainPage
     * PageFactory is used to initialize the WebElements
     */
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to check if the page is loaded
     * Get the Jetbrains heading logo and check if it is displayed
     */

    public boolean getHeadingLogo() {
        return siteLogo.isDisplayed();
    }

    /**
     * Method to check if the page title is available
     */
    public void getHomePageTitle() {
        siteTitle.getText();
    }

    /**
     * Method to check if the search action is available
     */
    public void getSearchAction() {
        searchAction.click();
    }

    /**
     * Method to send data to the search field
     */
    public void sendSearchField() {
        searchField.sendKeys("Quality Assurance");
    }

    /**
     * Method to submit the search
     */
    public void submitSearch() {
        searchSubmit.click();
    }

    /**
     * Method to check the search page result
     *
     * @return
     */
    public String searchPageResults() {
        return searchPageAction.getText();
    }

    /**
     * Method to check the see all tools button
     */
    public void seeAllTools() {
        seeAllToolsButton.click();
    }
}
