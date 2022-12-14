Feature: Krafttech Log in Test
  # Agile Story :As a user, I should be able to log in so I can see my account

  @Mike
  Scenario: Login as Mike
    Given The user is on the login page
    When The user enters Mike credentials
    Then The user should be able to login

    @db
  Scenario: Login as Sebastian
    Given The user is on the login page
    When The user enters Sebastian credentials
    Then The user should be able to login

  Scenario: Login as Jhon Nash
    Given The user is on the login page
    When The user enters Jhon Nash credentials
    Then The user should be able to login


  Scenario: User should be abe to login with valid credentilas
    Given User should be on the login page
    When User should input login information
    Then User should be on home page


  Scenario: Login with parameters
    Given User should be on the login page
    When User should input "user11@test.com" and "Test123456"
    Then User should be on home page


  Scenario: Login as a given user
    Given User should be on the login page
    Then User should input following credentials

      | email    | user22@test.com |
      | password | Test123456      |
      | Name     | User22          |

  Scenario Outline: Data table and scenario outline
    Then User should input following credentials

      | email    | <userEmail> |
      | password | <password>  |
      | Name     | <name>      |

    Examples:
      | userEmail               | password   | name           |
      | user22@test.com         | Test123456 | User22         |
      | eddiem@kraft.com        | eddiem12   | Eddie Murphy   |
      | morganfreeman@kraft.com | mfreeman   | Morgan Freeman |


