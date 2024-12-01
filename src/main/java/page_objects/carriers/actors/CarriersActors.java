package page_objects.carriers.actors;

import model_classes.carriers.CarriersModelClass;

public interface CarriersActors {

    void navigate();

    void fillCarrierInformation(CarriersModelClass carriersModelClass);

    void proceedNext();

    void fillCarrierAddressInformation(CarriersModelClass carriersModelClass);

    void fillCarrierProductInformation(CarriersModelClass carriersModelClass);

    void submitCarrier();

    void carrierCreatedSuccessfully(CarriersModelClass carriersModelClass);

    void viewCarrier();

    void addProductFromCarrierProfile(CarriersModelClass carriersModelClass);

    void productAddedSuccessfullyToCarrierProfile(CarriersModelClass carriersModelClass);

    void addPolicyForClientFromCarrierProfile(CarriersModelClass carriersModelClass);

    void addPolicyForGroupFromCarrierProfile(CarriersModelClass carriersModelClass);

    void policyAddedSuccessfullyToCarrierProfile(CarriersModelClass carriersModelClass);
}
