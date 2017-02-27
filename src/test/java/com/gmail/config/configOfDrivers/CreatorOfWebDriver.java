package com.gmail.config.configOfDrivers;

import org.openqa.selenium.WebDriver;

/**
 * Created by meowmeow on 27.02.2017.
 */
public abstract class CreatorOfWebDriver {

    protected WebDriver driver;


    public static WebDriver Create(String browser) throws Exception {
        WebDriver driver;
        if (browser.equals("firefox")) {
            driver = new FirefoxDriverCreator().FactoryMethod();

        } else if (browser.equals("chrome")) {
            driver = new ChromeDriverCreator().FactoryMethod();

        } else {
            throw new Exception("unsupported browser");
        }
        return driver;
    }

    public abstract WebDriver FactoryMethod();

}
