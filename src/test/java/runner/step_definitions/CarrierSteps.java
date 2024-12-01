package runner.step_definitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import enums.product.Actors;
import enums.product.Beneficiary;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model_classes.carriers.CarriersModelClass;
import model_classes.clients.ClientModelClass;
import page_objects.agents.actors.AgentsActors;
import page_objects.agents.pages.AgentsBrokerPage;
import page_objects.carriers.actors.CarriersActors;
import page_objects.carriers.pages.CarriersAgentPage;
import page_objects.carriers.pages.CarriersBrokerPage;
import page_objects.clients.pages.ClientsAgentPage;
import page_objects.clients.pages.ClientsBrokerPage;

import java.util.List;
import java.util.Map;

public class CarrierSteps {


    @And("{string} navigate to carrier page")
    public void navigateToCarrierPage(String arg0) {
        CarriersActors actors = null;
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new CarriersBrokerPage();
        } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
            actors = new CarriersAgentPage();
        } else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.navigate();
    }

    @When("{string} add carrier information")
    public void addCarrierInformation(String arg0, List<Map<String, String>> data) {
        CarriersActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        CarriersModelClass carrierModelClass = objectMapper.convertValue(data.get(0), CarriersModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new CarriersAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new CarriersBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.fillCarrierInformation(carrierModelClass);
    }

    @And("{string} click proceed to next step of create carrier")
    public void clickProceedToNextStepOfCreateCarrier(String arg0) {
        CarriersActors actor = null;
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new CarriersAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new CarriersBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.proceedNext();
    }

    @And("{string} add carrier address information")
    public void addCarrierAddressInformation(String arg0, List<Map<String, String>> data) {
        CarriersActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new CarriersAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new CarriersBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        for(Map<String, String> datum: data){
            CarriersModelClass carrierModelClass = objectMapper.convertValue(datum, CarriersModelClass.class);
            actor.fillCarrierAddressInformation(carrierModelClass);
        }
    }

    @And("{string} add carrier product information")
    public void addCarrierProductInformation(String arg0, List<Map<String, String>> data) {
        CarriersActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new CarriersAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new CarriersBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        for(Map<String, String> datum: data){
            CarriersModelClass carrierModelClass = objectMapper.convertValue(datum, CarriersModelClass.class);
            actor.fillCarrierProductInformation(carrierModelClass);
        }
    }

    @And("{string} submit the carrier information")
    public void submitTheCarrierInformation(String arg0) {
        CarriersActors actor = null;
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new CarriersAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new CarriersBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.submitCarrier();
    }

    @Then("{string} carrier is created successfully")
    public void isCreatedSuccessfully(String arg0, List<Map<String, String>> data) {
        CarriersActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        CarriersModelClass carrierModelClass = objectMapper.convertValue(data.get(0), CarriersModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new CarriersAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new CarriersBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.carrierCreatedSuccessfully(carrierModelClass);
    }


    @And("{string} view carrier")
    public void viewCarrier(String arg0) {
        CarriersActors actor = null;
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new CarriersAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new CarriersBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.viewCarrier();
    }

    @Then("{string} add product to carrier profile")
    public void addProductToCarrierProfile(String arg0, List<Map<String, String>> data) {
        CarriersActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        CarriersModelClass carrierModelClass = objectMapper.convertValue(data.get(0), CarriersModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new CarriersAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new CarriersBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.addProductFromCarrierProfile(carrierModelClass);
    }

    @Then("{string} product added successfully to carrier profile")
    public void productAddedSuccessfullyToCarrierProfile(String arg0, List<Map<String, String>> data) {
        CarriersActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        CarriersModelClass carrierModelClass = objectMapper.convertValue(data.get(0), CarriersModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new CarriersAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new CarriersBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.productAddedSuccessfullyToCarrierProfile(carrierModelClass);
    }

    @Then("{string} add policy for {string} to carrier profile")
    public void addPolicyToCarrierProfile(String arg0, String arg1, List<Map<String, String>> data) {
        CarriersActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        CarriersModelClass carrierModelClass = objectMapper.convertValue(data.get(0), CarriersModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new CarriersAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new CarriersBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        if(arg1.equalsIgnoreCase(Beneficiary.CLIENT.label)){
            actor.addPolicyForClientFromCarrierProfile(carrierModelClass);
        } else if (arg1.equalsIgnoreCase(Beneficiary.GROUP.label)) {
            actor.addPolicyForGroupFromCarrierProfile(carrierModelClass);
        }else {
            throw new UnsupportedOperationException("Cannot find a matched beneficiary type: " + arg1);
        }
    }

    @Then("{string} policy added successfully to carrier profile")
    public void policyAddedSuccessfullyToCarrierProfile(String arg0, List<Map<String, String>> data) {
        CarriersActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        CarriersModelClass carrierModelClass = objectMapper.convertValue(data.get(0), CarriersModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            actor = new CarriersAgentPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            actor = new CarriersBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.policyAddedSuccessfullyToCarrierProfile(carrierModelClass);
    }
}
