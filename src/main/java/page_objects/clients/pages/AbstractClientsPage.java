package page_objects.clients.pages;

import actions.ActionsHelper;
import actions.WebActions;
import assertions.AssertionsContext;
import enums.AssertType;
import enums.product.Actors;
import enums.product.Breadcrumbs;
import model_classes.clients.ClientModelClass;
import org.openqa.selenium.By;
import page_objects.clients.actors.ClientsActors;
import synchronization.Waiter;

public class AbstractClientsPage implements ClientsActors {

    protected final String url = "/en/system/new/new-client";

    protected final By addClientPanel = By.xpath("//div[@class='add_new_agent_modal-content']");
    protected final By clientSuccessPanel = By.xpath("//div[@class='add_new_client_modal-success-body']");
    protected final By clientSuccessText = By.xpath("//div[@class='add_new_client_modal-success-body']//h3");
    protected final By doItLaterButton = By.xpath("//div[@class='add_new_client_modal-success-footer']//button[contains(text(),'do it later')]");

    protected final By addClient = By.xpath("//div[@class='table_actions-search_add']//button[contains(text(),'Add Client')]");
    protected final By servicingAgent = By.xpath("//p-autocomplete[@formcontrolname='agentId']//input[@role='searchbox']");
    protected final By clientFirstName = By.xpath("//input[@formcontrolname='firstName']");
    protected final By clientLastName = By.xpath("//input[@formcontrolname='lastName']");
    protected final By clientEmail = By.xpath("//input[@formcontrolname='email']");
    protected final By clientDOB = By.xpath("//input[@formcontrolname='DOB']");
    protected final By clientGender = By.xpath("//select[@formcontrolname='genderID']");
    protected final By clientPhoneNumber = By.xpath("//input[@formcontrolname='phone']");
    protected final By nextButton = By.xpath("//div[@class='add_new_agent_modal-content']//div[contains(@class,'add_new_agent_modal-footer')]//button");

    protected final By saveAddNewAddress = By.xpath("//button[contains(text(),'Save & Add New')]");
    protected final By address = By.xpath("//input[@formcontrolname='address']");
    protected final By city = By.xpath("//input[@formcontrolname='city']");
    protected final By zipCode = By.xpath("//input[@formcontrolname='zipCode']");
    protected final By country = By.xpath("//select[@formcontrolname='countryID']");
    protected final By state = By.xpath("//select[@formcontrolname='stateID']");

    protected final By ssn = By.xpath("//input[@formcontrolname='SSN']");
    protected final By driverLicense = By.xpath("//input[@formcontrolname='driverLicense']");
    protected final By status = By.xpath("//select[@formcontrolname='statusID']");
    protected final By type = By.xpath("//select[@formcontrolname='typeID']");
    protected final By group = By.xpath("//p-autocomplete[@formcontrolname='groupID']//input[@role='searchbox']");
    protected final By submit = By.xpath("//div[@class='add_new_agent_modal-content']//div[contains(@class,'add_new_agent_modal-footer')]//button");

    protected final By grid = By.xpath("//div[@class='card']//p-table[@sortmode='multiple']//table[@role='table']");

    protected final By viewClient = By.cssSelector("a[title='Edit']");
    protected final By actions_icon = By.xpath("//div[contains(@class, 'action-dropdown')]//a");

    // profile
    protected final By profileClientEmail = By.xpath("//app-new-client-information//div[@class='ap_profile-profile_info']//div[@class='user_info']//div[text()='Email Address']//following-sibling::h6");
    protected final By profileClientPhone = By.xpath("//app-new-client-information//div[@class='ap_profile-profile_info']//div[@class='user_info']//div[text()='Phone Number']//following-sibling::h6");
    protected final By profileClientAccountStatus = By.xpath("//app-new-client-information//div[@class='ap_profile-profile_info']//div[@class='user_info']//div[text()='Account Status']//following-sibling::h6");
    protected final By profileClientLocation = By.xpath("//app-new-client-information//div[@class='ap_profile-profile_info']//div[@class='user_info']//div[text()='Location']//following-sibling::h6");
    protected final By profileClientName = By.xpath("//app-new-client-information//div[@class='user_head']//h4");
    protected final By profileInformationBox = By.xpath("//app-new-client-information//div[@class='ap_profile_boxes']//div[@class='ap_profile_boxes-item']//h5[contains(text(),'Personal Information')]");
    protected final By profileAddressInfoBox = By.xpath("//app-new-client-information//div[@class='ap_profile_boxes']//div[@class='ap_profile_boxes-item']//h5[contains(text(),'Addresses Information')]");
    protected final By profileSensitiveBox = By.xpath("//app-new-client-information//div[@class='ap_profile_boxes']//div[@class='ap_profile_boxes-item']//h5[contains(text(),'Sensitive Info')]");

    protected final By profileBreadcrumbFirstPart = By.xpath("//div[@class='ap_header_bredcrumb']//ul//li[1]//span");
    protected final By profileBreadcrumbSecondPart = By.xpath("//div[@class='ap_header_bredcrumb']//ul//li[2]//span");
    protected final By profileBreadcrumbThirdPart = By.xpath("//div[@class='ap_header_bredcrumb']//ul//li[3]//span");

    protected final By profileClientFormsTab = By.xpath("//app-new-client-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Client Forms')]");
    protected final By profileClientInformationTab = By.xpath("//app-new-client-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Client's Information')]");
    protected final By profileClientGroupsTab = By.xpath("//app-new-client-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Client Groups')]");
    protected final By profileClientRelationsTab = By.xpath("//app-new-client-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Client Relation')]");
    protected final By profileClientPoliciesTab = By.xpath("//app-new-client-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Policies')]");
    protected final By profileClientLeadsTab = By.xpath("//app-new-client-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Leads')]");
    protected final By profileClientNotesTab = By.xpath("//app-new-client-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Notes/Attachments')]");

    protected final By profilePersonalServicingAgent = By.xpath("//div[@class='personal_info-form']//p-autocomplete[@formcontrolname='agent_id']//input[@role='searchbox']");
    protected final By profilePersonalClientFirstName = By.xpath("//div[@class='personal_info-form']//input[@formcontrolname='firstName']");
    protected final By profilePersonalClientLastName = By.xpath("//div[@class='personal_info-form']//input[@formcontrolname='lastName']");
    protected final By profilePersonalClientEmail = By.xpath("//div[@class='personal_info-form']//input[@formcontrolname='email']");
    protected final By profilePersonalClientDOB = By.xpath("//div[@class='personal_info-form']//input[@formcontrolname='dateOfBirth']");
    protected final By profilePersonalClientGender = By.xpath("//div[@class='personal_info-form']//select[@formcontrolname='gender_id']");
    protected final By profilePersonalClientPhoneNumber = By.xpath("//div[@class='personal_info-form']//input[@formcontrolname='phoneNumber']");
    protected final By profilePersonalSaveButton = By.xpath("//app-new-client-personal-information//h5[text()='Save']//parent::button");
    protected final By profilePersonalDialogConfirm = By.xpath("//app-new-client-personal-information//div[@class='modal-dialog']//div[contains(@class,'confirm_modal-footer')]//button[text()='Confirm']");
    protected final By profilePersonalDialog = By.xpath("//app-new-client-personal-information//div[@class='modal-dialog']//div[@class='modal-content']");

    protected final By profileAddress = By.xpath("//div[@class='agent_info-form-box']//input[@formcontrolname='address']");
    protected final By profileCity = By.xpath("//div[@class='agent_info-form-box']//input[@formcontrolname='city']");
    protected final By profileZipCode = By.xpath("//div[@class='agent_info-form-box']//input[@formcontrolname='zipCode']");
    protected final By profileCountry = By.xpath("//div[@class='agent_info-form-box']//select[@formcontrolname='country_ID']");
    protected final By profileState = By.xpath("//div[@class='agent_info-form-box']//select[@formcontrolname='state_ID']");
    protected final By profileAddressSaveButton = By.xpath("//app-default-address-form//h5[text()='Save']//parent::button");

    protected final By profileSsn = By.xpath("//div[@class='roles_emails-form']//input[@formcontrolname='SSN']");
    protected final By profileDriverLicense = By.xpath("//div[@class='roles_emails-form']//input[@formcontrolname='driverLicense']");
    protected final By profileClientStatus = By.xpath("//div[@class='roles_emails-form']//select[@formcontrolname='status_ID']");
    protected final By profileType = By.xpath("//div[@class='roles_emails-form']//select[@formcontrolname='type_ID']");
    protected final By profileSensitiveSaveButton = By.xpath("//app-new-client-privacy//h5[text()='Save']//parent::button");

    protected WebActions actions;
    protected AssertionsContext assertion;

    protected AbstractClientsPage(WebActions actions, AssertionsContext assertion){
        this.actions = actions;
        this.assertion = assertion;
    }

    public AbstractClientsPage() {
        this.actions = new ActionsHelper<>().getActions();
        this.assertion = new AssertionsContext();
    }

    @Override
    public void navigate() {
        this.actions.navigate(this.url, true);
    }

    @Override
    public void addClientBasicInfo(ClientModelClass clientModelClass) {

    }

    @Override
    public void addClientAddressInfo(ClientModelClass clientModelClass) {
        this.actions.sendKeys(this.address, clientModelClass.getAddress());
        this.actions.selectByValue(this.country, clientModelClass.getCountry());
        this.actions.selectByValue(this.state, clientModelClass.getState());
        this.actions.sendKeys(this.city, clientModelClass.getCity());
        this.actions.sendKeys(this.zipCode, clientModelClass.getZipCode());
        this.actions.click(this.saveAddNewAddress);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void nextFromAddress() {
        this.actions.click(this.nextButton);
    }

    @Override
    public void addClientSensitiveData(ClientModelClass clientModelClass) {
        this.actions.sendKeys(this.ssn, clientModelClass.getSsn());
        this.actions.sendKeys(this.driverLicense, clientModelClass.getDriverLicense());
        this.actions.selectByValue(this.status, clientModelClass.getStatus());
        this.actions.selectByValue(this.type, clientModelClass.getType());
        this.actions.sendKeys(this.group, clientModelClass.getGroup());
        this.actions.click(this.submit);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void clientDetailsDisplaySuccessfully(ClientModelClass clientModelClass) {

    }

    @Override
    public void viewClientProfile() {
        this.actions.reloadPage();
        this.actions.hover(this.actions_icon);
        this.actions.click(this.viewClient);
        this.actions.switchCurrentTab(1);
    }

    @Override
    public void profileDetailsDisplaySuccessfully(ClientModelClass clientModelClass) {
        this.assertion.assertElementEqualText(this.profileClientName, clientModelClass.getFullName(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.profileClientEmail, clientModelClass.getEmail(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.profileClientPhone, clientModelClass.getPhoneNumber(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.profileClientAccountStatus, clientModelClass.getAccountStatus(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.profileClientLocation, clientModelClass.getLocation(), AssertType.HARD);
        this.assertion.assertElementIsVisible(this.profileInformationBox, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.profileAddressInfoBox, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.profileSensitiveBox, AssertType.HARD);
        this.assertion.assertElementEqualText(this.profileBreadcrumbFirstPart, Actors.CLIENT.label, AssertType.HARD);
        this.assertion.assertElementEqualText(this.profileBreadcrumbSecondPart, clientModelClass.getFullName(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.profileBreadcrumbThirdPart, Breadcrumbs.CLIENT_INFORMATION.label, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.profileClientFormsTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.profileClientInformationTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.profileClientGroupsTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.profileClientLeadsTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.profileClientNotesTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.profileClientPoliciesTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.profileClientRelationsTab, AssertType.HARD);
    }

    @Override
    public void profilePersonalInformationDisplaySuccessfully(ClientModelClass clientModelClass) {

    }

    @Override
    public void profileAddressInformationDisplaySuccessfully(ClientModelClass clientModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.profileAddressInfoBox);
        Waiter.waitForAngularLoad();
        this.assertion.assertFieldValueEqual(this.profileAddress, clientModelClass.getAddress(), AssertType.HARD);
        this.assertion.assertElementNotEditable(this.profileAddress, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profileCountry, clientModelClass.getCountry(), AssertType.HARD);
        this.assertion.assertElementNotEditable(this.profileCountry, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profileState, clientModelClass.getState(), AssertType.HARD);
        this.assertion.assertElementNotEditable(this.profileState, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profileCity, clientModelClass.getCity(), AssertType.HARD);
        this.assertion.assertElementNotEditable(this.profileCity, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profileZipCode, clientModelClass.getZipCode(), AssertType.HARD);
        this.assertion.assertElementNotEditable(this.profileZipCode, AssertType.SOFT);
    }

    @Override
    public void profileSensitiveDataDisplaySuccessfully(ClientModelClass clientModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.profileSensitiveBox);
        Waiter.waitForAngularLoad();
        this.assertion.assertFieldValueEqual(this.profileSsn, clientModelClass.getSsn(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.profileSsn, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profileDriverLicense, clientModelClass.getDriverLicense(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.profileDriverLicense, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profileClientStatus, clientModelClass.getStatus(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.profileClientStatus, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profileType, clientModelClass.getType(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.profileType, AssertType.SOFT);
    }

    @Override
    public void updatePersonalInformation(ClientModelClass clientModelClass) {

    }

    @Override
    public void updateAddressInformation(ClientModelClass clientModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.profileAddressInfoBox);
        Waiter.waitForAngularLoad();
        this.actions.sendKeys(this.profileAddress, clientModelClass.getAddress());
        this.actions.selectByValue(this.profileCountry, clientModelClass.getCountry());
        this.actions.selectByValue(this.profileState, clientModelClass.getState());
        this.actions.sendKeys(this.profileCity, clientModelClass.getCity());
        this.actions.sendKeys(this.profileZipCode, clientModelClass.getZipCode());
        this.actions.click(this.profileAddressSaveButton);
    }

    @Override
    public void updateSensitiveInformation(ClientModelClass clientModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.profileSensitiveBox);
        Waiter.waitForAngularLoad();
        this.actions.sendKeys(this.profileSsn, clientModelClass.getSsn());
        this.actions.sendKeys(this.profileDriverLicense, clientModelClass.getDriverLicense());
        this.actions.selectByValue(this.profileClientStatus, clientModelClass.getStatus());
        this.actions.selectByValue(this.profileType, clientModelClass.getType());
        this.actions.click(this.profileSensitiveSaveButton);
    }
}
