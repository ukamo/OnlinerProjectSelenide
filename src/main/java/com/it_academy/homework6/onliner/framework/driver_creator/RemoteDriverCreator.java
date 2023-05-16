package com.it_academy.homework6.onliner.framework.driver_creator;

import com.it_academy.homework6.onliner.framework.BrowserOptionsFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class  RemoteDriverCreator implements WebDriverCreator<RemoteWebDriver> {
    @Override
    public RemoteWebDriver create(){
        try{
            return new RemoteWebDriver(new URL("http://172.20.121.127:4444/"),
                     BrowserOptionsFactory.getBrowserOptions(System.getProperty("remoteBrowser")));
                     //BrowserOptionsFactory.getBrowserOptions("remote"));
        } catch(MalformedURLException e){
            throw new RuntimeException(e);
        }
    }

}
