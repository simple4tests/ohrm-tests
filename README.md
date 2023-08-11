# simple4tests

The goal os simple4tests is to build and provide easy tools supporting developers and testers to build maintainable and
reliable automated test. Main focus is about test automation at UI and API level.

# ohrm-tests

WebDriver Overload showcase using cucumber and serenity.

## OhrmITs

Some test examples written with WebDriverInteractions and illustrating the simple4tests methodology.

## Branches

### main / cucumber_picocontainer (cucumber tests & html pretty report)

Using Webdriver Overload with:

- cucumber tests with cucumber expressions
- picocontainer to share data between steps
- pretty html report including execution status and gherkin, steps details and screenshots (
  target/site/cucumber/index.html)
- junit 5

mvn clean verify -Ds4t.browser=chrome -Ds4t.driverPath="c:/dev/tools/selenium/chromedriver.exe" -Ds4t.optionsAsYamlResource=chrome_options_default.yml -Dcucumber.filter.tags=@BLOOD_TYPE

mvn clean verify -Ds4t.browser=firefox -Ds4t.driverPath="c:/dev/tools/selenium/geckodriver.exe" -Ds4t.optionsAsYamlResource=firefox_options_headless.yml -Dcucumber.filter.tags=@BLOOD_TYPE

### cucumber_spring (cucumber tests & html pretty report)

Using Webdriver Overload with:

- cucumber tests with cucumber expressions
- springboot to share data between steps
- pretty html report including execution status and gherkin, steps details and screenshots (
  target/site/cucumber/index.html)
- junit 5

mvn clean verify -Ds4t.browser=chrome -Ds4t.driverPath="c:/dev/tools/selenium/chromedriver.exe" -Ds4t.optionsAsYamlResource=chrome_options_default.yml -Dcucumber.filter.tags=@BLOOD_TYPE

mvn clean verify -Ds4t.browser=firefox -Ds4t.driverPath="c:/dev/tools/selenium/geckodriver.exe" -Ds4t.optionsAsYamlResource=firefox_options_headless.yml -Dcucumber.filter.tags=@BLOOD_TYPE

### cucumber_serenity (cucumber tests & html serenity report)

Using Webdriver Overload with:

- cucumber tests with cucumber expressions
- serenity report including execution status, gherkin, steps details and screenshots (target/site/serenity/index.html)
- serenity single page report (target/site/serenity/serenity-summary.html)
- junit 4

mvn clean verify -Ds4t.browser=chrome -Ds4t.driverPath="c:/dev/tools/selenium/chromedriver.exe" -Ds4t.optionsAsYamlResource=chrome_options_default.yml -Dcucumber.filter.tags=@BLOOD_TYPE

mvn clean verify -Ds4t.browser=firefox -Ds4t.driverPath="c:/dev/tools/selenium/geckodriver.exe" -Ds4t.optionsAsYamlResource=firefox_options_headless.yml -Dcucumber.filter.tags=@BLOOD_TYPE

### cucumber_serenity_junit5 (cucumber tests & html serenity report)

Using Webdriver Overload with:

- cucumber tests with cucumber expressions
- serenity report including execution status, gherkin, steps details and screenshots (target/site/serenity/index.html)
- serenity single page report (target/site/serenity/serenity-summary.html)
- junit 5

mvn clean verify -Ds4t.browser=chrome -Ds4t.driverPath="c:/dev/tools/selenium/chromedriver.exe" -Ds4t.optionsAsYamlResource=chrome_options_default.yml -Dcucumber.filter.tags=@BLOOD_TYPE

mvn clean verify -Ds4t.browser=firefox -Ds4t.driverPath="c:/dev/tools/selenium/geckodriver.exe" -Ds4t.optionsAsYamlResource=firefox_options_headless.yml -Dcucumber.filter.tags=@BLOOD_TYPE

## Support & Contact

Additional information can be found at https://simple4tests.github.io/
and https://simple4tests.github.io/method/method.html
Contact us at simple4tests@gmail.com
