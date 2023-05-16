package com.it_academy.homework6.onliner.framework;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserOptions {

    public static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName","chrome");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        return options;
    }

    public static FirefoxOptions getFirefoxOptions(){
        FirefoxOptions options = new FirefoxOptions();
        options.setPlatformName(Platform.WIN10.name());
        options.setCapability("browserName", "firefox");
        return options;
    }
    public static EdgeOptions getEdgeBrowserOptions(){
        EdgeOptions options  = new EdgeOptions();
        options.setPlatformName(Platform.WIN10.name());
        options.setCapability("browserName", "edge");
        return options;
    }

}
