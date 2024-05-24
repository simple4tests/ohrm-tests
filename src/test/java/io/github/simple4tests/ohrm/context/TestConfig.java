package io.github.simple4tests.ohrm.context;

import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.webdriver.reporters.AllureReporter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TestConfig {

    @Bean("reporter")
    public AllureReporter getReporter() {
        return new AllureReporter();
    }

    @Bean("ohrm")
    public Ohrm getOhrm() {
        return new Ohrm();
    }

    @Bean("testData")
    public TestData getTestData() {
        return new TestData();
    }
}
