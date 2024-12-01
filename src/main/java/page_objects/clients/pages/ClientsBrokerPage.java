package page_objects.clients.pages;

import actions.ActionsHelper;
import assertions.AssertionsContext;
import enums.AssertType;
import enums.product.Grids;
import enums.product.Messages;
import model_classes.clients.ClientModelClass;
import page_objects.clients.actors.ClientsBroker;
import properties.Product;
import synchronization.Waiter;

public class ClientsBrokerPage extends AbstractClientsPage implements ClientsBroker {

    public ClientsBrokerPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }

    @Override
    public void addClientBasicInfo(ClientModelClass clientModelClass) {
        this.actions.click(this.addClient);
        Waiter.waitForElementVisible(this.addClientPanel);
        this.actions.sendKeys(this.servicingAgent, clientModelClass.getServicingAgent());
        this.actions.sendKeys(this.clientFirstName, clientModelClass.getFirstName());
        this.actions.sendKeys(this.clientLastName, clientModelClass.getLastName());
        this.actions.sendKeys(this.clientEmail, clientModelClass.getEmail());
        this.actions.sendKeys(this.clientPhoneNumber, clientModelClass.getPhoneNumber());
        this.actions.sendKeys(this.clientDOB, clientModelClass.getDateOfBirth());
        this.actions.selectByValue(this.clientGender, clientModelClass.getGender());
        this.actions.click(this.nextButton);
    }

    @Override
    public void addClientAddressInfo(ClientModelClass clientModelClass) {
        super.addClientAddressInfo(clientModelClass);
    }

    @Override
    public void addClientSensitiveData(ClientModelClass clientModelClass) {
        super.addClientSensitiveData(clientModelClass);
    }

    @Override
    public void clientDetailsDisplaySuccessfully(ClientModelClass clientModelClass) {
        this.assertion.assertElementIsVisible(this.clientSuccessPanel, AssertType.HARD);
        this.assertion.assertElementTextMatch(this.clientSuccessText, Messages.CLIENT_SUCCESS.label, AssertType.HARD);
        this.actions.click(this.doItLaterButton);
        this.actions.reloadPage();
        this.assertion.assertGridValue(this.grid, Grids.FULL_NAME.label, clientModelClass.getFullName(), 1, AssertType.HARD);
        this.assertion.assertGridValue(this.grid, Grids.SERVING_AGENT.label, clientModelClass.getServicingAgent(), 1, AssertType.HARD);
        this.assertion.assertGridValue(this.grid, Grids.CONTACT_EMAIL.label, clientModelClass.getEmail(), 1, AssertType.HARD);
        this.assertion.assertGridValue(this.grid, Grids.PHONE.label, clientModelClass.getPhoneNumber(), 1, AssertType.HARD);
        this.assertion.assertGridRadioSelected(this.grid, Grids.ACTIVE_STATUS.label, clientModelClass.getActiveStatus(), 1,  AssertType.HARD);
    }

    @Override
    public void profilePersonalInformationDisplaySuccessfully(ClientModelClass clientModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.profileInformationBox);
        Waiter.waitForAngularLoad();
        this.assertion.assertFieldValueEqual(this.profilePersonalServicingAgent, clientModelClass.getServicingAgent(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.profilePersonalServicingAgent, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profilePersonalClientFirstName, clientModelClass.getFirstName(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.profilePersonalClientFirstName, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profilePersonalClientLastName, clientModelClass.getLastName(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.profilePersonalClientLastName, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profilePersonalClientEmail, clientModelClass.getEmail(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.profilePersonalClientEmail, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profilePersonalClientPhoneNumber, clientModelClass.getPhoneNumber(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.profilePersonalClientPhoneNumber, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profilePersonalClientDOB, clientModelClass.getDateOfBirth(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.profilePersonalClientDOB, AssertType.SOFT);
        this.assertion.assertFieldValueEqual(this.profilePersonalClientGender, clientModelClass.getGender(), AssertType.HARD);
        this.assertion.assertElementIsEditable(this.profilePersonalClientGender, AssertType.SOFT);
    }

    @Override
    public void updatePersonalInformation(ClientModelClass clientModelClass) {
        this.actions.reloadPage();
        this.actions.click(this.profileInformationBox);
        Waiter.waitForAngularLoad();
        String currentAgent = this.actions.getValueOfField(this.profilePersonalServicingAgent);
        this.actions.sendKeys(this.profilePersonalServicingAgent, clientModelClass.getServicingAgent());
        if(!currentAgent.trim().equalsIgnoreCase(clientModelClass.getServicingAgent())){
            Waiter.waitForElementVisible(this.profilePersonalDialog);
            this.actions.click(this.profilePersonalDialogConfirm);
        }
        this.actions.sendKeys(this.profilePersonalClientFirstName, clientModelClass.getFirstName());
        this.actions.sendKeys(this.profilePersonalClientLastName, clientModelClass.getLastName());
        this.actions.sendKeys(this.profilePersonalClientEmail, clientModelClass.getEmail());
        this.actions.sendKeys(this.profilePersonalClientPhoneNumber, clientModelClass.getPhoneNumber());
        this.actions.sendKeys(this.profilePersonalClientDOB, clientModelClass.getDateOfBirth());
        this.actions.selectByValue(this.profilePersonalClientGender, clientModelClass.getGender());
        this.actions.click(this.profilePersonalSaveButton);
    }

}
