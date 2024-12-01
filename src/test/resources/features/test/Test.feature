Feature: Test

  Scenario: Carrier information are updated successfully
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to carrier page
    When "Broker" add carrier information
      |carrierName|abbreviation|emailAddress|phoneNumber|website|
      |automation carrier_policy_group|auto_group_policy|automation_group_policy@gmail.com|5889939998|www.test_prod.com|
    And "Broker" click proceed to next step of create carrier
    And "Broker" add carrier address information
      |address|country|state|city|zipCode|
      |test address|USA|Arizona - AZ|test city|7777|
    And "Broker" click proceed to next step of create carrier
    And "Broker" add carrier product information
      |productName|effectiveDate|productTermDate|CoverageType|description|isActiveOnCommission|
      |product policy group 1|10/31/2024|10/31/2024     |BCBS        |test product description|true   |
    And "Broker" submit the carrier information
    And "Broker" view carrier

