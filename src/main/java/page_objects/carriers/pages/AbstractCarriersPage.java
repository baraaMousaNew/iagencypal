package page_objects.carriers.pages;

import actions.ActionsHelper;
import actions.WebActions;
import assertions.AssertionsContext;
import enums.AssertType;
import enums.product.Grids;
import enums.product.Messages;
import model_classes.carriers.CarriersModelClass;
import org.openqa.selenium.By;
import page_objects.carriers.actors.CarriersActors;
import synchronization.Waiter;

public class AbstractCarriersPage implements CarriersActors {

    protected final String carriersUrl = "/en/system/new/new-carrier";

    protected final By addNewCarrier = By.xpath("//app-new-carrier//button[contains(text(),'Add Carrier')]");

    protected final By carrierName = By.xpath("//app-add-new-carrier//div[@class='personal_info-form']//input[@formcontrolname='name']");
    protected final By abbreviation = By.xpath("//app-add-new-carrier//div[@class='personal_info-form']//input[@formcontrolname='abbreviation']");
    protected final By email = By.xpath("//app-add-new-carrier//div[@class='personal_info-form']//input[@formcontrolname='email']");
    protected final By phone = By.xpath("//app-add-new-carrier//div[@class='personal_info-form']//input[@formcontrolname='phone']");
    protected final By website = By.xpath("//app-add-new-carrier//div[@class='personal_info-form']//input[@formcontrolname='website']");
    protected final By nextButton = By.xpath("//app-add-new-carrier//div[contains(@class,'add_new_agent_modal-footer')]//h5[contains(text(),'Next')]//parent::button");

    protected final By address = By.xpath("//app-add-new-carrier//div[@formgroupname='addressInfoForm']//input[@formcontrolname='address']");
    protected final By country = By.xpath("//app-add-new-carrier//div[@formgroupname='addressInfoForm']//select[@formcontrolname='countryID']");
    protected final By state = By.xpath("//app-add-new-carrier//div[@formgroupname='addressInfoForm']//select[@formcontrolname='stateID']");
    protected final By city = By.xpath("//app-add-new-carrier//div[@formgroupname='addressInfoForm']//input[@formcontrolname='city']");
    protected final By zipCode = By.xpath("//app-add-new-carrier//div[@formgroupname='addressInfoForm']//input[@formcontrolname='zipCode']");
    protected final By addressSaveAddNew = By.xpath("//app-add-new-carrier//div[@formgroupname='addressInfoForm']//button[contains(text(),'Save & Add New')]");

    protected final By productName = By.xpath("//app-add-new-carrier//div[@formgroupname='productInfoForm']//input[@formcontrolname='Name']");
    protected final By productEffectiveDate = By.xpath("//app-add-new-carrier//div[@formgroupname='productInfoForm']//input[@formcontrolname='ProductEffectiveDate']");
    protected final By productTermDate = By.xpath("//app-add-new-carrier//div[@formgroupname='productInfoForm']//input[@formcontrolname='ProductTermDate']");
    protected final By productCoverageType = By.xpath("//app-add-new-carrier//div[@formgroupname='productInfoForm']//select[@formcontrolname='CoverageType_ID']");
    protected final By productDescription = By.xpath("//app-add-new-carrier//div[@formgroupname='productInfoForm']//input[@formcontrolname='Description']");
    protected final By productIsActiveOnCommission = By.xpath("//app-add-new-carrier//div[@formgroupname='productInfoForm']//input[@formcontrolname='isActiveOnCommission']");
    protected final By saveAddNewProduct = By.xpath("//app-add-new-carrier//div[@formgroupname='productInfoForm']//button[contains(text(),'Save & Add New')]");

    protected final By submitButton = By.xpath("//app-add-new-carrier//div[contains(@class,'add_new_agent_modal-footer')]//h5[contains(text(),'Submit')]//parent::button");

    protected final By toasterAlertMessage = By.xpath("//div[@id='toast-container']//div[@role='alertdialog']//h6");

    protected final By carriersGrid = By.xpath("//app-new-carrier//app-new-data-table//table[@role='table']");
    protected final By gridActions = By.xpath("//app-new-carrier//app-new-data-table//table//tbody//div[contains(@class,'ipal_actions')]//a");
    protected final By viewIcon = By.xpath("//app-new-carrier//app-new-data-table//table//tbody//div[contains(@class,'ipal_actions')]//a[@title='Edit']");

    protected final By productsCarrierProfile = By.xpath("//app-new-carrier-profile//div[@class='ap_profile_tabs-content']//h6[text()=' Product']");
    protected final By policiesCarrierProfile = By.xpath("//app-new-carrier-profile//div[@class='ap_profile_tabs-content']//h6[text()=' Policies']");
    protected final By notesCarrierProfile = By.xpath("//app-new-carrier-profile//div[@class='ap_profile_tabs-content']//h6[text()=' Notes/Attachments ']");

    protected final By addProductButtonCarrierProfile = By.xpath("//app-new-carrier-product//div[@class='table_box_tabs-header--actions']//button");
    protected final By productNameCarrierProfile = By.xpath("//app-add-new-product//form//div[@formgroupname='productInfoForm']//h6[contains(text(),'Product Name')]//parent::label//parent::div//input");
    protected final By productEffectiveDateCarrierProfile = By.xpath("//app-add-new-product//form//div[@formgroupname='productInfoForm']//input[@id='ProductEffectiveDate']");
    protected final By productTermDateCarrierProfile = By.xpath("//app-add-new-product//form//div[@formgroupname='productInfoForm']//input[@id='ProductTermDate']");
    protected final By productCoverageTypeCarrierProfile = By.xpath("//app-add-new-product//form//div[@formgroupname='productInfoForm']//select[@aria-label='Default select example']");
    protected final By productDescriptionCarrierProfile = By.xpath("//app-add-new-product//form//div[@formgroupname='productInfoForm']//input[@formcontrolname='Description']");
    protected final By productIsActiveOnCommissionCarrierProfile = By.xpath("//app-add-new-product//form//div[@formgroupname='productInfoForm']//input[@formcontrolname='isActiveOnCommission']");
    protected final By productNextButtonCarrierProfile = By.xpath("//app-add-new-product//div[contains(@class,'add_new_agent_modal-footer')]//h5[text()='Next']//parent::button");
    protected final By productWebsiteCarrierProfile = By.xpath("//app-add-new-product//form//div[@formgroupname='commissionStatementSourceForm']//input[@formcontrolname='portalWebSite']");
    protected final By productUsernameCarrierProfile = By.xpath("//app-add-new-product//form//div[@formgroupname='commissionStatementSourceForm']//input[@formcontrolname='username']");
    protected final By productPasswordCarrierProfile = By.xpath("//app-add-new-product//form//div[@formgroupname='commissionStatementSourceForm']//input[@formcontrolname='password']");
    protected final By productCommissionDescriptionCarrierProfile = By.xpath("//app-add-new-product//form//div[@formgroupname='commissionStatementSourceForm']//input[@formcontrolname='description']");
    protected final By productSubmitButtonCarrierProfile = By.xpath("//app-add-new-product//div[contains(@class,'add_new_agent_modal-footer')]//h5[text()='Submit']//parent::button");

    protected final By productsGridCarrierProfile = By.xpath("//app-new-carrier-profile//app-new-carrier-product//app-new-data-table//table");

    protected final By addPolicyButtonCarrierProfile = By.xpath("//app-new-carrier-profile//app-new-sub-policy//div[@class='table_box_tabs-header--actions']//button");
    protected final By addForClientButtonCarrierProfile = By.xpath("//app-new-carrier-profile//app-new-sub-policy//div[@class='table_box_tabs-header--actions']//button//div[@data-bs-toggle='modal']//span[text()='For Client']");
    protected final By addForGroupButtonCarrierProfile = By.xpath("//app-new-carrier-profile//app-new-sub-policy//div[@class='table_box_tabs-header--actions']//button//div[@data-bs-toggle='modal']//span[text()='For Group']");

    protected final By policyNumberCarrierProfile = By.xpath("//app-add-new-policy-for-client//form//div[@formgroupname='policyInfoForm']//input[@formcontrolname='PolicyNumber']");
    protected final By policyStatusCarrierProfile = By.xpath("//app-add-new-policy-for-client//form//div[@formgroupname='policyInfoForm']//select[@formcontrolname='Status_ID']");
    protected final By servicingAgentPolicyCarrierProfile = By.xpath("//app-add-new-policy-for-client//form//div[@formgroupname='policyInfoForm']//p-autocomplete[@formcontrolname='Agent_ID']//input");
    protected final By clientPolicyCarrierProfile = By.xpath("//app-add-new-policy-for-client//form//div[@formgroupname='policyInfoForm']//p-autocomplete[@formcontrolname='Client_ID']//input");
    protected final By policyEffectiveDateCarrierProfile = By.xpath("//app-add-new-policy-for-client//form//div[@formgroupname='policyInfoForm']//input[@id='EffectiveDate']");
    protected final By renewalDateCarrierProfile = By.xpath("//app-add-new-policy-for-client//form//div[@formgroupname='policyInfoForm']//input[@id='RenewalDate']");
    protected final By policyNextButtonCarrierProfile = By.xpath("//app-add-new-policy-for-client//div[contains(@class,'add_new_client_modal-footer')]//h5[text()='Next']//parent::button");
    protected final By policyProductCarrierProfile = By.xpath("//app-add-new-policy-for-client//form//div[@formgroupname='carrierAndProductsForm']//p-autocomplete[@formcontrolname='Product_ID']//input");
    protected final By policySubmitButtonCarrierProfile = By.xpath("//app-add-new-policy-for-client//div[contains(@class,'add_new_client_modal-footer')]//h5[text()='Submit']//parent::button");

    protected final By policyGridCarrierProfile = By.xpath("//app-new-carrier-profile//app-new-sub-policy//table");

    protected final By policyNumberCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//form//div[@formgroupname='policyInfoForm']//input[@formcontrolname='PolicyNumber']");
    protected final By policyStatusCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//form//div[@formgroupname='policyInfoForm']//select[@formcontrolname='Status_ID']");
    protected final By policyServicingAgentCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//form//div[@formgroupname='policyInfoForm']//p-autocomplete[@formcontrolname='Agent_ID']//input");
    protected final By policyGroupCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//form//div[@formgroupname='policyInfoForm']//p-autocomplete[@formcontrolname='Group_ID']//input");
    protected final By policyEffectiveDateCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//form//div[@formgroupname='policyInfoForm']//input[@id='EffectiveDate']");
    protected final By policyRenewalDateCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//form//div[@formgroupname='policyInfoForm']//input[@id='RenewalDate']");
    protected final By policyNextButtonCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//div[contains(@class,'add_new_client_modal-footer')]//h5[text()='Next']//parent::button");
    protected final By policyProductsCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//form//div[@formgroupname='carrierAndProductsForm']//p-autocomplete[@formcontrolname='Product_ID']//input");
    protected final By policyNewHireEligibilityCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//input[@formcontrolname='NewHireEligblity_Name']");
    protected final By policyEligibilityHoursCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//input[@formcontrolname='EligblityHours_Name']");
    protected final By policyRenewalCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//input[@formcontrolname='Renewal']");
    protected final By policyNotesCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//textarea[@formcontrolname='Notes']");
    protected final By policySubmitButtonCarrierProfileGroup = By.xpath("//app-add-new-policy-for-group//div[contains(@class,'add_new_client_modal-footer')]//h5[text()='Submit']//parent::button");


    protected WebActions actions;
    protected AssertionsContext assertion;

    protected AbstractCarriersPage(WebActions actions, AssertionsContext assertion){
        this.actions = actions;
        this.assertion = assertion;
    }

    public AbstractCarriersPage(){
        this.actions = new ActionsHelper<>().getActions();
        this.assertion = new AssertionsContext();
    }

    @Override
    public void navigate() {
        this.actions.navigate(this.carriersUrl, true);
    }

    @Override
    public void fillCarrierInformation(CarriersModelClass carriersModelClass) {
        this.actions.click(this.addNewCarrier);
        Waiter.waitForAngularLoad();
        this.actions.sendKeys(this.carrierName, carriersModelClass.getCarrierName());
        this.actions.sendKeys(this.abbreviation, carriersModelClass.getAbbreviation());
        this.actions.sendKeys(this.email, carriersModelClass.getEmailAddress());
        this.actions.sendKeys(this.phone, carriersModelClass.getPhoneNumber());
        this.actions.sendKeys(this.website, carriersModelClass.getWebsite());
    }

    @Override
    public void proceedNext() {
        this.actions.click(this.nextButton);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void fillCarrierAddressInformation(CarriersModelClass carriersModelClass) {
        this.actions.sendKeys(this.address, carriersModelClass.getAddress());
        this.actions.selectByValue(this.country, carriersModelClass.getCountry());
        this.actions.selectByValue(this.state, carriersModelClass.getState());
        this.actions.sendKeys(this.city, carriersModelClass.getCity());
        this.actions.sendKeys(this.zipCode, carriersModelClass.getZipCode());
        this.actions.click(this.addressSaveAddNew);
    }

    @Override
    public void fillCarrierProductInformation(CarriersModelClass carriersModelClass) {
        this.actions.sendKeys(this.productName, carriersModelClass.getProductName());
        this.actions.sendKeys(this.productEffectiveDate, carriersModelClass.getEffectiveDate());
        this.actions.sendKeys(this.productTermDate, carriersModelClass.getProductTermDate());
        this.actions.selectByValue(this.productCoverageType, carriersModelClass.getCoverageType());
        this.actions.sendKeys(this.productDescription, carriersModelClass.getProductDescription());
        this.actions.checkbox(this.productIsActiveOnCommission, carriersModelClass.getIsActiveOnCommission());
        this.actions.click(this.saveAddNewProduct);
    }

    @Override
    public void submitCarrier() {
        this.actions.click(this.submitButton);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void carrierCreatedSuccessfully(CarriersModelClass carriersModelClass) {
        this.assertion.assertElementEqualText(this.toasterAlertMessage, Messages.CARRIER_ADDED.label, AssertType.SOFT);
        this.actions.reloadPage();
        this.assertion.assertGridValue(this.carriersGrid, Grids.CARRIER_NAME.label, carriersModelClass.getCarrierName(), 1, AssertType.HARD);
        this.assertion.assertGridValue(this.carriersGrid, Grids.EMAIL.label, carriersModelClass.getEmailAddress(), 1, AssertType.HARD);
        this.assertion.assertGridValue(this.carriersGrid, Grids.TOTAL_PRODUCTS.label, carriersModelClass.getTotalProducts(), 1, AssertType.HARD);
        this.assertion.assertGridRadioSelected(this.carriersGrid, Grids.ACTIVE_STATUS.label, true, 1, AssertType.HARD);
    }

    @Override
    public void viewCarrier() {
        this.actions.reloadPage();
        this.actions.hover(this.gridActions);
        this.actions.click(this.viewIcon);
        this.actions.switchCurrentTab(1);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void addProductFromCarrierProfile(CarriersModelClass carriersModelClass) {
        this.actions.click(this.productsCarrierProfile);
        Waiter.waitForAngularLoad();
        this.actions.click(this.addProductButtonCarrierProfile);
        this.actions.sendKeys(this.productNameCarrierProfile, carriersModelClass.getProductName());
        this.actions.sendKeys(this.productEffectiveDateCarrierProfile, carriersModelClass.getEffectiveDate());
        this.actions.sendKeys(this.productTermDateCarrierProfile, carriersModelClass.getProductTermDate());
        this.actions.selectByValue(this.productCoverageTypeCarrierProfile, carriersModelClass.getCoverageType());
        this.actions.sendKeys(this.productDescriptionCarrierProfile, carriersModelClass.getProductDescription());
        this.actions.checkbox(this.productIsActiveOnCommissionCarrierProfile, carriersModelClass.getIsActiveOnCommission());
        this.actions.click(this.productNextButtonCarrierProfile);
        this.actions.sendKeys(this.productWebsiteCarrierProfile, carriersModelClass.getProductWebsite());
        this.actions.sendKeys(this.productUsernameCarrierProfile, carriersModelClass.getProductUsername());
        this.actions.sendKeys(this.productPasswordCarrierProfile, carriersModelClass.getProductPassword());
        this.actions.sendKeys(this.productCommissionDescriptionCarrierProfile, carriersModelClass.getCommissionDescription());
        this.actions.click(this.productSubmitButtonCarrierProfile);
    }

    @Override
    public void productAddedSuccessfullyToCarrierProfile(CarriersModelClass carriersModelClass) {
        this.assertion.assertElementEqualText(this.toasterAlertMessage, Messages.PRODUCT_ADDED.label, AssertType.HARD);
        this.actions.reloadPage();
        this.assertion.assertGridValue(this.productsGridCarrierProfile, Grids.PRODUCT_NAME.label, carriersModelClass.getProductName(),1,AssertType.HARD);
        this.assertion.assertGridValue(this.productsGridCarrierProfile, Grids.CARRIER_NAME.label, carriersModelClass.getCarrierName(),1,AssertType.HARD);
        this.assertion.assertGridValue(this.productsGridCarrierProfile, Grids.PRODUCT_EFFECTIVE_DATE.label, carriersModelClass.getEffectiveDate(),1,AssertType.HARD);
        this.assertion.assertGridRadioSelected(this.productsGridCarrierProfile, Grids.ACTIVE_STATUS.label, true, 1, AssertType.HARD);
    }

    @Override
    public void addPolicyForClientFromCarrierProfile(CarriersModelClass carriersModelClass) {
        this.actions.click(this.policiesCarrierProfile);
        Waiter.waitForAngularLoad();
        this.actions.click(this.addForClientButtonCarrierProfile);
        this.actions.sendKeys(this.policyNumberCarrierProfile, carriersModelClass.getPolicyNumber());
        this.actions.selectByValue(this.policyStatusCarrierProfile, carriersModelClass.getPolicyStatus());
        this.actions.sendKeys(this.servicingAgentPolicyCarrierProfile, carriersModelClass.getServicingAgent());
        this.actions.sendKeys(this.clientPolicyCarrierProfile, carriersModelClass.getClient());
        this.actions.sendKeys(this.policyEffectiveDateCarrierProfile, carriersModelClass.getPolicyEffectiveDate());
        this.actions.sendKeys(this.renewalDateCarrierProfile, carriersModelClass.getPolicyRenewalDate());
        this.actions.click(this.policyNextButtonCarrierProfile);
        this.actions.sendKeys(this.policyProductCarrierProfile, carriersModelClass.getProductName());
        this.actions.click(this.policySubmitButtonCarrierProfile);
    }

    @Override
    public void addPolicyForGroupFromCarrierProfile(CarriersModelClass carriersModelClass) {
        this.actions.click(this.policiesCarrierProfile);
        Waiter.waitForAngularLoad();
        this.actions.click(this.addForGroupButtonCarrierProfile);
        this.actions.sendKeys(this.policyNumberCarrierProfileGroup, carriersModelClass.getPolicyNumber());
        this.actions.sendKeys(this.policyServicingAgentCarrierProfileGroup, carriersModelClass.getServicingAgent());
        this.actions.sendKeys(this.policyGroupCarrierProfileGroup, carriersModelClass.getGroup());
        this.actions.selectByValue(this.policyStatusCarrierProfileGroup, carriersModelClass.getPolicyStatus());
        this.actions.sendKeys(this.policyEffectiveDateCarrierProfileGroup, carriersModelClass.getPolicyEffectiveDate());
        this.actions.sendKeys(this.policyRenewalDateCarrierProfileGroup, carriersModelClass.getPolicyRenewalDate());
        this.actions.click(this.policyNextButtonCarrierProfileGroup);
        this.actions.sendKeys(this.policyProductsCarrierProfileGroup, carriersModelClass.getProductName());
        this.actions.click(this.policyNextButtonCarrierProfileGroup);
        this.actions.sendKeys(this.policyNewHireEligibilityCarrierProfileGroup, carriersModelClass.getNewHireEligibility());
        this.actions.sendKeys(this.policyEligibilityHoursCarrierProfileGroup, carriersModelClass.getEligibilityHours());
        this.actions.sendKeys(this.policyRenewalCarrierProfileGroup, carriersModelClass.getRenewal());
        this.actions.sendKeys(this.policyNotesCarrierProfileGroup, carriersModelClass.getNotes());
        this.actions.click(this.policySubmitButtonCarrierProfileGroup);
    }

    @Override
    public void policyAddedSuccessfullyToCarrierProfile(CarriersModelClass carriersModelClass) {
        this.assertion.assertElementEqualText(this.toasterAlertMessage, Messages.POLICY_ADDED.label, AssertType.HARD);
        this.actions.reloadPage();
        this.assertion.assertGridValue(this.policyGridCarrierProfile, Grids.POLICY_NUMBER.label, carriersModelClass.getPolicyNumber(),1,AssertType.HARD);
        this.assertion.assertGridValue(this.policyGridCarrierProfile, Grids.POLICY_HOLDER.label, carriersModelClass.getPolicyHolder(),1,AssertType.HARD);
        this.assertion.assertGridValue(this.policyGridCarrierProfile, Grids.SERVING_AGENT.label, carriersModelClass.getServicingAgent(),1,AssertType.HARD);
        this.assertion.assertGridValue(this.policyGridCarrierProfile, Grids.POLICY_EFFECTIVE_DATE.label, carriersModelClass.getPolicyEffectiveDate(),1,AssertType.HARD);
        this.assertion.assertGridRadioSelected(this.policyGridCarrierProfile, Grids.ACTIVE_STATUS.label, true, 1, AssertType.HARD);
    }
}
