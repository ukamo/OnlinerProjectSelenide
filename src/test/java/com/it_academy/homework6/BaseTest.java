package com.it_academy.homework6;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void init() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
        //DriveManager.initDriver("chrome");

    }

    @AfterClass
    public void closeBrowser() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
