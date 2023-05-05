package com.it_academy.homework6.onliner.page_object.pages;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.homework6.onliner.page_object.BasePage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ProductPage extends BasePage {
    private static final String PRODUCT_GROUP_XPATH_PATTERN =
            "//div[contains(@class,'schema-product__group')]";
    @Step("check Product Group")
    public ElementsCollection checkProductGroup() {
        $x(PRODUCT_GROUP_XPATH_PATTERN).shouldBe(visible,Duration.ofSeconds(30));
        ElementsCollection collections =  $$x(format(PRODUCT_GROUP_XPATH_PATTERN));
                return collections;
    }
    @Step ("Check product Titles Count")
    public ElementsCollection checkProductTitlesCount() {
        $x("//span[contains(@data-bind,'html: product.extended_name || product.full_name')]").shouldBe(visible,Duration.ofSeconds(30));
        ElementsCollection elements = $$x( "//span[contains(@data-bind,'html: product.extended_name || product.full_name')]");
        return elements;
    }
    @Step ("Check product Description Count")
    public ElementsCollection checkProductDescriptionCount() {
        $x("//span[contains(@data-bind,'html: product.description')]").shouldBe(visible,Duration.ofSeconds(30));
        return $$x("//span[contains(@data-bind,'html: product.description')]");
    }
    @Step ("Check component rating Count")
    public ElementsCollection checkComponentRatingCount() {
        $x("//div[@class='schema-product__rating-group']").shouldBe(visible,Duration.ofSeconds(30));
        return $$x("//div[@class='schema-product__rating-group']");
    }
    @Step ("Check component price Count")
    public ElementsCollection checkComponentPriceCount() {
        $x("//div[@class = 'schema-product']/div[ contains(@class,'schema-product__part_2')]/div[contains(@class, 'schema-product__part_3')]").shouldBe(visible,Duration.ofSeconds(30));
        return $$x("//div[@class = 'schema-product']/div[ contains(@class,'schema-product__part_2')]/div[contains(@class, 'schema-product__part_3')]");

    }
    @Step ("Check component price Count")
    public ElementsCollection  checkComponentIconCount() {
        $x("//a[contains(@data-bind, 'product.html')]/img[@loading='lazy']").shouldBe(visible,Duration.ofSeconds(30));
        return $$x("//a[contains(@data-bind, 'product.html')]/img[@loading='lazy']");
    }
    @Step ("Check component Checkbox Count")
    public ElementsCollection checkComponentCheckboxCount() {
        $x("//div[@class ='schema-product']").shouldBe(visible,Duration.ofSeconds(30));
        ElementsCollection collection = $$x("//div[@class ='schema-product']");
        return collection;
    }
}
