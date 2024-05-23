package io.github.simple4tests.ohrm.context;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestConfig.class)
@CucumberContextConfiguration
public class CucumberSpringConfiguration {
}
