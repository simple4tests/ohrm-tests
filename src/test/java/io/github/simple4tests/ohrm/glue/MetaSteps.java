package io.github.simple4tests.ohrm.glue;

import io.cucumber.java.DataTableType;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import io.github.simple4tests.ohrm.context.TestContext;
import io.github.simple4tests.ohrm.datamodel.PersonalDetailsData;
import io.github.simple4tests.webdriver.framework.CucumberJava8Reporter;
import io.github.simple4tests.webdriver.framework.DriverProvider;
import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;

public class MetaSteps implements En {

    WebDriver driver;

    CucumberJava8Reporter reporter;

    TestContext context;

    public MetaSteps(TestContext context) {
        this.context = context;

        Before((Scenario scenario) -> {
            initDriverAndReporter(scenario);
            initAutomaton();
            initTestData();
        });

        After(this::closeDriverAndReporter);
    }

    public void initDriverAndReporter(Scenario scenario) {
        driver = DriverProvider.get(
                System.getProperty("s4t.browser"),
                Paths.get(System.getProperty("s4t.driverPath")),
                System.getProperty("s4t.optionsAsYamlResource"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));

        reporter = new CucumberJava8Reporter();
        reporter.init(scenario, driver);
        reporter.clearErrors();
        context.reporter = reporter;
    }

    public void initAutomaton() {
        context.ohrm.init(driver, context.reporter, "DEMO");
    }

    public void initTestData() {
        context.username = "Admin";
        context.password = "admin123";
    }

    public void closeDriverAndReporter() {
        context.ohrm.ui.driver.quit();
        context.reporter.throwAssertionErrorIfAny(true);
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
