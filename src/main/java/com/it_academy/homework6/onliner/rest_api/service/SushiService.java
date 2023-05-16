package com.it_academy.homework6.onliner.rest_api.service;

import com.google.common.collect.ImmutableMap;
import com.it_academy.homework6.onliner.rest_api.model.Sushi;

import java.util.List;
import java.util.Map;

import static com.it_academy.homework6.onliner.rest_api.endpoints.OnlinerEndpoints.getSushiEndPoint;
import static com.it_academy.homework6.onliner.rest_api.utils.GetRequestUtils.makeGetRequestAndMakeResponseBody;


public class SushiService {
    public List<Sushi> getAllSushi(){
        return makeGetRequestAndMakeResponseBody(getSushiEndPoint(),null, configureParamsPage())
                .jsonPath()
                .getList("products", Sushi.class);
    }
   private static Map<String, Object> configureParamsPage() {
        return ImmutableMap.of("Host","catalog.onliner.by/sushivesla");
    }

    public List<String> getFilteredSushi(String filter){
        return makeGetRequestAndMakeResponseBody(getSushiEndPoint(),null, configureParamsFilter(filter))
                .jsonPath()
                .getList("products.name_prefix");
    }
    private static Map<String, Object> configureParamsFilter(String filter) {
        return ImmutableMap.of("sushi_typ[0]",filter,"sushi_typ[operation]","union");
    }

}
