package com.it_academy.homework6;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.it_academy.homework6.onliner.page_object.pages.Header;
import com.it_academy.homework6.onliner.page_object.pages.ProductPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductPageTest extends BaseTest {
    private ProductPage productPage;
    private Header header;

    @BeforeClass
    public void createForTestProductPage() {
        header = new Header();
        productPage = new ProductPage();

        getWebDriver().get("https://www.onliner.by/");
    }

    @Test
    public void checkProductTitleSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        ElementsCollection components = productPage.checkProductGroup();
        assertThat(productPage.checkProductTitlesCount()
                .as("Количество тайтлов не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size())));
    }

    @Test
    public void checkProductDescriptionSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        ElementsCollection components = productPage.checkProductGroup();
        assertThat(productPage.checkProductDescriptionCount()
                .as("Количество описания не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size())));
    }

    @Test
    public void checkProductRatingSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        ElementsCollection components = productPage.checkProductGroup();
        assertThat(productPage.checkComponentRatingCount()
                .as("Количество рейтингов не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size())));
    }

    @Test
    public void checkProductPriceSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        ElementsCollection components = productPage.checkProductGroup();
        assertThat(productPage.checkComponentPriceCount()
                .as("Количество цен не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size())));
    }

    @Test
    public void checkProductIconSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        ElementsCollection components = productPage.checkProductGroup();
        assertThat(productPage.checkComponentIconCount()
                .as("Количество иконок не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size())));
    }

    @Test
    public void checkProductCheckboxSize() {
        header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickTextSectionItemCatalog("Аудиотехника")
                .clickOnProductLink("Наушники");
        ElementsCollection components = productPage.checkProductGroup();
        assertThat(productPage.checkComponentCheckboxCount()
                .as("Количество чекбоксов не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size())));
    }

}
