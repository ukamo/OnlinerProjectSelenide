package com.it_academy.homework6.onliner.page_object;

import com.codeborne.selenide.Configuration;
import com.it_academy.homework6.onliner.framework.DriveManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class BasePage {

    public BasePage() {
        DriveManager.initDriver("chrome");
    }






    /*
    private final WebDriver driver;
    public BasePage() {
        driver = DriveManager.getWebDriver();
    }

     */



    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), ofSeconds(30));
        return wait.until(visibilityOfElementLocated(by));
    }

    public void navigate(String url) {
        getWebDriver().get(url);
    }

    public String getBrowserTitle() {
        return getWebDriver().getTitle();
    }

    protected boolean checkComponentPart(List<WebElement> components, String className) {
        List<WebElement> titles = new ArrayList<>();
        for (WebElement component : components) {
            WebElement title =
                    component.findElement(By.cssSelector(className));
            if (title.isDisplayed() && !title.getText().isBlank()) {
                titles.add(title);
            }
        }
        return components.size() == titles.size();
    }
    protected boolean checkComponentPartWithoutText(List<WebElement> components, String className) {
        List<WebElement> titles = new ArrayList<>();
        for (WebElement component : components) {
            WebElement title =
                    component.findElement(By.cssSelector(className));
            if (title.isDisplayed()) {
                titles.add(title);
            }
        }
        return components.size() == titles.size();
    }

    public void closeAllWindow() {
        getWebDriver().quit();
    }




}
