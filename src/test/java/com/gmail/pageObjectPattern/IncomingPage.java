package com.gmail.pageObjectPattern;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


/**
 * Created by meowmeow on 26.02.2017.
 */
public class IncomingPage {
    private WebDriver driver;

    By composeNewEmail = By.xpath("//div[2]/div/div/div/div[2]/div/div/div/div/div");
    By fieldSendTo = By.cssSelector("TEXTAREA[class='vO']");
    By fieldSubjectTo = By.cssSelector("INPUT[class='aoT']");
    By fieldbodyOfTheEmail = By.cssSelector("DIV[class='Am Al editable LW-avf']");
    By closeEmailButton = By.cssSelector("IMG[class='Ha']");
    By accountButton = By.cssSelector("span.gb_9a.gbii");
    By escapeButton = By.cssSelector("#gb_71");

    public IncomingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public IncomingPage clickOnComposeButton() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(composeNewEmail).click();
        return this;

    }

    public IncomingPage typeNameRecipient(String RecepientName) {
        driver.findElement(fieldSendTo).sendKeys(RecepientName);
        return this;

    }

    public IncomingPage typeUniqSubject(String uniqSubject) {
        driver.findElement(fieldSubjectTo).sendKeys(uniqSubject);
        return this;

    }

    public IncomingPage typeBody(String emailBody) {
        driver.findElement(fieldbodyOfTheEmail).click();
        driver.findElement(fieldbodyOfTheEmail).sendKeys(emailBody);
        return this;

    }

    public void closeComposeEmailWindow() {
        driver.findElement(closeEmailButton).click();
    }

    public void clickOnAccountButton() {
        driver.findElement(accountButton).click();
    }

    public IncomingPage clickOnLogOutButton() {
        driver.findElement(escapeButton).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return this;
    }

}

