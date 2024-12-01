package page_objects.forms.pages.aca;

import actions.ActionsHelper;
import assertions.AssertionsContext;
import enums.AssertType;
import enums.product.Forms;
import enums.product.Messages;
import model_classes.forms.SearchFormModel;
import model_classes.forms.SignFormModel;
import org.openqa.selenium.By;
import page_objects.forms.actors.FormsClient;
import page_objects.forms.customs.aca.ClientACACustom;
import synchronization.Waiter;

public class ACAClientFormPage  extends AbstractACAFormPage implements FormsClient, ClientACACustom {


    private By successMessage = By.xpath("//app-new-form-success//h5");

    public ACAClientFormPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }

    @Override
    public void navigate() {
        super.navigate();
    }

    @Override
    public void sign(SignFormModel signFormModel) {
        actions.sendKeys(this.comment, signFormModel.getSignatureComment());
        actions.fillSignField(this.signature);
        actions.click(this.submit);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void formSigned(SearchFormModel searchFormModel) {
        this.assertion.assertElementEqualText(this.successMessage, Messages.SUCCESS_CLIENT_SUBMIT.label, AssertType.HARD);
    }

    @Override
    public void formResign(SignFormModel signFormModel) {

    }

    @Override
    public void formAlreadySigned(SearchFormModel searchFormModel) {
        super.formAlreadySigned(searchFormModel);
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
    public void formViewed(SignFormModel signFormModel) {
        this.assertion.assertElementIsVisible(this.viewSignatureSignatureImg, AssertType.HARD);
        this.assertion.assertFieldValueEqual(this.viewSignatureComment, signFormModel.getSignatureComment(), AssertType.HARD);
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
    public void fillClientDetails(SignFormModel signFormModel) {
        this.actions.sendKeys(this.clientYearBirth, signFormModel.getDateOfBirthClient());
        this.actions.sendKeys(this.clientLastName, signFormModel.getLastNameClient());
        this.actions.click(this.loginButton);
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
}
