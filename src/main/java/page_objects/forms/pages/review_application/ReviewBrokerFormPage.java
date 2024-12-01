package page_objects.forms.pages.review_application;

import actions.ActionsHelper;
import assertions.AssertionsContext;
import auxiliary.StaticAuxiliary;
import enums.AssertType;
import enums.product.Forms;
import enums.product.SupportiveContent;
import enums.product.DateTime;
import enums.product.Grids;
import model_classes.forms.SearchFormModel;
import model_classes.forms.SendFormModel;
import model_classes.forms.SignFormModel;
import org.openqa.selenium.By;
import page_objects.forms.actors.FormsBroker;
import synchronization.Waiter;

import java.util.Objects;

public class ReviewBrokerFormPage extends AbstractReviewFormPage implements FormsBroker {

    public ReviewBrokerFormPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }

    @Override
    public void bulkSend() {

    }

    @Override
    public void navigate() {
        super.navigate();
    }

    @Override
    public void sign(SignFormModel signFormModel) {
        this.actions.checkbox(this.approveCheckbox, true);
        this.actions.selectByIndex(this.confirmationType, Integer.parseInt(Forms.CONFIRMATION_TYPE.label));
        this.actions.sendKeys(this.confirmationDate, StaticAuxiliary.getCurrentDate(DateTime.DATE_TIME_I));
        this.actions.click(this.submit);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void send(SendFormModel sendFormModel) {
        Waiter.waitForAngularLoad();
        actions.click(addForm);
        actions.click(forClientLink);
        Waiter.waitForElementVisible(By.cssSelector("div[class='add_new_agent_modal-head']"));
        actions.sendKeys(servicingAgentField, sendFormModel.getServicingAgent());
        actions.sendKeys(clientField, sendFormModel.getClient());
        actions.sendKeys(clientEmail, sendFormModel.getClientEmail());
        actions.sendKeys(clientMobile, sendFormModel.getClientMobile());
        actions.selectByValue(formYearList, sendFormModel.getFormYear());
        actions.selectByValue(formTypeList, sendFormModel.getFormType());
        actions.sendKeys(instructionsField, sendFormModel.getClientInstructions());
        if(!Objects.isNull(sendFormModel.getAttachments())){
            actions.sendKeys(file, StaticAuxiliary.getFileFromPath(SupportiveContent.TEST_IMAGE_PATH.label).getAbsolutePath());
        }
        actions.click(submitButton);
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
    public void noSign(SignFormModel signFormModel) {
        super.noSign(signFormModel);
    }

    @Override
    public void formSigned(SearchFormModel searchFormModel) {
        this.assertion.assertGridValue(this.formsGrid, Grids.FORM_TYPE.label, searchFormModel.getFormType(),1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.CLIENT.label, searchFormModel.getClient(),1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.YEAR.label, searchFormModel.getYear(),1, AssertType.HARD);
        this.assertion.assertGridValueMatch(this.formsGrid, Grids.SENT_DATE.label, this.dateRegex,1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.STATUS.label, searchFormModel.getStatus(),1, AssertType.HARD);
        this.assertion.assertGridValue(this.formsGrid, Grids.SUBMITTED_AGENT.label, searchFormModel.getSubmittedAgent(),1, AssertType.HARD);
        this.assertion.assertGridValueMatch(this.formsGrid, Grids.SUBMITTED_DATE.label, this.dateRegex,1, AssertType.HARD);
    }

    @Override
    public void formSent(SearchFormModel searchFormModel) {
        super.formSent(searchFormModel);
    }

    @Override
    public void formNotSent(SearchFormModel searchFormModel) {
        super.formNotSent(searchFormModel);
    }

    @Override
    public void formViewed(SignFormModel signFormModel) {
        super.formViewed(signFormModel);
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
