package com.it_academy.homework6;

import com.codeborne.selenide.ElementsCollection;
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
        header= new Header();
        header.navigate(Links.HOME_PAGE.getLink());
        catalogPage = new CatalogPage();
    }

    /*
    @DataProvider(name = "sections")
    public static Object[][] sections() {
        return new Object[][]{{"Электроника", "Электроника"},
                {"Компьютеры и\u00a0сети", "Компьютеры и сети"},
                {"Бытовая техника", "Бытовая техника"},
                {"На каждый день", "На каждый день"},
                {"Стройка и\u00a0ремонт", "Стройка и ремонт"},
                {"Дом и\u00a0сад", "Дом и сад"},
                {"Авто и\u00a0мото", "Авто и мото"},
                {"Красота и\u00a0спорт", "Красота и спорт"},
                {"Детям и\u00a0мамам", "Детям и мамам"}};
    }

     */
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

    /*
    @Test(dataProvider = "sections")
    public void testSectionsOnCatalog(String str1, String answer) {
        header.clickOnMainNavigationLink("Каталог")
                .getTextFromSectionCatalog(str1,answer);
    }

     */

    @Test
    public void testSizeOfSectionOnCatalog() {
        ArrayList<String> titles = new ArrayList<>(Arrays.asList("Onlíner Prime","Электроника",
                "Компьютеры и\u00a0сети","Бытовая техника","На каждый день","Стройка и\u00a0ремонт",
                "Дом и\u00a0сад","Авто и\u00a0мото","Красота и\u00a0спорт","Детям и\u00a0мамам"));
        header.clickOnMainNavigationLink("Каталог")
                .isSizeFromSectionCatalog(titles);
    }

    @Test
    public void testTextOfSectionOnCatalog() {
        ArrayList<String> titles = new ArrayList<>(Arrays.asList("Onlíner Prime","Электроника",
                "Компьютеры и\u00a0сети","Бытовая техника","На каждый день","Стройка и\u00a0ремонт",
                "Дом и\u00a0сад","Авто и\u00a0мото","Красота и\u00a0спорт","Детям и\u00a0мамам"));
        header.clickOnMainNavigationLink("Каталог")
                .isDisplaySectionCatalog(titles);
    }
    /*
    public void testSectionsOnCatalog(String str1, String answer) {
        header.clickOnMainNavigationLink("Каталог");
        assertThat(catalogPage.getTextFromSectionCatalog(str1,answer))
                .as("Browser title on Catalog page is incorrect")
                .isEqualTo(answer);
    }
     */

    @Test
    public void testVerifyTitleDisplayed() {
        header.clickOnMainNavigationLink("Каталог")
                .verifyBrowserTitleIsDisplayed("Компьютеры и\u00a0сети");
    }
    @Test(dataProvider = "verticalList")
    public void testVerticalListOnComputersSection(String str1, String expected) {
        header.clickOnMainNavigationLink("Каталог")
                .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                .getTextSectionItemCatalogLink(str1,expected);
    }

    @Test
    public void testTitleOfList() {
        header.clickOnMainNavigationLink("Каталог")
                .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                .clickTextSectionItemCatalog("Комплектующие")
                .checkTitleOfCatalogPage("Комплектующие");
    }
    @Test
    public void testGoodsOfList() {
        header.clickOnMainNavigationLink("Каталог")
                .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                .clickTextSectionItemCatalog("Комплектующие")
                .checkGoodsCatalogPage("Комплектующие");
    }
    @Test
    public void testComponentGoodsOfList() {
        header.clickOnMainNavigationLink("Каталог")
                .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                .clickTextSectionItemCatalog("Комплектующие");
        ElementsCollection components = catalogPage.getGoodsComponentsByName("Комплектующие");
        assertThat(catalogPage.checkGoodsComponentsSize(components))
                .as("Размер компонентов не соответвует размеру элементов")
                .isTrue();

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
        header.clickOnMainNavigationLink("Каталог")
                .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                    .clickTextSectionItemCatalog("Комплектующие");
        ElementsCollection components = catalogPage.getGoodsComponentsByName("Комплектующие");
        assertThat(catalogPage.checkComponentPreviewsCount(components))
                .as("Количество превью не соответствует количеству компонентов")
                .isTrue();
    }
    @Test
    public void testComponentDescriptionCountGoodsOfList() {
        header.clickOnMainNavigationLink("Каталог")
                .clickOnSectionCatalogLink("Компьютеры и\u00a0сети")
                .clickTextSectionItemCatalog("Комплектующие");
        ElementsCollection components = catalogPage.getGoodsComponentsByName("Комплектующие");
        assertThat(catalogPage.checkComponentDescriptionCount(components))
                .as("Количество описания не соответствует количеству компонентов")
                .isTrue();
    }
    @AfterClass
    public void closeWindow() {
        header.closeAllWindow();
    }
}
