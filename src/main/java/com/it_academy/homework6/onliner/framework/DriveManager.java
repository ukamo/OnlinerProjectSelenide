package com.it_academy.homework6.onliner.framework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.open;

public class DriveManager {
    /*
    private static ThreadLocal<RemoteWebDriver> driver =
            new ThreadLocal();

    private static void setWebDriver() {
        driver.set(new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*")));
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public static WebDriver getWebDriver() {
        if (driver.get() == null) {
            setWebDriver();
        }
        return driver.get();
    }
*/
    public static void closeBrowser() {
//        driver.get().close();
//        driver.remove();
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }



    public static void initDriver(String type){
        Configuration.browser = type;
        Configuration.pageLoadTimeout = 200000;
        open();
    }
}
