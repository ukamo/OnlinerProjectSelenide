package com.it_academy.homework6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.homework6.onliner.Links;
import com.it_academy.homework6.onliner.page_object.pages.PageSearch;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PageSearchTest {
    private PageSearch pageSearch;

    @BeforeClass
    public void createForTestProductPage() {
        pageSearch = new PageSearch();
        getWebDriver().get(Links.HOME_PAGE.getLink());
    }

    @Test
    public void testVerifySearchInput() {
        SelenideElement searchElement =
                pageSearch
                        .getSearchElement("Поиск");
        searchElement
                .as("Элемент на странице не отображается")
                .shouldBe(visible);
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
        searchElement
                .as("IFrame не открывается")
                .shouldBe(exist);

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
        element.as("Поле не пустое").shouldBe(Condition.empty);
    }


}
