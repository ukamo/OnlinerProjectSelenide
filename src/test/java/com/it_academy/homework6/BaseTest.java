package com.it_academy.homework6;

import com.it_academy.homework6.onliner.framework.DriveManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void init(){
        DriveManager.initDriver("chrome");

    }


    @AfterSuite
    public void closeBrowser() {
        DriveManager.closeBrowser();
    }
}
