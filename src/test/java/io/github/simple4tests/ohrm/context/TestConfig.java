package io.github.simple4tests.ohrm.context;

import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.webdriver.reporters.CucumberJava8Reporter;

public class TestConfig {

    public CucumberJava8Reporter reporter = new CucumberJava8Reporter();

    public TestData testData = new TestData();

    public Ohrm ohrm = new Ohrm();
}
