package page_objects.forms.pages.aca;

import actions.ActionsHelper;
import actions.SeleniumActions;
import assertions.AssertionsContext;
import enums.AssertType;
import enums.product.Forms;
import enums.product.Grids;
import model_classes.forms.SearchFormModel;
import model_classes.forms.SendFormModel;
import model_classes.forms.SignFormModel;
import org.openqa.selenium.By;
import page_objects.forms.actors.FormsAgent;
import properties.Product;
import synchronization.Waiter;

public class ACAAgentFormPage extends AbstractACAFormPage implements FormsAgent {


    public ACAAgentFormPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }

    @Override
    public void navigate() {
        super.navigate();
    }

    @Override
    public void sign(SignFormModel signFormModel) {
        this.actions.checkbox(this.approveCheckbox, true);
        this.actions.selectByIndex(this.confirmationType, Integer.parseInt(Forms.CONFIRMATION_TYPE.label));
        this.actions.sendKeysSetKeys(this.confirmationDate, keysForConfirmationDate);
        this.actions.click(this.save);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void send(SendFormModel sendFormModel) {
        Waiter.waitForAngularLoad();
        actions.click(addForm);
        actions.click(forClientLink);
        Waiter.waitForElementVisible(By.cssSelector("div[class='add_new_agent_modal-head']"));
        actions.sendKeys(clientField, sendFormModel.getClient());
        actions.sendKeys(clientEmail, sendFormModel.getClientEmail());
        actions.sendKeys(clientMobile, sendFormModel.getClientMobile());
        actions.selectByValue(formYearList, sendFormModel.getFormYear());
        actions.selectByValue(formTypeList, sendFormModel.getFormType());
        actions.checkbox(prepopulateCheckbox, Boolean.parseBoolean(sendFormModel.getPrePopulate()));
        actions.sendKeys(instructionsField, sendFormModel.getClientInstructions());
        actions.click(submitButton);
//        Waiter.waitForElementInvisible(By.cssSelector("div[class='add_new_agent_modal-head']"));
    }

    @Override
    public void formNotSent(SearchFormModel searchFormModel) {
        super.formNotSent(searchFormModel);
    }

    @Override
    public void formSent(SearchFormModel searchFormModel) {
        super.formSent(searchFormModel);
    }

    @Override
    public void formSigned(SearchFormModel searchFormModel) {
        this.assertion.assertGridValue(this.formsGrid, Grids.FORM_TYPE.label, searchFormModel.getFormType(),1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.CLIENT.label, searchFormModel.getClient(),1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.YEAR.label, searchFormModel.getYear(),1, AssertType.HARD);
        this.assertion.assertGridValueMatch(this.formsGrid, Grids.SENT_DATE.label, this.dateRegex,1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.STATUS.label, searchFormModel.getStatus(),1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.SUBMITTED_AGENT.label, Product.ProductProps.agentName,1, AssertType.HARD);
        this.assertion.assertGridValueMatch(this.formsGrid, Grids.SUBMITTED_DATE.label, this.dateRegex,1, AssertType.HARD);
    }

    @Override
    public void noSign(SignFormModel signFormModel) {
        this.assertion.assertElementNotVisible(this.confirmationType, AssertType.HARD);
        this.assertion.assertElementNotVisible(this.confirmationDate, AssertType.HARD);
        this.assertion.assertElementNotVisible(this.approveCheckbox, AssertType.HARD);
    }

    @Override
    public void formViewed(SignFormModel signFormModel) {
        this.assertion.assertCheckboxChecked(this.viewFormCheckboxApproval, AssertType.HARD);
        this.assertion.assertSelectValueEqual(this.viewFormConfirmationMethod, Forms.CONFIRMATION_TYPE_LABEL.label, AssertType.HARD);
        this.assertion.assertElementValueMatch(this.viewFormConfirmationDate, Forms.CONFIRMATION_ACA_DATE_TIME.label, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.viewDownloadForm, AssertType.HARD);
        this.assertion.assertElementTextMatch(this.viewFormSubmittedDate, Forms.SUBMITTED_DATE_REGEX.label, AssertType.HARD);
        this.assertion.assertElementTextMatch(this.viewFormSubmittedTime, Forms.SUBMITTED_TIME_REGEX.label, AssertType.HARD);
        this.assertion.assertElementTextMatch(this.viewFormSubmittedIP, Forms.SUBMITTED_IP_REGEX.label, AssertType.HARD);
    }

    @Override
    public void fillBasicInformation2025(SignFormModel signFormModel) {
        super.fillBasicInformation2025(signFormModel);
    }

    @Override
    public void proceedNext() {
        super.proceedNext();
    }

    @Override
    public void addRelative2025(SignFormModel signFormModel) {
        super.addRelative2025(signFormModel);
    }

    @Override
    public void addHouseHoldSize2025(SignFormModel signFormModel) {
        super.addHouseHoldSize2025(signFormModel);
    }

    @Override
    public void addDoctorInfo2025(SignFormModel signFormModel) {
        super.addDoctorInfo2025(signFormModel);
    }

    @Override
    public void addPrescriptionInfo2025(SignFormModel signFormModel) {
        super.addPrescriptionInfo2025(signFormModel);
    }

    @Override
    public void addFileAttachment(SignFormModel signFormModel) {
        super.addFileAttachment(signFormModel);
    }

    @Override
    public void copyAndOpen(SignFormModel signFormModel) {
        this.actions.reloadPage();
        this.actions.hover(this.actions_icon);
        this.actions.click(this.copyLink);
        String link = this.actions.getClipboardValue();
        this.actions.navigate(link, false);
    }

    @Override
    public void basicInformationFilled2025(SignFormModel signFormModel) {
        super.basicInformationFilled2025(signFormModel);
    }

    @Override
    public void relativeFilled2025(SignFormModel signFormModel, int row) {
        super.relativeFilled2025(signFormModel, row);
    }

    @Override
    public void houseHoldSizeFilled2025(SignFormModel signFormModel) {
        super.houseHoldSizeFilled2025(signFormModel);
    }

    @Override
    public void doctorInfoFilled2025(SignFormModel signFormModel, int row) {
        super.doctorInfoFilled2025(signFormModel, row);
    }

    @Override
    public void prescriptionInfoFilled2025(SignFormModel signFormModel, int row) {
        super.prescriptionInfoFilled2025(signFormModel, row);
    }

    @Override
    public void fileAttachmentFilled(SignFormModel signFormModel, int row) {
        super.fileAttachmentFilled(signFormModel, row);
    }

    @Override
    public void resend(SendFormModel sendFormModel) {
        super.resend(sendFormModel);
    }

    @Override
    public void formIsResent(SearchFormModel searchFormModel) {
        super.formIsResent(searchFormModel);
    }


}
