package com.gmail.pageObjectPattern;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

import java.beans.IntrospectionException;
import java.util.concurrent.TimeUnit;


/**
 * Created by meowmeow on 26.02.2017.
 */
public class DraftsPage {
    private WebDriver driver;

    By sendEmailstFolder = By.xpath("//div[2]/div/div/div/div/div[3]/div/div/div[2]");
    By draftsListFolder = By.xpath("//div[2]/div/div/div/div/div[4]/div/div/div[2]");
    By openFirstDraft = By.xpath("//div[2]/font");
    By textOfSubject = By.xpath("//h2/div[2]");
    By textOfBody = By.xpath("//td[2]/div[2]/div");
    By sendEmailButton = By.xpath("//td/div/div/div[4]/table/tbody/tr/td/div/div[2]");
    By openFirstSend = By.xpath("//div[3]/div[4]/div/div/table/tbody/tr/td[6]");
    By sendEmailSubject = By.xpath("//td/div[2]/div/div[2]");

    public DraftsPage(WebDriver driver) {
        this.driver = driver;
    }

    public DraftsPage navigateToSendEmailFolder() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(sendEmailstFolder).click();
        return this;

    }

    public DraftsPage navigateToDraftsFolder() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(draftsListFolder).click();
        return this;

    }

    public DraftsPage selectFirstDraftInList() throws IntrospectionException, InterruptedException {
        Thread.sleep(4000);
        driver.findElement(openFirstDraft).click();
        return this;
    }

    public String getTextOfSubject() throws IntrospectionException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String subject = driver.findElement(textOfSubject).getText();
        return subject;

    }

    public String getTextOfBody() throws IntrospectionException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String sbody = driver.findElement(textOfBody).getText();
        return sbody;
    }

    public DraftsPage sendVerifEmail() throws IntrospectionException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(sendEmailButton).click();
        return this;
    }

    public DraftsPage selectFirstSendEmailInList() throws IntrospectionException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(openFirstSend).click();
        return this;
    }

    public String getSubjectOfSendEmail() throws IntrospectionException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String sSubject = driver.findElement(sendEmailSubject).getText();
        return sSubject;
    }
}

