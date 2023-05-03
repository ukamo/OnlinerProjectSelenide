package com.it_academy.homework6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.homework6.onliner.page_object.pages.PageSearch;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PageSearchTest {
    private PageSearch pageSearch;

    @BeforeClass
    public void createForTestProductPage() {
        pageSearch = new PageSearch();
        getWebDriver().get("https://www.onliner.by/");
    }

    @Test
    public void testVerifySearchInput() {
        SelenideElement searchElement =
                pageSearch
                        .getSearchElement("Поиск");
        assertThat(searchElement
                .as("Элемент на странице не отображается")
                .isDisplayed());
    }

    @Test
    public void verifyValueInSearching() {
        boolean input =
                pageSearch
                        .typeOnSearchField("Тест")
                        .isSearchFieldFillOut("Тест");
        assertThat(input)
                .as("Поле поиска не заполнено ожидаемым значением")
                .isTrue();
    }

    @Test(dependsOnMethods = {"verifyValueInSearching"})
    public void verifyIFrameFieldSearching() {
        SelenideElement searchElement =
                pageSearch
                        .typeOnSearchField("Тест")
                        .swithOnIFrameFieldSearching()
                        .verifyIFrameFieldSearching();
        assertThat(searchElement
                .as("IFrame не открывается")
                .exists());
    }

    @Test
    public void deleteDataInSearchingFieldAfterClosingIFrame() {
        SelenideElement element =
                pageSearch
                        .typeOnSearchField("Тест")
                        .swithOnIFrameFieldSearching()
                        .closeIFrameFieldSearching()
                        .switchFromMain()
                        .deleteDataInSearchField();
        assertThat(element.shouldBe(Condition.empty)
                .as("Поле не пустое"));
    }


}
