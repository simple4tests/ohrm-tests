package io.github.simple4tests.ohrm.capabilities;

import io.github.simple4tests.ohrm.Ohrm;

import static io.github.simple4tests.ohrm.locators.LoginLocators.*;

public class Login extends Ohrm {

    public void signIn(String username, String password) {
        reporter.reportAction("Sign in with username ".concat(username));
        ui
                .sendKeys(USERNAME, username)
                .sendKeys(PASSWORD, password)
                .click(LOGIN);
    }
}
