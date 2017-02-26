package com.gmail.Tests;


import com.gmail.pageObjectPattern.IncomingPage;
import com.gmail.pageObjectPattern.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.gmail.config.Data.Email;
import static com.gmail.config.Data.Password;
import static com.gmail.config.Data.LinkTo;

/**
 * Created by meowmeow on 26.02.2017.
 */
public class LogOutTest {
    private WebDriver driver;
    public LoginPage loginPage;
    public IncomingPage incomingPage;

    @BeforeClass
    public void setUp() {

        driver = new FirefoxDriver();
        driver.get(LinkTo);
        loginPage = new LoginPage(driver);
        loginPage.typeUsername(Email);
        loginPage.clickNext();
        loginPage.typePassword(Password);
        loginPage.submitLogin();
    }

    @Test
    public void logOutOnLoginPage () {

        incomingPage = new IncomingPage(driver);
        incomingPage.clickOnAccountButton();
        incomingPage.clickOnLogOutButton();
        loginPage.submitLogin();
    }

    @AfterTest
    public void cleanUp() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
