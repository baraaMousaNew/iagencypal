package page_objects.agents.pages;

import actions.ActionsHelper;
import actions.WebActions;
import assertions.AssertionsContext;
import enums.AssertType;
import enums.product.Grids;
import enums.product.Messages;
import model_classes.agents.AgentModelClass;
import org.openqa.selenium.By;
import page_objects.agents.actors.AgentsActors;

public class AbstractAgentsPage implements AgentsActors {

    protected final String url = "/en/system/new/new-agent";

    protected final By addAgentButton = By.xpath("//app-new-agent//div[@class='table_actions-search_add']//button[contains(text(),'Add Agent')]");
    protected final By nextButton = By.xpath("//div[contains(@class,'add_new_agent_modal-footer')]//h5[contains(text(),'Next')]//parent::button");
    protected final By submitButton = By.xpath("//div[contains(@class,'add_new_agent_modal-footer')]//button//h5[contains(text(),'Submit')]");

    protected final By firstName = By.xpath("//div[@class='add_new_agent_modal-body']//input[@formcontrolname='firstName']");
    protected final By lastName = By.xpath("//div[@class='add_new_agent_modal-body']//input[@formcontrolname='lastName']");
    protected final By email = By.xpath("//div[@class='add_new_agent_modal-body']//input[@formcontrolname='email']");
    protected final By phone = By.xpath("//div[@class='add_new_agent_modal-body']//input[@formcontrolname='phone']");
    protected final By dateOfBirth = By.xpath("//div[@class='add_new_agent_modal-body']//input[@id='DOB']");
    protected final By gender = By.xpath("//div[@class='add_new_agent_modal-body']//select[@formcontrolname='genderID']");
    protected final By agency = By.xpath("//div[@class='add_new_agent_modal-body']//select[@formcontrolname='agencyID']");
    protected final By independentAgent = By.xpath("//div[@class='add_new_agent_modal-body']//input[@formcontrolname='isOutsideAgent']");

    protected final By address = By.xpath("//div[@formgroupname='addressInfoForm']//input[@formcontrolname='address']");
    protected final By country = By.xpath("//div[@formgroupname='addressInfoForm']//select[@formcontrolname='countryID']");
    protected final By state = By.xpath("//div[@formgroupname='addressInfoForm']//select[@formcontrolname='stateID']");
    protected final By city = By.xpath("//div[@formgroupname='addressInfoForm']//input[@formcontrolname='city']");
    protected final By zipCode = By.xpath("//div[@formgroupname='addressInfoForm']//input[@formcontrolname='zipCode']");
    protected final By saveAddNewButton = By.xpath("//div[@formgroupname='addressInfoForm']//div[contains(@class,'agent_info-action-form')]//button[contains(text(),'Save & Add New')]");

    protected final By role = By.xpath("//div[@formgroupname='roleTeamEmailForm']//select[@formcontrolname='roleID']");
    protected final By team = By.xpath("//div[@formgroupname='roleTeamEmailForm']//select[@formcontrolname='teamID']");
    protected final By dataSharing = By.xpath("//div[@formgroupname='roleTeamEmailForm']//input[@formcontrolname='shareData']");
    protected final By emailReplyForm = By.xpath("//div[contains(@class, 'roles_emails-roles')]//div[@class='row']");
    protected final By agentEmailOnly = By.xpath("//div[@formgroupname='roleTeamEmailForm']//input[@id='emailReplies1']");
    protected final By systemEmailOnly = By.xpath("//div[@formgroupname='roleTeamEmailForm']//input[@id='emailReplies2']");
    protected final By agentAndBrokerEmail = By.xpath("//div[@formgroupname='roleTeamEmailForm']//input[@id='emailReplies3']");

    protected final By formGrid = By.xpath("//div[@class='card-body']//div[@class='p-datatable-wrapper']//table[@role='table']");

    protected final By toasterAlertMessage = By.xpath("//div[@id='toast-container']//div[@role='alertdialog']//h6");
    protected final By savedPhoneTabPanel = By.xpath("//app-add-phone-number//div[@id='svedPhoneNumber']");
    protected final By savedEmailTabPanel = By.xpath("//app-add-email-address//div[@id='svedEmailAdress']");

    protected final By viewClient = By.cssSelector("a[title='Edit']");
    protected final By actions_icon = By.xpath("//div[contains(@class, 'action-dropdown')]//a");

    // agent profile tabs
    protected final By agentInformationTab = By.xpath("//app-new-agent-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Agent Information')]");
    protected final By agentClientsTab = By.xpath("//app-new-agent-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Clients')]");
    protected final By agentCommissionTab = By.xpath("//app-new-agent-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Commissions')]");
    protected final By agentLicenseTab = By.xpath("//app-new-agent-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'License')]");
    protected final By agentLeadsTab = By.xpath("//app-new-agent-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Leads')]");
    protected final By agentPoliciesTab = By.xpath("//app-new-agent-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Policies')]");
    protected final By agentErrorsTab = By.xpath("//app-new-agent-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Error And Omission')]");
    protected final By agentNotesTab = By.xpath("//app-new-agent-profile//div[@class='ap_profile_tabs-content']//h6[contains(text(),'Notes/Attachments')]");

    // breadcrumbs
    protected final By agentsBreadcrumbButton = By.xpath("//div[@class='ap_header_bredcrumb']//span[contains(text(),'Agents')]//parent::li[contains(@class,'breadcrumb-item')]");

    //profile content
    protected final By agentFullNameProfile = By.xpath("//app-new-agent-profile//div[@class='user_head']//h4[contains(@class,'user_name')]");
    protected final By agentEmailProfile = By.xpath("//app-new-agent-profile//div[contains(@class,'user_content')]//div[@class='user_info']//div[text()='Email Address']//parent::div//h6");
    protected final By agentPhoneProfile = By.xpath("//app-new-agent-profile//div[contains(@class,'user_content')]//div[@class='user_info']//div[text()='Phone Number']//parent::div//h6");
    protected final By agentLocationProfile = By.xpath("//app-new-agent-profile//div[contains(@class,'user_content')]//div[@class='user_info']//div[text()='Location']//parent::div//h6");
    protected final By agentActiveButton = By.xpath("//app-new-agent-profile//div[@class='user_head']//button");

    //profile boxes
    protected final By agentInformationBox = By.xpath("//div[@class='ap_profile_boxes']//div[@class='ap_profile_boxes-item']//h5[contains(text(),'Agent Information')]");
    protected final By agentPersonalInformationBox = By.xpath("//div[@class='ap_profile_boxes']//div[@class='ap_profile_boxes-item']//h5[contains(text(),'Personal Information')]");
    protected final By agentAddressInformationBox = By.xpath("//div[@class='ap_profile_boxes']//div[@class='ap_profile_boxes-item']//h5[contains(text(),'Addresses Information')]");
    protected final By agentRolesBox = By.xpath("//div[@class='ap_profile_boxes']//div[@class='ap_profile_boxes-item']//h5[contains(text(),'Roles & Teams & Email Reply')]");

    // agent information box
    protected final By agentInformationFirstName = By.xpath("//app-new-agent-personal-informations//div[@class='personal_info-form']//input[@formcontrolname='firstName']");
    protected final By agentInformationLastName = By.xpath("//app-new-agent-personal-informations//div[@class='personal_info-form']//input[@formcontrolname='lastName']");
    protected final By agentInformationEmail = By.xpath("//app-new-agent-personal-informations//div[@class='personal_info-form']//input[@formcontrolname='email']");
    protected final By agentInformationPhoneNumber = By.xpath("//app-new-agent-personal-informations//div[@class='personal_info-form']//input[@formcontrolname='phoneNumber']");
    protected final By agentInformationDateOfBirth = By.xpath("//app-new-agent-personal-informations//div[@class='personal_info-form']//input[@id='dateOfBirth']");
    protected final By agentInformationGender = By.xpath("//app-new-agent-personal-informations//div[@class='personal_info-form']//select[@formcontrolname='gender_id']");
    protected final By agentInformationAgency = By.xpath("//app-new-agent-personal-informations//div[@class='personal_info-form']//select[@formcontrolname='agency_id']");
    protected final By agentInformationIndependent = By.xpath("//app-new-agent-personal-informations//div[@class='personal_info-form']//following-sibling::div//input[@formcontrolname='isOutsideAgent']");
    protected final By agentInformationSaveButton = By.xpath("//app-new-agent-personal-informations//div[@class='add_new_agent_modal-footer']//h5[text()='Save']//parent::button");
    protected final By agentInformationAddEmailPhone = By.xpath("//app-new-agent-personal-informations//button[contains(@class,'has_dropdown')]");
    protected final By agentInformationAddEmail = By.xpath("//app-new-agent-personal-informations//button[contains(@class,'has_dropdown')]//div[@data-bs-target='#addEmailAddress']//span");
    protected final By agentInformationAddPhone = By.xpath("//app-new-agent-personal-informations//button[contains(@class,'has_dropdown')]//div[contains(@class,'dropdown_addNew-item')]//span[text()='Phone Number']");
    protected final By agentInformationSecondaryEmailField = By.xpath("//div[@id='addNewEmailAdress']//input[@formcontrolname='email']");
    protected final By agentInformationSubmitSecondaryEmail = By.xpath("//app-add-email-address//div[@class='modal-content']//button[text()='Submit']");
    protected final By agentInformationSecondaryPhoneField = By.xpath("//div[@id='addNewPhoneNumber']//input[@formcontrolname='phone']");
    protected final By agentInformationSubmitSecondaryPhone = By.xpath("//app-add-phone-number//div[@class='modal-content']//button[text()='Submit']");

    // agent personal information box
    protected final By agentSpouseName = By.xpath("//app-new-agent-informations//div[@class='personal_info-form']//input[@formcontrolname='spouseName']");
    protected final By agentAdditionalInformation = By.xpath("//app-new-agent-informations//div[@class='personal_info-form']//input[@formcontrolname='additionalInfo']");
    protected final By agentChildrenInformation = By.xpath("//app-new-agent-informations//div[@class='personal_info-form']//input[@formcontrolname='agentChildren']//parent::div//parent::div//following-sibling::div[contains(@class,'col')]");
    protected final By agentChildrenField = By.xpath("//app-new-agent-informations//div[@class='personal_info-form']//input[@formcontrolname='agentChildren']");
    protected final By addChildrenButton = By.xpath("//app-new-agent-informations//div[@class='personal_info-form']//button");
    protected final By saveAgentPersonalButton = By.xpath("//app-new-agent-personal-info//h5[text()='Save']//parent::button");


    // agent address information box
    protected final By agentAddressField = By.xpath("//app-new-agent-informations//div[@class='agent_info-form-box']//input[@formcontrolname='address']");
    protected final By agentCountryField = By.xpath("//app-new-agent-informations//div[@class='agent_info-form-box']//select[@formcontrolname='country_ID']");
    protected final By agentStateField = By.xpath("//app-new-agent-informations//div[@class='agent_info-form-box']//select[@formcontrolname='state_ID']");
    protected final By agentCityField = By.xpath("//app-new-agent-informations//div[@class='agent_info-form-box']//input[@formcontrolname='city']");
    protected final By agentZipCodeField = By.xpath("//app-new-agent-informations//div[@class='agent_info-form-box']//input[@formcontrolname='zipCode']");
    protected final By agentAddressSaveButton = By.xpath("//app-new-agent-informations//form//div[@class='add_new_agent_modal-footer']//h5[text()='Save']//parent::button");

    // agent roles
    protected final By agentRolesField = By.xpath("//app-new-agent-profile//div[@class='roles_emails-form']//select[@formcontrolname='roleID']");
    protected final By agentTeamField = By.xpath("//app-new-agent-profile//div[@class='roles_emails-form']//select[@formcontrolname='team_ID']");
    protected final By agentShareDataCheckbox = By.xpath("//app-new-agent-profile//div[contains(@class,'roles_emails-roles')]//input[@formcontrolname='shareData']");
    protected final By agentEmailReplyProfile = By.xpath("//app-new-agent-profile//h5[text()='Email Reply']//parent::div[contains(@class,'roles_emails-roles')]");
    protected final By agentRolesSaveButton = By.xpath("//app-new-agent-roles-and-teams-informations//h5[text()='Save']//parent::button");

    protected WebActions actions;
    protected AssertionsContext assertion;

    protected AbstractAgentsPage(WebActions actions, AssertionsContext assertion){
        this.actions = actions;
        this.assertion = assertion;
    }

    public AbstractAgentsPage() {
        this.actions = new ActionsHelper<>().getActions();
        this.assertion = new AssertionsContext();
    }

    @Override
    public void navigate() {
        this.actions.navigate(this.url, true);
    }

    @Override
    public void proceedNext() {
        this.actions.click(this.nextButton);
    }

    @Override
    public void viewAgentProfile() {
        this.actions.reloadPage();
        this.actions.hover(this.actions_icon);
        this.actions.click(this.viewClient);
        this.actions.switchCurrentTab(1);
    }

    @Override
    public void addAgentBasicInformation(AgentModelClass agentModelClass) {

    }

    @Override
    public void addAgentAddressInformation(AgentModelClass agentModelClass) {

    }

    @Override
    public void addAgentRolesInformation(AgentModelClass agentModelClass) {

    }

    @Override
    public void agentCreatedSuccessfully(AgentModelClass agentModelClass) {
        this.assertion.assertElementEqualText(this.toasterAlertMessage, Messages.SUCCESS_AGENT_CREATION.label, AssertType.HARD);
        this.actions.reloadPage();
        this.assertion.assertGridValue(this.formGrid, Grids.FULL_NAME.label, agentModelClass.getFullName(), 1, AssertType.HARD);
        this.assertion.assertGridValue(this.formGrid, Grids.EMAIL.label, agentModelClass.getEmail(), 1, AssertType.HARD);
        this.assertion.assertGridButtonLabel(this.formGrid, Grids.INDEPENDENT_AGENT.label, agentModelClass.getIndependentAgentString(), 1, AssertType.HARD);
        this.assertion.assertGridRadioSelected(this.formGrid, Grids.ACTIVE_STATUS.label, agentModelClass.getActiveStatus(), 1, AssertType.HARD);
    }

    @Override
    public void agentDetailsDisplaySuccessfully(AgentModelClass agentModelClass) {

    }

    @Override
    public void agentInformationDisplaySuccessfully(AgentModelClass agentModelClass) {

    }

    @Override
    public void agentPersonalInformationDisplaySuccessfully(AgentModelClass agentModelClass) {

    }

    @Override
    public void agentAddressInformationDisplaySuccessfully(AgentModelClass agentModelClass) {

    }

    @Override
    public void agentRolesDisplaySuccessfully(AgentModelClass agentModelClass) {

    }

    @Override
    public void updateAgentInformation(AgentModelClass agentModelClass) {

    }

    @Override
    public void updateAgentPersonalInformation(AgentModelClass agentModelClass) {

    }

    @Override
    public void updateAgentAddressInformation(AgentModelClass agentModelClass) {

    }

    @Override
    public void updateAgentRolesInformation(AgentModelClass agentModelClass) {

    }

    @Override
    public void addSecondaryEmail(AgentModelClass agentModelClass) {

    }

    @Override
    public void addSecondaryPhone(AgentModelClass agentModelClass) {

    }

    @Override
    public void secondaryEmailAddedSuccessfully(AgentModelClass agentModelClass) {

    }

    @Override
    public void secondaryPhoneAddedSuccessfully(AgentModelClass agentModelClass) {

    }
}
