package com.it_academy.homework6.web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.homework6.onliner.Links;
import com.it_academy.homework6.onliner.page_object.pages.CatalogPage;
import com.it_academy.homework6.onliner.page_object.pages.Header;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CatalogPageTest {

    private Header header;
    private CatalogPage catalogPage;


    @BeforeClass
    public void createForTestCatalogPage() {
        catalogPage = new CatalogPage();
        header = new Header();
        getWebDriver().get(Links.HOME_PAGE.getLink());

    }

    @DataProvider(name = "verticalList")
    public static Object[][] verticalList() {
        return new Object[][]{{"Ноутбуки, компьютеры, мониторы", "Ноутбуки, компьютеры, мониторы"},
                {"Комплектующие", "Комплектующие"}};
    }

    @Test
    public void testNavigateToCatalog() {
        header.clickOnMainNavigationLink("Каталог");
        assertThat(title())
                .as("Title of Catalog is incorrect")
                .isEqualTo("Каталог Onlíner");
    }

    @Test
    public void testSizeOfSectionOnCatalog() {
        ArrayList<String> titles = new ArrayList<>(Arrays.asList("Onlíner Prime", "Электроника",
                "Компьютеры и\u00a0сети", "Бытовая техника", "На каждый день", "Стройка и\u00a0ремонт",
                "Дом и\u00a0сад", "Авто и\u00a0мото", "Красота и\u00a0спорт", "Детям и\u00a0мамам"));
        header.clickOnMainNavigationLink("Каталог");
        catalogPage.elementsFromSectionCatalog()
                .as("Количество элементов на странице не совпадает")
                .shouldHave(CollectionCondition.size(titles.size()));
    }

    @Test
    public void testTextOfSectionOnCatalog() {
        ArrayList<String> titles = new ArrayList<>(Arrays.asList("Onlíner Prime", "Электроника",
                "Компьютеры и\u00a0сети", "Бытовая техника", "На каждый день", "Стройка и\u00a0ремонт",
                "Дом и\u00a0сад", "Авто и\u00a0мото", "Красота и\u00a0спорт", "Детям и\u00a0мамам"));
        header.clickOnMainNavigationLink("Каталог");
        catalogPage.elementsFromSectionCatalog()
                .shouldHave(CollectionCondition.exactTexts(titles));
    }

    @Test
    public void testVerifyTitleDisplayed() {
        SelenideElement element =
                header.clickOnMainNavigationLink("Каталог")
                        .verifyBrowserTitleIsDisplayed("Компьютеры и\u00a0сети");
        element.as("Данное название отсутствует на странице").shouldBe(visible);
    }

    @Test(dataProvider = "verticalList")
    public void testVerticalListOnComputersSection(String str1, String expected) {
        SelenideElement element =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .getTextSectionItemCatalogLink(str1);
        element.as("Данный элемент не соответствует ожидаемому элементу").shouldHave(text(expected));
    }

    @Test
    public void testTitleOfList() {
        ElementsCollection elements =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .clickTextSectionItemCatalog("Комплектующие")
                        .checkTitleOfCatalogPage();
        elements
                .shouldBe(CollectionCondition
                        .noneMatch("Не все комплектующие содержат названия", el -> el.equals("")));
    }

    @Test
    public void testGoodsOfList() {
        ElementsCollection elements =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .clickTextSectionItemCatalog("Комплектующие")
                        .checkGoodsCatalogPage();
                elements
                        .shouldBe(CollectionCondition
                                .noneMatch("Товар или цена пустые", el -> el.equals("")));
    }

    @Test
    public void testComponentGoodsOfList() {
        ElementsCollection elements =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .clickTextSectionItemCatalog("Комплектующие")
                        .checkGoodsComponentsSize();
        ElementsCollection components = catalogPage.getGoodsComponents();
        elements
                .as("Размер компонентов не соответвует размеру элементов")
                .shouldHave(CollectionCondition.size(components.size()));
    }

    @Test
    public void testTitleGoodsOfList() {
        ElementsCollection components =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .clickTextSectionItemCatalog("Комплектующие")
                        .getGoodsComponents();
        catalogPage.checkComponentTitles()
                .as("Количество тайтлов не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size()));
    }

    @Test
    public void testComponentPreviewsCountGoodsOfList() {
        ElementsCollection components =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .clickTextSectionItemCatalog("Комплектующие")
                        .getGoodsComponents();
        catalogPage.checkComponentPreviews()
                .as("Количество превью не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size()));
    }

    @Test
    public void testComponentDescriptionCountGoodsOfList() {
        ElementsCollection components =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .clickTextSectionItemCatalog("Комплектующие")
                        .getGoodsComponents();
        catalogPage.checkComponentDescription()
                .as("Количество описания не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size()));
    }

    @AfterClass
    public void closeWindow() {
        closeWebDriver();
    }
}
