package com.it_academy.homework6;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.homework6.onliner.Links;
import com.it_academy.homework6.onliner.page_object.pages.CatalogPage;
import com.it_academy.homework6.onliner.page_object.pages.Header;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CatalogPageTest {

    private Header header;
    private CatalogPage catalogPage; //= new CatalogPage();


    @BeforeClass
    public void createForTestCatalogPage() {
        header = new Header();
        header.navigate(Links.HOME_PAGE.getLink());
        catalogPage = new CatalogPage();
    }

    @DataProvider(name = "verticalList")
    public static Object[][] verticalList() {
        return new Object[][]{{"Ноутбуки, компьютеры, мониторы", "Ноутбуки, компьютеры, мониторы"},
                {"Комплектующие", "Комплектующие"}};
    }

    @Test
    public void testNavigateToCatalog() {
        header.clickOnMainNavigationLink("Каталог");
        assertThat(header.getBrowserTitle())
                .as("Title of Catalog is incorrect")
                .isEqualTo("Каталог Onlíner");
    }

    @Test
    public void testSizeOfSectionOnCatalog() {
        ArrayList<String> titles = new ArrayList<>(Arrays.asList("Onlíner Prime", "Электроника",
                "Компьютеры и\u00a0сети", "Бытовая техника", "На каждый день", "Стройка и\u00a0ремонт",
                "Дом и\u00a0сад", "Авто и\u00a0мото", "Красота и\u00a0спорт", "Детям и\u00a0мамам"));
        header.clickOnMainNavigationLink("Каталог");
        assertThat(catalogPage.elementsFromSectionCatalog()
                .as("Количество элементов на странице не совпадает")
                .shouldHave(CollectionCondition.size(titles.size())));
    }

    @Test
    public void testTextOfSectionOnCatalog() {
        ArrayList<String> titles = new ArrayList<>(Arrays.asList("Onlíner Prime", "Электроника",
                "Компьютеры и\u00a0сети", "Бытовая техника", "На каждый день", "Стройка и\u00a0ремонт",
                "Дом и\u00a0сад", "Авто и\u00a0мото", "Красота и\u00a0спорт", "Детям и\u00a0мамам"));
        header.clickOnMainNavigationLink("Каталог");
        assertThat(catalogPage.elementsFromSectionCatalog()
                .shouldHave(CollectionCondition.exactTexts(titles)));
    }

    @Test
    public void testVerifyTitleDisplayed() {
        SelenideElement element =
                header.clickOnMainNavigationLink("Каталог")
                        .verifyBrowserTitleIsDisplayed("Компьютеры и\u00a0сети");
        assertThat(element
                .as("Данное название отсутствует на странице")
                .isDisplayed());

    }

    @Test(dataProvider = "verticalList")
    public void testVerticalListOnComputersSection(String str1, String expected) {
        SelenideElement element =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .getTextSectionItemCatalogLink(str1);
        assertThat(element.
                as("Данный элемент не соответсвует ожидаемому элементу")
                .text()
                .equals(expected));
    }

    @Test
    public void testTitleOfList() {
        ElementsCollection elements =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .clickTextSectionItemCatalog("Комплектующие")
                        .checkTitleOfCatalogPage("Комплектующие");
        assertThat(elements
                .shouldBe(CollectionCondition
                        .noneMatch("Не все комплектующие содержат названия", el -> el.equals(""))));
    }

    @Test
    public void testGoodsOfList() {
        ElementsCollection elements =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .clickTextSectionItemCatalog("Комплектующие")
                        .checkGoodsCatalogPage("Комплектующие");
        assertThat(
                elements
                        .shouldBe(CollectionCondition
                                .noneMatch("Товар или цена пустые", el -> el.equals(""))));
    }

    @Test
    public void testComponentGoodsOfList() {
        ElementsCollection elements =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .clickTextSectionItemCatalog("Комплектующие")
                        .checkGoodsComponentsSize();
        ElementsCollection components = catalogPage.getGoodsComponentsByName("Комплектующие");
        assertThat(elements
                .as("Размер компонентов не соответвует размеру элементов")
                .shouldHave(CollectionCondition.size(components.size())));
    }

    @Test
    public void testTitleGoodsOfList() {
        header.clickOnMainNavigationLink("Каталог")
                .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                .clickTextSectionItemCatalog("Комплектующие");
        ElementsCollection components = catalogPage.getGoodsComponentsByName("Комплектующие");
        assertThat(catalogPage.checkComponentTitlesCount(components))
                .as("Количество тайтлов не соответствует количеству компонентов")
                .isTrue();
    }

    @Test
    public void testComponentPreviewsCountGoodsOfList() {
        ElementsCollection components =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .clickTextSectionItemCatalog("Комплектующие")
                        .getGoodsComponentsByName("Комплектующие");
        assertThat(catalogPage.checkComponentPreviewsCount(components)
                .as("Количество превью не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size())));
    }

    @Test
    public void testComponentDescriptionCountGoodsOfList() {
        ElementsCollection components =
                header.clickOnMainNavigationLink("Каталог")
                        .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                        .clickTextSectionItemCatalog("Комплектующие")
                        .getGoodsComponentsByName("Комплектующие");
        assertThat(catalogPage.checkComponentDescriptionCount(components)
                .as("Количество описания не соответствует количеству компонентов")
                .shouldHave(CollectionCondition.size(components.size())));
    }

    @AfterClass
    public void closeWindow() {
        header.closeAllWindow();
    }
}
