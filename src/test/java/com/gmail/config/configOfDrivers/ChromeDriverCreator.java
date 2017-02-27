package com.gmail.config.configOfDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;

/**
 * Created by meowmeow on 27.02.2017.
 */
public class ChromeDriverCreator extends CreatorOfWebDriver {

    public static String chromedriver = "chromedriver.exe";

    @Override

    public WebDriver FactoryMethod() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(chromedriver)).build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = new ChromeDriver(service);
        return driver;
    }
}

