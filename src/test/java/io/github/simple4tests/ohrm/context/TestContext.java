package io.github.simple4tests.ohrm.context;

import io.cucumber.java8.Scenario;
import io.github.simple4tests.ohrm.Ohrm;
import io.github.simple4tests.webdriver.framework.Reporter;

public class TestContext {

    private static final ThreadLocal<TestContext> _context = ThreadLocal.withInitial(TestContext::new);

    public static TestContext context() {
        return _context.get();
    }

    public Scenario scenario;
    public Reporter reporter;
    public Ohrm ohrm;

    public String username;
    public String password;
    public String bloodType;
}
