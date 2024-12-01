Feature: Clients

  @Selenium
  Scenario: Broker create client
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to clients page
    And "Broker" add client basic information
      |servicingAgent|firstName|lastName|email|phoneNumber|dateOfBirth|gender|
      |Auto Agent|data|broker client|client_auto_broker@automationClient.com|000552252|10/01/2024|Male|
    And "Broker" add client address information
      |address|country|state|city|zipCode|
      |test address|USA|Alabama - AL|test city|02215|
    And "Broker" add client sensitive data
      |type|
      |Client|
    Then "Broker" client is created successfully
      |fullName|servicingAgent|email|phoneNumber|activeStatus|
      |data broker client|Auto Agent|client_auto_broker@automationClient.com|000552252|true|

  @Selenium
  Scenario: Agent create client
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to clients page
    And "Agent" add client basic information
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|
      |data|agent client|client_auto_agent@automationClient.com|000552252|10/01/2024|Male|
    And "Agent" add client address information
      |address|country|state|city|zipCode|
      |test address|USA|Alabama - AL|test city|02215|
    And "Agent" add client sensitive data
      |type|
      |Client|
    Then "Agent" client is created successfully
      |fullName|servicingAgent|email|phoneNumber|activeStatus|
      |data agent client|Auto Agent|client_auto_agent@automationClient.com|000552252|true|

  @Selenium
  Scenario: Agent Can view the client details
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to clients page
    And "Agent" add client basic information
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|
      |data|view client|client_view_added@automationClient.com|000552252|10/01/2024|Male|
    And "Agent" add client address information
      |address|country|state|city|zipCode|
      |test address|USA|Alabama - AL|test city|02215|
    And "Agent" add client sensitive data
      |type|
      |Client|
    And "Agent" view the profile of the client
    Then "Agent" client details display successfully
      |fullName|email|phoneNumber|accountStatus|
      |data view client|client_view_added@automationClient.com|000552252|Active|
    And "Agent" client personal information display successfully
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|
      |data|view client|client_view_added@automationClient.com|000552252|10/01/2024|Male|
    And "Agent" client address information display successfully
      |address|country|state|city|zipCode|
      |test address|USA|Alabama - AL|test city|02215|
    And "Agent" client sensitive data display successfully
      |type|
      |Client|


  @Selenium
  Scenario: Agent Can update the client profile
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to clients page
    And "Agent" add client basic information
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|
      |data|update client|client_view_update@automationClient.com|000552252|10/01/2024|Male|
    And "Agent" add client address information
      |address|country|state|city|zipCode|
      |test address|USA|Alabama - AL|test city|02215|
    And "Agent" add client sensitive data
      |type|
      |Client|
    And "Agent" view the profile of the client
    Then "Agent" update client personal information
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|
      |data update|update client update|client_view_update_update@automationClient.com|000521111|10/01/2024|Male|
    And "Agent" client personal information display successfully
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|
      |data update|update client update|client_view_update_update@automationClient.com|000521111|10/01/2024|Male|
    Then "Agent" update client address information
      |address|country|state|city|zipCode|
      |test address update|USA|Arizona - AZ|test city update|00015|
    And "Agent" client address information display successfully
      |address|country|state|city|zipCode|
      |test address update|USA|Arizona - AZ|test city update|00015|
    Then "Agent" update client sensitive data
      |type|ssn|driverLicense|status|type|
      |Client|22222|driver2222|Active|Primary|
    And "Agent" client sensitive data display successfully
      |type|ssn|driverLicense|status|type|
      |Client|22222|driver2222|Active|Primary|

  @Selenium
  Scenario: Broker Can view the client details
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to clients page
    And "Broker" add client basic information
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|servicingAgent|
      |data|view client broker|client_view_added_broker@automationClient.com|000552252|10/01/2024|Male|Auto Agent|
    And "Broker" add client address information
      |address|country|state|city|zipCode|
      |test address|USA|Alabama - AL|test city|02215|
    And "Broker" add client sensitive data
      |type|
      |Client|
    And "Broker" view the profile of the client
    Then "Broker" client details display successfully
      |fullName|email|phoneNumber|accountStatus|
      |data view client broker|client_view_added_broker@automationClient.com|000552252|Active|
    And "Broker" client personal information display successfully
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|servicingAgent|
      |data|view client broker|client_view_added_broker@automationClient.com|000552252|10/01/2024|Male|Auto Agent|
    And "Broker" client address information display successfully
      |address|country|state|city|zipCode|
      |test address|USA|Alabama - AL|test city|02215|
    And "Broker" client sensitive data display successfully
      |type|
      |Client|

  @Selenium
  Scenario: Broker Can update the client profile
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to clients page
    And "Broker" add client basic information
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|servicingAgent|
      |data|broker client|client_broker_update@automationClient.com|000552252|10/01/2024|Male|Auto Agent|
    And "Broker" add client address information
      |address|country|state|city|zipCode|
      |test address|USA|Alabama - AL|test city|02215|
    And "Broker" add client sensitive data
      |type|
      |Client|
    And "Broker" view the profile of the client
    Then "Broker" update client personal information
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|servicingAgent|
      |data update|broker client update|client_broker_update_update@automationClient.com|000521111|10/01/2024|Male|Agent Automation 2|
    And "Broker" client personal information display successfully
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|servicingAgent|
      |data update|broker client update|client_broker_update_update@automationClient.com|000521111|10/01/2024|Male|Agent Automation 2|
    Then "Broker" update client address information
      |address|country|state|city|zipCode|
      |test address update|USA|Arizona - AZ|test city update|00015|
    And "Broker" client address information display successfully
      |address|country|state|city|zipCode|
      |test address update|USA|Arizona - AZ|test city update|00015|
    Then "Broker" update client sensitive data
      |type|ssn|driverLicense|status|type|
      |Client|22222|driver2222|Active|Primary|
    And "Broker" client sensitive data display successfully
      |type|ssn|driverLicense|status|type|
      |Client|22222|driver2222|Active|Primary|


