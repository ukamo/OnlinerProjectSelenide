package com.it_academy.homework6.onliner.page_object.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.homework6.onliner.page_object.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {
    private static final String SECTION_FOR_CATALOG_XPATH_PATTERN = "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";
    private static final ElementsCollection SECTIONS_CATALOG = $$x("//ul[@class='catalog-navigation-classifier ']/li[@class = 'catalog-navigation-classifier__item ']");
    private static final String SECTION_ITEM_XPATH_PATTERN = "//div[contains(@class,'aside-item')]//div[contains(text(),'%s')]";
    private final ElementsCollection TITLE = $$x("//div[contains(@class,'item_active')]//div[contains(@class,'dropdown-list')]//span[contains(@class,'dropdown-title')]");
    public static final ElementsCollection GOODS_ITEM = $$x("//div[contains(@class,'item_active')]//a[contains(@class,'list__dropdown-item')]");
    private static final String PRODUCT_XPATH_PATTERN = "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]" + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";
    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN = "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";

    public ElementsCollection elementsFromSectionCatalog() {
        return SECTIONS_CATALOG.shouldHave(CollectionCondition.allMatch("visible", WebElement::isDisplayed), ofSeconds(20));
    }


    @Step("Click on section Catalog Link{link}")
    public CatalogPage clickOnSectionCatalogLink(String link) {
        $x(format(SECTION_FOR_CATALOG_XPATH_PATTERN, link)).shouldBe(and("clickable", visible, enabled), ofSeconds(30)).click();
        return this;
    }

    @Step("Get text section item Catalog Link{link}")
    public SelenideElement getTextSectionItemCatalogLink(String link) {
        return $x(format(SECTION_ITEM_XPATH_PATTERN, link)).shouldBe(and("clickable", visible, enabled), ofSeconds(30));
    }

    @Step("Click text section Item Catalog {link}")
    public CatalogPage clickTextSectionItemCatalog(String link) {
        $x(format(SECTION_ITEM_XPATH_PATTERN, link)).shouldBe(and("clickable", visible, enabled), ofSeconds(30)).click();
        return this;
    }

    @Step("Verify title of Catalog Page")
    public ElementsCollection checkTitleOfCatalogPage() {
        return TITLE.shouldHave(CollectionCondition.allMatch("visible", WebElement::isDisplayed), ofSeconds(20));
    }

    @Step("Get Goods Components")
    public ElementsCollection getGoodsComponents() {
        return GOODS_ITEM.shouldHave(CollectionCondition.allMatch("visible", WebElement::isDisplayed), ofSeconds(20));
    }

    @Step("Check component Titles")
    public ElementsCollection checkComponentTitles() {
        return $$x("//div[contains(@class, 'aside-item_active')]//span[contains(@class,'catalog-navigation-list__dropdown-title')]");
    }

    @Step("Check component Previews")
    public ElementsCollection checkComponentPreviews() {
        return $$x("//div[contains(@class, 'aside-item_active')]//span[contains(@class,'catalog-navigation-list__dropdown-image')]");
    }

    @Step("Check component Description")
    public ElementsCollection checkComponentDescription() {
        return $$x("//div[contains(@class, 'aside-item_active')]//span[contains(@class,'catalog-navigation-list__dropdown-description')]");
    }

    @Step("Check component Size")
    public ElementsCollection checkGoodsComponentsSize() {
        return $$x("//div[contains(@class, 'aside-item_active')]//span[contains(@class,'catalog-navigation-list__dropdown-data')]");
    }

    @Step("Check Goods Catalog Page")
    public ElementsCollection checkGoodsCatalogPage() {
        //ElementsCollection elements = $$x(format(TITLE_XPATH_PATTERN, catalogName));
        return TITLE.shouldHave(CollectionCondition.allMatch("visible", WebElement::isDisplayed), ofSeconds(20));
    }

    @Step("click on Product Link {link}")
    public void clickOnProductLink(String product) {
        $x(format(PRODUCT_XPATH_PATTERN, product)).shouldBe(and("clickable", visible, enabled), ofSeconds(30)).click();
    }

    @Step("clickOnCatalogClassifierLink {link}")
    public CatalogPage clickOnCatalogClassifierLink(String link) {
        $x(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link)).shouldBe(visible, ofSeconds(30)).click();
        return this;
    }

    @Step("Verify browser title is displayed")
    public SelenideElement verifyBrowserTitleIsDisplayed(String title) {
        return $x(format(SECTION_FOR_CATALOG_XPATH_PATTERN, title)).shouldBe(and("clickable", visible, enabled), ofSeconds(30));
    }
}
