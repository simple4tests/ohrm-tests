package io.github.simple4tests.ohrm.locators;

import org.openqa.selenium.By;

public class CommonLocators {

    public static final By NO_LOADER = By.xpath("//*[@id='loader-1' and @style='display: none;']");
    public static final By NO_TOGGL = By.xpath("//*[@id='togglConfirm' and @style='display: none;']");

    public static final By SUCCESS_MSG = By.xpath("//*[@class='message success fadable']");

    public static final By TITLE = By.xpath("//header//span/h6");
}
