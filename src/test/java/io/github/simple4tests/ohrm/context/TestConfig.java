package io.github.simple4tests.ohrm.context;

import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.webdriver.framework.CucumberJava8Reporter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TestConfig {

    @Bean("ohrm")
    public Ohrm getOhrm() {
        return new Ohrm();
    }

    @Bean("reporter")
    public CucumberJava8Reporter getReporter() {
        return new CucumberJava8Reporter();
    }

    @Bean("testData")
    public TestData getTestData() {
        return new TestData();
    }
}
