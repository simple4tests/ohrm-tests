package io.github.simple4tests.ohrm;

import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "io.github.simple4tests.ohrm.glue")
@ConfigurationParameter(
        key = Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty,json:target/cucumber.json,html:target/site/cucumber/index.html")
//@ConfigurationParameter(key = "cucumber.execution.parallel.enabled", value = "true")
//@ConfigurationParameter(key = "cucumber.execution.parallel.config.strategy", value = "fixed")
//@ConfigurationParameter(key = "cucumber.execution.parallel.config.fixed.parallelism", value = "2")
//@ConfigurationParameter(key = "cucumber.execution.parallel.config.fixed.max-pool-size", value = "2")
//@ConfigurationParameter(key = "cucumber.execution.execution-mode.feature", value = "same_thread")
//@ConfigurationParameter(
//        key = "cucumber.execution.exclusive-resources.isolated.read-write",
//        value = "org.junit.platform.engine.support.hierarchical.ExclusiveResource.GLOBAL_KEY")
public class OhrmITs {
}
