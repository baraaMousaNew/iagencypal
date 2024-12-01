Feature: Carriers

  Scenario: Broker can create a new carrier
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to carrier page
    When "Broker" add carrier information
      |carrierName|abbreviation|emailAddress|phoneNumber|website|
      |automation carrier|auto_car|automation_carrier@gmail.com|588999998|www.test.com|
    And "Broker" click proceed to next step of create carrier
    And "Broker" add carrier address information
      |address|country|state|city|zipCode|
      |test address|USA|Arizona - AZ|test city|7777|
    And "Broker" click proceed to next step of create carrier
    And "Broker" add carrier product information
      |productName|effectiveDate|productTermDate|CoverageType|description|isActiveOnCommission|
      |test product 1|10/31/2024|10/31/2024     |BCBS        |test product description|true   |
      |test product 2|10/31/2024|10/31/2024     |BCBS        |test product description 2|true   |
    And "Broker" submit the carrier information
    Then "Broker" carrier is created successfully
      |carrierName|emailAddress|totalProducts|
      |automation carrier|automation_carrier@gmail.com|2|

  Scenario: Products created through carrier display under products page
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to carrier page
    When "Broker" add carrier information
      |carrierName|abbreviation|emailAddress|phoneNumber|website|
      |automation carrier_prod|auto_car_prod|automation_carrier_prod@gmail.com|588999998|www.test_prod.com|
    And "Broker" click proceed to next step of create carrier
    And "Broker" add carrier address information
      |address|country|state|city|zipCode|
      |test address|USA|Arizona - AZ|test city|7777|
    And "Broker" click proceed to next step of create carrier
    And "Broker" add carrier product information
      |productName|effectiveDate|productTermDate|CoverageType|description|isActiveOnCommission|
      |product display 1|10/31/2024|10/31/2024     |BCBS        |test product description|true   |
    And "Broker" submit the carrier information
    And "Broker" navigate to product page
    Then "Broker" products display successfully
      |productName|effectiveDate|carrierName|
      |product display 1|10/31/2024|automation carrier_prod|


  Scenario: Products can be added inside carrier profile
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to carrier page
    When "Broker" add carrier information
      |carrierName|abbreviation|emailAddress|phoneNumber|website|
      |automation carrier_prod|auto_car_prod|automation_carrier_prod@gmail.com|588999998|www.test_prod.com|
    And "Broker" click proceed to next step of create carrier
    And "Broker" add carrier address information
      |address|country|state|city|zipCode|
      |test address|USA|Arizona - AZ|test city|7777|
    And "Broker" click proceed to next step of create carrier
    And "Broker" add carrier product information
      |productName|effectiveDate|productTermDate|CoverageType|description|isActiveOnCommission|
      |product display 1|10/31/2024|10/31/2024     |BCBS        |test product description|true   |
    And "Broker" submit the carrier information
    And "Broker" view carrier
    Then "Broker" add product to carrier profile
      |productName|effectiveDate|productTermDate|CoverageType|description|isActiveOnCommission|productWebsite|productUsername|productPassword|productDescription|
      |product display 2|10/31/2024|10/31/2024     |BCBS        |test product description|true   |https://product_website.com|productUsername|Test@1234|product description 2|
    Then "Broker" product added successfully to carrier profile
      |productName|effectiveDate|carrierName|
      |product display 2|10/31/2024, 12:00 AM|automation carrier_prod|


  Scenario: Policy can be added inside carrier profile for client
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to carrier page
    When "Broker" add carrier information
      |carrierName|abbreviation|emailAddress|phoneNumber|website|
      |automation carrier_policy|auto_car_policy|automation_carrier_policy@gmail.com|5889939998|www.test_prod.com|
    And "Broker" click proceed to next step of create carrier
    And "Broker" add carrier address information
      |address|country|state|city|zipCode|
      |test address|USA|Arizona - AZ|test city|7777|
    And "Broker" click proceed to next step of create carrier
    And "Broker" add carrier product information
      |productName|effectiveDate|productTermDate|CoverageType|description|isActiveOnCommission|
      |product policy 1|10/31/2024|10/31/2024     |BCBS        |test product description|true   |
    And "Broker" submit the carrier information
    And "Broker" view carrier
    Then "Broker" add policy for "Client" to carrier profile
      |policyNumber|policyStatus|servicingAgent|client|policyEffectiveDate|policyRenewalDate|product|
      |carrierPolicy1|Active|Automation Agent|Automation Client|11/01/2024|11/01/2025|product policy 1|
    Then "Broker" policy added successfully to carrier profile
      |policyNumber|policyHolder|servicingAgent|policyEffectiveDate|
      |carrierPolicy1|Automation Client|Automation Agent|11/1/24, 12:00 AM|

  Scenario: Policy can be added inside carrier profile for group
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
    Then "Broker" add policy for "Group" to carrier profile
      |policyNumber|policyStatus|servicingAgent|group|policyEffectiveDate|policyRenewalDate|product|newHireEligibility|eligibilityHours|renewal|notes|
      |carrierGroupPolicy1|Active|Automation Agent|Clients Group|11/01/2024|11/01/2025|product policy group 1|5|7                                 |5      |test notes|
    Then "Broker" policy added successfully to carrier profile
      |policyNumber|policyHolder|servicingAgent|policyEffectiveDate|
      |carrierGroupPolicy1|Clients Group|Automation Agent|11/1/24, 12:00 AM|