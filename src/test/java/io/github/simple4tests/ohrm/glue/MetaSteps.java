package io.github.simple4tests.ohrm.glue;

import io.cucumber.java.DataTableType;
import io.cucumber.java8.En;
import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.datamodel.PersonalDetailsData;
import io.github.simple4tests.webdriver.framework.serenity.SerenityReporter;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static io.github.simple4tests.ohrm.context.TestContext.context;

public class MetaSteps implements En {

    @Managed(driver = "provided")
    WebDriver driver;

    @Steps
    SerenityReporter reporter;

    @Shared
    Ohrm ohrm;

    public MetaSteps() {

        Before(() -> {
            initDriverAndReporter();
            initOhrmAutomaton();
            initTestContext();
        });

        After(this::closeDriverAndReporter);
    }

    public void initDriverAndReporter() {
        reporter.clearErrors();
    }

    public void initOhrmAutomaton() {
        ohrm.init(driver, reporter, "DEMO");
    }

    public void initTestContext() {
        context().reporter = reporter;
        context().username = "Admin";
        context().password = "admin123";
    }

    public void closeDriverAndReporter() {
        ohrm.ui.driver.quit();
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
