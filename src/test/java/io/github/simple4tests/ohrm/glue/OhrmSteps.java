package io.github.simple4tests.ohrm.glue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.context.TestConfig;
import io.github.simple4tests.ohrm.context.TestData;
import io.github.simple4tests.ohrm.datamodel.PersonalDetailsData;
import io.github.simple4tests.webdriver.reporters.CucumberJava8Reporter;
import io.github.simple4tests.webdriver.utils.Yml;
import org.hamcrest.Matchers;

public class OhrmSteps implements En {

    CucumberJava8Reporter reporter;

    Ohrm ohrm;

    TestData testData;

    public OhrmSteps(TestConfig config) {
        this.reporter = config.reporter;
        this.ohrm = config.ohrm;
        this.testData = config.testData;

        Given("a user connected to the OrangeHRM site", () -> {
            ohrm.navigation.navigateToHome();
            ohrm.login.signIn(testData.username, testData.password);
        });

        When("(the user )opens menu {word}", (String url) -> ohrm.navigation.goTo(url));

        When("(the user )update his blood type with the value {string}", (String bloodType) -> {
            testData.bloodType = bloodType;
            ohrm.myInfo.setCustomFields(bloodType);
        });

        When("(the user )updates his personal details with following data", (PersonalDetailsData personalDetails) ->
                ohrm.myInfo.setPersonalDetails(personalDetails));

        When("(the user )updates his personal details with the data {string}", (String inputSource) -> {
            PersonalDetailsData personalDetails = Yml.loadAs(
                    String.format("input/personal-details-%s.yml", inputSource),
                    PersonalDetailsData.class);
            ohrm.myInfo.setPersonalDetails(personalDetails);
        });

        When("(the user  )adds following messages", (DataTable dataTable) -> {
            for (String message : dataTable.asList()) {
                ohrm.buzz.add(message);
            }
        });

        When("(the user  )adds message {string}", (String message) -> ohrm.buzz.add(message));

        When("(the user  )replies to {string} at position {int} with message {string}", (String user, Integer postNumber, String message) ->
                ohrm.buzz.reply(user, postNumber, message));

        Then("the page {string} is displayed", (String title) ->
                reporter.assertThat("Check if page title is ".concat(title),
                        ohrm.common.getTitle(),
                        Matchers.equalTo(title)));

        Then("the blood type is updated", () -> {
            ohrm.ui.waitForPageToLoad();
            reporter.assertThat("Check if blood type is ".concat(testData.bloodType),
                    ohrm.myInfo.getBloodType(),
                    Matchers.equalTo(testData.bloodType));
        });
    }
}
