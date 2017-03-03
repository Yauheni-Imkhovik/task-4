package com.gmail.Tests;

import com.gmail.config.configOfDrivers.WebDriverCreate;
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
public class SignInTest {

    WebDriver driver = WebDriverCreate.getInstance();

    public LoginPage loginPage;
    public IncomingPage incomingPage;

    public SignInTest() throws Exception {
    }


    @BeforeClass
    public void setUp() throws Exception {
        driver.get(LinkTo);
    }

    @Test
    public void SignInToAccount() {
        loginPage = new LoginPage(driver);
        loginPage.typeUsername(Email);
        loginPage.clickNext();
        loginPage.typePassword(Password);
        loginPage.submitLogin();

        incomingPage = new IncomingPage(driver);
        Assert.assertTrue(incomingPage.getPageTitle().contains("Gmail"));
    }

    @AfterTest
    public void cleanUp() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
