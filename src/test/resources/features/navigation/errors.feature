@ALL @NAVIGATION @ERRORS
Feature: Orange-HRM: Browsing and errors
  The scenarios below verify the following functionalities:
  - Browse and simulate an error
  - Browse and do not simulate an error

  @ERROR
  Scenario: Browse and simulate an error
    Given browse to goog site
    Then simulate an error
    When browse with screenshot
    When browse with screenshots
    When browse without screenshot

  @NO_ERROR
  Scenario: Browse and do not simulate an error
    Given browse to goog site
    When browse with screenshot
    When browse with screenshots
    When browse without screenshot
