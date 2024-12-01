package page_objects.forms.pages.pii;

import actions.ActionsHelper;
import actions.SeleniumActions;
import assertions.AssertionsContext;
import com.beust.ah.A;
import enums.AssertType;
import enums.product.Forms;
import enums.product.Messages;
import model_classes.forms.SearchFormModel;
import model_classes.forms.SignFormModel;
import org.openqa.selenium.By;
import page_objects.forms.actors.FormsClient;
import synchronization.Waiter;

public class PIIClientFormPage extends AbstractPIIFormPage implements FormsClient {


    private By successMessage = By.xpath("//app-new-form-success//h5");

    private By alreadySentMessage = By.xpath("//div[contains(@class,'Instructions_msg')]//div[contains(@class,'caption')]");

    public PIIClientFormPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }

    @Override
    public void navigate() {
        super.navigate();
    }

    @Override
    public void sign(SignFormModel signFormModel) {
        actions.fillSignField(this.signature);
        actions.click(this.submit);
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
    public void formAlreadySigned(SearchFormModel searchFormModel) {
        this.assertion.assertElementEqualText(this.alreadySentMessage, Messages.SENT_ALREADY.label, AssertType.HARD);
    }

    @Override
    public void formViewed(SignFormModel signFormModel) {
        this.assertion.assertElementEqualText(this.viewFormClientFormType, signFormModel.getFormType(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewFormEmailHeading, signFormModel.getEmail(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewFormClientMobile, signFormModel.getPhoneNumber(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewFormClientHeading, signFormModel.getClient(), AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewFormClientServingAgent, signFormModel.getServingAgent(), AssertType.HARD);
        this.assertion.assertElementIsVisible(this.viewFormAppointmentStatusDroplist, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.viewFormSignatureImage, AssertType.HARD);
        this.assertion.assertElementIsVisible(this.viewFormDownloadButton, AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewFormSubmittedDateTimeLabel, Forms.SUBMITTED_DATE_TIME.label, AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewFormSubmittedIPLabel, Forms.SUBMITTED_IP_ADDRESS.label, AssertType.HARD);
        this.assertion.assertElementTextMatch(this.viewFormSubmittedDate, Forms.SUBMITTED_DATE_REGEX.label, AssertType.HARD);
        this.assertion.assertElementTextMatch(this.viewFormSubmittedTime, Forms.SUBMITTED_TIME_REGEX.label, AssertType.HARD);
        this.assertion.assertElementTextMatch(this.viewFormSubmittedIPValue, Forms.SUBMITTED_IP_REGEX.label, AssertType.HARD);
        this.assertion.assertElementEqualText(this.viewFormSendDateLabel, Forms.SUBMITTED_SEND_DATE.label, AssertType.HARD);
        this.assertion.assertElementTextMatch(this.viewFormSendDateValue, Forms.SUBMITTED_SEND_DATE_REGEX.label, AssertType.HARD);
        this.assertion.assertElementNotVisible(this.signature, AssertType.HARD);
    }
}
