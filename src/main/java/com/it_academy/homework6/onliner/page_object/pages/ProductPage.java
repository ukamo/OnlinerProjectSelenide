package com.it_academy.homework6.onliner.page_object.pages;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.homework6.onliner.page_object.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ProductPage extends BasePage {
    private static final String PRODUCT_GROUP_XPATH_PATTERN =
            "//div[contains(@class,'schema-product__group')]";
    public ElementsCollection checkProductGroup() {
        return (ElementsCollection) $x(format(PRODUCT_GROUP_XPATH_PATTERN))
                .shouldBe(and("clickable",visible,enabled), Duration.ofSeconds(30));
    }

    public boolean checkProductTitlesCount(ElementsCollection components) {
        return checkComponentPart(components, "span[data-bind*='html: product.extended_name || product.full_name']");
    }
    public boolean checkProductDescriptionCount(ElementsCollection components) {
        return checkComponentPart(components, "span[data-bind*='html: product.description']");
    }
    public boolean checkComponentRatingCount(ElementsCollection components) {
        return checkComponentPartWithoutText(components, ".rating__fill");
    }
    public boolean checkComponentPriceCount(ElementsCollection components) {
        return checkComponentPart(components, ".schema-product__price");
    }
    public boolean checkComponentIconCount(ElementsCollection components) {
        return checkComponentPartWithoutText(components, ".js-product-image-link");
    }
    public boolean checkComponentCheckboxCount(ElementsCollection components) {
        return checkComponentPartWithoutText(components, ".schema-product__control");
    }
}
