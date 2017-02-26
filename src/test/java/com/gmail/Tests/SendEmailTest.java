package com.gmail.Tests;

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
        import static com.sun.javafx.scene.control.skin.FXVK.Type.EMAIL;

/**
 * Created by meowmeow on 26.02.2017.
 */
public class SendEmailTest {
    private WebDriver driver;
    public IncomingPage incomingPage;
    public LoginPage loginPage;
    public DraftsPage draftsPage;

    @BeforeTest
    public void setUp() throws InterruptedException, IntrospectionException {
        driver = new FirefoxDriver();
        driver.get(LinkTo);

        loginPage = new LoginPage(driver);
        loginPage.typeUsername(Email);
        loginPage.clickNext();
        loginPage.typePassword(Password);
        loginPage.submitLogin();

        incomingPage = new IncomingPage(driver);
        incomingPage.clickOnComposeButton();
        incomingPage.typeNameRecipient(RecepientName);
        String uniqueID = UUID.randomUUID().toString();
        incomingPage.typeUniqSubject("test subject email " + uniqueID);
        incomingPage.typeBody(Body);
        incomingPage.closeComposeEmailWindow();

        draftsPage = new DraftsPage(driver);
        draftsPage.navigateToDraftsFolder();
        draftsPage.selectFirstDraftInList();
        Assert.assertTrue(draftsPage.getTextOfSubject().contains(uniqueID));
    }
        @Test
    public void SendVerificatedEmail () throws IntrospectionException {
            draftsPage = new DraftsPage(driver);
            Assert.assertTrue(draftsPage.getTextOfBody().contains("body"));
            draftsPage.sendVerifEmail();
        }
            @AfterTest
            public void cleanUp(){
                if ( driver != null ) {
                    driver.manage().deleteAllCookies();
                    driver.quit();
                }
            }
        }