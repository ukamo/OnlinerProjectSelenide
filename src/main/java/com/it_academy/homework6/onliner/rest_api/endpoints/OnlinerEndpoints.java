package com.it_academy.homework6.onliner.rest_api.endpoints;

import com.it_academy.homework6.onliner.framework.PropertiesReader;

public class OnlinerEndpoints {
    public static String  getSushiEndPoint(){
        return PropertiesReader.getEndPointProperty("onliner.sushi.list");
    }
}
