package com.it_academy.homework6.onliner.page_object;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.homework6.onliner.framework.DriveManager;
import java.util.ArrayList;
import java.util.List;

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

    protected boolean isComponentSizeWithText(ElementsCollection components, String className) {
        List<SelenideElement> titles = new ArrayList<>();
        for (SelenideElement component : components) {
            SelenideElement title =
                    component.$(className);
            if (title.isDisplayed() && !title.getText().isBlank()) {
                titles.add(title);
            }
        }
        return components.size() == titles.size();
    }

    protected boolean isComponentSizeWithoutText(ElementsCollection components, String className) {
        List<SelenideElement> titles = new ArrayList<>();
        for (SelenideElement component : components) {
            SelenideElement title =
                    component.$(className);
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
