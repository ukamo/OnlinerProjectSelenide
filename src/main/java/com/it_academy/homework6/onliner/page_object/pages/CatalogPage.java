package com.it_academy.homework6.onliner.page_object.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.homework6.onliner.page_object.BasePage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class CatalogPage extends BasePage {
    private static final String SECTION_FOR_CATALOG_XPATH_PATTERN = "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";
    private static final String SECTIONS_CATALOG_XPATH_PATTERN = "//ul[@class='catalog-navigation-classifier ']/li[@class = 'catalog-navigation-classifier__item ']";
    private static final String SECTION_ITEM_XPATH_PATTERN = "//div[contains(@class,'aside-item')]//div[contains(text(),'%s')]";
    private static final String TITLE_XPATH_PATTERN = "//div[contains(@class,'item_active')]//div[contains(@class,'dropdown-list')]//span[contains(@class,'dropdown-title')]";
    public static final String GOODS_ITEM_XPATH_PATTERN = "//div[contains(@class,'item_active')]//a[contains(@class,'list__dropdown-item')]";
    private static final String PRODUCT_XPATH_PATTERN = "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]" + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";
    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN = "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";

    public ElementsCollection elementsFromSectionCatalog() {
        ElementsCollection elements = $$x(SECTIONS_CATALOG_XPATH_PATTERN);
        return elements;
    }


    @Step("Click on section Catalog Link{link}")
    public CatalogPage clickOnSectionCatalogLink(String link) {
        $x(format(SECTION_FOR_CATALOG_XPATH_PATTERN, link)).shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(30)).click();
        return this;
    }
    @Step ("Get text section item Catalog Link{link}")
    public SelenideElement getTextSectionItemCatalogLink(String link) {
        return $x(format(SECTION_ITEM_XPATH_PATTERN, link)).shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(30));
    }

    @Step ("Click text section Item Catalog {link}")
    public CatalogPage clickTextSectionItemCatalog(String link) {
        $x(format(SECTION_ITEM_XPATH_PATTERN, link)).shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(30)).click();
        return this;
    }
    @Step ("Verify title of Catalog Page")
    public ElementsCollection checkTitleOfCatalogPage(String testContains) {
        return $$x(format(TITLE_XPATH_PATTERN, testContains));
    }
    @Step ("Get Goods Components By Name {name}")
    public ElementsCollection getGoodsComponentsByName(String name) {
        return $$x(format(GOODS_ITEM_XPATH_PATTERN, name));
    }
    @Step ("Check component Titles Count")
    public ElementsCollection checkComponentTitlesCount() {
        ElementsCollection elements = $$x("//div[contains(@class, 'aside-item_active')]//span[contains(@class,'catalog-navigation-list__dropdown-title')]");
        return elements;
    }
    @Step ("Check component Previews Count")
    public ElementsCollection checkComponentPreviewsCount() {
        ElementsCollection elements = $$x("//div[contains(@class, 'aside-item_active')]//span[contains(@class,'catalog-navigation-list__dropdown-image')]");
        return elements;
    }
    @Step ("Check component Description Count")
    public ElementsCollection checkComponentDescriptionCount() {
        ElementsCollection elements = $$x("//div[contains(@class, 'aside-item_active')]//span[contains(@class,'catalog-navigation-list__dropdown-description')]");
        return elements;
    }
    @Step ("Check component Size")
    public ElementsCollection checkGoodsComponentsSize() {
        ElementsCollection elements = $$x("//div[contains(@class, 'aside-item_active')]//span[contains(@class,'catalog-navigation-list__dropdown-data')]");
        return elements;
    }
    @Step ("Check Goods Catalog Page")
    public ElementsCollection checkGoodsCatalogPage(String catalogName) {
        ElementsCollection elements = $$x(format(TITLE_XPATH_PATTERN, catalogName));
        return elements;
    }
    @Step ("click on Product Link {link}")
    public void clickOnProductLink(String product) {
        $x(format(PRODUCT_XPATH_PATTERN, product)).shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(30)).click();
    }
    @Step ("clickOnCatalogClassifierLink {link}")
    public CatalogPage clickOnCatalogClassifierLink(String link) {
        $x(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link)).shouldBe(visible, Duration.ofSeconds(30)).click();
        return this;
    }
    @Step ("Verify browser title is displayed")
    public SelenideElement verifyBrowserTitleIsDisplayed(String title) {
        return $x(format(SECTION_FOR_CATALOG_XPATH_PATTERN, title)).shouldBe(and("clickable", visible, enabled), Duration.ofSeconds(30));
    }
}
