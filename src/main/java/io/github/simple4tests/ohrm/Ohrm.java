package io.github.simple4tests.ohrm;

import io.github.simple4tests.ohrm.capabilities.*;
import io.github.simple4tests.ohrm.interactions.Wdi;
import io.github.simple4tests.webdriver.framework.Reporter;
import org.openqa.selenium.WebDriver;

public class Ohrm {

    public enum Env {
        DEMO("https://opensource-demo.orangehrmlive.com/");

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

    public Wdi wdi;
    public Reporter reporter;
    public String url;

    public Buzz buzz;
    public Common common;
    public Login login;
    public MyInfo myInfo;
    public Navigation navigation;

    protected void copy(Ohrm ohrm) {
        this.wdi = ohrm.wdi;
        this.reporter = ohrm.reporter;
        this.url = ohrm.url;

        this.buzz= ohrm.buzz;
        this.common = ohrm.common;
        this.login = ohrm.login;
        this.myInfo = ohrm.myInfo;
        this.navigation = ohrm.navigation;
    }

    public void init(WebDriver driver, Reporter reporter, String envNameOrUrl) {
        this.wdi = new Wdi(driver);
        this.reporter = reporter;
        this.url = Env.getUrlFromEnvNameOrUrl(envNameOrUrl);

        this.buzz = new Buzz();
        this.common = new Common();
        this.login = new Login();
        this.myInfo = new MyInfo();
        this.navigation = new Navigation();

        this.buzz.copy(this);
        this.common.copy(this);
        this.login.copy(this);
        this.myInfo.copy(this);
        this.navigation.copy(this);
    }
}
