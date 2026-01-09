package io.github.simple4tests.ohrm.glue;

import io.cucumber.java8.En;
import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.context.TestConfig;
import io.github.simple4tests.ohrm.context.TestData;
import io.github.simple4tests.webdriver.reporters.CucumberJava8Reporter;
import org.hamcrest.Matchers;

public class ErrorsSteps implements En {

    CucumberJava8Reporter reporter;
    TestData testData;

    Ohrm ohrm;

    public ErrorsSteps(TestConfig config) {
        this.reporter = config.reporter;
        this.ohrm = config.ohrm;
        this.testData = config.testData;

        Given("browse to goog site", () -> {
            reporter.startStep("navigate to goog site step");
            ohrm.ui.driver.navigate().to("http://www.google.com");
            ohrm.ui.sleep(1000);
            reporter.endStep();
        });

        When("browse without screenshot", () -> {
            reporter.startStep("empty step");
            reporter.endStep();
        });

        When("browse with screenshot", () -> {
            reporter.startStep("screenshot step");
            reporter.reportScreenshot();
            reporter.endStep();
        });

        When("browse with screenshots", () -> {
            reporter.startStep("screenshots step");
            reporter.reportScreenshot();
            reporter.endStep();
            reporter.startStep("my double screenshot");
            reporter.reportScreenshot();
            reporter.reportScreenshot();
            reporter.endStep();
        });

        Then("simulate an error", () ->
                reporter.assertThat("failed step",
                        1,
                        Matchers.equalTo(2)));
    }
}
