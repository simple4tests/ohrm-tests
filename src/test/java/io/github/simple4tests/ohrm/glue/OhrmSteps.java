package io.github.simple4tests.ohrm.glue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.github.simple4tests.ohrm.datamodel.PersonalDetailsData;
import io.github.simple4tests.webdriver.utils.Yml;
import org.hamcrest.Matchers;

import static io.github.simple4tests.ohrm.context.TestContext.context;

public class OhrmSteps implements En {

    public OhrmSteps() {

        Given("a user connected to the OrangeHRM site", () -> {
            context().ohrm.navigation.navigateToHome();
            context().ohrm.login.signIn(context().username, context().password);
        });

        When("(the user )opens menu {word}", (String url) -> context().ohrm.navigation.goTo(url));

        When("(the user )update his blood type with the value {string}", (String bloodType) -> {
            context().bloodType = bloodType;
            context().ohrm.myInfo.setCustomFields(bloodType);
        });

        When("(the user )updates his personal details with following data", (PersonalDetailsData personalDetails) ->
                context().ohrm.myInfo.setPersonalDetails(personalDetails));

        When("(the user )updates his personal details with the data {string}", (String inputSource) -> {
            PersonalDetailsData personalDetails = Yml.loadAs(
                    String.format("input/personal-details-%s.yml", inputSource),
                    PersonalDetailsData.class);
            context().ohrm.myInfo.setPersonalDetails(personalDetails);
        });

        When("(the user  )adds following messages", (DataTable dataTable) -> {
            for (String message : dataTable.asList()) {
                context().ohrm.buzz.add(message);
            }
        });

        When("(the user  )adds message {string}", (String message) -> context().ohrm.buzz.add(message));

        When("(the user  )replies to {string} at position {int} with message {string}", (String user, Integer postNumber, String message) ->
                context().ohrm.buzz.reply(user, postNumber, message));

        Then("the page {string} is displayed", (String title) ->
                context().reporter.assertThat("Check if page title is ".concat(title),
                        context().ohrm.common.getTitle(),
                        Matchers.equalTo(title)));

        Then("the blood type is updated", () -> {
            context().ohrm.ui.waitForPageToLoad();
            context().reporter.assertThat("Check if blood type is ".concat(context().bloodType),
                    context().ohrm.myInfo.getBloodType(),
                    Matchers.equalTo(context().bloodType));
        });
    }
}
