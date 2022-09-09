package io.github.simple4tests.ohrm.capabilities;

import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.datamodel.PersonalDetailsData;

import static io.github.simple4tests.ohrm.locators.MyInfoLocators.*;

public class MyInfo extends Ohrm {

    public void setPersonalDetails(PersonalDetailsData personalDetails) {
        reporter.reportAction("Set personal details");
        reporter.reportData(personalDetails.toString());
        ui.click(NICK_NAME).clearNext(true).sendKeys(NICK_NAME, personalDetails.nickName);
        ui.setSelected(SMOKER, personalDetails.smoker);
        ui.clearNext(true).sendKeys(MILITARY_SERVICE, personalDetails.militaryService);
        ui.click(SAVE_PERSONAL_DETAILS);
    }

    public void setCustomFields(String bloodType) {
        reporter.reportAction("Set blood type ".concat(bloodType));
        ui
                .selectByVisibleText(BLOOD_TYPE, bloodType)
                .click(SAVE_CUSTOM_FIELDS);
    }

    public String getBloodType() {
        return ui.getElement(BLOOD_TYPE_SELECTED).getText();
    }
}
