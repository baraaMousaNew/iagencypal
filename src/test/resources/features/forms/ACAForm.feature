Feature: ACA Form


  @Selenium
    Scenario: Agent send ACA form
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "ACA enrollment" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client|2024|test instructions|true|ACA enrollment|
    Then "Agent" form is sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||ACA enrollment|QA Client|Sent|2024|

  @Selenium
    Scenario: Agent cannot duplicate ACA form
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "ACA enrollment" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 2|2024|test instructions|true|ACA enrollment|
    And "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 2|2024|test instructions|true|ACA enrollment|
    Then "Agent" form is not sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||ACA enrollment|QA Client 2|Sent|2024|

  @Selenium
  Scenario: Client signs the ACA form sent from agent
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "ACA enrollment" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 3|2025|test instructions|false|ACA enrollment|
    And "Client" copy and open form
      |formType|
      |ACA enrollment|
    And "Client" fill login information of ACA form
      |dateOfBirthClient|lastNameClient|
      |2024|Client 3|
    And "Client" fill basic information of "2025" ACA form
      |address|country|state|city|zipCode|county|email|phoneNumber|employer|spouseEmployer|emergencyFirstName|emergencyLastName|emergencyPhoneNumber|hearAboutUs|freeQuoteFromUs|
      |test address|USA|Alabama - AL|test city|123456|test county|qa_client3@gmail.com|22320000|test employer|test spouse employer|em test|em last test|00001112236|iAgencyPal|No|
    And "Client" click proceed to next step of form
    And "Client" add relative of "2025" ACA form
      |relation|relativeFirstName|relativeLastName|relativeGender|relativeDOB|relativeSSN|relativeLegalStatus|relationApplying|
      |Self|QA|Client 3|Male|01/10/2024|2332323|Arrival/Departure Record(I-94/194A)|true|
      |Dependent|QA|Dependent 1|Male|01/10/2000|23323223|Arrival/Departure Record(I-94/194A)|true|
    And "Client" click proceed to next step of form
    And "Client" add household information of "2025" ACA form
      |houseHoldSize|totalHouseholdTaxableIncome|povertyLineAmount|healthInsuranceThatMeetsACAStandards|medicareOrMedicaid|
      |2            |255000                     |yes              |no                                  |yes               |
    And "Client" click proceed to next step of form
    And "Client" add doctor information of "2025" ACA form
      |doctorsHospitals|
      |test test hospitals\ntest test doctors|
      |test test 1 hospitals\ntest test 1 doctors|
    And "Client" add prescription information of "2025" ACA form
      |prescriptionSummary|prescriptionDosage|
      |test prescription 1|dosage 1          |
      |test prescription 2|dosage 2          |
    And "Client" click proceed to next step of form
    And "Client" add file attachments to "2025" ACA form
      |uploadFile|
      |true      |
    And "Client" click proceed to next step of form
    And "Client" sign form
      |formType|
      |ACA enrollment|
    Then "Client" form is signed
      |formType|
      |ACA enrollment|
    And "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "ACA enrollment" form page
    And "Agent" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      |||ACA enrollment|QA Client 3|Submitted|2025|

  @Selenium
  Scenario: Broker signs ACA form
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "ACA enrollment" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client 4|2025|test instructions|false|ACA enrollment|Agent Automation 2|
    And "Broker" copy and open form
      |formType|
      |ACA enrollment|
    And "Broker" fill basic information of "2025" ACA form
      |address|country|state|city|zipCode|county|email|phoneNumber|employer|spouseEmployer|emergencyFirstName|emergencyLastName|emergencyPhoneNumber|hearAboutUs|freeQuoteFromUs|
      |test address|USA|Alabama - AL|test city|123456|test county|qa2_client4@gmail.com|22320000|test employer|test spouse employer|em test|em last test|00001112236|iAgencyPal|No|
    And "Broker" click proceed to next step of form
    And "Broker" add relative of "2025" ACA form
      |relation|relativeFirstName|relativeLastName|relativeGender|relativeDOB|relativeSSN|relativeLegalStatus|relationApplying|
      |Self|QA|QA 2 Client 4|Male|01/10/2024|2332323|Arrival/Departure Record(I-94/194A)|true|
      |Dependent|QA|Dependent 1|Male|01/10/2000|23323223|Arrival/Departure Record(I-94/194A)|true|
    And "Broker" click proceed to next step of form
    And "Broker" add household information of "2025" ACA form
      |houseHoldSize|totalHouseholdTaxableIncome|povertyLineAmount|healthInsuranceThatMeetsACAStandards|medicareOrMedicaid|
      |2            |255000                     |yes              |no                                  |yes               |
    And "Broker" click proceed to next step of form
    And "Broker" add doctor information of "2025" ACA form
      |doctorsHospitals|
      |test test hospitals\ntest test doctors|
      |test test 1 hospitals\ntest test 1 doctors|
    And "Broker" add prescription information of "2025" ACA form
      |prescriptionSummary|prescriptionDosage|
      |test prescription 1|dosage 1          |
      |test prescription 2|dosage 2          |
    And "Broker" click proceed to next step of form
    And "Broker" add file attachments to "2025" ACA form
      |uploadFile|
      |true      |
    And "Broker" click proceed to next step of form
    And "Broker" sign form
      |formType|
      |ACA enrollment|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "ACA enrollment" form page
    And "Broker" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      ||Agent Automation 2|ACA enrollment|QA 2 Client 4|Submitted|2025|


  @Selenium
  Scenario: Agent signs ACA form
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "ACA enrollment" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 4|2025|test instructions|false|ACA enrollment|
    And "Agent" copy and open form
      |formType|
      |ACA enrollment|
    And "Agent" fill basic information of "2025" ACA form
      |address|country|state|city|zipCode|county|email|phoneNumber|employer|spouseEmployer|emergencyFirstName|emergencyLastName|emergencyPhoneNumber|hearAboutUs|freeQuoteFromUs|
      |test address|USA|Alabama - AL|test city|123456|test county|qa_client4@gmail.com|22320000|test employer|test spouse employer|em test|em last test|00001112236|iAgencyPal|No|
    And "Agent" click proceed to next step of form
    And "Agent" add relative of "2025" ACA form
      |relation|relativeFirstName|relativeLastName|relativeGender|relativeDOB|relativeSSN|relativeLegalStatus|relationApplying|
      |Self|QA|QA Client 4|Male|01/10/2024|2332323|Arrival/Departure Record(I-94/194A)|true|
      |Dependent|QA|Dependent 1|Male|01/10/2000|23323223|Arrival/Departure Record(I-94/194A)|true|
    And "Agent" click proceed to next step of form
    And "Agent" add household information of "2025" ACA form
      |houseHoldSize|totalHouseholdTaxableIncome|povertyLineAmount|healthInsuranceThatMeetsACAStandards|medicareOrMedicaid|
      |2            |255000                     |yes              |no                                  |yes               |
    And "Agent" click proceed to next step of form
    And "Agent" add doctor information of "2025" ACA form
      |doctorsHospitals|
      |test test hospitals\ntest test doctors|
      |test test 1 hospitals\ntest test 1 doctors|
    And "Agent" add prescription information of "2025" ACA form
      |prescriptionSummary|prescriptionDosage|
      |test prescription 1|dosage 1          |
      |test prescription 2|dosage 2          |
    And "Agent" click proceed to next step of form
    And "Agent" add file attachments to "2025" ACA form
      |uploadFile|
      |true      |
    And "Agent" click proceed to next step of form
    And "Agent" sign form
      |formType|
      |ACA enrollment|
    And "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "ACA enrollment" form page
    And "Agent" form is signed
      |submittedDate|submittedAgent|formType|client|status|year|
      |||ACA enrollment|QA Client 4|Submitted|2025|

  @Selenium
  Scenario: Broker send ACA form
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "ACA enrollment" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client|2024|test instructions|true|ACA enrollment|Agent Automation 2|
    Then "Broker" form is sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||ACA enrollment|QA 2 Client|Sent|2024|


  @Selenium
  Scenario: Broker cannot duplicate ACA form
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "ACA enrollment" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client 2|2025|test instructions|true|ACA enrollment|Agent Automation 2|
    And "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client 2|2025|test instructions|true|ACA enrollment|Agent Automation 2|
    Then "Broker" form is not sent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||ACA enrollment|QA 2 Client 2|Sent|2025|

  @Selenium
  Scenario: Broker views the form signed by client
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "ACA enrollment" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client 5|2025|test instructions|false|ACA enrollment|Agent Automation 2|
    And "Client" copy and open form
      |formType|
      |ACA enrollment|
    And "Client" fill login information of ACA form
      |dateOfBirthClient|lastNameClient|
      |2024|Client 5|
    And "Client" fill basic information of "2025" ACA form
      |address|country|state|city|zipCode|county|email|phoneNumber|employer|spouseEmployer|emergencyFirstName|emergencyLastName|emergencyPhoneNumber|hearAboutUs|freeQuoteFromUs|healthCoverage|
      |test address|USA|Alabama - AL|test city|123456|test county|qa2_client5@gmail.com|22320000|test employer|test spouse employer|em test|em last test|00001112236|iAgencyPal|No|             |
    And "Client" click proceed to next step of form
    And "Client" add relative of "2025" ACA form
      |relation|relativeFirstName|relativeLastName|relativeGender|relativeDOB|relativeSSN|relativeLegalStatus|relationApplying|
      |Self|QA 2|Client 5|Male|01/10/2024|2332323|Arrival/Departure Record(I-94/194A)|true|
      |Dependent|QA|Dependent 1|Male|01/10/2000|23323223|Arrival/Departure Record(I-94/194A)|true|
    And "Client" click proceed to next step of form
    And "Client" add household information of "2025" ACA form
      |houseHoldSize|totalHouseholdTaxableIncome|povertyLineAmount|healthInsuranceThatMeetsACAStandards|medicareOrMedicaid|
      |2            |255000                     |yes              |no                                  |yes               |
    And "Client" click proceed to next step of form
    And "Client" add doctor information of "2025" ACA form
      |doctorsHospitals|
      |test test hospitals\ntest test doctors|
      |test test 1 hospitals\ntest test 1 doctors|
    And "Client" add prescription information of "2025" ACA form
      |prescriptionSummary|prescriptionDosage|
      |test prescription 1|dosage 1          |
      |test prescription 2|dosage 2          |
    And "Client" click proceed to next step of form
    And "Client" add file attachments to "2025" ACA form
      |uploadFile|
      |true      |
    And "Client" click proceed to next step of form
    And "Client" sign form
      |formType|signatureComment|
      |ACA enrollment|test comment|
    And "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "ACA enrollment" form page
    And "Broker" view the form
      |formType|
      |ACA enrollment|
    Then "Client" basic information of "2025" ACA form are filled successfully
      |address|country|state|city|zipCode|county|email|phoneNumber|employer|spouseEmployer|emergencyFirstName|emergencyLastName|emergencyPhoneNumber|hearAboutUs|freeQuoteFromUs|healthCoverage|
      |test address|USA|Alabama - AL|test city|123456|test county|qa2_client5@gmail.com|22320000|test employer|test spouse employer|em test|em last test|00001112236|iAgencyPal|No|             |
    And "Client" relatives information of "2025" ACA form are filled successfully
      |relation|relativeFullName|relativeGender|relativeDOB|relativeSSN|relativeLegalStatus|relativeApplyingString|
      |Self|QA 2 Client 5|Male|10-01-2024|2332323|Arrival/Departure Record(I-94/194A)|Applying|
      |Dependent|QA Dependent 1|Male|10-01-2000|23323223|Arrival/Departure Record(I-94/194A)|Applying|
    And "Client" household information of "2025" ACA form are filled successfully
      |houseHoldSize|totalHouseholdTaxableIncome|povertyLineAmount|healthInsuranceThatMeetsACAStandards|medicareOrMedicaid|
      |2            |$ 255,000.00                     |yes              |no                                  |yes               |
    And "Client" doctor information of "2025" ACA form are filled successfully
      |doctorsHospitals|
      |test test hospitals test test doctors|
      |test test 1 hospitals test test 1 doctors|
    And "Client" prescription information of "2025" ACA form are filled successfully
      |prescriptionSummary|prescriptionDosage|
      |test prescription 1|dosage 1          |
      |test prescription 2|dosage 2          |
    And "Client" file attachments of "2025" ACA form are added successfully
      |uploadFile|
      |true|
    And "Client" form is viewed successfully
      |formType|signatureComment|
      |ACA enrollment|test comment|

  @Selenium
  Scenario: Agent views the form signed by client
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "ACA enrollment" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 7|2025|test instructions|false|ACA enrollment|
    And "Client" copy and open form
      |formType|
      |ACA enrollment|
    And "Client" fill login information of ACA form
      |dateOfBirthClient|lastNameClient|
      |2024|Client 7|
    And "Client" fill basic information of "2025" ACA form
      |address|country|state|city|zipCode|county|email|phoneNumber|employer|spouseEmployer|emergencyFirstName|emergencyLastName|emergencyPhoneNumber|hearAboutUs|freeQuoteFromUs|healthCoverage|
      |test address|USA|Alabama - AL|test city|123456|test county|qa_client7@gmail.com|22320000|test employer|test spouse employer|em test|em last test|00001112236|iAgencyPal|No|             |
    And "Client" click proceed to next step of form
    And "Client" add relative of "2025" ACA form
      |relation|relativeFirstName|relativeLastName|relativeGender|relativeDOB|relativeSSN|relativeLegalStatus|relationApplying|
      |Self|QA|Client 7|Male|01/10/2024|2332323|Arrival/Departure Record(I-94/194A)|true|
      |Dependent|QA|Dependent 1|Male|01/10/2000|23323223|Arrival/Departure Record(I-94/194A)|true|
    And "Client" click proceed to next step of form
    And "Client" add household information of "2025" ACA form
      |houseHoldSize|totalHouseholdTaxableIncome|povertyLineAmount|healthInsuranceThatMeetsACAStandards|medicareOrMedicaid|
      |2            |255000                     |yes              |no                                  |yes               |
    And "Client" click proceed to next step of form
    And "Client" add doctor information of "2025" ACA form
      |doctorsHospitals|
      |test test hospitals\ntest test doctors|
      |test test 1 hospitals\ntest test 1 doctors|
    And "Client" add prescription information of "2025" ACA form
      |prescriptionSummary|prescriptionDosage|
      |test prescription 1|dosage 1          |
      |test prescription 2|dosage 2          |
    And "Client" click proceed to next step of form
    And "Client" add file attachments to "2025" ACA form
      |uploadFile|
      |true      |
    And "Client" click proceed to next step of form
    And "Client" sign form
      |formType|signatureComment|
      |ACA enrollment|test comment|
    And "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "ACA enrollment" form page
    And "Agent" view the form
      |formType|
      |ACA enrollment|
    Then "Client" basic information of "2025" ACA form are filled successfully
      |address|country|state|city|zipCode|county|email|phoneNumber|employer|spouseEmployer|emergencyFirstName|emergencyLastName|emergencyPhoneNumber|hearAboutUs|freeQuoteFromUs|healthCoverage|
      |test address|USA|Alabama - AL|test city|123456|test county|qa_client7@gmail.com|22320000|test employer|test spouse employer|em test|em last test|00001112236|iAgencyPal|No|             |
    And "Client" relatives information of "2025" ACA form are filled successfully
      |relation|relativeFullName|relativeGender|relativeDOB|relativeSSN|relativeLegalStatus|relativeApplyingString|
      |Self|QA Client 7|Male|10-01-2024|2332323|Arrival/Departure Record(I-94/194A)|Applying|
      |Dependent|QA Dependent 1|Male|10-01-2000|23323223|Arrival/Departure Record(I-94/194A)|Applying|
    And "Client" household information of "2025" ACA form are filled successfully
      |houseHoldSize|totalHouseholdTaxableIncome|povertyLineAmount|healthInsuranceThatMeetsACAStandards|medicareOrMedicaid|
      |2            |$ 255,000.00                     |yes              |no                                  |yes               |
    And "Client" doctor information of "2025" ACA form are filled successfully
      |doctorsHospitals|
      |test test hospitals test test doctors|
      |test test 1 hospitals test test 1 doctors|
    And "Client" prescription information of "2025" ACA form are filled successfully
      |prescriptionSummary|prescriptionDosage|
      |test prescription 1|dosage 1          |
      |test prescription 2|dosage 2          |
    And "Client" file attachments of "2025" ACA form are added successfully
      |uploadFile|
      |true|
    And "Client" form is viewed successfully
      |formType|signatureComment|
      |ACA enrollment|test comment|


  @Selenium
  Scenario: Agent views the form signed by Agent
    Given "Agent" navigate to login page
    And "Agent" login
    And "Agent" navigate to "ACA enrollment" form page
    When "Agent" send form
      |client|formYear|clientInstructions|prePopulate|formType|
      |QA Client 5|2025|test instructions|false|ACA enrollment|
    And "Agent" copy and open form
      |formType|
      |ACA enrollment|
    And "Agent" fill basic information of "2025" ACA form
      |address|country|state|city|zipCode|county|email|phoneNumber|employer|spouseEmployer|emergencyFirstName|emergencyLastName|emergencyPhoneNumber|hearAboutUs|freeQuoteFromUs|healthCoverage|
      |test address|USA|Alabama - AL|test city|123456|test county|qa_client5@gmail.com|22320000|test employer|test spouse employer|em test|em last test|00001112236|iAgencyPal|No|             |
    And "Agent" click proceed to next step of form
    And "Agent" add relative of "2025" ACA form
      |relation|relativeFirstName|relativeLastName|relativeGender|relativeDOB|relativeSSN|relativeLegalStatus|relationApplying|
      |Self|QA|Client 5|Male|01/10/2024|2332323|Arrival/Departure Record(I-94/194A)|true|
      |Dependent|QA|Dependent 1|Male|01/10/2000|23323223|Arrival/Departure Record(I-94/194A)|true|
    And "Agent" click proceed to next step of form
    And "Agent" add household information of "2025" ACA form
      |houseHoldSize|totalHouseholdTaxableIncome|povertyLineAmount|healthInsuranceThatMeetsACAStandards|medicareOrMedicaid|
      |2            |255000                     |yes              |no                                  |yes               |
    And "Agent" click proceed to next step of form
    And "Agent" add doctor information of "2025" ACA form
      |doctorsHospitals|
      |test test hospitals\ntest test doctors|
      |test test 1 hospitals\ntest test 1 doctors|
    And "Agent" add prescription information of "2025" ACA form
      |prescriptionSummary|prescriptionDosage|
      |test prescription 1|dosage 1          |
      |test prescription 2|dosage 2          |
    And "Agent" click proceed to next step of form
    And "Agent" add file attachments to "2025" ACA form
      |uploadFile|
      |true      |
    And "Agent" click proceed to next step of form
    And "Agent" sign form
      |formType|signatureComment|
      |ACA enrollment|test comment|
    And "Agent" navigate to "ACA enrollment" form page
    And "Agent" view the form
      |formType|
      |ACA enrollment|
    Then "Agent" basic information of "2025" ACA form are filled successfully
      |address|country|state|city|zipCode|county|email|phoneNumber|employer|spouseEmployer|emergencyFirstName|emergencyLastName|emergencyPhoneNumber|hearAboutUs|freeQuoteFromUs|healthCoverage|
      |test address|USA|Alabama - AL|test city|123456|test county|qa_client5@gmail.com|22320000|test employer|test spouse employer|em test|em last test|00001112236|iAgencyPal|No|             |
    And "Agent" relatives information of "2025" ACA form are filled successfully
      |relation|relativeFullName|relativeGender|relativeDOB|relativeSSN|relativeLegalStatus|relativeApplyingString|
      |Self|QA Client 5|Male|10-01-2024|2332323|Arrival/Departure Record(I-94/194A)|Applying|
      |Dependent|QA Dependent 1|Male|10-01-2000|23323223|Arrival/Departure Record(I-94/194A)|Applying|
    And "Agent" household information of "2025" ACA form are filled successfully
      |houseHoldSize|totalHouseholdTaxableIncome|povertyLineAmount|healthInsuranceThatMeetsACAStandards|medicareOrMedicaid|
      |2            |$ 255,000.00                     |yes              |no                                  |yes               |
    And "Agent" doctor information of "2025" ACA form are filled successfully
      |doctorsHospitals|
      |test test hospitals test test doctors|
      |test test 1 hospitals test test 1 doctors|
    And "Agent" prescription information of "2025" ACA form are filled successfully
      |prescriptionSummary|prescriptionDosage|
      |test prescription 1|dosage 1          |
      |test prescription 2|dosage 2          |
    And "Agent" file attachments of "2025" ACA form are added successfully
      |uploadFile|
      |true|
    And "Agent" form is viewed successfully
      |formType|signatureComment|
      |ACA enrollment|test comment|

  @Selenium
  Scenario: Broker views the form signed by Broker
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "ACA enrollment" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA Client 6|2025|test instructions|false|ACA enrollment|Agent Automation|
    And "Broker" copy and open form
      |formType|
      |ACA enrollment|
    And "Broker" fill basic information of "2025" ACA form
      |address|country|state|city|zipCode|county|email|phoneNumber|employer|spouseEmployer|emergencyFirstName|emergencyLastName|emergencyPhoneNumber|hearAboutUs|freeQuoteFromUs|healthCoverage|
      |test address|USA|Alabama - AL|test city|123456|test county|qa_client6@gmail.com|22320000|test employer|test spouse employer|em test|em last test|00001112236|iAgencyPal|No|             |
    And "Broker" click proceed to next step of form
    And "Broker" add relative of "2025" ACA form
      |relation|relativeFirstName|relativeLastName|relativeGender|relativeDOB|relativeSSN|relativeLegalStatus|relationApplying|
      |Self|QA|Client 6|Male|01/10/2024|2332323|Arrival/Departure Record(I-94/194A)|true|
      |Dependent|QA|Dependent 1|Male|01/10/2000|23323223|Arrival/Departure Record(I-94/194A)|true|
    And "Broker" click proceed to next step of form
    And "Broker" add household information of "2025" ACA form
      |houseHoldSize|totalHouseholdTaxableIncome|povertyLineAmount|healthInsuranceThatMeetsACAStandards|medicareOrMedicaid|
      |2            |255000                     |yes              |no                                  |yes               |
    And "Broker" click proceed to next step of form
    And "Broker" add doctor information of "2025" ACA form
      |doctorsHospitals|
      |test test hospitals\ntest test doctors|
      |test test 1 hospitals\ntest test 1 doctors|
    And "Broker" add prescription information of "2025" ACA form
      |prescriptionSummary|prescriptionDosage|
      |test prescription 1|dosage 1          |
      |test prescription 2|dosage 2          |
    And "Broker" click proceed to next step of form
    And "Broker" add file attachments to "2025" ACA form
      |uploadFile|
      |true      |
    And "Broker" click proceed to next step of form
    And "Broker" sign form
      |formType|signatureComment|
      |ACA enrollment|test comment|
    And "Broker" navigate to "ACA enrollment" form page
    And "Broker" view the form
      |formType|
      |ACA enrollment|
    Then "Broker" basic information of "2025" ACA form are filled successfully
      |address|country|state|city|zipCode|county|email|phoneNumber|employer|spouseEmployer|emergencyFirstName|emergencyLastName|emergencyPhoneNumber|hearAboutUs|freeQuoteFromUs|healthCoverage|
      |test address|USA|Alabama - AL|test city|123456|test county|qa_client6@gmail.com|22320000|test employer|test spouse employer|em test|em last test|00001112236|iAgencyPal|No|             |
    And "Broker" relatives information of "2025" ACA form are filled successfully
      |relation|relativeFullName|relativeGender|relativeDOB|relativeSSN|relativeLegalStatus|relativeApplyingString|
      |Self|QA Client 6|Male|10-01-2024|2332323|Arrival/Departure Record(I-94/194A)|Applying|
      |Dependent|QA Dependent 1|Male|10-01-2000|23323223|Arrival/Departure Record(I-94/194A)|Applying|
    And "Broker" household information of "2025" ACA form are filled successfully
      |houseHoldSize|totalHouseholdTaxableIncome|povertyLineAmount|healthInsuranceThatMeetsACAStandards|medicareOrMedicaid|
      |2            |$ 255,000.00                     |yes              |no                                  |yes               |
    And "Broker" doctor information of "2025" ACA form are filled successfully
      |doctorsHospitals|
      |test test hospitals test test doctors|
      |test test 1 hospitals test test 1 doctors|
    And "Broker" prescription information of "2025" ACA form are filled successfully
      |prescriptionSummary|prescriptionDosage|
      |test prescription 1|dosage 1          |
      |test prescription 2|dosage 2          |
    And "Broker" file attachments of "2025" ACA form are added successfully
      |uploadFile|
      |true|
    And "Broker" form is viewed successfully
      |formType|signatureComment|
      |ACA enrollment|test comment|

  @Selenium
  Scenario: Broker resend the form signed by Broker
    Given "Broker" navigate to login page
    And "Broker" login
    And "Broker" navigate to "ACA enrollment" form page
    When "Broker" send form
      |client|formYear|clientInstructions|prePopulate|formType|servicingAgent|
      |QA 2 Client 6|2025|test instructions|false|ACA enrollment|Agent Automation 2|
    And "Broker" copy and open form
      |formType|
      |ACA enrollment|
    And "Broker" fill basic information of "2025" ACA form
      |address|country|state|city|zipCode|county|email|phoneNumber|employer|spouseEmployer|emergencyFirstName|emergencyLastName|emergencyPhoneNumber|hearAboutUs|freeQuoteFromUs|healthCoverage|
      |test address|USA|Alabama - AL|test city|123456|test county|qa2_client6@gmail.com|22320000|test employer|test spouse employer|em test|em last test|00001112236|iAgencyPal|No|             |
    And "Broker" click proceed to next step of form
    And "Broker" add relative of "2025" ACA form
      |relation|relativeFirstName|relativeLastName|relativeGender|relativeDOB|relativeSSN|relativeLegalStatus|relationApplying|
      |Self|QA 2|Client 6|Male|01/10/2024|2332323|Arrival/Departure Record(I-94/194A)|true|
      |Dependent|QA|Dependent 1|Male|01/10/2000|23323223|Arrival/Departure Record(I-94/194A)|true|
    And "Broker" click proceed to next step of form
    And "Broker" add household information of "2025" ACA form
      |houseHoldSize|totalHouseholdTaxableIncome|povertyLineAmount|healthInsuranceThatMeetsACAStandards|medicareOrMedicaid|
      |2            |255000                     |yes              |no                                  |yes               |
    And "Broker" click proceed to next step of form
    And "Broker" add doctor information of "2025" ACA form
      |doctorsHospitals|
      |test test hospitals\ntest test doctors|
      |test test 1 hospitals\ntest test 1 doctors|
    And "Broker" add prescription information of "2025" ACA form
      |prescriptionSummary|prescriptionDosage|
      |test prescription 1|dosage 1          |
      |test prescription 2|dosage 2          |
    And "Broker" click proceed to next step of form
    And "Broker" add file attachments to "2025" ACA form
      |uploadFile|
      |true      |
    And "Broker" click proceed to next step of form
    And "Broker" sign form
      |formType|signatureComment|
      |ACA enrollment|test comment|
    And "Broker" navigate to "ACA enrollment" form page
    And "Broker" resend the form
      |formType|
      |ACA enrollment|
    Then "Broker" form is resent
      |submittedDate|submittedAgent|formType|client|status|year|
      |||ACA enrollment|QA 2 Client 6|Sent|2025|

#  @API
#  Scenario: No error when sending ACA form
#    Given Agent login with API
#    When Agent send ACA form with API
#      |client_id|formType_id|formYear_id|clientEmail|clientMobile|instructions|PrePpopulate|id|agent_id|status|
#      |b01e7584-603a-4c28-cfde-08dccc299b4f|17|23|testclientqa@gmail.com|12313213|test instructions|true| |E4F8732E-A098-4829-A35C-08DCCC278004| |
#    Then Agent ACA Form is sent with API successfully
