package io.github.simple4tests.ohrm.glue;

import io.cucumber.java8.En;
import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.webdriver.reporters.AllureReporter;
import io.github.simple4tests.webdriver.reporters.CucumberJava8Reporter;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;

public class ErrorsSteps implements En {

    @Autowired
    AllureReporter reporter;

    @Autowired
    Ohrm ohrm;

    public ErrorsSteps() {

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
