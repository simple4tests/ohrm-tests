package io.github.simple4tests.ohrm.capabilities;

import io.github.simple4tests.ohrm.Ohrm;
import org.openqa.selenium.By;

public class Login extends Ohrm {

    public static final By USERNAME = By.xpath("//input[@name='username']");
    public static final By PASSWORD = By.xpath("//input[@name='password']");
    public static final By LOGIN = By.xpath("//button[@type='submit']");

    public void signIn(String username, String password) {
        reporter.startAction("Sign in with username ".concat(username));
        ui.sendKeys(USERNAME, username);
        ui.sendKeys(PASSWORD, password);
        ui.click(LOGIN);
        reporter.endAction();
    }
}
