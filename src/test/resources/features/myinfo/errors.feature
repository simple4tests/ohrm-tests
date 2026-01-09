@ALL @MY_INFO @ERRORS
Feature: Orange-HRM: Check errors
  The scenarios below verify the following functionalities:
  - Simulate an error

  @ERROR
  Scenario: Simulate an error
    Given browse to goog site
    Then simulate an error
    When browse with screenshot
    When browse with screenshots
    When browse without screenshot
