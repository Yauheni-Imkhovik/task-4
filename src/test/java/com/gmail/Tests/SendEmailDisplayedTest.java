package com.gmail.Tests;

import com.gmail.config.configOfDrivers.WebDriverCreate;
import com.gmail.pageObjectPattern.DraftsPage;
import com.gmail.pageObjectPattern.IncomingPage;
import com.gmail.pageObjectPattern.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.beans.IntrospectionException;
import java.util.UUID;

import static com.gmail.config.Data.*;

/**
 * Created by meowmeow on 26.02.2017.
 */
public class SendEmailDisplayedTest {
    WebDriver driver = WebDriverCreate.getInstance();

    public IncomingPage incomingPage;
    public LoginPage loginPage;
    public DraftsPage draftsPage;
    private String uniqueID = UUID.randomUUID().toString();

    public SendEmailDisplayedTest() throws Exception {
    }

    @BeforeTest
    public void setUp() throws InterruptedException, IntrospectionException {
        driver.get(LinkTo);

        loginPage = new LoginPage(driver);
        loginPage.typeUsername(Email);
        loginPage.clickNext();
        loginPage.typePassword(Password);
        loginPage.submitLogin();

        incomingPage = new IncomingPage(driver);
        incomingPage.clickOnComposeButton();
        incomingPage.typeNameRecipient(RecepientName);
        incomingPage.typeUniqSubject("test subject email " + uniqueID);
        incomingPage.typeBody(Body);
        incomingPage.closeComposeEmailWindow();

        draftsPage = new DraftsPage(driver);
        draftsPage.navigateToDraftsFolder();
        draftsPage.selectFirstDraftInList();
        draftsPage.sendVerifEmail();
    }

    @Test
    public void VerificateThatSendEmailNotDisplayedInDrafts() throws IntrospectionException, InterruptedException {

        draftsPage = new DraftsPage(driver);
        draftsPage.navigateToSendEmailFolder();
        draftsPage.navigateToDraftsFolder();
        draftsPage.selectFirstDraftInList();
        Assert.assertFalse(draftsPage.getTextOfSubject().contains(uniqueID));
        incomingPage = new IncomingPage(driver);
        incomingPage.closeComposeEmailWindow();
    }

    @AfterTest
    public void cleanUp() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}

