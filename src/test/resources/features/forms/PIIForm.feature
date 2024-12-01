Feature: PII Form

  @Selenium
  Scenario: Agent send PII form
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "PII Form" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client|2024|test instructions|true|PII Form|
    Then "Agent" form is sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||PII Form|QA Client|Sent|2024|

  @Selenium
  Scenario: Agent cannot duplicate PII form
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "PII Form" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 2|2024|test instructions|true|PII Form|
    And "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 2|2024|test instructions|true|PII Form|
    Then "Agent" form is not sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||PII Form|QA Client 2|Sent|2024|

  @Selenium
  Scenario: Client signs the PII form sent from agent
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "PII Form" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 3|2024|test instructions|true|PII Form|
    And "Client" copy and open form
      |formType|
      |PII Form|
    And "Client" sign form
      |formType|
      |PII Form|
    Then "Client" form is signed
      |formType|
      |PII Form|
    And "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "PII Form" form page
    And "Agent" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      |||PII Form|QA Client 3|Submitted|2024|

  @Selenium
  Scenario: Agent signs the document
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "PII Form" form page
    When "Agent" send form
      |client|formYear|clientInstructions|formType|
      |QA Client 4|2024|test instructions|PII Form|
    And "Agent" copy and open form
      |formType|
      |PII Form|
    And "Agent" sign form
      |formType|
      |PII Form|
    And "Agent" navigate to "PII Form" form page
    Then "Agent" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      |||PII Form|QA Client 4|Submitted|2024|

  @Selenium
  Scenario: Broker send PII form
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "PII Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client|2024|test instructions|true|PII Form|Agent Automation 2|
    Then "Broker" form is sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||PII Form|QA 2 Client|Sent|2024|

  @Selenium
  Scenario: Broker cannot duplicate PII form
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "PII Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client 2|2024|test instructions|true|PII Form|Agent Automation 2|
    And "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client 2|2024|test instructions|true|PII Form|Agent Automation 2|
    Then "Broker" form is not sent
      |formType|
      |PII Form|

  @Selenium
  Scenario: Client signs the form sent from broker
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "PII Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client 3|2024|test instructions|true|PII Form|Agent Automation 2|
    And "Client" copy and open form
      |formType|
      |PII Form|
    And "Client" sign form
      |formType|
      |PII Form|
    Then "Client" form is signed
      |formType|
      |PII Form|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "PII Form" form page
    And "Broker" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      ||Agent Automation 2|PII Form|QA 2 Client 3|Submitted|2024|

  @Selenium
  Scenario: Broker signs the document
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "PII Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|formType|servicingAgent|
      |QA 2 Client 4|2024|test instructions|PII Form|Agent Automation 2|
    And "Broker" copy and open form
      |formType|
      |PII Form|
    And "Broker" sign form
      |formType|
      |PII Form|
    And "Broker" navigate to "PII Form" form page
    Then "Broker" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      ||Agent Automation 2|PII Form|QA 2 Client 4|Submitted|2024|


  @Selenium
  Scenario: Client signs and already signed document
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "PII Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|formType|servicingAgent|
      |QA Client 5|2024|test instructions|PII Form|Agent Automation|
    And "Client" copy and open form
      |formType|
      |PII Form|
    And "Client" sign form
      |formType|
      |PII Form|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "PII Form" form page
    And "Client" resign form
      |formType|
      |PII Form|
    Then "Client" form is already signed
      |formType|
      |PII Form|

  @Selenium
  Scenario: Broker views the form signed by client
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "PII Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA Client 6|2024|test instructions|true|PII Form|Agent Automation|
    And "Client" copy and open form
      |formType|
      |PII Form|
    And "Client" sign form
      |formType|
      |PII Form|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "PII Form" form page
    And "Broker" view the form
      |formType|
      |PII Form|
    Then "Client" form is viewed successfully
      |formType|email|phoneNumber|client|servingAgent|
      |PII Form|qa_client6@gmail.com|2320003030|QA Client 6|Agent Automation and/or Automation System|


  @Selenium
  Scenario: Broker resend the form signed by client
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "PII Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA Client 7|2025|test instructions|true|PII Form|Agent Automation|
    And "Client" copy and open form
      |formType|
      |PII Form|
    And "Client" sign form
      |formType|
      |PII Form|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "PII Form" form page
    And "Broker" resend the form
      |formType|
      |PII Form|
    Then "Broker" form is resent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||PII Form|QA Client 7|Sent|2025|