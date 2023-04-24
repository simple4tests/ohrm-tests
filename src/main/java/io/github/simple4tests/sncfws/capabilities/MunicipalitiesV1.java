package io.github.simple4tests.sncfws.capabilities;

import io.github.simple4tests.sncfws.SncfWs;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MunicipalitiesV1 extends SncfWs {

    String uri = "https://geo.api.gouv.fr/communes/";

    public Response get(String inseeCode) {
        Response response = RestAssured
                .given().get(uri.concat(inseeCode))
                .thenReturn();
        reporter.reportAction("Appel WS Municipalities V1 pour la commune ".concat(inseeCode), response.asString());
        return response;
    }

    public Response get() {
        Response response = RestAssured
                .given().get(uri)
                .thenReturn();
        reporter.reportAction("Appel WS Municipalities V1 pour toutes les communes ; Total = ".concat(response.path("nom.size()").toString()));
        return response;
    }
}
