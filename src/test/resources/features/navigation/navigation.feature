@ALL @NAVIGATION @MENU
Feature: Orange-HRM: Navigation and menu
  The scenarios below verify the following functionalities:
  - Navigation menu

  Scenario: Navigation menu
    Given a user connected to the OrangeHRM site
    When the user opens menu MY_INFO
    Then the page 'PIM' is displayed
    When the user opens menu ADMIN__NATIONALITIES
    Then the page 'Admin' is displayed
    When the user opens menu PIM__CONFIGURATION__OPTIONAL_FIELDS
    Then the page 'PIM' is displayed
    When the user opens menu PIM__ADD_EMPLOYEE
    Then the page 'PIM' is displayed
    When the user opens menu DASHBOARD
    Then the page 'Dashboard' is displayed
