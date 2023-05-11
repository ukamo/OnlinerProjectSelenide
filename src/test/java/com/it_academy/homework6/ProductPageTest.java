package com.it_academy.homework6;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.it_academy.homework6.onliner.Links;
import com.it_academy.homework6.onliner.page_object.pages.Header;
import com.it_academy.homework6.onliner.page_object.pages.ProductPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProductPageTest extends BaseTest {
    private ProductPage productPage;
    private Header header;

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
        ElementsCollection components = productPage.checkProductGroup();
        productPage.checkProductTitlesCount()
                .as("Количество тайтлов не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size()));
    }

    @Test
    public void checkProductDescriptionSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        ElementsCollection components = productPage.checkProductGroup();
        productPage.checkProductDescriptionCount()
                .as("Количество описания не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size()));
    }

    @Test
    public void checkProductRatingSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        ElementsCollection components = productPage.checkProductGroup();
        productPage.checkComponentRating()
                .as("Количество рейтингов не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size()));
    }

    @Test
    public void checkProductPriceSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        ElementsCollection components = productPage.checkProductGroup();
        productPage.checkComponentPrice()
                .as("Количество цен не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size()));
    }

    @Test
    public void checkProductIconSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        ElementsCollection components = productPage.checkProductGroup();
        productPage.checkComponentIcon()
                .as("Количество иконок не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size()));
    }

    @Test
    public void checkProductCheckboxSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        ElementsCollection components = productPage.checkProductGroup();
        productPage.checkComponentCheckbox()
                .as("Количество чекбоксов не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size()));
    }

}
