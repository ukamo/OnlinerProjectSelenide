package com.it_academy.homework6.web;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.homework6.BaseTest;
import com.it_academy.homework6.onliner.Links;
import com.it_academy.homework6.onliner.page_object.pages.Header;
import com.it_academy.homework6.onliner.page_object.pages.ProductPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.time.Duration.ofSeconds;

public class ProductPageTest extends BaseTest {

    protected  static final Logger  LOG = LoggerFactory.getLogger(ProductPageTest.class);
    private ProductPage productPage;
    private Header header;

    @Test
    public void voidTestLogs(){
        LOG.info("Test Info");
        LOG.warn("Test Warn");
        LOG.error("Test Error");
        LOG.debug("Test debug");
    }

    @BeforeClass
    public void createForTestProductPage() {
        header = new Header();
        productPage = new ProductPage();
        getWebDriver().get(Links.HOME_PAGE.getLink());
    }

    @Test
    public void checkProductTitleSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        productPage.checkProductTitlesCount()
                .as("Размер тайтлов меньше 0")
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));
    }

    @Test
    public void checkProductDescriptionSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        ElementsCollection components = productPage.checkProductDescriptionCount();
        components.as("Описание меньше 0")
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));
    }

    @Test
    public void checkProductRatingSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        productPage.checkComponentRating()
                .as("Рейтинг меньше 0")
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));
    }

    @Test
    public void checkProductPriceSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        productPage.checkComponentPrice()
                .as("Цены меньше 0")
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));


    }

    @Test
    public void checkProductIconSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        productPage.checkComponentIcon()
                .as("Размер иконок меньше 0")
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));
    }

    @Test
    public void checkProductCheckboxSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        productPage.checkComponentCheckbox()
                .as("Чекбоксы меньше 0")
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));
    }

}
