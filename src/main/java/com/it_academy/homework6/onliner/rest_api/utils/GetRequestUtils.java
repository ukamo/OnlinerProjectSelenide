package com.it_academy.homework6.onliner.rest_api.utils;
import io.restassured.response.ResponseBody;
import org.apache.commons.collections4.MapUtils;
import org.apache.hc.core5.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public final class GetRequestUtils {

    private GetRequestUtils(){

    }
    public static ResponseBody  makeGetRequestAndMakeResponseBody(String endpoint, Map<String, Object> headers, Map<String, Object> parameters){
        return given()
                .headers(MapUtils.emptyIfNull(headers))
                .params(MapUtils.emptyIfNull(parameters))
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody();


    }

}
