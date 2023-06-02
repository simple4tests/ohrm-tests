package io.github.simple4tests.ohrm;

import io.cucumber.core.options.Constants;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@ExtendWith(SerenityJUnit5Extension.class)
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty, html:target/site/cucumber/index.html")
public class OhrmITs {
}
