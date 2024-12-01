package page_objects.forms.pages.credit_card;

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
import synchronization.Waiter;

public class AbstractCreditCardFormPage implements FormsActors {

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
    protected final By approveCheckbox = By.id("flexCheckDefault");
    protected final By confirmationType = By.xpath("//select[@formcontrolname='confirmationMethod']");
    protected final By confirmationDate = By.xpath("//input[@formcontrolname='approvalDate']");
    protected final By cardType = By.xpath("//select[@aria-label='Default select example']");
    protected final By cardHolderName = By.xpath("//input[@placeholder='Card Holder Name ( as shown on card )']");
    protected final By cardNumber = By.xpath("//input[@placeholder='Card Number (as shown on card)']");
    protected final By cardExpiryMonth = By.xpath("//input[@placeholder='MM']");
    protected final By cardExpiryYear = By.xpath("//input[@placeholder='YY']");
    protected final By zipCode = By.xpath("//input[@placeholder='Card Holder Zip Code']");
    protected final By viewFormButton = By.xpath("//a[@title='View Form']");
    protected final By viewFormSignatureImage = By.id("signature");
    protected final By viewFormDownloadButton = By.xpath("//div[@id='downloadButton']//a");
    protected final By viewFormSubmittedDate = By.xpath("//div[contains(@class,'date')]//div[text()=' Submitted Date & Time ']//following-sibling::div[1]");
    protected final By viewFormSubmittedTime = By.xpath("//div[contains(@class,'date')]//div[text()=' Submitted Date & Time ']//following-sibling::div[2]");
    protected final By viewFormSubmittedIP = By.xpath("//div[contains(@class,'date')]//div[text()=' Submitted IP address ']//following-sibling::div[1]");
    protected final By viewFormSendDateValue = By.xpath("//div[contains(@class,'ipal_pi_form_header')]//div[text()=' Send Date ']//following-sibling::div[@class='caption clr-gray']");

    protected final By resendFormButton = By.xpath("//a[@title='Resend submitted Form']");

    protected WebActions actions;

    protected AssertionsContext assertion;

    protected AbstractCreditCardFormPage(WebActions actions, AssertionsContext assertion){
        this.actions = new ActionsHelper<>().getActions();
        this.assertion = assertion;
    }

    public AbstractCreditCardFormPage(){
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
