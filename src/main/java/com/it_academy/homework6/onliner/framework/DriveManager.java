package com.it_academy.homework6.onliner.framework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.it_academy.homework6.onliner.framework.driver_creator.Driver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.getProperty;

public class DriveManager {

    public static void configurationBrowser(){
        if (getProperty("driverType") != null){
            initDriver(getProperty("driverType"));
        } else {
            initDriver("chrome");
        }
    }

    public static void initDriver(String type) {
        if (type.equals("remote")) {
            //todo read from properties
            //Configuration.browser = "chrome";
            Configuration.remote = "http://localhost:4444/wd/hub";
            //todo end
        } else {
            Configuration.browser = type;
            Configuration.pageLoadTimeout = 200000;
        }
        open();
    }




}
