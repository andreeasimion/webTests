@Smoke
Feature: User creation

  Background:
    Given Sign up page is open

  Scenario: User created with success
    When I submit mandatory data
    Then I'm redirected to Check email page

  Scenario: Sign up page has the expected elements
    When I take a screenshot
    Then Register screen is as expected

  Scenario: Cannot register without accepting terms
    When I submit registration form without accepting terms
    Then Terms and conditioning checkbox returns an error

  Scenario: I can open Terms and conditions
    When I click terms link
    Then The Terms and Conditions page is open


  Scenario Outline: User created without mandatory data for '<fieldToValidate>' field
    When I submit '<nameValue>', '<emailValue>' and '<passwordValue>' values for registration fields
    Then I receive an error message for field '<fieldToValidate>'

    Examples:
      | nameValue | emailValue       | passwordValue | fieldToValidate |
      |           | valid@email1.com | 12345678      | name            |
      | test      |                  | 12345678      | email           |
      | test      | valid@email.com  |               | password        |
      | test      | miro@yopmail.    | 12345678      | email           |
