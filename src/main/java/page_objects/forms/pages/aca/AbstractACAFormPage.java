package page_objects.forms.pages.aca;

import actions.ActionsHelper;
import actions.WebActions;
import assertions.AssertionsContext;
import auxiliary.StaticAuxiliary;
import enums.AssertType;
import enums.product.FormBox;
import enums.product.Grids;
import enums.product.Messages;
import enums.product.SupportiveContent;
import model_classes.forms.SearchFormModel;
import model_classes.forms.SendFormModel;
import model_classes.forms.SignFormModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import page_objects.forms.actors.FormsActors;
import page_objects.forms.customs.aca.ACACustom;
import synchronization.Waiter;

public class AbstractACAFormPage implements FormsActors, ACACustom {


    protected final By servicingAgentField = By.xpath("//p-autocomplete[@formcontrolname='agent_id']//input");
    protected final String url = "/en/system/new/new-forms";
    protected final By copyLink = By.cssSelector("a[title='Copy']");
    protected final By successSignature = By.xpath("//app-new-form-success//div[contains(@class, 'Instructions_msg-success')]");
    protected final String formsGrid = "//div[@class='p-datatable-wrapper']//table[@role='table']";
    protected final By clientField = By.xpath("//p-autocomplete[@formcontrolname='client_id']//input");
    protected final By clientEmail = By.cssSelector("input[formcontrolname='clientEmail']");
    protected final By clientMobile = By.cssSelector("input[formcontrolname='clientMobile']");
    protected final By formYearList = By.cssSelector("select[id='formYear_id']");
    protected final By formTypeList = By.cssSelector("select[id='formType_id']");
    protected final By prepopulateCheckbox = By.cssSelector("input[formcontrolname='prePpopulate']");
    protected final By instructionsField = By.cssSelector("textarea[formcontrolname='instructions']");
    protected final By submitButton = By.cssSelector("button[type='submit']");
    protected final By addForm = By.cssSelector("div[class='table_actions-search_add-add'] button[class*='btn btn-primary has_dropdown']");
    protected final By forClientLink = By.xpath("//app-new-data-table-send-form-dropdown//ul[@class='list-unstyled']//li");
    protected final By actions_icon = By.xpath("//div[contains(@class, 'action-dropdown')]//a");
    protected final By addNewRelation = By.xpath("//h6[contains(text(),'Add New Relation')]//parent::button");
    protected final By relation = By.xpath("//h6[text()='Relation']//parent::label//following-sibling::select");
    protected final By relationApplying = By.cssSelector("input[id='flexCheckDefault']");
    protected final By relationFirstName = By.cssSelector("input[name='firstName']");
    protected final By relationLastName = By.xpath("//div[@id='relation']//h6[text()='Last Name']//parent::label//following-sibling::input");
    protected final By relationGender = By.xpath("//div[@id='relation']//h6[text()='Gender']//parent::label//following-sibling::select");
    protected final By relationDOB = By.xpath("//div[@id='relation']//input[@name='dateOfBirth']");
    protected final By relationSSN = By.cssSelector("input[name='ssn']");
    protected final By relationLegalStatus = By.cssSelector("select[name='legalStatus_Id']");
    protected final By submitRelation = By.xpath("//div[contains(@class,'summary_footer')]//button");
    protected final By signature = By.xpath("//app-signature//canvas");
    protected final By comment = By.xpath("//textarea[@name='comment']");
    protected final By submit = By.xpath("//div[@id='sign']//button[contains(@class,'btn-primary')]");
    protected final By clientYearBirth = By.cssSelector("input[formcontrolname='birthDate']");
    protected final By clientLastName = By.cssSelector("input[formcontrolname='lastName']");
    protected final By loginButton = By.cssSelector("button[class*='Login']");
    protected final By address = By.cssSelector("input[name='address']");
    protected final By countryDropList = By.xpath("//h6[text()='Country']//parent::label//following-sibling::select");
    protected final By stateDropList = By.xpath("//h6[text()='State/Province']//parent::label//following-sibling::select");
    protected final By city = By.cssSelector("input[name='city']");
    protected final By zipCode = By.xpath("//h6[text()='Zip Code/Postal Code']//parent::label//following-sibling::input");
    protected final By email = By.cssSelector("input[name='email']");
    protected final By phoneNumber = By.cssSelector("input[name='Phone']");
    protected final By employer = By.cssSelector("input[name='employer']");
    protected final By income = By.xpath("//h6[text()='Income']//parent::label//following-sibling::input");
    protected final By spouseEmployer = By.cssSelector("input[name='spouseEmployer']");
    protected final By spouseIncome = By.xpath("//h6[text()='Spouse Income']//parent::label//following-sibling::input");
    protected final By healthCoverage = By.xpath("//h6[text()='Current or previouse health covarage']//parent::label//following-sibling::input");
    protected final By saveAndContinue = By.xpath("//h6[text()='Save & Continue']//parent::button");
    protected final By saveAndAddNew = By.xpath("//button[contains(text(),'Save & Add New')]");
    protected final By save = By.xpath("//div[@id='sign']//button[@type='submit']");
    protected final By yesCheckbox = By.xpath("//input[@id='yes1' and @value='1']");
    protected final By falseCheckbox = By.xpath("//input[@id='yes1' and @value='0']");
    protected final By emergencyContact = By.xpath("//h6[contains(text(),'Please provide your emergency contact information')]//parent::label//following-sibling::input");
    protected final By addDoctorSummary = By.xpath("//h6[contains(text(),'Add Doctor Summary')]//parent::button");
    protected final By doctorSummaryTextArea = By.cssSelector("textarea[name='doctorName']");
    protected final By submitDoctorSummary = By.xpath("//div[@id='addSammary']//button[contains(@class,'btn-primary')]");
    protected final By yourPrescriptionTab = By.xpath("//h6[contains(text(),'Your Prescriptions')]//parent::button");
    protected final By youDoctorsTab = By.xpath("//h6[contains(text(),'Your Doctors')]//parent::button");
    protected final By prescriptionDosage = By.cssSelector("input[name='dosage']");
    protected final By prescriptionSummary = By.cssSelector("textarea[name='summary']");
    protected final By checkbox = By.xpath("//input[@id='yes1' and @type='checkbox']");
    protected final By hearAboutUs = By.xpath("//h6[contains(text(),'How did you hear about us? ')]//parent::label//following-sibling::input");
    protected final By houseHoldGrid = By.xpath("//div[contains(@class,'hold_size')]//table");
    protected final By questionYes = By.xpath("//some-element//input[@id='yes1' and @value='1']");
    protected final By questionNo = By.xpath("//some-element//input[@id='yes1' and @value='0']");
    protected final String dateRegex = "\\d{1,2}/\\d{1,2}/\\d{2},\\s\\d{1,2}:\\d{2}\\s(?:AM|PM)";
    protected final By addFormDialog = By.cssSelector("div[class='add_new_agent_modal-head']");
    protected final By toasterAlert = By.xpath("//div[@id='toast-container']//div[@role='alertdialog']");
    protected final By toasterAlertMessage = By.xpath("//div[@id='toast-container']//div[@role='alertdialog']//h6");
    protected final By approveCheckbox = By.xpath("//div[@id='sign']//input[@type='checkbox']");
    protected final By confirmationType = By.xpath("//select[@formcontrolname='confirmationMethod']");
    protected final By confirmationDate = By.xpath("//input[@formcontrolname='approvalDate']");
    protected final By confirmationDateCalendar = By.xpath("//div[@id='sign']//input[@formcontrolname='approvalDate']");
    protected final By county = By.xpath("//input[@name='county']");
    protected final By emergencyFirstName = By.xpath("//h6[text()='First Name']//parent::label//following-sibling::input[@type='text']");
    protected final By emergencyLastName = By.xpath("//h6[text()='Last Name']//parent::label//following-sibling::input[@type='text']");
    protected final By emergencyPhoneNumber = By.xpath("//input[@name='emergencyContactPhone']");
    protected final By questionFreeQuote = By.xpath("//h5[text()=' You might save more money on your Home, Auto, and Commercial insurance. Do you want to get a Free quote from us? ']//parent::label//following-sibling::container-element");
    protected final By householdSize = By.xpath("//h5[contains(text(),'Household Size ?')]//parent::label//following-sibling::container-element//input");
    protected final By totalHouseHoldTaxableSize = By.xpath("//h5[contains(text(),'Total Household Taxable Income ?')]//parent::label//following-sibling::container-element//input");
    protected final By povertyLineAmount = By.xpath("//h5[text()=' Based on your household size, income, and the chart above does your income for the year 2025 exceed the 400% Poverty line amount? ']//parent::label//following-sibling::container-element");
    protected final By meetsACAStandards = By.xpath("//h5[text()=' Has your employer offered you health insurance that meets ACA standards, and is your share of the premium for the lowest-cost, self-only plan less than 9.02% of your household income? ']//parent::label//following-sibling::container-element");
    protected final By medicareOrMedicaid = By.xpath("//h5[text()=' Are you eligible for Medicare or Medicaid? ']//parent::label//following-sibling::container-element");
    protected final By youDoctorsHospitals = By.xpath("//h6[text()=' Your Doctors/ Hospitals ']//parent::button");
    protected final By yourPrescriptions = By.xpath("//h6[text()=' Your Prescriptions ']//parent::button");
    protected final By addDoctorsHospitals = By.xpath("//h6[text()=' Add Doctors/ Hospitals ']//parent::button");
    protected final By addPrescription = By.xpath("//h6[text()=' Add Prescription ']//parent::button");
    protected final By addDoctorTextArea = By.xpath("//textarea[@name='doctorName']");
    protected final By addButtonDoctor = By.xpath("//div[@id='addSammary']//button[text()=' Add ']");
    protected final By addButtonPrescription = By.xpath("//div[@id='prescriptions']//button[text()=' Add ']");
    protected final By dosageField = By.xpath("//input[@name='dosage']");
    protected final By dosagePrescriptionTextArea = By.xpath("//textarea[@name='summary']");
    protected final By uploadFile = By.id("uploadFile");
    protected final Keys[] keysForConfirmationDate = {Keys.ARROW_UP, Keys.ARROW_RIGHT, Keys.ARROW_UP, Keys.ARROW_RIGHT, Keys.ARROW_UP, Keys.ARROW_RIGHT, Keys.ARROW_UP, Keys.ARROW_RIGHT, Keys.ARROW_UP, Keys.ARROW_RIGHT, Keys.ARROW_UP, Keys.ARROW_RIGHT, Keys.ARROW_UP};
    protected final By viewFormButton = By.xpath("//a[@title='View Form']");
    protected final By resendFormButton = By.xpath("//a[@title='Resend submitted Form']");

    // view form
    protected final By viewBasicInfoAddress = By.xpath("//h3[contains(text(),'Basic Information')]//parent::div//h6[text()='Address']//following-sibling::h6");
    protected final By viewBasicInfoCountry = By.xpath("//h3[contains(text(),'Basic Information')]//parent::div//h6[text()='Country']//following-sibling::h6");
    protected final By viewBasicInfoState = By.xpath("//h3[contains(text(),'Basic Information')]//parent::div//h6[text()='State/Province']//following-sibling::h6");
    protected final By viewBasicInfoCity = By.xpath("//h3[contains(text(),'Basic Information')]//parent::div//h6[text()='City']//following-sibling::h6");
    protected final By viewBasicInfoZipCode = By.xpath("//h3[contains(text(),'Basic Information')]//parent::div//h6[text()='Zip Code/Postal Code']//following-sibling::h6");
    protected final By viewBasicInfoEmail = By.xpath("//h3[contains(text(),'Basic Information')]//parent::div//h6[text()='Email Address ']//following-sibling::h6");
    protected final By viewBasicInfoPhoneNumber = By.xpath("//h3[contains(text(),'Basic Information')]//parent::div//h6[text()='Phone Number ']//following-sibling::h6");
    protected final By viewBasicInfoEmployer = By.xpath("//h3[contains(text(),'Basic Information')]//parent::div//h6[text()='Employer']//following-sibling::h6");
    protected final By viewBasicInfoSpouseEmployer = By.xpath("//h3[contains(text(),'Basic Information')]//parent::div//h6[text()='Spouse Employer ']//following-sibling::h6");
    protected final By viewBasicInfoHealthCoverage = By.xpath("//h3[contains(text(),'Basic Information')]//parent::div//h6[text()='Current or previous health coverage']//following-sibling::h6");
    protected final By viewBasicInfoHearAboutUs = By.xpath("//h3[contains(text(),'Basic Information')]//parent::div//h6[text()='How did you hear about us? ']//parent::label//parent::*//input");
    protected final By viewBasicInfoFreeQuote = By.xpath("//h5[text()=' You might save more money on your Home, Auto, and Commercial insurance. Do you want to get a Free quote from us? ']//parent::label//following-sibling::container-element");
    protected final By viewBasicInfoFreeQuoteNo = By.xpath("//h5[text()=' You might save more money on your Home, Auto, and Commercial insurance. Do you want to get a Free quote from us? ']//parent::label//following-sibling::container-element//input[@value='0']");
    protected final By viewBasicInfoFreeQuoteYes = By.xpath("//h5[text()=' You might save more money on your Home, Auto, and Commercial insurance. Do you want to get a Free quote from us? ']//parent::label//following-sibling::container-element//input[@value='1']");

    protected final String viewRelationsRelationFormBox = "//h3[contains(text(),'Household Members')]//parent::div//div[contains(@class,'relation_info_box')]";

    protected final By viewHouseHoldSize = By.xpath("//h3[contains(text(),'Household Size')]//parent::div//h5[contains(text(),'Household Size ?')]//parent::label//following-sibling::container-element//input");
    protected final By viewHouseHoldTaxableIncome = By.xpath("//h3[contains(text(),'Household Size')]//parent::div//h5[contains(text(),'Total Household Taxable Income ?')]//parent::label//following-sibling::container-element//input");
    protected final By viewHouseHoldGrid = By.xpath("//div[contains(@class,'hold_size')]//table");
    protected final By viewHouseHoldPovertyLineAmount = By.xpath("//h3[contains(text(),'Household Size')]//parent::div//h5[text()=' Based on your household size, income, and the chart above does your income for the year 2025 exceed the 400% Poverty line amount? ']//parent::label//following-sibling::container-element");
    protected final By viewHouseHoldMeetACAStandard = By.xpath("//h3[contains(text(),'Household Size')]//parent::div//h5[text()=' Has your employer offered you health insurance that meets ACA standards, and is your share of the premium for the lowest-cost, self-only plan less than 9.02% of your household income? ']//parent::label//following-sibling::container-element");
    protected final By viewHouseHoldMedicareOrMedicaid = By.xpath("//h3[contains(text(),'Household Size')]//parent::div//h5[text()=' Are you eligible for Medicare or Medicaid? ']//parent::label//following-sibling::container-element");
    protected final By viewDoctorsDoctorTable = By.xpath("//h3[contains(text(),'Doctor / Hospital / Prescriptions')]//parent::div//h5[text()='Doctors']//parent::div[contains(@class,'sammary')]//table");
    protected final By viewDoctorsPrescriptionTable = By.xpath("//h3[contains(text(),'Doctor / Hospital / Prescriptions')]//parent::div//h5[text()='Prescriptions ']//parent::div[contains(@class,'sammary')]//table");

    protected final String viewAttachmentsAttachment = "//h3[contains(text(),'Attach Files (for NON citizens)')]//parent::div//h6[text()='Attachments']//parent::div[contains(@class,'file_upload')]";
    protected final String viewAttachmentsFileName = "//h6";
    protected final String viewAttachmentsDownload = "//button";

    protected final By viewSignatureComment = By.xpath("//h3[contains(text(),'eSignature')]//parent::div//textarea[@name='comment']");
    protected final By viewSignatureSignatureImg = By.xpath("//h3[contains(text(),'eSignature')]//parent::div//img[@id='signature']");

    protected final By viewDownloadForm = By.xpath("//div[contains(@class,'form_box_footer')]//a[text()='Download Form']");
    protected final By viewFormSubmittedDate = By.xpath("//div[contains(@class,'date')]//div[contains(text(),'Submitted Date & Time')]//following-sibling::div[1]");
    protected final By viewFormSubmittedTime = By.xpath("//div[contains(@class,'date')]//div[contains(text(),'Submitted Date & Time')]//following-sibling::div[2]");
    protected final By viewFormSubmittedIP = By.xpath("//div[contains(@class,'date')]//div[contains(text(),'Submitted IP address')]//following-sibling::div[1]");

    protected final By viewFormCheckboxApproval = By.xpath("//input[@name='approval']");
    protected final By viewFormConfirmationMethod = By.xpath("//select[@name='confirmationMethod']");
    protected final By viewFormConfirmationDate = By.xpath("//input[@name='approvalDate']");

    protected final By formFilters = By.xpath("//app-new-forms//app-new-client-form//button[@data-bs-target='#filterClientFormModal']");

    protected WebActions actions;
    protected AssertionsContext assertion;

    protected AbstractACAFormPage(WebActions actions, AssertionsContext assertion){
        this.actions = actions;
        this.assertion = assertion;
    }

    public AbstractACAFormPage(){
        this.actions = new ActionsHelper<>().getActions();
        this.assertion = new AssertionsContext();
    }

    @Override
    public void navigate() {
        this.actions.navigate(this.url, true);
    }

    @Override
    public void sign(SignFormModel signFormModel) {

    }

    @Override
    public void noSign(SignFormModel signFormModel) {

    }

    @Override
    public void send(SendFormModel sendFormModel) {

    }

    @Override
    public void formSigned(SearchFormModel searchFormModel) {

    }

    @Override
    public void formResign(SignFormModel signFormModel) {

    }

    @Override
    public void formSent(SearchFormModel searchFormModel) {
        this.assertion.assertElementEqualText(toasterAlertMessage, Messages.SUCCESS_FORM.label, AssertType.HARD);
        Waiter.waitForElementInvisible(this.addFormDialog);
        this.actions.reloadPage();
        this.assertion.assertGridValue(this.formsGrid, Grids.FORM_TYPE.label, searchFormModel.getFormType(),1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.CLIENT.label, searchFormModel.getClient(),1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.YEAR.label, searchFormModel.getYear(),1, AssertType.HARD);
        this.assertion.assertGridValueMatch(this.formsGrid, Grids.SENT_DATE.label, this.dateRegex,1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.STATUS.label, searchFormModel.getStatus(),1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.SUBMITTED_AGENT.label, "",1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.SUBMITTED_DATE.label, "",1, AssertType.HARD);

    }

    @Override
    public void formNotSent(SearchFormModel searchFormModel) {
//        this.assertion.assertElementIsPresent(toasterAlert, AssertType.HARD);
        this.assertion.assertElementEqualText(toasterAlertMessage, Messages.PENDING_FORM.label, AssertType.HARD);
        this.assertion.assertElementIsVisible(addFormDialog, AssertType.HARD);
    }

    @Override
    public void formAlreadySigned(SearchFormModel searchFormModel) {

    }

    @Override
    public void viewForm(SearchFormModel searchFormModel) {
        this.actions.reloadPage();
        this.actions.hover(this.actions_icon);
        this.actions.click(this.viewFormButton);
        this.actions.switchCurrentTab(1);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void formViewed(SignFormModel signFormModel) {

    }

    @Override
    public void copyAndOpen(SignFormModel signFormModel) {

    }


    @Override
    public void fillBasicInformation2025(SignFormModel signFormModel) {
        this.actions.sendKeys(this.address, signFormModel.getAddress());
        this.actions.selectByValue(this.countryDropList, signFormModel.getCountry());
        this.actions.selectByValue(this.stateDropList, signFormModel.getState());
        this.actions.sendKeys(this.city, signFormModel.getCity());
        this.actions.sendKeys(this.zipCode, signFormModel.getZipCode());
        this.actions.sendKeys(this.county, signFormModel.getCounty());
        this.actions.sendKeys(this.email, signFormModel.getEmail());
        this.actions.sendKeys(this.phoneNumber, signFormModel.getPhoneNumber());
        this.actions.sendKeys(this.employer, signFormModel.getEmployer());
        this.actions.sendKeys(this.spouseEmployer, signFormModel.getSpouseEmployer());
        this.actions.sendKeys(this.emergencyFirstName, signFormModel.getEmergencyFirstName());
        this.actions.sendKeys(this.emergencyLastName, signFormModel.getEmergencyLastName());
        this.actions.sendKeys(this.emergencyPhoneNumber, signFormModel.getEmergencyPhoneNumber());
        this.actions.sendKeys(this.hearAboutUs, signFormModel.getHearAboutUs());
        this.actions.selectRadioButton(this.questionFreeQuote, signFormModel.getFreeQuoteFromUs());
    }

    @Override
    public void proceedNext() {
        this.actions.click(this.saveAndContinue);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void addRelative2025(SignFormModel signFormModel) {
        this.actions.selectByValue(this.relation, signFormModel.getRelation());
        this.actions.sendKeys(this.relationFirstName, signFormModel.getRelativeFirstName());
        this.actions.sendKeys(this.relationLastName, signFormModel.getRelativeLastName());
        this.actions.selectByValue(this.relationGender, signFormModel.getRelativeGender());
        this.actions.sendKeys(this.relationDOB, signFormModel.getRelativeDOB());
        this.actions.sendKeys(this.relationSSN, signFormModel.getRelativeSSN());
        this.actions.selectByValue(this.relationLegalStatus, signFormModel.getRelativeLegalStatus());
        this.actions.checkbox(this.relationApplying, signFormModel.isRelationApplying());
        this.actions.click(this.saveAndAddNew);
    }

    @Override
    public void addHouseHoldSize2025(SignFormModel signFormModel) {
        this.actions.sendKeys(this.householdSize, signFormModel.getHouseHoldSize());
        this.actions.sendKeys(this.totalHouseHoldTaxableSize, signFormModel.getTotalHouseholdTaxableIncome());
        this.actions.selectRadioButton(this.povertyLineAmount, signFormModel.getPovertyLineAmount());
        this.actions.selectRadioButton(this.meetsACAStandards, signFormModel.getHealthInsuranceThatMeetsACAStandards());
        this.actions.selectRadioButton(this.medicareOrMedicaid, signFormModel.getMedicareOrMedicaid());
    }

    @Override
    public void addDoctorInfo2025(SignFormModel signFormModel) {
        this.actions.click(this.youDoctorsHospitals);
        this.actions.click(this.addDoctorsHospitals);
        this.actions.sendKeys(this.addDoctorTextArea, signFormModel.getDoctorsHospitals());
        this.actions.click(this.addButtonDoctor);
    }

    @Override
    public void addPrescriptionInfo2025(SignFormModel signFormModel) {
        this.actions.click(this.yourPrescriptions);
        this.actions.click(this.addPrescription);
        this.actions.sendKeys(this.prescriptionDosage, signFormModel.getPrescriptionSummary());
        this.actions.sendKeys(this.prescriptionSummary, signFormModel.getPrescriptionDosage());
        this.actions.click(this.addButtonPrescription);
    }

    @Override
    public void addFileAttachment(SignFormModel signFormModel) {
        if(signFormModel.isUploadFile()){
            WebElement element = Waiter.waitForElementPresent(this.uploadFile);
            this.actions.sendKeys(element, StaticAuxiliary.getFileFromPath(SupportiveContent.TEST_IMAGE_PATH.label).getAbsolutePath());
        }
    }

    @Override
    public void basicInformationFilled2025(SignFormModel signFormModel) {
        Waiter.waitForAngularLoad();
        this.assertion.assertElementEqualText(this.viewBasicInfoAddress, signFormModel.getAddress(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewBasicInfoCountry, signFormModel.getCountry(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewBasicInfoState, signFormModel.getState(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewBasicInfoCity, signFormModel.getCity(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewBasicInfoZipCode, signFormModel.getZipCode(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewBasicInfoEmail, signFormModel.getEmail(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewBasicInfoPhoneNumber, signFormModel.getPhoneNumber(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewBasicInfoEmployer, signFormModel.getEmployer(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewBasicInfoSpouseEmployer, signFormModel.getSpouseEmployer(), AssertType.HARD);
//        this.assertion.assertElementEqualText(this.viewBasicInfoHealthCoverage, signFormModel.getHealthCoverage(), AssertType.HARD);
        this.assertion.assertFieldValueEqual(this.viewBasicInfoHearAboutUs, signFormModel.getHearAboutUs(), AssertType.HARD);
        this.assertion.assertElementAttribute(this.viewBasicInfoHearAboutUs, "disabled", AssertType.SOFT);
        this.assertion.assertRadioSelection(this.viewBasicInfoFreeQuote, signFormModel.getFreeQuoteFromUs(), AssertType.HARD);
        this.assertion.assertElementAttribute(this.viewBasicInfoFreeQuoteNo, "disabled", AssertType.SOFT);
        this.assertion.assertElementAttribute(this.viewBasicInfoFreeQuoteYes, "disabled", AssertType.SOFT);
    }

    @Override
    public void relativeFilled2025(SignFormModel signFormModel, int row) {
        this.assertion.assertFormBoxValue(this.viewRelationsRelationFormBox, row, FormBox.RELATION.label, signFormModel.getRelation(), AssertType.HARD);
        this.assertion.assertFormBoxValue(this.viewRelationsRelationFormBox, row, FormBox.FULL_NAME.label, signFormModel.getRelativeFullName(), AssertType.HARD);
        this.assertion.assertFormBoxValue(this.viewRelationsRelationFormBox, row, FormBox.GENDER.label, signFormModel.getRelativeGender(), AssertType.HARD);
        this.assertion.assertFormBoxValue(this.viewRelationsRelationFormBox, row, FormBox.DATE_OF_BIRTH.label, signFormModel.getRelativeDOB(), AssertType.HARD);
        this.assertion.assertFormBoxValue(this.viewRelationsRelationFormBox, row, FormBox.SSN.label, signFormModel.getRelativeSSN(), AssertType.HARD);
        this.assertion.assertFormBoxValue(this.viewRelationsRelationFormBox, row, FormBox.LEGAL_STATUS.label, signFormModel.getRelativeLegalStatus(), AssertType.HARD);
        this.assertion.assertFormBoxValue(this.viewRelationsRelationFormBox, row, FormBox.APPLYING_STATUS.label, signFormModel.getRelativeApplyingString(), AssertType.HARD);
    }

    @Override
    public void houseHoldSizeFilled2025(SignFormModel signFormModel) {
        this.assertion.assertFieldValueEqual(this.viewHouseHoldSize, signFormModel.getHouseHoldSize(), AssertType.HARD);
        this.assertion.assertFieldValueEqual(this.viewHouseHoldTaxableIncome, signFormModel.getTotalHouseholdTaxableIncome(), AssertType.HARD);
        this.assertion.assertGridCheckboxSelected(this.viewHouseHoldGrid, Grids.HOUSEHOLD_SIZE.label, signFormModel.getHouseHoldSize(), AssertType.HARD);
        this.assertion.assertRadioSelection(this.povertyLineAmount, signFormModel.getPovertyLineAmount(), AssertType.HARD);
        this.assertion.assertRadioSelection(this.meetsACAStandards, signFormModel.getHealthInsuranceThatMeetsACAStandards(), AssertType.HARD);
        this.assertion.assertRadioSelection(this.medicareOrMedicaid, signFormModel.getMedicareOrMedicaid(), AssertType.HARD);
    }

    @Override
    public void doctorInfoFilled2025(SignFormModel signFormModel, int row) {
        this.assertion.assertSummaryGridValue(this.viewDoctorsDoctorTable, Grids.DOCTOR_HOSPITALS.label, signFormModel.getDoctorsHospitals(), row, AssertType.HARD);
        this.assertion.assertSummaryGridValue(this.viewDoctorsDoctorTable, Grids.DOCTOR_HOSPITALS_NO.label, String.valueOf(row), row, AssertType.HARD);
    }

    @Override
    public void prescriptionInfoFilled2025(SignFormModel signFormModel, int row) {
        this.assertion.assertSummaryGridValue(this.viewDoctorsPrescriptionTable, Grids.PRESCRIPTIONS.label, signFormModel.getPrescriptionSummary(), row, AssertType.HARD);
        this.assertion.assertSummaryGridValue(this.viewDoctorsPrescriptionTable, Grids.DOSAGE_PRESCRIPTION.label, signFormModel.getPrescriptionDosage(), row, AssertType.HARD);
        this.assertion.assertSummaryGridValue(this.viewDoctorsPrescriptionTable, Grids.DOCTOR_HOSPITALS_NO.label, String.valueOf(row), row, AssertType.HARD);
    }

    @Override
    public void fileAttachmentFilled(SignFormModel signFormModel, int row) {
        this.assertion.assertInputBoxValue(this.viewAttachmentsAttachment, row, SupportiveContent.TEST_IMAGE_FILE_NAME.label, AssertType.HARD);
    }

    @Override
    public void resend(SendFormModel sendFormModel) {
        this.actions.reloadPage();
        this.actions.hover(this.actions_icon);
        this.actions.click(this.resendFormButton);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void formIsResent(SearchFormModel searchFormModel) {
        this.actions.reloadPage();
        this.assertion.assertGridValue(this.formsGrid, Grids.FORM_TYPE.label, searchFormModel.getFormType(),1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.CLIENT.label, searchFormModel.getClient(),1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.YEAR.label, searchFormModel.getYear(),1, AssertType.HARD);
        this.assertion.assertGridValueMatch(this.formsGrid, Grids.SENT_DATE.label, this.dateRegex,1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.STATUS.label, searchFormModel.getStatus(),1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.SUBMITTED_AGENT.label, "",1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.SUBMITTED_DATE.label, "",1, AssertType.HARD);
    }
}
