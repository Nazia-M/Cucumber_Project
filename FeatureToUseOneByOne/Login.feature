@qaEnv
@dataTable
Feature: Login

  Background:
    When User opens URL "http://admin-demo.nopcommerce.com/login"

@qaEnv
Scenario: Successful Login 1 with Valid Credentials
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
  | email | password |
  | dmin  | admin   |
    When User click on Log out link
    Then Page Title should be "Your store. Login"

@ProdEnv
Scenario: Successful Login 2 with Valid Credentials
    And User enters Email as email and Password as pass
      | admin@yourstore.com | admin |
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"

#Data-Driven testing, login as multiple users
@ProdEnv
Scenario Outline: Login with Data Driven Approach, valid and invalid tests
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    Examples:
      | email | password |
      | admin@yourstore.com | admin |
#      | admin1@yourstore.com | admin1 |
