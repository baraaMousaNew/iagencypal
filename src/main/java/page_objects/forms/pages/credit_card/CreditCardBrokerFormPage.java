package page_objects.forms.pages.credit_card;

import actions.ActionsHelper;
import assertions.AssertionsContext;
import enums.AssertType;
import enums.product.Grids;
import model_classes.forms.SearchFormModel;
import model_classes.forms.SendFormModel;
import model_classes.forms.SignFormModel;
import org.openqa.selenium.By;
import synchronization.Waiter;

public class CreditCardBrokerFormPage extends AbstractCreditCardFormPage{

    public CreditCardBrokerFormPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }

    @Override
    public void navigate() {
        super.navigate();
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
    public void resend(SendFormModel sendFormModel) {
        super.resend(sendFormModel);
    }

    @Override
    public void formIsResent(SearchFormModel searchFormModel) {
        super.formIsResent(searchFormModel);
    }

    @Override
    public void sign(SignFormModel signFormModel) {
        this.actions.selectByValue(this.cardType, signFormModel.getCardType());
        this.actions.sendKeys(this.cardHolderName, signFormModel.getCardHolderName());
        this.actions.sendKeys(this.cardNumber, signFormModel.getCardNumber());
        this.actions.sendKeys(this.cardExpiryMonth, signFormModel.getExpirationMonth());
        this.actions.sendKeys(this.cardExpiryYear, signFormModel.getExpirationYear());
        this.actions.sendKeys(this.zipCode, signFormModel.getCardHolderZipCode());
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
        actions.click(submitButton);
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
    public void formNotSent(SearchFormModel searchFormModel) {
        super.formNotSent(searchFormModel);
    }

    @Override
    public void formSent(SearchFormModel searchFormModel) {
        super.formSent(searchFormModel);
    }

    @Override
    public void noSign(SignFormModel signFormModel) {
        this.assertion.assertElementNotVisible(this.confirmationType, AssertType.HARD);
        this.assertion.assertElementNotVisible(this.confirmationDate, AssertType.HARD);
        this.assertion.assertElementNotVisible(this.approveCheckbox, AssertType.HARD);
    }

    @Override
    public void formViewed(SignFormModel signFormModel) {
        super.formViewed(signFormModel);
    }


}
