package io.github.simple4tests.ohrm.glue;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import io.github.simple4tests.ohrm.context.TestData;
import io.github.simple4tests.sncfws.SncfWs;
import io.github.simple4tests.webdriver.reporters.SerenityReporter;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Shared;
import org.openqa.selenium.WebDriver;

public class MetaSteps implements En {

    @Managed(driver = "provided")
    WebDriver driver;

    @Shared
    SerenityReporter reporter;

    @Shared
    SncfWs sncfWs;

    @Shared
    TestData testData;

    public MetaSteps() {

        Before((Scenario scenario) -> {
            initReporter();
            initAutomaton();
            initTestData();
        });

        After(this::closeAll);
    }

    public void initReporter() {
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
