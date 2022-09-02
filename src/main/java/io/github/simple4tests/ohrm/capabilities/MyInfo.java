package io.github.simple4tests.ohrm.capabilities;

import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.datamodel.PersonalDetailsData;

import static io.github.simple4tests.ohrm.locators.MyInfoLocators.*;

public class MyInfo extends Ohrm {

    public void setPersonalDetails(PersonalDetailsData personalDetails) {
        reporter.reportAction("Set personal details");
        reporter.reportData(personalDetails.toString());
        wdi.element.locatedBy(NICK_NAME).click().clearNext(true).sendKeys(personalDetails.nickName);
        wdi.setSelected(SMOKER, personalDetails.smoker);
        wdi.element.locatedBy(MILITARY_SERVICE).clearNext(true).sendKeys(personalDetails.militaryService);
        wdi.element.locatedBy(SAVE_PERSONAL_DETAILS).click();
    }

    public void setCustomFields(String bloodType) {
        reporter.reportAction("Set blood type ".concat(bloodType));
        wdi.selectByVisibleText(BLOOD_TYPE, bloodType);
        wdi.element.locatedBy(SAVE_CUSTOM_FIELDS).click();
    }

    public String getBloodType() {
        return wdi.element.locatedBy(BLOOD_TYPE_SELECTED).getElement().getText();
    }
}
