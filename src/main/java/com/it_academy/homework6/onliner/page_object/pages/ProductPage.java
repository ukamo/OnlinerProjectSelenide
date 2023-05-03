package com.it_academy.homework6.onliner.page_object.pages;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.homework6.onliner.page_object.BasePage;
import static com.codeborne.selenide.Selenide.$$x;
import static java.lang.String.format;

public class ProductPage extends BasePage {
    private static final String PRODUCT_GROUP_XPATH_PATTERN =
            "//div[contains(@class,'schema-product__group')]";

    public ElementsCollection checkProductGroup() {
       ElementsCollection collections =  $$x(format(PRODUCT_GROUP_XPATH_PATTERN));
                return collections;
    }

    public ElementsCollection checkProductTitlesCount() {
        ElementsCollection elements = $$x( "//span[contains(@data-bind,'html: product.extended_name || product.full_name')]");
        return elements;
    }

    public ElementsCollection checkProductDescriptionCount() {
        return $$x("//span[contains(@data-bind,'html: product.description')]");
    }

    public ElementsCollection checkComponentRatingCount() {
        return $$x("//span[@class ='rating__fill']");
    }

    public ElementsCollection checkComponentPriceCount() {
        return $$x("//div[@class ='schema-product__price']");

    }

    public ElementsCollection  checkComponentIconCount() {
        return $$x("//a[@class ='js-product-image-link']");
    }

    public ElementsCollection checkComponentCheckboxCount() {
        ElementsCollection collection = $$x("//label[@class ='schema-product__control']");
        return collection;
    }
}
