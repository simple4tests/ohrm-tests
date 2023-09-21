package io.github.simple4tests.ohrm.capabilities;

import io.github.simple4tests.ohrm.Ohrm;

import static io.github.simple4tests.ohrm.locators.BuzzLocators.*;

public class Buzz extends Ohrm {

    public void add(String message) {
        reporter.reportAction("Add message : ".concat(message));
        ui
                .sendKeys(NEW_MESSAGE, message)
                .click(POST);
        ui.waitForPageToLoad();
    }

    public void reply(String user, int postNumber, String message) {
        reporter.reportAction("Reply : ".concat(message));
        ui
                .sendKeys(String.format(MESSAGE_X_Y, user, postNumber), message)
                .click(String.format(POST_X_Y, user, postNumber));
        ui.waitForPageToLoad();
    }
}
