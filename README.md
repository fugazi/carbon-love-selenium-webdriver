
# Carbon Love - Selenium Webdriver Project

This is an Automation project using Java with Selenium Webdriver, developed by Douglas Urrea Ocampo to improve learning on advanced Automation testing.

The main features of this project has the following:

* Page Object Model (POM) as a design pattern for creating an Object directory for web UI elements.
* Encapsulation and Data Abstraction to bind together the data and the functions that operate on them so that no other part of the code can access this data except that function.
* The re-usability of code to avoid unnecessary data exposure to the user by using the abstraction.

## 🏠 Tester details
* Name: `Douglas Urrea Ocampo`
* Country: `Colombia`
* City: `Medellin`
* E-mail: `itmteleco@gmail.com`
* LinkedIn: [https://www.linkedin.com/in/douglasfugazi](https://www.linkedin.com/in/douglasfugazi)
* Contact: [https://douglasfugazi.co](https://douglasfugazi.co)

## ✨ Pre-requisites:
1. Install Selenium Webdriver from [here](https://www.selenium.dev)
2. Get WebDriverManager from [here](https://bonigarcia.dev/webdrivermanager/)
3. Install git from [here](https://git-scm.com)
4. Install Apache Maven from [here](https://maven.apache.org)
5. Test Runner is JUnit 5
6. Build Tool is Maven the latest version
7. Note: ChromeDriver.exe is not necessary, you should use the WebDriverManager capabilities.

## 🛠️ Running the project:
1. Download the project from GitHub
    * Option 1: `git clone https://github.com/fugazi/carbon-love-selenium-webdriver.git`
    * Option 2: Download it as a Zip file and extract it
2. CD into the `Carbon Love` folder
3. Set up Apache Maven
    * Maven: `Update Maven Archetype Catalog`
4. Set up Selenium Project
    * Maven: Create Maven Project Type adding `Selenium` as archetype
5. Running Tests
    * run `mvn clean install` in the path of the project
7. Open the project baseline and run each Selenium Test


### ✏️ Step by Step tutorial

TBA

### 🚴 Project configuration
* Selenium project Baseline: `Carbon Love`
* Selenium Tests `MainPageTest.java` (Tets without Authentication) into folder `src\test\java\carbonlove`
* Selenium Tests `LoginTest.java` (Tests with Login Credentials) into folder `src\test\java\carbonlove`
* Base Utility class `BaseLogin.java` into folder `src\test\java\carbonlove\BaseUtility`
* Login Credentials class `LoginCredentials.java` into folder `src\test\java\carbonlove\BaseUtility`
* Page Objects `MainPage.java` into folder `src\test\java\carbonlove\Page`
* Page Objects `LoginPage.java` into folder `src\test\java\carbonlove\Page`
* testName: `CarbonLove`

### ⚡ Automation Test Strategy
This is an end-to-end UI tests using Selenium Webdriver.
The website under test was developed by SauceLabs [here](https://www.saucedemo.com) with a login frontpage in order to test different login access and difficult to work with locators on the UI. I must say it was fun learning and automating this website.

1. Browser is Microsoft Edge in order to have a different approach to login
2. User will navigate to the website and login with different access:
* Test login with valid credentials: STANDARD_USER
* Test login with error message: LOCKED_OUT_USER
* Test login with invalid credentials: INVALID_USER
3. Once the Login step is successful, registered user will log in the website.
4. After the login, assertions will be validated to each test, user will check for the logo and the items displayed on top of the banner menu.
5. Each tests will finish automatically and the browser will be closed.