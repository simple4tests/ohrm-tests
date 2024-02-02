package io.github.simple4tests.ohrm.capabilities;

import io.github.simple4tests.ohrm.Ohrm;

public class Buzz extends Ohrm {

    public static final String NEW_MESSAGE = "//*[@placeholder=\"What's on your mind?\"]";
    public static final String POST = "//button[contains(., 'Post') and not(contains(., 'Recent'))]";

    public static final String MESSAGE_X = "//*[contains(@class,'orangehrm-buzz-post-body-text') and text()='%s']";
    public static final String MESSAGE_X_Y = "(//*[@id='buzz']//li[.//*[@id='postEmployeeName' and normalize-space()='%s']]//textarea[contains(@id, 'commentBoxNew_listId') and @class='commentBox'])[%d]";
    public static final String POST_X_Y = "(//*[@id='buzz']//li[.//*[@id='postEmployeeName' and normalize-space()='%s']]//textarea[contains(@id, 'commentBoxNew_listId') and @class='commentBox']//following-sibling::input[@type='button'])[%d]";

    public void add(String message) {
        reporter.startStep("Add message : ".concat(message));
        ui.sendKeys(NEW_MESSAGE, message);
        ui.click(POST);
        ui.waitForPageToLoad();
        reporter.endStep();
    }

    public boolean waitToBePresent(String message) {
        return ui.waitToBePresent(String.format(MESSAGE_X, message), true);
    }

    public void reply(String user, int postNumber, String message) {
        reporter.startStep("Reply : ".concat(message));
        ui.sendKeys(String.format(MESSAGE_X_Y, user, postNumber), message);
        ui.click(String.format(POST_X_Y, user, postNumber));
        ui.waitForPageToLoad();
        reporter.endStep();
    }
}
