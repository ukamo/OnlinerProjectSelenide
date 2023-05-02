package com.it_academy.homework6.onliner.page_object.pages;

import com.it_academy.homework6.onliner.page_object.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.format;

public class MainPageSearch extends BasePage {
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


    public void verifySearchIsDisplayed(String title){
        $x(format(SEARCH_MAIN_TEXT_XPATH_PATTERN,title))
                .shouldBe(and("clickable",visible,enabled), Duration.ofSeconds(10));
    }
    public MainPageSearch typeOnSearchField(String inputText) {
        $x(format(SEARCH_MAIN_XPATH_PATTERN))
                .shouldBe(and("clickable",visible,enabled), Duration.ofSeconds(10))
                .setValue(inputText)
                .pressEnter();
        return this;
    }

    public boolean verifySearchField(String inputText) {
        return $x(format(SEARCH_MAIN_XPATH_PATTERN))
                .getValue().matches(inputText);
    }

    public MainPageSearch verifyIFrameFieldSearching() {
        $(format(IFRAME_SEARCH_CSS_PATTERN))
                .shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    public MainPageSearch swithOnIFrameFieldSearching() {
        parentWindow = getWebDriver().getWindowHandle();
        driver().switchTo().frame(IFRAME_NUMBER_PATTERN);
        return this;
    }

    public MainPageSearch closeIFrameFieldSearching() {
        $x(format(IFRAME_CLOSE_XPATH_PATTERN))
                .shouldBe(and("clickable",visible,enabled), Duration.ofSeconds(10))
                .click();
        return this;
    }
    public MainPageSearch switchFromMain() {
        getWebDriver().switchTo().parentFrame();
        return this;
    }

    public MainPageSearch deleteDataInSearchField() {
        $x(format(SEARCH_MAIN_XPATH_PATTERN))
                .clear();
        return this;
    }

}
