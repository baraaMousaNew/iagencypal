Feature: Agents

  @Selenium
  Scenario: Broker can create an agent
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to agents page
    When "Broker" add agent basic information
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|independentAgent|
      |data|agent|auto_agent_create@automationAgent.com|5595955000|10/31/2024|Male|true|
    And "Broker" click proceed to next step of create agent
    And "Broker" add agent address information
      |address|country|state|city|zipCode|
      |agent address 1|USA|Alabama - AL|agent city|110011|
      |agent address 2|USA|Alaska - AK|agent city 2|111111|
    And "Broker" click proceed to next step of create agent
    And "Broker" add roles information
      |role|allowDataSharing|emailReply|
      |Agents Role|true|Agent & Broker email|
    Then "Broker" agent is created successfully
      |fullName|email|independentAgentString|activeStatus|
      |data agent|auto_agent_create@automationAgent.com|Independent Agent|true|

  @Selenium
  Scenario: Agent profile details display successfully
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to agents page
    When "Broker" add agent basic information
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|independentAgent|
      |data|agent second|auto_ag_sec_create@automationAgent.com|5595955000|10/31/2024|Male|true|
    And "Broker" click proceed to next step of create agent
    And "Broker" add agent address information
      |address|country|state|city|zipCode|
      |agent address 1|USA|Alabama - AL|agent city|110011|
      |agent address 2|USA|Alaska - AK|agent city 2|111111|
    And "Broker" click proceed to next step of create agent
    And "Broker" add roles information
      |role|allowDataSharing|emailReply|
      |Agents Role|true|Agent & Broker email|
    And "Broker" view agent profile
    Then "Broker" agent details display successfully
      |fullName|email|phoneNumber|location|
      |data agent|auto_agent_create@automationAgent.com|5595955000||
    And "Broker" agent information display successfully
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|independentAgent|agency|
      |data|agent second|auto_ag_sec_create@automationAgent.com|5595955000|10/31/2024|Male|true|Select Agency|
    And "Broker" agent personal information display successfully
      |spouse|additionalInfo|child|
      |[blank]|[blank]|[blank]|
    And "Broker" agent address information display successfully
      |address|country|state|city|zipCode|
      |agent address 1|USA|Alabama - AL|agent city|110011|
    And "Broker" agent roles display successfully
      |role|allowDataSharing|emailReply|team|
      |Agents Role|true|Agent & Broker email|Select Team|


  @Selenium
  Scenario: Agent profile is updated successfully
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to agents page
    When "Broker" add agent basic information
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|independentAgent|
      |data|agent second|auto_ag_third_create@automationAgent.com|5595955000|10/31/2024|Male|true|
    And "Broker" click proceed to next step of create agent
    And "Broker" add agent address information
      |address|country|state|city|zipCode|
      |agent address 1|USA|Alabama - AL|agent city|110011|
    And "Broker" click proceed to next step of create agent
    And "Broker" add roles information
      |role|allowDataSharing|emailReply|
      |Agents Role|true|Agent & Broker email|
    And "Broker" view agent profile
    And "Broker" update agent information
      |firstName|lastName|dateOfBirth|gender|independentAgent|
      |data update|agent second update|10/31/2024|Male|true|
    Then "Broker" agent information display successfully
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|independentAgent|agency|
      |data update|agent second update|auto_ag_third_create@automationAgent.com|5595955000|10/31/2024|Male|true|Select Agency|
    And "Broker" update personal information
      |spouse|additionalInfo|child|
      |agent spouse|additional info|child one|
    Then "Broker" agent personal information display successfully
      |spouse|additionalInfo|child|
      |agent spouse|additional info|child one|
    And "Broker" update address information
      |address|country|state|city|zipCode|
      |agent address 2|USA|Alaska - AK|agent city update|110022|
    Then "Broker" agent address information display successfully
      |address|country|state|city|zipCode|
      |agent address 2|USA|Alaska - AK|agent city update|110022|
    And "Broker" update roles of agent
      |role|allowDataSharing|emailReply|
      |Agents Role|false|System email only|
    Then "Broker" agent roles display successfully
      |role|allowDataSharing|emailReply|team|
      |Agents Role|false|System email only|Select Team|


  @Selenium
  Scenario: Broker can add emails to agent profile
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to agents page
    When "Broker" add agent basic information
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|independentAgent|
      |data|agent second|auto_ag_third_create@automationAgent.com|5595955000|10/31/2024|Male|true|
    And "Broker" click proceed to next step of create agent
    And "Broker" add agent address information
      |address|country|state|city|zipCode|
      |agent address 1|USA|Alabama - AL|agent city|110011|
    And "Broker" click proceed to next step of create agent
    And "Broker" add roles information
      |role|allowDataSharing|emailReply|
      |Agents Role|true|Agent & Broker email|
    And "Broker" view agent profile
    And "Broker" add secondary email to agent profile
      |email|
      |secondary_agent_email@gmail.com|
    Then "Broker" agent secondary email is added successfully
      |email|
      |secondary_agent_email@gmail.com|

  @Selenium
  Scenario: Broker can add phone to agent profile
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to agents page
    When "Broker" add agent basic information
      |firstName|lastName|email|phoneNumber|dateOfBirth|gender|independentAgent|
      |data|agent second|auto_ag_third_create@automationAgent.com|5595955000|10/31/2024|Male|true|
    And "Broker" click proceed to next step of create agent
    And "Broker" add agent address information
      |address|country|state|city|zipCode|
      |agent address 1|USA|Alabama - AL|agent city|110011|
    And "Broker" click proceed to next step of create agent
    And "Broker" add roles information
      |role|allowDataSharing|emailReply|
      |Agents Role|true|Agent & Broker email|
    And "Broker" view agent profile
    And "Broker" add secondary phone to agent profile
      |phoneNumber|
      |5000222000|
    Then "Broker" agent secondary phone is added successfully
      |phoneNumber|
      |5000222000|