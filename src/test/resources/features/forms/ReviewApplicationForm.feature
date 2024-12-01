Feature: Review Application Form

  @Selenium
  Scenario: Agent send review application form
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "Review Application Form" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|attachments|
      |QA Client|2024|test instructions|true|Review Application Form|test image|
    Then "Agent" form is sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||Review Application Form|QA Client|Sent|2024|

  @Selenium
  Scenario: Agent cannot duplicate review application form
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "Review Application Form" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|attachments|
      |QA Client 2|2024|test instructions|true|Review Application Form|test image|
    And "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|attachments|
      |QA Client 2|2024|test instructions|true|Review Application Form|test image|
    Then "Agent" form is not sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||Review Application Form|QA Client 2|Sent|2024|

  @Selenium
  Scenario: Client signs the review application form sent from agent
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "Review Application Form" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|attachments|
      |QA Client 3|2024|test instructions|true|Review Application Form|test image|
    And "Client" copy and open form
      |formType|
      |Review Application Form|
    And "Client" fill login information of Review Application form
      |dateOfBirthClient|lastNameClient|
      |2024|Client 3|
    And "Client" sign form
      |formType|
      |Review Application Form|
    Then "Client" form is signed
      |formType|
      |Review Application Form|
    And "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "Review Application Form" form page
    And "Agent" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      |||Review Application Form|QA Client 3|Submitted|2024|

  @Selenium
  Scenario: Agent signs the document
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "Review Application Form" form page
    When "Agent" send form
      |client|formYear|clientInstructions|formType|attachments|
      |QA Client 4|2024|test instructions|Review Application Form|test image|
    And "Agent" copy and open form
      |formType|
      |Review Application Form|
    And "Agent" sign form
      |formType|
      |Review Application Form|
    And "Agent" navigate to "PII Form" form page
    Then "Agent" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      |||Review Application Form|QA Client 4|Submitted|2024|

  @Selenium
  Scenario: Broker send review application form
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Review Application Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|attachments|
      |QA 2 Client|2024|test instructions|true|Review Application Form|Agent Automation 2|test image|
    Then "Broker" form is sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||Review Application Form|QA 2 Client|Sent|2024|

  @Selenium
  Scenario: Broker cannot duplicate review application form
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Review Application Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|attachments|
      |QA 2 Client 2|2024|test instructions|true|Review Application Form|Agent Automation 2|test image|
    And "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|attachments|
      |QA 2 Client 2|2024|test instructions|true|Review Application Form|Agent Automation 2|test image|
    Then "Broker" form is not sent
      |formType|
      |Review Application Form|

  @Selenium
  Scenario: Client signs the form sent from broker
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Review Application Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|attachments|
      |QA 2 Client 3|2024|test instructions|true|Review Application Form|Agent Automation 2|test image|
    And "Client" copy and open form
      |formType|
      |Review Application Form|
    And "Client" fill login information of Review Application form
      |dateOfBirthClient|lastNameClient|
      |2024|Client 3|
    And "Client" sign form
      |formType|
      |Review Application Form|
    Then "Client" form is signed
      |formType|
      |Review Application Form|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Review Application Form" form page
    And "Broker" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      ||Agent Automation 2|Review Application Form|QA 2 Client 3|Submitted|2024|

  @Selenium
  Scenario: Broker signs the document
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Review Application Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|formType|servicingAgent|attachments|
      |QA 2 Client 4|2024|test instructions|Review Application Form|Agent Automation 2|test image|
    And "Broker" copy and open form
      |formType|
      |Review Application Form|
    And "Broker" sign form
      |formType|
      |Review Application Form|
    And "Broker" navigate to "Review Application Form" form page
    Then "Broker" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      ||Agent Automation 2|Review Application Form|QA 2 Client 4|Submitted|2024|

  @Selenium
  Scenario: Client signs and already signed document
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Review Application Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|formType|servicingAgent|attachments|
      |QA Client 5|2024|test instructions|Review Application Form|Agent Automation|test image|
    And "Client" copy and open form
      |formType|
      |Review Application Form|
    And "Client" fill login information of Review Application form
      |dateOfBirthClient|lastNameClient|
      |2024|Client 5|
    And "Client" sign form
      |formType|
      |Review Application Form|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Review Application Form" form page
    And "Client" resign form
      |formType|
      |Review Application Form|
    Then "Client" form is already signed
      |formType|
      |Review Application Form|

  @Selenium
  Scenario: Broker views the form signed by client
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Review Application Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|attachments|
      |QA Client 6|2024|test instructions|true|Review Application Form|Agent Automation|test image|
    And "Client" copy and open form
      |formType|
      |Review Application Form|
    And "Client" fill login information of Review Application form
      |dateOfBirthClient|lastNameClient|
      |2024|Client 6|
    And "Client" sign form
      |formType|
      |Review Application Form|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Review Application Form" form page
    And "Broker" view the form
      |formType|
      |Review Application Form|
    Then "Client" form is viewed successfully
      |formType|email|phoneNumber|client|servingAgent|formYear|
      |Review Application Form|qa_client6@gmail.com|2320003030|QA Client 6|Agent Automation and/or Automation System|2024|


  @Selenium
  Scenario: Broker resend the form signed by client
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Review Application Form" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|attachments|
      |QA Client 7|2025|test instructions|true|Review Application Form|Agent Automation|test image|
    And "Client" copy and open form
      |formType|
      |Review Application Form|
    And "Client" fill login information of Review Application form
      |dateOfBirthClient|lastNameClient|
      |2024|Client 7|
    And "Client" sign form
      |formType|
      |Review Application Form|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Review Application Form" form page
    And "Broker" resend the form
      |formType|
      |Review Application Form|
    Then "Broker" form is resent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||Review Application Form|QA Client 7|Sent|2025|