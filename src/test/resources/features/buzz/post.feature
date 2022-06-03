@ALL @BUZZ @POST
Feature: Orange-HRM: Buzz
  The scenarios below verify the following functionalities:
  - Add multiple messages
  - Add message
  - Reply to a message

  Scenario: Add multiple messages
    Given a user connected to the OrangeHRM site
    When the user opens menu BUZZ
    And adds following messages
      | MESSAGE                  |
      | This is my first message |
      | This is message num. 2   |
      | This is message num. 3   |
    And opens menu DASHBOARD
    And opens menu BUZZ
    And adds following messages
      | MESSAGE                |
      | This is message num. 4 |
      | This is message num. 5 |

  Scenario Outline: Add message
    Given a user connected to the OrangeHRM site
    When the user opens menu BUZZ
    And adds message '<Message>'

    Examples:
      | Message                |
      | This is message num. 6 |
      | This is message num. 7 |
      | This is message num. 8 |

  Scenario: Reply to a message
    Given a user connected to the OrangeHRM site
    When the user opens menu BUZZ
    And replies to 'Kevin Mathews' at position 1 with message 'My first reply'
    And replies to 'Odis Adalwin' at position 2 with message 'My second reply'
