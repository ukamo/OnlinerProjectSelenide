package com.it_academy.homework6.onliner.page_object;

import com.it_academy.homework6.onliner.framework.DriveManager;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {

    public BasePage() {
        DriveManager.initDriver("chrome");
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
