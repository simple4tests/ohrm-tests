package io.github.simple4tests.ohrm.glue;

import io.cucumber.java8.En;
import io.github.simple4tests.ohrm.context.TestData;
import io.github.simple4tests.sncfws.SncfWs;
import io.github.simple4tests.sncfws.json.JsonUtils;
import io.github.simple4tests.webdriver.reporters.SerenityReporter;
import net.thucydides.core.annotations.Shared;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;

public class WsSteps implements En {

    @Shared
    SerenityReporter reporter;

    @Shared
    SncfWs sncfWs;

    @Shared
    TestData testData;

    public WsSteps() {

        Given("a call to the municipalities v1 webservice for municipalitie INSEE code {word}", (String inseeCode) ->
                testData.responseV1 = sncfWs.municipalitiesV1.get(inseeCode));

        Given("a call to the municipalities v2 webservice for municipalitie INSEE code {word}", (String inseeCode) ->
                testData.responseV2 = sncfWs.municipalitiesV2.get(inseeCode));

        Given("a call to the municipalities v1 webservice for all municipalities", () ->
                testData.responseV1 = sncfWs.municipalitiesV1.get());

        Given("a call to the municipalities v2 webservice for all municipalities", () ->
                testData.responseV2 = sncfWs.municipalitiesV2.get());

        Then("JSON responses are the same", () ->
                reporter.assertThat("Check that the 2 answers are identical in terms of key value pair",
                        JsonUtils.getJsonDifferences(
                                        new JSONObject(testData.responseV1.getBody().asString()),
                                        new JSONObject(testData.responseV2.getBody().asString()))
                                .toString(),
                        "[]"));

        Then("JSON responses have the same number of municipalities", () ->
                reporter.assertThat("Check that the 2 answers have the same number of municipalities",
                        testData.responseV1.path("nom.size()"),
                        Matchers.equalTo(testData.responseV2.path("nom.size()"))));

        Then("JSON modified count responses have the same number of municipalities", () -> {
            Integer responseV1Count = testData.responseV1.path("nom.size()");
            Integer responseV2Count = (Integer) testData.responseV2.path("nom.size()") + 3;
            reporter.assertThat("Check that the 2 answers have the same number of municipalities",
                    responseV1Count,
                    Matchers.equalTo(responseV2Count));
        });

        Then("JSON responses have the same elements in same order", () -> {
            JsonUtils.counter = 0;
            reporter.assertThat("Check that the 2 answers are identical in terms of key value pair",
                    JsonUtils.getJsonDifferences(
                                    new JSONArray(testData.responseV1.getBody().asString()),
                                    new JSONArray(testData.responseV2.getBody().asString()),
                                    "")
                            .toString(),
                    "[]");
            reporter.reportData("Number of key value pair comparaison: ".concat(String.valueOf(JsonUtils.counter)));
        });
    }
}
