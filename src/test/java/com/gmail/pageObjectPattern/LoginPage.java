package com.gmail.pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by meowmeow on 26.02.2017.
 */
public class LoginPage {
    private WebDriver driver;

    By emailField = By.name("Email");
    By nextButton = By.id("next");
    By passwordField = By.name("Passwd");
    By signInButton = By.id("signIn");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage typeUsername(String Email) {
        driver.findElement(emailField).sendKeys(Email);
        return this;
    }

    public LoginPage typePassword(String Password) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(passwordField).sendKeys(Password);
        return this;
    }

    public LoginPage submitLogin() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public LoginPage clickNext() {
        driver.findElement(nextButton).click();
        return this;
    }
}
