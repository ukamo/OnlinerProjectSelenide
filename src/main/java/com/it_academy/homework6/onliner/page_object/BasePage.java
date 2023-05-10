package com.it_academy.homework6.onliner.page_object;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.it_academy.homework6.onliner.framework.DriveManager.configurationBrowser;

public abstract class BasePage {

    public BasePage() {
        //DriveManager.initDriver("firefox");
        configurationBrowser();
    }

    public void navigate(String url) {
        getWebDriver().get(url);
    }

    public String getBrowserTitle() {
        return getWebDriver().getTitle();
    }

    public void closeAllWindow() {
        getWebDriver().quit();
    }

}
