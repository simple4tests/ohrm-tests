package io.github.simple4tests.ohrm.locators;

import org.openqa.selenium.By;

public class BuzzLocators {

    public static final By NEW_MESSAGE = By.id("createPost_content");
    public static final By POST = By.id("postSubmitBtn");

    public static final String MESSAGE_X_Y = "(//*[@id='buzz']//li[.//*[@id='postEmployeeName' and normalize-space()='%s']]//textarea[contains(@id, 'commentBoxNew_listId') and @class='commentBox'])[%d]";
    public static final String POST_X_Y = "(//*[@id='buzz']//li[.//*[@id='postEmployeeName' and normalize-space()='%s']]//textarea[contains(@id, 'commentBoxNew_listId') and @class='commentBox']//following-sibling::input[@type='button'])[%d]";
}
