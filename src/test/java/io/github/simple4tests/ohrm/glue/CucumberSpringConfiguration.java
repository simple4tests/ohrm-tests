package io.github.simple4tests.ohrm.glue;

import io.cucumber.spring.CucumberContextConfiguration;
import io.github.simple4tests.ohrm.context.TestConfig;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfig.class)
public class CucumberSpringConfiguration {
}
