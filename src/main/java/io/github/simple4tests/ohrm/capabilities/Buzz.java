package io.github.simple4tests.ohrm.capabilities;

import io.github.simple4tests.ohrm.Ohrm;
import org.openqa.selenium.By;

import static io.github.simple4tests.ohrm.locators.BuzzLocators.*;

public class Buzz extends Ohrm {

    public void add(String message) {
        reporter.reportAction("Add a message: ".concat(message));
        wdi.element.locatedBy(NEW_MESSAGE).sendKeys(message);
        wdi.element.locatedBy(POST).click();
    }

    public void reply(String user, int postNumber, String message) {
        reporter.reportAction("Reply with: ".concat(message));
        wdi.element.locatedBy(By.xpath(String.format(MESSAGE_X_Y, user, postNumber))).sendKeys(message);
        wdi.element.locatedBy(By.xpath(String.format(POST_X_Y, user, postNumber))).click();
    }
}
