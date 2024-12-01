package page_objects.forms.pages.credit_card;

import actions.ActionsHelper;
import assertions.AssertionsContext;
import enums.AssertType;
import enums.product.Forms;
import enums.product.Messages;
import model_classes.forms.SearchFormModel;
import model_classes.forms.SendFormModel;
import model_classes.forms.SignFormModel;
import org.openqa.selenium.By;
import page_objects.forms.actors.FormsClient;

public class CreditCardClientFormPage extends AbstractCreditCardFormPage implements FormsClient {

    private By successMessage = By.xpath("//app-new-form-success//h5");

    private By alreadySentMessage = By.xpath("//div[contains(@class,'Instructions_msg')]//div[contains(@class,'caption')]");

    public CreditCardClientFormPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }

    @Override
    public void navigate() {
        super.navigate();
    }

    @Override
    public void sign(SignFormModel signFormModel) {
        this.actions.selectByValue(this.cardType, signFormModel.getCardType());
        this.actions.sendKeys(this.cardHolderName, signFormModel.getCardHolderName());
        this.actions.sendKeys(this.cardNumber, signFormModel.getCardNumber());
        this.actions.sendKeys(this.cardExpiryMonth, signFormModel.getExpirationMonth());
        this.actions.sendKeys(this.cardExpiryYear, signFormModel.getExpirationYear());
        this.actions.sendKeys(this.zipCode, signFormModel.getCardHolderZipCode());
        actions.fillSignField(this.signature);
        actions.click(this.submit);
    }

    @Override
    public void formSigned(SearchFormModel searchFormModel) {
        this.assertion.assertElementEqualText(this.successMessage, Messages.SUCCESS_CLIENT_SUBMIT.label, AssertType.HARD);
    }

    @Override
    public void formResign(SignFormModel signFormModel) {
        this.actions.reloadPage();
        this.actions.hover(this.actions_icon);
        this.actions.click(this.copyLink);
        String link = this.actions.getClipboardValue();
        this.actions.clearCache();
        this.actions.navigate(link, false);
    }

    @Override
    public void send(SendFormModel sendFormModel) {
        super.send(sendFormModel);
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
    public void formAlreadySigned(SearchFormModel searchFormModel) {
        this.assertion.assertElementEqualText(this.alreadySentMessage, Messages.SENT_ALREADY.label, AssertType.HARD);
    }

    @Override
    public void formViewed(SignFormModel signFormModel) {
        this.assertion.assertSelectValueEqual(this.cardType, signFormModel.getCardType(), AssertType.HARD);
        this.assertion.assertFieldValueEqual(this.cardHolderName, signFormModel.getCardHolderName(), AssertType.HARD);
        this.assertion.assertFieldValueEqual(this.cardNumber, signFormModel.getCardNumber(), AssertType.HARD);
        this.assertion.assertFieldValueEqual(this.cardExpiryYear, signFormModel.getExpirationYear(), AssertType.HARD);
        this.assertion.assertFieldValueEqual(this.cardExpiryMonth, signFormModel.getExpirationMonth(), AssertType.HARD);
        this.assertion.assertFieldValueEqual(this.zipCode, signFormModel.getCardHolderZipCode(), AssertType.HARD);
        this.assertion.assertElementIsVisible(this.viewFormSignatureImage, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.viewFormDownloadButton, AssertType.HARD);
        this.assertion.assertElementTextMatch(this.viewFormSubmittedDate, Forms.SUBMITTED_DATE_REGEX.label, AssertType.HARD);
        this.assertion.assertElementTextMatch(this.viewFormSubmittedTime, Forms.SUBMITTED_TIME_REGEX.label, AssertType.HARD);
        this.assertion.assertElementTextMatch(this.viewFormSubmittedIP, Forms.SUBMITTED_IP_REGEX.label, AssertType.HARD);
        this.assertion.assertElementTextMatch(this.viewFormSendDateValue, Forms.SUBMITTED_SEND_DATE_REGEX.label, AssertType.HARD);
        this.assertion.assertElementAttribute(this.cardType, "disabled", AssertType.HARD);
        this.assertion.assertElementAttribute(this.cardHolderName, "disabled", AssertType.HARD);
        this.assertion.assertElementAttribute(this.cardNumber, "disabled", AssertType.HARD);
        this.assertion.assertElementAttribute(this.cardExpiryYear, "disabled", AssertType.HARD);
        this.assertion.assertElementAttribute(this.cardExpiryMonth, "disabled", AssertType.HARD);
        this.assertion.assertElementAttribute(this.zipCode, "disabled", AssertType.HARD);
    }

    @Override
    public void copyAndOpen(SignFormModel signFormModel) {
        this.actions.reloadPage();
        this.actions.hover(this.actions_icon);
        this.actions.click(this.copyLink);
        String link = this.actions.getClipboardValue();
        this.actions.clearCache();
        this.actions.navigate(link, false);
    }
}
