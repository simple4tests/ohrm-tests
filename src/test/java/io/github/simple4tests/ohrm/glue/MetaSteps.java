package io.github.simple4tests.ohrm.glue;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import io.github.simple4tests.ohrm.context.TestConfig;
import io.github.simple4tests.ohrm.context.TestData;
import io.github.simple4tests.webdriver.providers.WebDriverProvider;
import io.github.simple4tests.webdriver.reporters.CucumberJava8Reporter;
import io.github.simple4tests.sncfws.SncfWs;
import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;
import java.time.Duration;

public class MetaSteps implements En {

    WebDriver driver;

    CucumberJava8Reporter reporter;

    SncfWs sncfWs;

    TestData testData;

    public MetaSteps(TestConfig config) {
        this.reporter = config.reporter;
        this.sncfWs = config.sncfWs;
        this.testData = config.testData;

        Before((Scenario scenario) -> {
            initDriver();
            initReporter(scenario);
            initAutomaton();
            initTestData();
        });

        After(this::closeAll);
    }

    public void initDriver() {
        driver = WebDriverProvider.get(
                System.getProperty("s4t.browser"),
                Paths.get(System.getProperty("s4t.driverPath")),
                System.getProperty("s4t.optionsAsYamlResource"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));
    }

    public void initReporter(Scenario scenario) {
        reporter.init(scenario, driver);
        reporter.clearErrors();
    }

    public void initAutomaton() {
        sncfWs.init(reporter);
    }

    public void initTestData() {
    }

    public void closeAll() {
        driver.quit();
        reporter.throwAssertionErrorIfAny(true);
    }
}
