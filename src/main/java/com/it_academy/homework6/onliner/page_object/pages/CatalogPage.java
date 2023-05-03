package com.it_academy.homework6.onliner.page_object.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.homework6.onliner.page_object.BasePage;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class CatalogPage extends BasePage {
    private static final String SECTION_FOR_CATALOG_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";
    private static final String SECTIONS_CATALOG_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li[@class = 'catalog-navigation-classifier__item ']";
    private static final String SECTION_ITEM_XPATH_PATTERN =
            "//div[contains(@class,'aside-item')]//div[contains(text(),'%s')]";
    private static final String TITLE_XPATH_PATTERN =
            "//div[contains(@class,'item_active')]//div[contains(@class,'dropdown-list')]//span[contains(@class,'dropdown-title')]";
    public static final String GOODS_ITEM_XPATH_PATTERN =
            "//div[contains(@class,'item_active')]//a[contains(@class,'list__dropdown-item')]";
    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";
    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";

    public ElementsCollection elementsFromSectionCatalog() {
        ElementsCollection elements = $$x(SECTIONS_CATALOG_XPATH_PATTERN);
        return elements;
    }

    public CatalogPage clickOnSectionCatalogLink(String link) {
        $x(format(SECTION_FOR_CATALOG_XPATH_PATTERN, link))
                .shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(30))
                .click();
        return this;
    }

    public SelenideElement getTextSectionItemCatalogLink(String link) {
        return $x(format(SECTION_ITEM_XPATH_PATTERN, link))
                .shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(30));
    }


    public CatalogPage clickTextSectionItemCatalog(String link) {
        $x(format(SECTION_ITEM_XPATH_PATTERN, link))
                .shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(30))
                .click();
        return this;
    }

    public ElementsCollection checkTitleOfCatalogPage(String testContains) {
        return $$x(format(TITLE_XPATH_PATTERN, testContains));
    }

    public ElementsCollection getGoodsComponentsByName(String name) {
        return $$x(format(GOODS_ITEM_XPATH_PATTERN, name));
    }

    public boolean checkComponentTitlesCount(ElementsCollection components) {
        return isComponentSizeWithText(components, ".catalog-navigation-list__dropdown-title");
    }

    public ElementsCollection checkComponentPreviewsCount(ElementsCollection components) {
        ElementsCollection elements = $$x("//div[contains(@class, 'aside-item_active')]//span[contains(@class,'catalog-navigation-list__dropdown-image')]");
        return elements;
    }

    public ElementsCollection checkComponentDescriptionCount(ElementsCollection components) {
        ElementsCollection elements = $$x("//div[contains(@class, 'aside-item_active')]//span[contains(@class,'catalog-navigation-list__dropdown-description')]");
        return elements;
    }

    public ElementsCollection checkGoodsComponentsSize() {
        ElementsCollection elements = $$x("//div[contains(@class, 'aside-item_active')]//span[contains(@class,'catalog-navigation-list__dropdown-data')]");
        return elements;
    }

    public ElementsCollection checkGoodsCatalogPage(String catalogName) {
        ElementsCollection elements = $$x(format(TITLE_XPATH_PATTERN, catalogName));
        return elements;
    }

    public void clickOnProductLink(String product) {
        $x(format(PRODUCT_XPATH_PATTERN, product))
                .shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(30))
                .click();
    }

    public CatalogPage clickOnCatalogClassifierLink(String link) {
        $x(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link))
                .shouldBe(visible, Duration.ofSeconds(30))
                .click();
        return this;
    }

    public SelenideElement verifyBrowserTitleIsDisplayed(String title) {
        return $x(format(SECTION_FOR_CATALOG_XPATH_PATTERN, title))
                .shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(30));
    }
}
