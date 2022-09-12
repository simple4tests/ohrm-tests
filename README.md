# simple4tests

The goal os simple4tests is to build and provide easy tools supporting developers and testers to build maintainable and
reliable automated test. Main focus is about test automation at UI and API level.

# ohrm-tests

WebDriver Overload showcase using cucumber and serenity.

## OhrmITs

Some test examples written with WebDriverInteractions and illustrating the simple4tests methodology.

## Branches

### main (cucumber tests & html serenity report)

Using Webdriver Overload with:
- cucumber tests
- serenity report including execution status, gherkin, steps details and screenshots (target/site/serenity/index.html)

mvn clean verify -Ds4t.browser=chrome -Ds4t.driverPath="c:/dev/tools/selenium/chromedriver.exe" -Ds4t.optionsAsYamlResource=chrome_options_default.yml -Dcucumber.filter.tags=@blood_type

mvn clean verify -Ds4t.browser=firefox -Ds4t.driverPath="c:/dev/tools/selenium/geckodriver.exe" -Ds4t.optionsAsYamlResource=firefox_options_headless.yml -Dcucumber.filter.tags=@blood_type

### cucumber-java8-reporter (cucumber tests, html pretty report)

Using Webdriver Overload with:
- cucumber tests
- pretty html report including execution status and gherkin, steps details and screenshots (target/site/cucumber/index.html)

mvn clean verify -Ds4t.browser=chrome -Ds4t.driverPath="c:/dev/tools/selenium/chromedriver.exe" -Ds4t.optionsAsYamlResource=chrome_options_default.yml -Dcucumber.filter.tags=@blood_type

mvn clean verify -Ds4t.browser=firefox -Ds4t.driverPath="c:/dev/tools/selenium/geckodriver.exe" -Ds4t.optionsAsYamlResource=firefox_options_headless.yml -Dcucumber.filter.tags=@blood_type

## Support & Contact

Additional information can be found at https://simple4tests.github.io/
and https://simple4tests.github.io/method/method.html
Contact us at simple4tests@gmail.com
