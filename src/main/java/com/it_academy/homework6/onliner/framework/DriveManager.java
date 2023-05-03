package com.it_academy.homework6.onliner.framework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.open;

public class DriveManager {
    public static void closeBrowser() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }

    public static void initDriver(String type) {
        Configuration.browser = type;
        Configuration.pageLoadTimeout = 200000;
        open();
    }
}
