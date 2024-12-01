package model_classes.forms;

public class SignFormModel extends AbstractModel{

    private String yearOfBirth;

    private String lastName;

    private String address;

    private String country;

    private String county;

    private String state;

    private String city;

    private String zipCode;

    private String email;

    private String phoneNumber;

    private String employer;

    private String income;

    private String spouseEmployer;

    private String spouseIncome;

    private String healthCoverage;

    private String emergencyFirstName;

    private String emergencyLastName;

    private String emergencyPhoneNumber;

    private String relation;

    private String relativeFullName;

    private String relativeFirstName;

    private String relativeLastName;

    private String relativeGender;

    private String relativeDOB;

    private String relativeSSN;

    private String relativeLegalStatus;

    private boolean relationApplying;

    private String relativeApplyingString;

    private String houseHoldSize;

    private String totalHouseholdTaxableIncome;

    private String povertyLineAmount;

    private String medicareOrMedicaid;

    private String healthInsuranceThatMeetsACAStandards;

    private boolean questionsYes;

    private String emergencyContact;

    private String doctorSummary;

    private String prescriptionDosage;

    private String prescriptionSummary;

    private boolean uploadFile;

    private String hearAboutUs;

    private boolean autoAddNewRelation;

    private boolean iUnderstand;

    private String formType;

    private String client;

    private String formYear;

    private String submittedAgent;

    private String submittedDate;

    private String cardType;

    private String cardHolderName;

    private String cardNumber;

    private String expirationMonth;

    private String expirationYear;

    private String cardHolderZipCode;

    private String servingAgent;

    private String freeQuoteFromUs;

    private String doctorsHospitals;

    private String dateOfBirthClient;

    private String lastNameClient;

    private String attachmentName;

    private String signatureComment;

    ////////////////////////////////////////////////////////////////////////////////


    public String getSignatureComment() {
        return signatureComment;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public String getRelativeApplyingString() {
        return relativeApplyingString;
    }

    public String getRelativeFullName() {
        return relativeFullName;
    }

    public String getDoctorsHospitals() {
        return doctorsHospitals;
    }

    public String getCounty() {
        return county;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public boolean isiUnderstand() {
        return iUnderstand;
    }

    public boolean isAutoAddNewRelation() {
        return autoAddNewRelation;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmployer() {
        return employer;
    }

    public String getIncome() {
        return income;
    }

    public String getSpouseEmployer() {
        return spouseEmployer;
    }

    public String getSpouseIncome() {
        return spouseIncome;
    }

    public String getHealthCoverage() {
        return healthCoverage;
    }

    public String getRelation() {
        return relation;
    }

    public String getRelativeFirstName() {
        return relativeFirstName;
    }

    public String getRelativeLastName() {
        return relativeLastName;
    }

    public String getRelativeGender() {
        return relativeGender;
    }

    public String getRelativeDOB() {
        return relativeDOB;
    }

    public String getRelativeSSN() {
        return relativeSSN;
    }

    public String getRelativeLegalStatus() {
        return relativeLegalStatus;
    }

    public boolean isRelationApplying() {
        return relationApplying;
    }

    public String getHouseHoldSize() {
        return houseHoldSize;
    }

    public boolean isQuestionsYes() {
        return questionsYes;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public String getDoctorSummary() {
        return doctorSummary;
    }

    public String getPrescriptionDosage() {
        return prescriptionDosage;
    }

    public String getPrescriptionSummary() {
        return prescriptionSummary;
    }

    public boolean isUploadFile() {
        return uploadFile;
    }

    public String getHearAboutUs() {
        return hearAboutUs;
    }

    public boolean getAutoAddNewRelation() {
        return autoAddNewRelation;
    }

    public String getFormType() {
        return formType;
    }

    public String getClient() {
        return client;
    }

    public String getFormYear() {
        return formYear;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public String getSubmittedAgent() {
        return submittedAgent;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderZipCode() {
        return cardHolderZipCode;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public String getServingAgent() {
        return servingAgent;
    }

    public String getEmergencyFirstName() {
        return emergencyFirstName;
    }

    public String getEmergencyLastName() {
        return emergencyLastName;
    }

    public String getEmergencyPhoneNumber() {
        return emergencyPhoneNumber;
    }

    public String getFreeQuoteFromUs() {
        return freeQuoteFromUs;
    }

    public String getTotalHouseholdTaxableIncome() {
        return totalHouseholdTaxableIncome;
    }

    public String getPovertyLineAmount() {
        return povertyLineAmount;
    }

    public String getMedicareOrMedicaid() {
        return medicareOrMedicaid;
    }

    public String getHealthInsuranceThatMeetsACAStandards() {
        return healthInsuranceThatMeetsACAStandards;
    }

    public String getDateOfBirthClient() {
        return dateOfBirthClient;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    ////////////////////////////////////////////////////////////////////////////////


    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public void setSpouseEmployer(String spouseEmployer) {
        this.spouseEmployer = spouseEmployer;
    }

    public void setSpouseIncome(String spouseIncome) {
        this.spouseIncome = spouseIncome;
    }

    public void setHealthCoverage(String healthCoverage) {
        this.healthCoverage = healthCoverage;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public void setRelativeFirstName(String relativeFirstName) {
        this.relativeFirstName = relativeFirstName;
    }

    public void setRelativeGender(String relativeGender) {
        this.relativeGender = relativeGender;
    }

    public void setRelativeLastName(String relativeLastName) {
        this.relativeLastName = relativeLastName;
    }

    public void setRelativeDOB(String relativeDOB) {
        this.relativeDOB = relativeDOB;
    }

    public void setRelativeSSN(String relativeSSN) {
        this.relativeSSN = relativeSSN;
    }

    public void setRelativeLegalStatus(String relativeLegalStatus) {
        this.relativeLegalStatus = relativeLegalStatus;
    }

    public void setRelationApplying(boolean relationApplying) {
        this.relationApplying = relationApplying;
    }

    public void setHouseHoldSize(String houseHoldSize) {
        this.houseHoldSize = houseHoldSize;
    }

    public void setQuestionsYes(boolean questionsYes) {
        this.questionsYes = questionsYes;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setDoctorSummary(String doctorSummary) {
        this.doctorSummary = doctorSummary;
    }

    public void setPrescriptionDosage(String prescriptionDosage) {
        this.prescriptionDosage = prescriptionDosage;
    }

    public void setUploadFile(boolean uploadFile) {
        this.uploadFile = uploadFile;
    }

    public void setPrescriptionSummary(String prescriptionSummary) {
        this.prescriptionSummary = prescriptionSummary;
    }

    public void setHearAboutUs(String hearAboutUs) {
        this.hearAboutUs = hearAboutUs;
    }

    public void setAutoAddNewRelation(boolean autoAddNewRelation) {
        this.autoAddNewRelation = autoAddNewRelation;
    }

    public void setiUnderstand(boolean iUnderstand) {
        this.iUnderstand = iUnderstand;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setFormYear(String formYear) {
        this.formYear = formYear;
    }

    public void setSubmittedAgent(String submittedAgent) {
        this.submittedAgent = submittedAgent;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolderZipCode(String cardHolderZipCode) {
        this.cardHolderZipCode = cardHolderZipCode;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public void setServingAgent(String servingAgent) {
        this.servingAgent = servingAgent;
    }

    public void setEmergencyFirstName(String emergencyFirstName) {
        this.emergencyFirstName = emergencyFirstName;
    }

    public void setEmergencyLastName(String emergencyLastName) {
        this.emergencyLastName = emergencyLastName;
    }

    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }

    public void setFreeQuoteFromUs(String freeQuoteFromUs) {
        this.freeQuoteFromUs = freeQuoteFromUs;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setTotalHouseholdTaxableIncome(String totalHouseholdTaxableIncome) {
        this.totalHouseholdTaxableIncome = totalHouseholdTaxableIncome;
    }

    public void setPovertyLineAmount(String povertyLineAmount) {
        this.povertyLineAmount = povertyLineAmount;
    }

    public void setMedicareOrMedicaid(String medicareOrMedicaid) {
        this.medicareOrMedicaid = medicareOrMedicaid;
    }

    public void setHealthInsuranceThatMeetsACAStandards(String healthInsuranceThatMeetsACAStandards) {
        this.healthInsuranceThatMeetsACAStandards = healthInsuranceThatMeetsACAStandards;
    }

    public void setDoctorsHospitals(String doctorsHospitals) {
        this.doctorsHospitals = doctorsHospitals;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public void setDateOfBirthClient(String dateOfBirthClient) {
        this.dateOfBirthClient = dateOfBirthClient;
    }

    public void setRelativeFullName(String relativeFullName) {
        this.relativeFullName = relativeFullName;
    }

    public void setRelativeApplyingString(String relativeApplyingString) {
        this.relativeApplyingString = relativeApplyingString;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public void setSignatureComment(String signatureComment) {
        this.signatureComment = signatureComment;
    }
}
