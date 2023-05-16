package com.it_academy.homework6.api;

import com.it_academy.homework6.onliner.rest_api.service.SushiService;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class RestAssuredTest {
    @Test
    public void verifySushiCollectionValuesName() {
        assertTrue("Имя суши пустое", new SushiService().getAllSushi()
                .stream().noneMatch(s -> {
                    return s.getName().equals("");
                }));
    }
    @Test
    public void verifyFilteringOfRolls() {
        assertTrue("name_prefix содержит иное значение",
                new SushiService().getFilteredSushi("roll").stream().allMatch((String s) -> s.equals("Роллы")));
    }
}