package com.it_academy.homework6.onliner.page_object.pages;

import com.codeborne.selenide.SelenideElement;
import com.it_academy.homework6.onliner.page_object.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.format;

public class PageSearch extends BasePage {
    private static final String SEARCH_MAIN_TEXT_XPATH_PATTERN =
            "//input[contains(@class,'fast-search__input') and contains(@placeholder , '%s')]";
    private static final String SEARCH_MAIN_XPATH_PATTERN =
            "//input[contains(@class,'fast-search__input')]";

    private static final int IFRAME_NUMBER_PATTERN = 0;
    private static final String IFRAME_SEARCH_CSS_PATTERN =
            ".search__close";

    private static final String IFRAME_CLOSE_XPATH_PATTERN =
            "//span[contains(@class,'search__close')]";
    String parentWindow = null;


    public SelenideElement getSearchElement(String title) {
        return $x(format(SEARCH_MAIN_TEXT_XPATH_PATTERN, title))
                .shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(10));
    }

    public PageSearch typeOnSearchField(String inputText) {
        $x(format(SEARCH_MAIN_XPATH_PATTERN))
                .shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(10))
                .setValue(inputText)
                .pressEnter();
        return this;
    }

    public boolean isSearchFieldFillOut(String expectedValue) {
        return $x(format(SEARCH_MAIN_XPATH_PATTERN))
                .getValue().matches(expectedValue);
    }

    public SelenideElement verifyIFrameFieldSearching() {
        return $(format(IFRAME_SEARCH_CSS_PATTERN))
                .shouldBe(visible, Duration.ofSeconds(10));
    }

    public PageSearch swithOnIFrameFieldSearching() {
        parentWindow = getWebDriver().getWindowHandle();
        driver().switchTo().frame(IFRAME_NUMBER_PATTERN);
        return this;
    }

    public PageSearch closeIFrameFieldSearching() {
        $x(format(IFRAME_CLOSE_XPATH_PATTERN))
                .shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(10))
                .click();
        return this;
    }

    public PageSearch switchFromMain() {
        getWebDriver().switchTo().parentFrame();
        return this;
    }

    public SelenideElement deleteDataInSearchField() {
        $x(format(SEARCH_MAIN_XPATH_PATTERN))
                .clear();
        return $x(format(SEARCH_MAIN_XPATH_PATTERN));
    }

}
