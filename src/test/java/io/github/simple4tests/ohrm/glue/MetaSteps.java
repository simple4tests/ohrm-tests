package io.github.simple4tests.ohrm.glue;

import io.cucumber.java.DataTableType;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.context.TestData;
import io.github.simple4tests.ohrm.datamodel.PersonalDetailsData;
import io.github.simple4tests.webdriver.reporters.CucumberJava8Reporter;
import io.github.simple4tests.webdriver.providers.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;

public class MetaSteps implements En {

    WebDriver driver;

    @Autowired
    CucumberJava8Reporter reporter;

    @Autowired
    Ohrm ohrm;

    @Autowired
    TestData testData;

    public MetaSteps() {

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
        ohrm.init(driver, reporter, Ohrm.Env.DEMO);
    }

    public void initTestData() {
        testData.username = "Admin";
        testData.password = "admin123";
    }

    public void closeAll() {
        ohrm.ui.driver.quit();
        reporter.throwAssertionErrorIfAny(true);
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
