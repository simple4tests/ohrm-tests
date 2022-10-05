package io.github.simple4tests.ohrm;

import io.github.simple4tests.ohrm.capabilities.*;
import io.github.simple4tests.ohrm.interactions.UI;
import io.github.simple4tests.webdriver.framework.Reporter;
import org.openqa.selenium.WebDriver;

public class Ohrm {

    public enum Env {
        XXX("https://.../");

        public final String url;

        Env(String url) {
            this.url = url;
        }

        public static String getUrlFromEnvNameOrUrl(String nameOrUrl) {
            try {
                return valueOf(nameOrUrl.toUpperCase()).url;
            } catch (IllegalArgumentException e) {
                return nameOrUrl;
            }
        }
    }

    public UI ui;
    public Reporter reporter;
    public String url;

    public Common common;

    protected void copy(Ohrm ohrm) {
        this.ui = ohrm.ui;
        this.reporter = ohrm.reporter;
        this.url = ohrm.url;

        this.common = ohrm.common;
    }

    public void init(WebDriver driver, Reporter reporter, String envNameOrUrl) {
        this.ui = new UI(driver);
        this.reporter = reporter;
        this.url = Env.getUrlFromEnvNameOrUrl(envNameOrUrl);

        this.common = new Common();

        this.common.copy(this);
    }
}
