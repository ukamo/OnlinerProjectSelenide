package com.it_academy.homework6.onliner.framework.driver_creator;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface WebDriverCreator <T extends RemoteWebDriver>{
    T create();
}
