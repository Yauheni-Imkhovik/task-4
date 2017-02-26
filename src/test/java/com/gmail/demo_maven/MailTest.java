package com.gmail.demo_maven;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MailTest {
    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger();

    @BeforeClass
    public void setUp() {

        driver = new FirefoxDriver();
    }

    @Test
    public void gotoGmailMainPage() throws InterruptedException {
        driver.get("https://gmail.com");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        WebElement emailField = driver.findElement(By.name("Email"));
        emailField.sendKeys("email4test26@gmail.com");
        driver.findElement(By.id("next")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement pwdField = driver.findElement(By.name("Passwd"));
        pwdField.sendKeys("emailpassword");
        driver.findElement(By.id("signIn")).click();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.findElement(By.id("gbqfq"));
        //Verify login
        String title = "Gmail";
        final boolean contains = driver.getTitle().contains(title);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement comButton = driver.findElement(By.xpath(".//*[@id=':3k']/div/div"));
        comButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement toField = driver.findElement(By.cssSelector("TEXTAREA[class='vO']"));
        toField.click();
        toField.sendKeys("dekeractops@gmail.com");

        WebElement subField = driver.findElement(By.cssSelector("INPUT[class='aoT']"));
        subField.click();
        String uniqueID = UUID.randomUUID().toString();
        subField.sendKeys("test subject email " + uniqueID);
        WebElement bodyField = driver.findElement(By.cssSelector("DIV[class='Am Al editable LW-avf']"));
        bodyField.click();
        bodyField.sendKeys("Hi, this is test text from test email.");
        WebElement clsCmpsBtn = driver.findElement(By.cssSelector("IMG[class='Ha']"));
        clsCmpsBtn.click();
        WebElement sendEmails = driver.findElement(By.xpath("//div[2]/div/div/div/div/div[3]/div/div/div[2]"));
        sendEmails.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement drafts = driver.findElement(By.xpath("//div[2]/div/div/div/div/div[4]/div/div/div[2]"));
        drafts.click();
        drafts.click();

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        WebElement frstDraf = driver.findElement(By.xpath("//div[2]/font"));
        frstDraf.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        String txtSubject = driver.findElement(By.xpath("//h2/div[2]")).getText();
        System.out.println(txtSubject);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Assert.assertTrue(txtSubject.contains(uniqueID));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement sndButton = driver.findElement(By.xpath("//td/div/div/div[4]/table/tbody/tr/td/div/div[2]"));
        sndButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendEmails.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[2]/div/div/div/div/div[4]/div/div/div[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[2]/font")).click();
        String incorrecttxtSubject = driver.findElement(By.xpath("//h2/div[2]")).getText();
        System.out.println(incorrecttxtSubject);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Assert.assertFalse(incorrecttxtSubject.contains(uniqueID));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("IMG[class='Ha']")).click();
        Thread.sleep(5000);

        sendEmails.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement firstSendEmail = driver.findElement(By.xpath("//div[3]/div[4]/div/div/table/tbody/tr/td[6]"));
        firstSendEmail.click();

        String sendEmailSubject = driver.findElement(By.xpath("//td/div[2]/div/div[2]")).getText();
        System.out.println(sendEmailSubject);
        Assert.assertTrue(sendEmailSubject.contains(uniqueID));

       WebElement accountButton = driver.findElement(By.cssSelector("span.gb_9a.gbii"));
       accountButton.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement escButton = driver.findElement(By.cssSelector("#gb_71"));
       escButton.click();
        //A.gb_Ha gb_3e gb_af gb_yb

    }
}