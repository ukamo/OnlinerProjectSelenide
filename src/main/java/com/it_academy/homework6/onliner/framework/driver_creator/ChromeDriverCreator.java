package com.it_academy.homework6.onliner.framework.driver_creator;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverCreator implements WebDriverCreator<RemoteWebDriver>{
    @Override
    public ChromeDriver create(){
        return new ChromeDriver( new ChromeOptions().addArguments("--remote-allow-origins=*"));
    }
}
