package page_objects.clients.actors;

import model_classes.clients.ClientModelClass;

public interface ClientsActors {

    void navigate();

    void addClientBasicInfo(ClientModelClass clientModelClass);

    void addClientAddressInfo(ClientModelClass clientModelClass);

    void nextFromAddress();

    void addClientSensitiveData(ClientModelClass clientModelClass);

    void clientDetailsDisplaySuccessfully(ClientModelClass clientModelClass);

    void viewClientProfile();

    void profileDetailsDisplaySuccessfully(ClientModelClass clientModelClass);

    void profilePersonalInformationDisplaySuccessfully(ClientModelClass clientModelClass);

    void profileAddressInformationDisplaySuccessfully(ClientModelClass clientModelClass);

    void profileSensitiveDataDisplaySuccessfully(ClientModelClass clientModelClass);

    // update

    void updatePersonalInformation(ClientModelClass clientModelClass);

    void updateAddressInformation(ClientModelClass clientModelClass);

    void updateSensitiveInformation(ClientModelClass clientModelClass);
}
