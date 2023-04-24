@ALL @WS @MUNICIPALITIES
Feature: SNCF Municipalities Web Services
  The scenarios below verify the following functionalities:
  - Municipalitie details for a given INSEE code
  - Municipalitie details for a given INSEE code with error simulation
  - Count municipalities
  - Count municipalities with error simulation
  - Compare municipalitie details for all municipalities

  Scenario: Municipalitie details for a given INSEE code
    Given a call to the municipalities v1 webservice for municipalitie INSEE code 75056
    And a call to the municipalities v2 webservice for municipalitie INSEE code 75056
    Then JSON responses are the same

  Scenario: Municipalitie details for a given INSEE code with error simulation
    Given a call to the municipalities v1 webservice for municipalitie INSEE code 01419
    And a call to the municipalities v2 webservice for municipalitie INSEE code 78616
    Then JSON responses are the same

  Scenario: Count municipalities
    Given a call to the municipalities v1 webservice for all municipalities
    And a call to the municipalities v2 webservice for all municipalities
    Then JSON responses have the same number of municipalities

  Scenario: Count municipalities with error simulation
    Given a call to the municipalities v1 webservice for all municipalities
    And a call to the municipalities v2 webservice for all municipalities
    Then JSON modified count responses have the same number of municipalities

  @PERF
  Scenario: Compare municipalitie details for all municipalities
    Given a call to the municipalities v1 webservice for all municipalities
    And a call to the municipalities v2 webservice for all municipalities
    Then JSON responses have the same elements in same order
