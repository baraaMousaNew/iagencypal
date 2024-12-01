Feature: Credit Card Form

  @Selenium
  Scenario: Agent send credit card form
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "Credit Card Info" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client|2024|test instructions|true|Credit Card Info|
    Then "Agent" form is sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||Credit Card Info|QA Client|Sent|2024|

  @Selenium
  Scenario: Agent cannot duplicate credit card form
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "Credit Card Info" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 2|2024|test instructions|true|Credit Card Info|
    And "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 2|2024|test instructions|true|Credit Card Info|
    Then "Agent" form is not sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||Credit Card Info|QA Client 2|Sent|2024|

  @Selenium
  Scenario: Client signs the credit card form sent from agent
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "Credit Card Info" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 3|2024|test instructions|true|Credit Card Info|
    And "Client" copy and open form
      |formType|
      |Credit Card Info|
    And "Client" sign form
      |formType|cardType|cardHolderName|cardNumber|expirationMonth|expirationYear|cardHolderZipCode|
      |Credit Card Info|Master Card|QA Client 3|2222555566667777|12|27|123456|
    Then "Client" form is signed
      |formType|
      |Credit Card Info|
    And "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "Credit Card Info" form page
    And "Agent" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      |||Credit Card Info|QA Client 3|Submitted|2024|


  @Selenium
  Scenario: Agent cannot sign credit card form
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "Credit Card Info" form page
    When "Agent" send form
      |client|formYear|clientInstructions|formType|
      |QA Client 4|2024|test instructions|Credit Card Info|
    And "Agent" copy and open form
      |formType|
      |Credit Card Info|
    And "Agent" sign form
      |formType|cardType|cardHolderName|cardNumber|expirationMonth|expirationYear|cardHolderZipCode|
      |Credit Card Info|Master Card|QA Client 4|2222555566667777|12|27|123456|
    Then "Agent" form cannot be signed
      |formType|
      |Credit Card Info|

  @Selenium
  Scenario: Broker send credit card form
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Credit Card Info" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client|2024|test instructions|true|Credit Card Info|Agent Automation 2|
    Then "Broker" form is sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||Credit Card Info|QA 2 Client|Sent|2024|

  @Selenium
  Scenario: Broker cannot duplicate PII form
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Credit Card Info" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client 2|2024|test instructions|true|Credit Card Info|Agent Automation 2|
    And "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client 2|2024|test instructions|true|Credit Card Info|Agent Automation 2|
    Then "Broker" form is not sent
      |formType|
      |Credit Card Info|

  @Selenium
  Scenario: Client signs the form sent from broker
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Credit Card Info" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client 3|2024|test instructions|true|Credit Card Info|Agent Automation 2|
    And "Client" copy and open form
      |formType|
      |Credit Card Info|
    And "Client" sign form
      |formType|cardType|cardHolderName|cardNumber|expirationMonth|expirationYear|cardHolderZipCode|
      |Credit Card Info|Master Card|QA 2 Client 3|2222555566667777|12|27|123456|
    Then "Client" form is signed
      |formType|
      |Credit Card Info|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Credit Card Info" form page
    And "Broker" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      ||Agent Automation 2|Credit Card Info|QA 2 Client 3|Submitted|2024|

  @Selenium
  Scenario: Broker cannot sign the form
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Credit Card Info" form page
    When "Broker" send form
      |client|formYear|clientInstructions|formType|servicingAgent|
      |QA 2 Client 4|2024|test instructions|Credit Card Info|Agent Automation 2|
    And "Broker" copy and open form
      |formType|
      |Credit Card Info|
    And "Broker" sign form
      |formType|cardType|cardHolderName|cardNumber|expirationMonth|expirationYear|cardHolderZipCode|
      |Credit Card Info|Master Card|QA 2 Client 4|2222555566667777|12|27|123456|
    Then "Broker" form cannot be signed
      |formType|
      |Credit Card Info|

  @Selenium
  Scenario: Client signs and already signed document
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Credit Card Info" form page
    When "Broker" send form
      |client|formYear|clientInstructions|formType|servicingAgent|
      |QA Client 5|2024|test instructions|Credit Card Info|Agent Automation|
    And "Client" copy and open form
      |formType|
      |Credit Card Info|
    And "Client" sign form
      |formType|cardType|cardHolderName|cardNumber|expirationMonth|expirationYear|cardHolderZipCode|
      |Credit Card Info|Master Card|QA  Client 5|2222555566667777|12|27|123456|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Credit Card Info" form page
    And "Client" resign form
      |formType|cardType|cardHolderName|cardNumber|expirationMonth|expirationYear|cardHolderZipCode|
      |Credit Card Info|Master Card|QA  Client 5|2222555566667777|12|27|123456|
    Then "Client" form is already signed
      |formType|
      |Credit Card Info|


  @Selenium
  Scenario: Agent views the form signed by client
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Credit Card Info" form page
    When "Broker" send form
      |client|formYear|clientInstructions|formType|servicingAgent|
      |QA Client 6|2024|test instructions|Credit Card Info|Agent Automation|
    And "Client" copy and open form
      |formType|
      |Credit Card Info|
    And "Client" sign form
      |formType|cardType|cardHolderName|cardNumber|expirationMonth|expirationYear|cardHolderZipCode|
      |Credit Card Info|Master Card|QA Client 6|2222555566667777|12|27|123456|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "Credit Card Info" form page
    And "Broker" view the form
      |formType|
      |Credit Card Info|
    Then "Client" form is viewed successfully
      |formType|cardType|cardHolderName|cardNumber|expirationMonth|expirationYear|cardHolderZipCode|
      |Credit Card Info|Master Card|QA Client 6|2222555566667777|12|27|123456|

  @Selenium
  Scenario: Agent resend the form signed by client
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "Credit Card Info" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 7|2025|test instructions|true|Credit Card Info|
    And "Client" copy and open form
      |formType|
      |Credit Card Info|
    And "Client" sign form
      |formType|cardType|cardHolderName|cardNumber|expirationMonth|expirationYear|cardHolderZipCode|
      |Credit Card Info|Master Card|QA Client 7|2222555566667777|12|27|123456|
    And "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "Credit Card Info" form page
    And "Agent" resend the form
      |formType|
      |Credit Card Info|
    Then "Agent" form is resent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||Credit Card Info|QA Client 7|Sent|2025|
