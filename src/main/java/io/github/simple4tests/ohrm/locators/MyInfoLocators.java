package io.github.simple4tests.ohrm.locators;

import org.openqa.selenium.By;

public class MyInfoLocators {

    public static final By NICK_NAME = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[text()='Nickname']]//input");

    public static final String SMOKER = "//div[contains(@class,'oxd-input-group') and .//label[text()='Smoker']]";

    public static final By MILITARY_SERVICE = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[text()='Military Service']]//input");

    public static final By SAVE_PERSONAL_DETAILS = By.xpath("//div[./h6[.='Personal Details']]//button[@type='submit']");

    public static final By BLOOD_TYPE = By.xpath("//form[@class='oxd-form' and .//label[text()='Blood Type']]//div[@class='oxd-select-wrapper']");
    public static final By BLOOD_TYPE_SELECTED = By.xpath("//form[@class='oxd-form' and .//label[text()='Blood Type']]//div[@class='oxd-select-text-input']");
    public static final By SAVE_CUSTOM_FIELDS = By.xpath("//div[./h6[.='Custom Fields']]//button[@type='submit']");
}
