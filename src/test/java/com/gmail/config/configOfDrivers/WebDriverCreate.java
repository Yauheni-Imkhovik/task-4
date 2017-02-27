package com.gmail.config.configOfDrivers;

import org.openqa.selenium.WebDriver;

/**
 * Created by meowmeow on 27.02.2017.
 */
public class WebDriverCreate {

    private static WebDriver driver;

    public static WebDriver getInstance() throws Exception {
        if (null == driver) {
            driver = CreatorOfWebDriver.Create("chrome");
        }
        return driver;
    }
}
