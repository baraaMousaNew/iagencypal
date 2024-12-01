package page_objects.clients.actors;

import model_classes.clients.ClientModelClass;

public interface ClientsBroker extends ClientsActors{

    @Override
    void addClientBasicInfo(ClientModelClass clientModelClass);

    @Override
    void addClientAddressInfo(ClientModelClass clientModelClass);

    @Override
    void nextFromAddress();

    @Override
    void addClientSensitiveData(ClientModelClass clientModelClass);

    @Override
    void clientDetailsDisplaySuccessfully(ClientModelClass clientModelClass);

    @Override
    void profilePersonalInformationDisplaySuccessfully(ClientModelClass clientModelClass);

    @Override
    void updatePersonalInformation(ClientModelClass clientModelClass);

}
