package com.it_academy.homework6.onliner.page_object.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.homework6.onliner.page_object.BasePage;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class CatalogPage extends BasePage {
    private static final String SECTION_FOR_CATALOG_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";
    private static final String SECTIONS_CATALOG_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li[@class = 'catalog-navigation-classifier__item ']";

    //private static final String SECTIONS_ITEM_XPATH_PATTERN =
    //        "//div[contains(@class,'catalog-navigation-list__aside-title')]";
    private static final String SECTION_ITEM_XPATH_PATTERN =
            "//div[contains(@class,'aside-item')]//div[contains(text(),'%s')]";
    private static final String TITLE_XPATH_PATTERN =
            "//div[contains(@class,'item_active')]//div[contains(text(),'%s')]/..//div[contains(@class,'dropdown-list')]//span[contains(@class,'dropdown-title')]";
    public static final String GOODS_ITEM_XPATH_PATTERN =
            "//div[contains(@class,'item_active')]//div[contains(text(),'%s')]/..//a[contains(@class,'list__dropdown-item')]";
    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";
    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";

    public boolean getTextFromSectionCatalog(String link, String expected) {
         return $x(format(SECTION_FOR_CATALOG_XPATH_PATTERN,link))
                 .shouldBe(visible, Duration.ofSeconds(30))
                 .as("Browser title on Catalog page is incorrect")
                 .getText()
                 .equals(expected);
    }

    public void isSizeFromSectionCatalog(ArrayList<String> titles) {
        ElementsCollection elements = $$x(SECTIONS_CATALOG_XPATH_PATTERN);
        elements.shouldHave(CollectionCondition.size(titles.size()));
    }
    public void isDisplaySectionCatalog(ArrayList<String> titles) {
        ElementsCollection elements = $$x(SECTIONS_CATALOG_XPATH_PATTERN);
        elements.stream().map(el -> el.getText()).collect(Collectors.toList());
        elements.shouldHave(CollectionCondition.exactTexts(titles));

    }

    public CatalogPage clickOnSectionCatalogLink(String link) {
        $x(format(SECTION_FOR_CATALOG_XPATH_PATTERN,link))
                .shouldBe(and("clickable",visible,enabled), Duration.ofSeconds(30))
                .click();
        return this;
    }

    public boolean getTextSectionItemCatalogLink(String link, String expected) {
        return $x(format(SECTION_ITEM_XPATH_PATTERN,link))
                .shouldBe(and("clickable",visible,enabled), Duration.ofSeconds(30))
                .getText()
                .equals(expected);
    }

    public boolean testListOnComputersSection(String link, String expected) {
        return $x(format(SECTION_ITEM_XPATH_PATTERN,link))
                .shouldBe(and("clickable",visible,enabled), Duration.ofSeconds(30))
                .getText()
                .equals(expected);
    }



    public CatalogPage clickTextSectionItemCatalog(String link) {
        $x(format(SECTION_ITEM_XPATH_PATTERN,link))
                .shouldBe(and("clickable",visible,enabled), Duration.ofSeconds(30))
                .click();
        return this;
    }

    public void checkTitleOfCatalogPage(String testContains) {
        $x (format(TITLE_XPATH_PATTERN, testContains))
                .shouldBe(visible,Duration.ofSeconds(30));
        ElementsCollection elements = $$x (format(TITLE_XPATH_PATTERN, testContains));
        elements.shouldBe(CollectionCondition.noneMatch("Не все комплектующие содержат названия",el -> el.equals("")));
    }

    public ElementsCollection getGoodsComponentsByName(String name) {
      return $$x(format(GOODS_ITEM_XPATH_PATTERN, name));
    }

    public boolean checkComponentTitlesCount(ElementsCollection components) {
        return checkComponentPart(components, ".catalog-navigation-list__dropdown-title");
    }

    public boolean checkComponentPreviewsCount(ElementsCollection components) {
        List<SelenideElement> titles = new ArrayList<>();
        for (SelenideElement component : components) {
            SelenideElement title = component.$(".catalog-navigation-list__dropdown-image")
                    .shouldBe(visible,Duration.ofSeconds(5));
            titles.add(title);
        }
       return components.size() == titles.size();
    }

    public boolean checkComponentDescriptionCount(ElementsCollection components) {
        return checkComponentPart(components, ".catalog-navigation-list__dropdown-description");
    }

    public boolean checkGoodsComponentsSize(ElementsCollection components) {
        Dimension size = components.stream().findAny().get().getSize();
        for (SelenideElement element : components) {
            if (!size.equals(element.getSize())) {
                return false;
            }
        }
        return true;
    }

    public void checkGoodsCatalogPage(String catalogName) {
        //$x (format(GOODS_XPATH_PATTERN, catalogName))
        //   .shouldBe(visible,Duration.ofSeconds(30));
        ElementsCollection elements = $$x(format(TITLE_XPATH_PATTERN, catalogName));
        elements.shouldBe(CollectionCondition.noneMatch("Товар или цена пустые",el -> el.equals("")));

        List<String> collect=elements.texts();
        //List<String> collect = elements.stream()
       //         .map(el -> el.getText()).collect(Collectors.toList());
       // return collect;
    }

    public boolean checkCountAndPrice(List<String> collect) {
        List<String> files = collect.stream().filter(f -> f.contains("\n")).map(f -> f.replaceAll("\n", " ")).toList();
        Pattern pattern = Pattern.compile("(\\d+(,\\d+)?)(\\D+)(\\d+(,\\d+)?)(.*?)");
        List<String> matching = files.stream()
                .filter(pattern.asPredicate())
                .toList();
        return files.size() == matching.size();
    }

    public void clickOnProductLink(String product) {
        $x(format(PRODUCT_XPATH_PATTERN,product))
                .shouldBe(and("clickable",visible,enabled), Duration.ofSeconds(30))
                .click();
        //return new ProductPage();
    }

    public CatalogPage clickOnCatalogClassifierLink(String link) {
        $x(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN,link))
                .shouldBe(visible, Duration.ofSeconds(30))
                .click();
        return this;
    }

    public void verifyBrowserTitleIsDisplayed(String title){
        $x(format(SECTION_FOR_CATALOG_XPATH_PATTERN,title))
                .shouldBe(and("clickable",visible,enabled), Duration.ofSeconds(30));
    }
}
