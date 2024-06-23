package io.github.simple4tests.ohrm.glue;

import io.cucumber.java.DataTableType;
import io.cucumber.java8.En;
import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.context.TestData;
import io.github.simple4tests.ohrm.datamodel.PersonalDetailsData;
import io.github.simple4tests.webdriver.reporters.SerenityReporter;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Shared;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class MetaSteps implements En {

    @Managed(driver = "provided")
    WebDriver driver;

    @Shared
    SerenityReporter reporter;
    @Shared
    TestData testData;

    @Shared
    Ohrm ohrm;

    public MetaSteps() {

        Before(() -> {
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
