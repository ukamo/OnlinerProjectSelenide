package com.it_academy.homework6.onliner.framework;

import org.openqa.selenium.remote.AbstractDriverOptions;

public class BrowserOptionsFactory {
    public static AbstractDriverOptions options;

    public static AbstractDriverOptions getBrowserOptions(String browser){
        if(browser.equals("firefox"))
            options = BrowserOptions.getFirefoxOptions();
        else if(browser.equals("edge"))
            options = BrowserOptions.getEdgeBrowserOptions();
        else
            options = BrowserOptions.getChromeOptions();
        return options;
    }

}
