package io.github.simple4tests.sncfws;

import io.github.simple4tests.webdriver.reporters.Reporter;
import io.github.simple4tests.sncfws.capabilities.MunicipalitiesV1;
import io.github.simple4tests.sncfws.capabilities.MunicipalitiesV2;

public class SncfWs {

    public Reporter reporter;

    public MunicipalitiesV1 municipalitiesV1;
    public MunicipalitiesV2 municipalitiesV2;

    protected void copy(SncfWs sncfWs) {
        this.reporter = sncfWs.reporter;

        this.municipalitiesV1 = sncfWs.municipalitiesV1;
        this.municipalitiesV2 = sncfWs.municipalitiesV2;
    }

    public void init(Reporter reporter) {
        this.reporter = reporter;

        this.municipalitiesV1 = new MunicipalitiesV1();
        this.municipalitiesV2 = new MunicipalitiesV2();

        this.municipalitiesV1.copy(this);
        this.municipalitiesV2.copy(this);
    }
}
