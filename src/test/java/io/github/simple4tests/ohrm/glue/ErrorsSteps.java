package io.github.simple4tests.ohrm.glue;

import io.cucumber.java8.En;
import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.context.TestData;
import io.github.simple4tests.webdriver.reporters.SerenityReporter;
import net.serenitybdd.annotations.Shared;
import org.hamcrest.Matchers;

public class ErrorsSteps implements En {

    @Shared
    SerenityReporter reporter;
    @Shared
    TestData testData;

    @Shared
    Ohrm ohrm;

    public ErrorsSteps() {

        Given("going to goog site", () -> {
            reporter.startStep("navigate to goog site");
            ohrm.ui.driver.navigate().to("http://www.google.com");
            ohrm.ui.sleep(1000);
            reporter.endStep();
        });

        When("running step without screenshot", () -> {
            reporter.startStep("my empty step");
            ohrm.ui.driver.navigate().to("http://www.sfr.com");
            ohrm.ui.sleep(1000);
            reporter.endStep();
        });

        When("running step with screenshot", () -> {
            reporter.startStep("my screenshot step");
            ohrm.ui.driver.navigate().to("http://www.leboncoin.com");
            ohrm.ui.sleep(1000);
            reporter.reportScreenshot();
            reporter.endStep();
        });

        When("perform screenshot", () -> {
            reporter.startStep("my single screenshot");
            ohrm.ui.driver.navigate().to("http://www.chess.com");
            ohrm.ui.sleep(1000);
            reporter.reportScreenshot();
            reporter.endStep();
            reporter.startStep("my double screenshot");
            ohrm.ui.driver.navigate().to("http://www.google.com");
            ohrm.ui.sleep(1000);
            reporter.reportScreenshot();
            ohrm.ui.driver.navigate().to("http://www.microsoft.com");
            ohrm.ui.sleep(1000);
            reporter.reportScreenshot();
            reporter.endStep();
        });

        Then("simulate an error", () ->
                reporter.assertThat("Check if 1 equals 2",
                        1,
                        Matchers.equalTo(2)));
    }
}
