package io.github.simple4tests.ohrm.glue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.datamodel.PersonalDetailsData;
import io.github.simple4tests.webdriver.utils.Yml;
import net.thucydides.core.annotations.Shared;
import org.hamcrest.Matchers;

import static io.github.simple4tests.ohrm.context.TestContext.context;

public class OhrmSteps implements En {

    @Shared
    Ohrm ohrm;

    public OhrmSteps() {

        Given("a user connected to the OrangeHRM site", () -> {
            ohrm.navigation.navigateToHome();
            ohrm.login.signIn(context().username, context().password);
        });

        When("(the user )opens menu {word}", (String url) -> ohrm.navigation.goTo(url));

        When("(the user )update his blood type with the value {string}", (String bloodType) -> {
            context().bloodType = bloodType;
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
                context().reporter.assertThat("Check if page title is ".concat(title),
                        ohrm.common.getTitle(),
                        Matchers.equalTo(title)));

        Then("the blood type is updated", () -> {
            ohrm.ui.waitForPageToLoad();
            context().reporter.assertThat("Check if blood type is ".concat(context().bloodType),
                    ohrm.myInfo.getBloodType(),
                    Matchers.equalTo(context().bloodType));
        });
    }
}
