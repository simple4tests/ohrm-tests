package io.github.simple4tests.ohrm.context;

import io.github.simple4tests.webdriver.reporters.CucumberJava8Reporter;
import io.github.simple4tests.sncfws.SncfWs;

public class TestConfig {

    public CucumberJava8Reporter reporter = new CucumberJava8Reporter();

    public SncfWs sncfWs = new SncfWs();

    public TestData testData = new TestData();
}
