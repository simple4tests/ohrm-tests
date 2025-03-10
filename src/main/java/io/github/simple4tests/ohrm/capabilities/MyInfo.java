package io.github.simple4tests.ohrm.capabilities;

import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.datamodel.PersonalDetailsData;

public class MyInfo extends Ohrm {

    public static final String FIRST_NAME = "//input[@name='firstName']";

    public static final String SMOKER = "//div[contains(@class,'oxd-input-group') and .//label[text()='Smoker']]";
    public static final String MILITARY_SERVICE = "//div[contains(@class,'oxd-input-group') and .//label[text()='Military Service']]//input";
    public static final String SAVE_PERSONAL_DETAILS = "//div[./h6[.='Personal Details']]//button[@type='submit']";

    public static final String BLOOD_TYPE = "//form[@class='oxd-form' and .//label[text()='Blood Type']]//div[@class='oxd-select-wrapper']";
    public static final String BLOOD_TYPE_SELECTED = "//form[@class='oxd-form' and .//label[text()='Blood Type']]//div[@class='oxd-select-text-input']";
    public static final String SAVE_CUSTOM_FIELDS = "//div[./h6[.='Custom Fields']]//button[@type='submit']";

    public void setPersonalDetails(PersonalDetailsData personalDetails) {
        reporter.startStep("Set personal details");
        reporter.reportData(personalDetails.toString());
        ui.click(FIRST_NAME).clearNext(true).sendKeys(FIRST_NAME, personalDetails.firstName);
//        ui.setSelected(SMOKER, personalDetails.smoker);
//        ui.clearNext(true).sendKeys(MILITARY_SERVICE, personalDetails.militaryService);
        ui.click(SAVE_PERSONAL_DETAILS);
        ui.waitForPageToLoad();
        reporter.endStep();
    }

    public void setCustomFields(String bloodType) {
        reporter.startStep("Set blood type ".concat(bloodType));
        ui.selectByVisibleText(BLOOD_TYPE, bloodType);
        ui.click(SAVE_CUSTOM_FIELDS);
        reporter.endStep();
    }

    public String getFirstName() {
        return ui.get(FIRST_NAME, "value").toString();
    }

    public boolean waitFirstNameToBe(String firstName) {
        return ui.wait.ignoreTimeoutException().until(input -> firstName.equals(getFirstName()));
    }

    public String getBloodType() {
        return ui.getElement(BLOOD_TYPE_SELECTED).getText();
    }
}
