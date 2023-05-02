package com.it_academy.homework6;
import com.it_academy.homework6.onliner.page_object.pages.MainPageSearch;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPageSearchTest {
    private MainPageSearch mainPageSearch;
    @BeforeClass
    public void createForTestProductPage() {
        mainPageSearch = new MainPageSearch();
        getWebDriver().get("https://www.onliner.by/");
    }

    @Test
    public void testVerifySearchInput() {
        mainPageSearch
                .verifySearchIsDisplayed("Поиск");
    }
    @Test
    public void verifyValueInSearching() {
        mainPageSearch
                .typeOnSearchField("Тест")
                .verifySearchField("Тест");
    }

    @Test (dependsOnMethods={"verifyValueInSearching"})
    public void verifyIFrameFieldSearching() {
        mainPageSearch
                .typeOnSearchField("Тест")
                .swithOnIFrameFieldSearching()
                .verifyIFrameFieldSearching();
    }
    @Test
    public void closeIFrameFieldSearching() {
        mainPageSearch
                .typeOnSearchField("Тест")
                .swithOnIFrameFieldSearching()
                .closeIFrameFieldSearching()
                .switchFromMain();
    }

    @Test
    public void deleteDataInSearchingField() {
        mainPageSearch
                .typeOnSearchField("Тест")
                .deleteDataInSearchField();
    }


}
