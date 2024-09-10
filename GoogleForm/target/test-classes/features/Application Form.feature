@SmokeTest
Feature:Application Form
  As a user,
  I want to save the date when the application was created
  so that I can see the date on which the application was created

  Background:
    Given I am on the google form


  @Positive @TC_001
  Scenario Outline: TC_001 User fill out the application form with valid data
    When I input valid application name "<Application Name>"
    And I select valid application user type "<Application Type>"
    And I input valid number of Application users "<users>"
    And I input valid "<date>"
    And I click the send button
    Then Successfully save data redirect to response page and show "<message>"
    Examples:
      | Application Name| Application Type  | users |date         | message                    |
      | GOIB            | Korporasi         | 100   |09-09-2024   |Jawaban Anda telah direkam. |

  @Positive @TC_002
  Scenario Outline: TC_002 User fill out the application form with combination string and numeric on field application name
    When I input valid application name "<Application Name>"
    And I select valid application user type "<Application Type>"
    And I input valid number of Application users "<users>"
    And I input valid "<date>"
    And I click the send button
    Then Successfully save data redirect to response page and show "<message>"
    Examples:
      | Application Name| Application Type  | users |date        | message                   |
      | King Indo 123   | Individu         | 100   |09-09-2024   |Jawaban Anda telah direkam.|

  @Positive @TC_003
  Scenario Outline: TC_003 User fill out the application form with combination string, numeric and special character on field application name
    When I input valid application name "<Application Name>"
    And I select valid application user type "<Application Type>"
    And I input valid number of Application users "<users>"
    And I input valid "<date>"
    And I click the send button
    Then Successfully save data redirect to response page and show "<message>"
    Examples:
      | Application Name          | Application Type  | users |date         | message                    |
      | Indonesia World Cup 2026$ | Korporasi         | 100   |09-09-2024   |Jawaban Anda telah direkam. |


  @Negative @TC_001
  Scenario Outline: TC_001 User fill out the application form without input Application Name
    When I Let empty on field application name "<Application Name>"
    And I select valid application user type "<Application Type>"
    And I input invalid number of Application users "<users>"
    And I input valid "<date>"
    And I click the send button
    Then Unsuccessfully save data and show "<message>"
    Examples:
      | Application Name| Application Type  | users |date         |message             |
      |                 | Korporasi         | 101   |08-08-2024   |Invalid format name.|

  @Negative @TC_002
  Scenario Outline: TC_002 User fill out the application form without select Application Type
    When I Let empty on field application name "<Application Name>"
    And I didn't select application user type "<Application Type>"
    And I input invalid number of Application users "<users>"
    And I input valid "<date>"
    And I click the send button
    Then Unsuccessfully save data and show "<message>"
    Examples:
      | Application Name| Application Type  | users |date         |message                         |
      | One Piece       |                   | 102   |10-09-2024   |Invalid Format Application Type.|

  @Negative @TC_003
  Scenario Outline: TC_003 User fill out the application form with invalid number of Application users
    When I input valid application name "<Application Name>"
    And I select valid application user type "<Application Type>"
    And I input invalid number of Application users "<users>"
    And I input valid "<date>"
    And I click the send button
    Then Unsuccessfully save data and show "<message>"
    Examples:
      | Application Name| Application Type  | users               |date         | message              |
      | Naruto App      | Individu          | QC Invalid Format   |07-07-2024   |Invalid format users. |

  @Negative @TC_004
  Scenario Outline: TC_004 User fill out the application form with invalid date (date > today)
    When I input valid application name "<Application Name>"
    And I select valid application user type "<Application Type>"
    And I input invalid number of Application users "<users>"
    And I input valid "<date>"
    And I click the send button
    Then Unsuccessfully save data and show "<message>"
    Examples:
      | Application Name| Application Type  | users |date         | message            |
      | Naruto App      | Individu          | 103   |12-12-2024   |Invalid Format Date |

  @Negative @TC_005
  Scenario Outline: TC_004 User fill out the application form with duplicate data or already registered.
    When I input valid application name "<Application Name>"
    And I select valid application user type "<Application Type>"
    And I input invalid number of Application users "<users>"
    And I input valid "<date>"
    And I click the send button
    Then Unsuccessfully save data and show "<message>"
    Examples:
      | Application Name| Application Type  | users |date         | message                                       |
      | King Indo 123   | Individu          | 100   |09-09-2024   |Cannot Save data Application Already registered|




