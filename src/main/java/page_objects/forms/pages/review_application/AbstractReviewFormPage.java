package page_objects.forms.pages.review_application;

import actions.ActionsHelper;
import actions.SeleniumActions;
import actions.WebActions;
import assertions.AssertionsContext;
import enums.AssertType;
import enums.product.Grids;
import enums.product.Messages;
import model_classes.forms.SearchFormModel;
import model_classes.forms.SendFormModel;
import model_classes.forms.SignFormModel;
import org.openqa.selenium.By;
import page_objects.forms.actors.FormsActors;
import page_objects.forms.customs.review_application.ReviewApplicationCustom;
import synchronization.Waiter;

public class AbstractReviewFormPage implements FormsActors, ReviewApplicationCustom {

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
    protected final By instructionsField = By.cssSelector("textarea[formcontrolname='instructions']");
    protected final By submitButton = By.cssSelector("button[type='submit']");
    protected final By saveButton = By.id("saveButton");
    protected final By addForm = By.cssSelector("div[class='table_actions-search_add-add'] button[class*='btn btn-primary has_dropdown']");
    protected final By forClientLink = By.xpath("//app-new-data-table-send-form-dropdown//ul[@class='list-unstyled']//li");
    protected final By actions_icon = By.xpath("//div[contains(@class, 'action-dropdown')]//a");
    protected final By signature = By.xpath("//app-signature//canvas");
    protected final By submit = By.cssSelector("button[class*='btn-primary']");
    protected final String dateRegex = "\\d{1,2}/\\d{1,2}/\\d{2},\\s\\d{1,2}:\\d{2}\\s(?:AM|PM)";
    protected final By addFormDialog = By.cssSelector("div[class='add_new_agent_modal-head']");
    protected final By toasterAlertMessage = By.xpath("//div[@id='toast-container']//div[@role='alertdialog']//h6");
    protected final By approveCheckbox = By.id("approval");
    protected final By confirmationType = By.id("confirmationMethod");
    protected final By confirmationDate = By.xpath("//input[@formcontrolname='approvalDate']");
    protected final By file = By.id("file");
    protected final By viewFormButton = By.xpath("//a[@title='View Form']");
    protected final By viewFormEmailHeading = By.xpath("//h6[text()='Email']//following-sibling::div");
    protected final By viewFormClientHeading = By.xpath("//h6[text()='Client']//following-sibling::div");
    protected final By viewFormClientFormType = By.xpath("//h6[text()='Form Type']//following-sibling::div");
    protected final By viewFormClientMobile = By.xpath("//h6[text()='Phone']//following-sibling::div");
    protected final By viewFormClientServingAgent = By.xpath("//h6[text()='Serving Agent']//following-sibling::div");
    protected final By viewFormAppointmentStatus = By.xpath("//h6[text()='Appointment Status']//following-sibling::div");
    protected final By viewFormAppointmentStatusDroplist = By.xpath("//h6[text()='Appointment Status']//following-sibling::select");
    protected final By viewFormDownloadButton = By.xpath("//div[@id='downloadButton1']//a");
    protected final By viewFormDownloadAttachment = By.xpath("//a[@id='downloadButton']");
    protected final By viewFormAttachmentFile = By.xpath("//h6[text()='Attachments']//following-sibling::div[contains(@class,'file_name')]//h6");
    protected final By viewFormApplicantNameLabel = By.xpath("//div[@class='table_inner_costome-table']//div[@class='head'][1]");
    protected final By viewFormApplicantNameValue = By.xpath("//div[@class='table_inner_costome-table']//div[@class='cell clr-gray'][1]");
    protected final By viewFormYearOfEnrollmentLabel = By.xpath("//div[@class='table_inner_costome-table']//div[@class='head'][2]");
    protected final By viewFormYearOfEnrollmentValue = By.xpath("//div[@class='table_inner_costome-table']//div[@class='cell clr-gray'][2]");
    protected final By viewFormApplicantsAgentLabel = By.xpath("//div[@class='table_inner_costome-table']//div[@class='head'][3]");
    protected final By viewFormApplicantAgentValue = By.xpath("//div[@class='table_inner_costome-table']//div[@class='cell clr-gray'][3]");
    protected final By viewFormSignatureImg = By.xpath("//div[contains(@class,'signature_box')]//img[contains(@class,'border-dark')]");
    protected final By viewFormSubmittedDateTimeLabel = By.xpath("//div[contains(@class,'signature_box')]//div[contains(@class,'date')][1]//div[1]");
    protected final By viewFormSubmittedDate = By.xpath("//div[contains(@class,'signature_box')]//div[contains(@class,'date')][1]//div[2]");
    protected final By viewFormSubmittedTime = By.xpath("//div[contains(@class,'signature_box')]//div[contains(@class,'date')][1]//div[3]");
    protected final By viewFormSubmittedIPLabel = By.xpath("//div[contains(@class,'signature_box')]//div[contains(@class,'date')][2]//div[1]");
    protected final By viewFormSubmittedIPValue = By.xpath("//div[contains(@class,'signature_box')]//div[contains(@class,'date')][2]//div[2]");
    protected final By viewFormSendDateLabel = By.xpath("//div[contains(@class,'ipal_pi_form_box')]//div[@class='caption']");
    protected final By viewFormSendDateValue = By.xpath("//div[contains(@class,'ipal_pi_form_box')]//div[@class='caption clr-gray']");

    protected final By clientYearBirth = By.cssSelector("input[formcontrolname='birthDate']");
    protected final By clientLastName = By.cssSelector("input[formcontrolname='lastName']");
    protected final By loginButton = By.cssSelector("button[class*='Login']");

    protected final By resendFormButton = By.xpath("//a[@title='Resend submitted Form']");

    protected WebActions actions;

    protected AssertionsContext assertion;

    protected AbstractReviewFormPage(WebActions actions, AssertionsContext assertion){
        this.actions = new ActionsHelper<>().getActions();
        this.assertion = assertion;
    }

    public AbstractReviewFormPage(){
        this.actions = new SeleniumActions();
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
