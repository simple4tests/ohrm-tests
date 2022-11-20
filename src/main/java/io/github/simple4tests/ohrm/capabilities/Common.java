package io.github.simple4tests.ohrm.capabilities;

import io.github.simple4tests.ohrm.Ohrm;

import static io.github.simple4tests.ohrm.locators.CommonLocators.TITLE;

public class Common extends Ohrm {

    public String getTitle() {
        return ui.getElement(TITLE).getText();
    }
}
