@ALL @SECURITY @NAVIGATION
Feature: Orange-HRM: Connectivity & Navigation
  The scenarios below verify the following functionalities:
  - Connectivity
  - Navigation

  @CONNECTIVITY
  Scenario: Connectivity
    Given a user connected to the OrangeHRM site
    Then the page 'Dashboard' is displayed

  @NAVIGATION
  Scenario: Navigation
    Given a user connected to the OrangeHRM site
    When the user opens menu MY_INFO
    Then the page 'Personal Details' is displayed
    When the user opens menu ADMIN__NATIONALITIES
    Then the page 'Nationalities' is displayed
    When the user opens menu PIM__CONFIGURATION__OPTIONAL_FIELDS
    Then the page 'Configure PIM' is displayed
    When the user opens menu PIM__ADD_EMPLOYEE
    Then the page 'Add Employee' is displayed
    When the user opens menu DASHBOARD
    Then the page 'Dashboard' is displayed
