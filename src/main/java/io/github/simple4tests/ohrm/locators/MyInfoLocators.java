package io.github.simple4tests.ohrm.locators;

import org.openqa.selenium.By;

public class MyInfoLocators {

    public static final By EDIT_PERSONAL_DETAILS = By.id("btnSave");
    public static final By NICK_NAME = By.id("personal_txtEmpNickName");
    public static final By SMOKER = By.id("personal_chkSmokeFlag");
    public static final By MILITARY_SERVICE = By.id("personal_txtMilitarySer");

    public static final By EDIT_CUSTOM_FIELDS = By.id("btnEditCustom");
    public static final By BLOOD_TYPE = By.xpath("//select[@name='custom1']");
    public static final By BLOOD_TYPE_SELECTED = By.xpath("//select[@name='custom1']/option[@selected]");
}
