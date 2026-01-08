@ALL @MY_INFO @ERRORS
Feature: Orange-HRM: Check errors
  The scenarios below verify the following functionalities:
  - Simulate an error

  @ERROR
  Scenario: Simulate an error
    Given going to goog site
    When running step with screenshot
    When running step without screenshot
    Then simulate an error
    When running step without screenshot
    When perform screenshot
    When running step without screenshot
