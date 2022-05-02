package com.example.carbon.love.carbonlove;

import com.example.carbon.love.carbonlove.Pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    /**
     * Initialize the WebDriverManager and EdgeDriver.
     * Visit the main page of JetBrains with Microsoft Edge Browser.
     */

    @BeforeEach
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.jetbrains.com/");

        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Test that the Jetbrains main page is loaded.
     * {Smoke Test}
     */
    @Test
    void homePageLoaded() {
        mainPage.getHeadingLogo();
        assertSoftly(softly -> {
            softly.assertThat(mainPage.getHeadingLogo())
                    .describedAs("Page is loaded. Heading logo is displayed")
                    .isTrue();
        });
    }

    /**
     * Test getting the Page title of JetBrains.
     * {Regression Test}
     */

    @Test
    void getPageTitle() {
        mainPage.getHomePageTitle();
        assertEquals("JetBrains: Essential tools for software developers and teams", driver.getTitle());
    }

    /**
     * Test that the search action is displayed.
     * Perform a search action and check if the search result is displayed.
     * {Regression Test}
     */
    @Test
    void search() {
        mainPage.getSearchAction();
        mainPage.sendSearchField();
        mainPage.submitSearch();
        mainPage.searchPageResults();
        assertSoftly(softly -> {
            softly.assertThat(mainPage.searchPageResults())
                    .describedAs("Search results is not displayed")
                    .contains("");
        });
    }

    /**
     * Test that the navigation menu is displayed.
     * Click on the navigation menu and check if the menu is displayed.
     * {Regression Test}
     */
    @Test
    public void navigationToAllTools() {
        mainPage.seeAllToolsButton.click();
        assertEquals("https://www.jetbrains.com/products/", driver.getCurrentUrl());
        WebElement productsList = driver.findElement(By.id("products-page"));
        assertTrue(productsList.isDisplayed());
        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle());
    }
}
