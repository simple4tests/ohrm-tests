@ALL @BUZZ @POST
Feature: Orange-HRM: Buzz
  The scenarios below verify the following functionalities:
  - Add multiple messages
  - Add a single message
#  - Reply to a message

  Scenario: Add multiple messages
    Given a user connected to the OrangeHRM site
    When the user opens menu BUZZ
    And adds following messages
      | This is message num. 1 |
      | This is message num. 2 |
    Then the post 'This is message num. 1' exists
    And the post 'This is message num. 2' exists
    When opens menu DASHBOARD
    And opens menu BUZZ
    And adds following messages
      | This is message num. 3 |
    Then the post 'This is message num. 3' exists

  Scenario Outline: Add a single message
    Given a user connected to the OrangeHRM site
    When the user opens menu BUZZ
    And adds message '<Message>'
    Then the post '<Message>' exists

    Examples:
      | Message                |
      | This is message num. 4 |
      | This is message num. 5 |

#  @I_USE_TO_FAILED
#  Scenario: Reply to a message
#    Given a user connected to the OrangeHRM site
#    When the user opens menu BUZZ
#    And replies to 'Kevin Mathews' at position 1 with message 'My first reply'
#    And replies to 'Odis Adalwin' at position 2 with message 'My second reply'
