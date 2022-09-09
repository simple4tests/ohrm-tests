package io.github.simple4tests.ohrm.glue;

import io.cucumber.java.DataTableType;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.datamodel.PersonalDetailsData;
import io.github.simple4tests.webdriver.framework.DriverProvider;
import io.github.simple4tests.webdriver.framework.SystemOutReporter;
import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;

import static io.github.simple4tests.ohrm.context.TestContext.context;

public class MetaSteps implements En {

    WebDriver driver;

    public MetaSteps() {

        Before((Scenario scenario) -> {
            context().scenario = scenario;
            initDriverAndReporter();
            initOhrmAutomaton();
            initTestContext();
        });

        After(this::closeDriverAndReporter);
    }

    public void initDriverAndReporter() {

        driver = DriverProvider.get(
                System.getProperty("s4t.browser"),
                Paths.get(System.getProperty("s4t.driverPath")),
                System.getProperty("s4t.optionsAsYamlResource"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));

        context().reporter = new SystemOutReporter();
        context().reporter.clearErrors();
    }

    public void initOhrmAutomaton() {
        context().ohrm = new Ohrm();
        context().ohrm.init(driver, context().reporter, "DEMO");
    }

    public void initTestContext() {
        context().username = "Admin";
        context().password = "admin123";
    }

    public void closeDriverAndReporter() {
        context().ohrm.ui.driver.quit();
        context().reporter.throwAssertionErrorIfAny(true);
    }

    @DataTableType
    public PersonalDetailsData personalDetailsDataEntry(Map<String, String> entry) {
        PersonalDetailsData personalDetails = new PersonalDetailsData();
        personalDetails.nickName = entry.get("nickName");
        personalDetails.smoker = Boolean.parseBoolean(entry.get("smoker"));
        personalDetails.militaryService = entry.get("militaryService");
        return personalDetails;
    }
}
