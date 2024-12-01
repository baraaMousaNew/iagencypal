package runner.step_definitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import enums.product.Actors;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model_classes.clients.ClientModelClass;
import page_objects.clients.actors.ClientsActors;
import page_objects.clients.actors.ClientsBroker;
import page_objects.clients.pages.ClientsAgentPage;
import page_objects.clients.pages.ClientsBrokerPage;

import java.util.List;
import java.util.Map;

public class ClientSteps {

    @Given("{string} navigate to clients page")
    public void navigateToClientsPage(String arg0) {
        ClientsActors actor = null;
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.navigate();
    }

    @And("{string} add client basic information")
    public void addNewClient(String arg0, List<Map<String, String>> data) {
        ClientsActors actor;
        ObjectMapper objectMapper = new ObjectMapper();
        ClientModelClass clientModelClass = objectMapper.convertValue(data.get(0), ClientModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.addClientBasicInfo(clientModelClass);
    }

    @And("{string} add client address information")
    public void addClientAddressInformation(String arg0, List<Map<String, String>> data) {
        ClientsActors actor;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        for(Map<String, String> datum: data){
            ClientModelClass clientModelClass = objectMapper.convertValue(datum, ClientModelClass.class);
            actor.addClientAddressInfo(clientModelClass);
        }
        actor.nextFromAddress();

    }

    @And("{string} add client sensitive data")
    public void addClientSensitiveData(String arg0, List<Map<String, String>> data) {
        ClientsActors actor;
        ObjectMapper objectMapper = new ObjectMapper();
        ClientModelClass clientModelClass = objectMapper.convertValue(data.get(0), ClientModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.addClientSensitiveData(clientModelClass);
    }

    @Then("{string} client is created successfully")
    public void clientIsCreatedSuccessfully(String arg0, List<Map<String, String>> data) {
        ClientsActors actor;
        ObjectMapper objectMapper = new ObjectMapper();
        ClientModelClass clientModelClass = objectMapper.convertValue(data.get(0), ClientModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.clientDetailsDisplaySuccessfully(clientModelClass);
    }

    @And("{string} view the profile of the client")
    public void viewTheProfileOfTheClient(String arg0) {
        ClientsActors actor;
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.viewClientProfile();
    }

    @Then("{string} client details display successfully")
    public void profileDetailsDisplaySuccessfully(String arg0, List<Map<String, String>> data) {
        ClientsActors actor;
        ObjectMapper objectMapper = new ObjectMapper();
        ClientModelClass clientModelClass = objectMapper.convertValue(data.get(0), ClientModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.profileDetailsDisplaySuccessfully(clientModelClass);
    }

    @And("{string} client personal information display successfully")
    public void clientPersonalInformationDisplaySuccessfully(String arg0, List<Map<String, String>> data) {
        ClientsActors actor;
        ObjectMapper objectMapper = new ObjectMapper();
        ClientModelClass clientModelClass = objectMapper.convertValue(data.get(0), ClientModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.profilePersonalInformationDisplaySuccessfully(clientModelClass);
    }

    @And("{string} client address information display successfully")
    public void clientAddressInformationDisplaySuccessfully(String arg0, List<Map<String, String>> data) {
        ClientsActors actor;
        ObjectMapper objectMapper = new ObjectMapper();
        ClientModelClass clientModelClass = objectMapper.convertValue(data.get(0), ClientModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.profileAddressInformationDisplaySuccessfully(clientModelClass);
    }

    @And("{string} client sensitive data display successfully")
    public void clientSensitiveDataDisplaySuccessfully(String arg0, List<Map<String, String>> data) {
        ClientsActors actor;
        ObjectMapper objectMapper = new ObjectMapper();
        ClientModelClass clientModelClass = objectMapper.convertValue(data.get(0), ClientModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.profileSensitiveDataDisplaySuccessfully(clientModelClass);
    }


    @Then("{string} update client personal information")
    public void updateClientPersonalInformation(String arg0, List<Map<String, String>> data) {
        ClientsActors actor;
        ObjectMapper objectMapper = new ObjectMapper();
        ClientModelClass clientModelClass = objectMapper.convertValue(data.get(0), ClientModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.updatePersonalInformation(clientModelClass);
    }

    @Then("{string} update client address information")
    public void updateClientAddressInformation(String arg0, List<Map<String, String>> data) {
        ClientsActors actor;
        ObjectMapper objectMapper = new ObjectMapper();
        ClientModelClass clientModelClass = objectMapper.convertValue(data.get(0), ClientModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.updateAddressInformation(clientModelClass);
    }

    @Then("{string} update client sensitive data")
    public void updateClientSensitiveData(String arg0, List<Map<String, String>> data) {
        ClientsActors actor;
        ObjectMapper objectMapper = new ObjectMapper();
        ClientModelClass clientModelClass = objectMapper.convertValue(data.get(0), ClientModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new ClientsAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new ClientsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.updateSensitiveInformation(clientModelClass);
    }

}
