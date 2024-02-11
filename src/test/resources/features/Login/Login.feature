# Developer: Mts. Ing. Raúl Mauricio Portillo Muñoz
# Scenarios for test case, valid and invalid credentials, login session

@Login
Feature: CP01 - Valid And Invalid Credentials

  Background: Validate start session with valid and invalid credentials

  @ValidCredentials
  Scenario Outline: Validate with valid credentials
    Given User navigate to website
    When User enter username credentials "<type>" and "<user>"
    When User enter password credentials "<type>" and "<pass>"
    When User click button LogIn
    Then User validate "<type>" and "<user>" and "<pass>" session

    Examples:
      | type    | user         | pass         |
      | valid   | admin        | admin        |
      | valid   | visual_user  | secret_sauce |

  @InvalidCredentials
  Scenario Outline: Validate with invalid credentials
    Given User navigate to website
    When User enter username credentials "<type>" and "<user>"
    When User enter password credentials "<type>" and "<pass>"
    When User click button LogIn
    Then User validate "<type>" and "<user>" and "<pass>" session

    Examples:
      |  type     | user          | pass         |
      |  invalid  | error_user    | error_key    |
      |  invalid  |               | error_key    |
      |  invalid  | error_user    |              |