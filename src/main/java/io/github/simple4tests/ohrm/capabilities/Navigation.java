package io.github.simple4tests.ohrm.capabilities;

import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.ohrm.enums.Menus;

public class Navigation extends Ohrm {

    public void navigateToHome() {
        reporter.startStep("Navigate to home page");
        ui.driver.navigate().to(url);
        reporter.endStep();
    }

    public void goTo(String menu) {
        String target;
        try {
            target = url.concat(Menus.valueOf(menu).href);
        } catch (IllegalArgumentException e) {
            reporter.reportAction("Reference does not exist for ".concat(menu));
            return;
        }
        reporter.startStep(String.format("Navigate to '%s'", target));
        ui.driver.navigate().to(target);
        ui.waitForPageToLoad();
        reporter.endStep();
    }
}
