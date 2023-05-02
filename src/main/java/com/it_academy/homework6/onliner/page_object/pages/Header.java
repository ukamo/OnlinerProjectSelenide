package com.it_academy.homework6.onliner.page_object.pages;

import com.it_academy.homework6.onliner.page_object.BasePage;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class Header extends BasePage {
    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTER =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";

    public CatalogPage clickOnMainNavigationLink(String link) {
        $x(format(MAIN_NAVIGATION_LINK_XPATH_PATTER,link))
                .shouldBe(visible, Duration.ofSeconds(30))
                .click();
        return new CatalogPage();
    }

}
