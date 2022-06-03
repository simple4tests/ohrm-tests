package io.github.simple4tests.ohrm.capabilities;

import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.enums.Menus;

public class Navigation extends Ohrm {

    public void navigateToHome() {
        reporter.reportAction("Navigate to home page");
        wdi.driver.navigate().to(url);
    }

    public void goTo(String menu) {
        String target;
        try {
            target = url.concat(Menus.valueOf(menu).href);
        } catch (IllegalArgumentException e) {
            reporter.reportAction("Reference does not exist for ".concat(menu));
            return;
        }
        reporter.reportAction(String.format("Navigate to '%s'", url));
        wdi.driver.navigate().to(target);
    }
}
