package page_objects.agents.pages;

import actions.ActionsHelper;
import assertions.AssertionsContext;
import enums.AssertType;
import enums.product.Forms;
import enums.product.Messages;
import enums.product.TabularContent;
import model_classes.agents.AgentModelClass;
import page_objects.agents.actors.AgentsBroker;
import synchronization.Waiter;

public class AgentsBrokerPage extends AbstractAgentsPage implements AgentsBroker {

    public AgentsBrokerPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }

    @Override
    public void addAgentBasicInformation(AgentModelClass agentModelClass) {
        this.actions.click(this.addAgentButton);
        this.actions.sendKeys(this.firstName, agentModelClass.getFirstName());
        this.actions.sendKeys(this.lastName, agentModelClass.getLastName());
        this.actions.sendKeys(this.email, agentModelClass.getEmail());
        this.actions.sendKeys(this.phone, agentModelClass.getPhoneNumber());
        this.actions.sendKeys(this.dateOfBirth, agentModelClass.getDateOfBirth());
        this.actions.selectByValue(this.gender, agentModelClass.getGender());
        this.actions.selectByValue(this.agency, agentModelClass.getAgency());
        this.actions.checkbox(this.independentAgent, agentModelClass.isIndependentAgent());
    }

    @Override
    public void addAgentAddressInformation(AgentModelClass agentModelClass) {
//        this.actions.click(this.nextButton);
        this.actions.sendKeys(this.address, agentModelClass.getAddress());
        this.actions.selectByValue(this.country, agentModelClass.getCountry());
        this.actions.selectByValue(this.state, agentModelClass.getState());
        this.actions.sendKeys(this.city, agentModelClass.getCity());
        this.actions.sendKeys(this.zipCode, agentModelClass.getZipCode());
        this.actions.click(this.saveAddNewButton);
    }

    @Override
    public void addAgentRolesInformation(AgentModelClass agentModelClass) {
        this.actions.selectByValue(this.role, agentModelClass.getRole());
        this.actions.selectByValue(this.team, agentModelClass.getTeam());
        this.actions.checkbox(this.dataSharing, agentModelClass.isAllowDataSharing());
        this.actions.selectRadioButton(this.emailReplyForm, agentModelClass.getEmailReply());
        this.actions.click(this.submitButton);
    }

    @Override
    public void agentDetailsDisplaySuccessfully(AgentModelClass agentModelClass) {
        this.assertion.assertElementIsVisible(this.agentInformationTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.agentClientsTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.agentCommissionTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.agentLicenseTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.agentLeadsTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.agentPoliciesTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.agentErrorsTab, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.agentNotesTab, AssertType.HARD);
        this.assertion.assertElementIsClickable(this.agentsBreadcrumbButton, AssertType.SOFT);
        this.assertion.assertElementEqualText(this.agentFullNameProfile, agentModelClass.getFullName(), AssertType.SOFT);
        this.assertion.assertElementEqualText(this.agentEmailProfile, agentModelClass.getEmail(), AssertType.SOFT);
        this.assertion.assertElementEqualText(this.agentPhoneProfile, agentModelClass.getPhoneNumber(), AssertType.SOFT);
        this.assertion.assertElementEqualText(this.agentLocationProfile, agentModelClass.getLocation(), AssertType.SOFT);
        this.assertion.assertElementIsVisible(this.agentActiveButton, AssertType.SOFT);
        this.assertion.assertElementIsVisible(this.agentInformationBox, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.agentPersonalInformationBox, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.agentAddressInformationBox, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.agentRolesBox, AssertType.HARD);
    }

    @Override
    public void agentInformationDisplaySuccessfully(AgentModelClass agentModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.agentInformationBox);
        Waiter.waitForAngularLoad();
        this.assertion.assertFieldValueEqual(this.agentInformationFirstName, agentModelClass.getFirstName(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.agentInformationFirstName, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.agentInformationLastName, agentModelClass.getLastName(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.agentInformationLastName, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.agentInformationEmail, agentModelClass.getEmail(), AssertType.HARD);
        this.assertion.assertElementNotEditable(this.agentInformationEmail, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.agentInformationPhoneNumber, agentModelClass.getPhoneNumber(), AssertType.HARD);
        this.assertion.assertElementNotEditable(this.agentInformationPhoneNumber, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.agentInformationDateOfBirth, agentModelClass.getDateOfBirth(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.agentInformationDateOfBirth, AssertType.SOFT);
        this.assertion.assertSelectValueEqual(this.agentInformationGender, agentModelClass.getGender(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.agentInformationGender, AssertType.SOFT);
        this.assertion.assertSelectValueEqual(this.agentInformationAgency, agentModelClass.getAgency(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.agentInformationAgency, AssertType.SOFT);
        this.assertion.assertCheckboxStatus(this.agentInformationIndependent, agentModelClass.isIndependentAgent(), AssertType.HARD);
        this.assertion.assertElementIsVisible(this.agentInformationSaveButton, AssertType.HARD);
        this.assertion.assertElementIsClickable(this.agentInformationSaveButton, AssertType.SOFT);
    }

    @Override
    public void agentPersonalInformationDisplaySuccessfully(AgentModelClass agentModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.agentPersonalInformationBox);
        Waiter.waitForAngularLoad();
        this.assertion.assertFieldValueEqual(this.agentSpouseName, agentModelClass.getSpouse(), AssertType.HARD);
        this.assertion.assertFieldValueEqual(this.agentAdditionalInformation, agentModelClass.getAdditionalInfo(), AssertType.HARD);
        this.assertion.assertDivContains(this.agentChildrenInformation, agentModelClass.getChild(), AssertType.HARD);
        this.assertion.assertElementIsVisible(this.addChildrenButton, AssertType.HARD);
    }

    @Override
    public void agentAddressInformationDisplaySuccessfully(AgentModelClass agentModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.agentAddressInformationBox);
        Waiter.waitForAngularLoad();
        this.assertion.assertFieldValueEqual(this.agentAddressField, agentModelClass.getAddress(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.agentAddressField, AssertType.SOFT);
        this.assertion.assertSelectValueEqual(this.agentCountryField, agentModelClass.getCountry(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.agentCountryField, AssertType.SOFT);
        this.assertion.assertSelectValueEqual(this.agentStateField, agentModelClass.getState(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.agentStateField, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.agentCityField, agentModelClass.getCity(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.agentCityField, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.agentZipCodeField, agentModelClass.getZipCode(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.agentZipCodeField, AssertType.SOFT);
        this.assertion.assertElementIsVisible(this.agentAddressSaveButton, AssertType.HARD);
    }

    @Override
    public void agentRolesDisplaySuccessfully(AgentModelClass agentModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.agentRolesBox);
        Waiter.waitForAngularLoad();
        this.assertion.assertSelectValueEqual(this.agentRolesField, agentModelClass.getRole(), AssertType.HARD);
        this.assertion.assertSelectValueEqual(this.agentTeamField, agentModelClass.getTeam(), AssertType.HARD);
        this.assertion.assertCheckboxStatus(this.agentShareDataCheckbox, agentModelClass.isAllowDataSharing(), AssertType.HARD);
        this.assertion.assertRadioSelection(this.agentEmailReplyProfile, agentModelClass.getEmailReply(), AssertType.HARD);
    }

    @Override
    public void updateAgentInformation(AgentModelClass agentModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.agentInformationBox);
        Waiter.waitForAngularLoad();
        this.actions.sendKeys(this.agentInformationFirstName, agentModelClass.getFirstName());
        this.actions.sendKeys(this.agentInformationLastName, agentModelClass.getLastName());
        this.actions.sendKeys(this.agentInformationEmail, agentModelClass.getEmail());
        this.actions.sendKeys(this.agentInformationPhoneNumber, agentModelClass.getPhoneNumber());
        this.actions.sendKeys(this.agentInformationDateOfBirth, agentModelClass.getDateOfBirth());
        this.actions.selectByValue(this.agentInformationGender, agentModelClass.getGender());
        this.actions.selectByValue(this.agentInformationAgency, agentModelClass.getAgency());
        this.actions.checkbox(this.agentInformationIndependent, agentModelClass.isIndependentAgent());
        this.actions.click(this.agentInformationSaveButton);
    }

    @Override
    public void updateAgentPersonalInformation(AgentModelClass agentModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.agentPersonalInformationBox);
        Waiter.waitForAngularLoad();
        this.actions.sendKeys(this.agentSpouseName, agentModelClass.getSpouse());
        this.actions.sendKeys(this.agentAdditionalInformation, agentModelClass.getAdditionalInfo());
        this.actions.sendKeysAndClick(this.agentChildrenField, this.addChildrenButton, agentModelClass.getChild());
        this.actions.click(this.saveAgentPersonalButton);
    }

    @Override
    public void updateAgentAddressInformation(AgentModelClass agentModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.agentAddressInformationBox);
        Waiter.waitForAngularLoad();
        this.actions.sendKeys(this.agentAddressField, agentModelClass.getAddress());
        this.actions.selectByValue(this.agentCountryField, agentModelClass.getCountry());
        this.actions.selectByValue(this.agentStateField, agentModelClass.getState());
        this.actions.sendKeys(this.agentCityField, agentModelClass.getCity());
        this.actions.sendKeys(this.agentZipCodeField, agentModelClass.getZipCode());
        this.actions.click(this.agentAddressSaveButton);
    }

    @Override
    public void updateAgentRolesInformation(AgentModelClass agentModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.agentRolesBox);
        Waiter.waitForAngularLoad();
        this.actions.selectByValue(this.agentRolesField, agentModelClass.getRole());
        this.actions.selectByValue(this.agentTeamField, agentModelClass.getTeam());
        this.actions.checkbox(this.agentShareDataCheckbox, agentModelClass.isAllowDataSharing());
        this.actions.selectRadioButton(this.agentEmailReplyProfile, agentModelClass.getEmailReply());
        this.actions.click(this.agentRolesSaveButton);
    }

    @Override
    public void addSecondaryEmail(AgentModelClass agentModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.agentInformationBox);
        Waiter.waitForAngularLoad();
        this.actions.click(this.agentInformationAddEmailPhone);
        this.actions.click(this.agentInformationAddEmail);
        this.actions.sendKeys(this.agentInformationSecondaryEmailField, agentModelClass.getEmail());
        this.actions.click(this.agentInformationSubmitSecondaryEmail);
        //still to capture the success message

    }

    @Override
    public void addSecondaryPhone(AgentModelClass agentModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.agentInformationBox);
        Waiter.waitForAngularLoad();
        this.actions.click(this.agentInformationAddEmailPhone);
        this.actions.click(this.agentInformationAddPhone);
        this.actions.sendKeys(this.agentInformationSecondaryPhoneField, agentModelClass.getEmail());
        this.actions.click(this.agentInformationSubmitSecondaryPhone);
        //still to capture the success message
    }

    @Override
    public void secondaryEmailAddedSuccessfully(AgentModelClass agentModelClass) {
        Waiter.waitForAngularLoad();
        this.assertion.assertElementEqualText(this.toasterAlertMessage, Messages.EMAIL_ADDED.label, AssertType.HARD);
        this.assertion.assertTabPanel(this.savedEmailTabPanel, TabularContent.TEXT, Forms.SAVED_EMAIL_ADDRESS.label, agentModelClass.getEmail(), 2, AssertType.HARD);
        this.assertion.assertTabPanel(this.savedEmailTabPanel, TabularContent.CHECKBOX, Forms.DEFAULT.label, false, 2, AssertType.HARD);
        this.assertion.assertTabPanel(this.savedEmailTabPanel, TabularContent.CHECKBOX, Forms.SECONDARY.label, true, 2, AssertType.HARD);
        this.assertion.assertTabPanel(this.savedEmailTabPanel, TabularContent.IMAGE, Forms.REMOVE.label, true, 2, AssertType.HARD);
    }

    @Override
    public void secondaryPhoneAddedSuccessfully(AgentModelClass agentModelClass) {
        Waiter.waitForAngularLoad();
        this.assertion.assertElementEqualText(this.toasterAlertMessage, Messages.PHONE_ADDED.label, AssertType.HARD);
        this.assertion.assertTabPanel(this.savedEmailTabPanel, TabularContent.TEXT, Forms.SAVED_PHONE_NUMBER.label, agentModelClass.getEmail(), 2, AssertType.HARD);
        this.assertion.assertTabPanel(this.savedEmailTabPanel, TabularContent.CHECKBOX, Forms.DEFAULT.label, false, 2, AssertType.HARD);
        this.assertion.assertTabPanel(this.savedEmailTabPanel, TabularContent.CHECKBOX, Forms.SECONDARY.label, true, 2, AssertType.HARD);
        this.assertion.assertTabPanel(this.savedEmailTabPanel, TabularContent.IMAGE, Forms.REMOVE.label, true, 2, AssertType.HARD);
    }
}
