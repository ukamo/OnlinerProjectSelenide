package com.it_academy.homework6;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.homework6.onliner.framework.DriveManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void init() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
        DriveManager.initDriver("chrome");

    }

    @AfterSuite
    public void closeBrowser() {
        DriveManager.closeBrowser();
    }
}
