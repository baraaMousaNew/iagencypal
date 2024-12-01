package runner.step_definitions;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.product.Actors;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model_classes.agents.AgentModelClass;
import page_objects.agents.actors.AgentsActors;
import page_objects.agents.pages.AgentsBrokerPage;

import java.util.List;
import java.util.Map;

public class AgentSteps {

    @And("{string} navigate to agents page")
    public void navigateToAgentsPage(String arg0) {
        AgentsActors actors = null;
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.navigate();
    }

    @When("{string} add agent basic information")
    public void addAgentBasicInformation(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.addAgentBasicInformation(agentModelClass);
    }

    @And("{string} add agent address information")
    public void addAgentAddressInformation(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        for(Map<String, String> datum: data){
            AgentModelClass agentModelClass = objectMapper.convertValue(datum, AgentModelClass.class);
            actors.addAgentAddressInformation(agentModelClass);
        }

    }

    @And("{string} click proceed to next step of create agent")
    public void clickProceedToNextStepOfCreateAgent(String arg0) {
        AgentsActors actors = null;
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.proceedNext();
    }

    @And("{string} add roles information")
    public void addRolesInformation(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.addAgentRolesInformation(agentModelClass);
    }

    @Then("{string} agent is created successfully")
    public void agentIsCreatedSuccessfully(String arg0,List<Map<String, String>> data ) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.agentCreatedSuccessfully(agentModelClass);
    }

    @And("{string} view agent profile")
    public void viewAgentProfile(String arg0) {
        AgentsActors actors = null;
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.viewAgentProfile();
    }

    @Then("{string} agent details display successfully")
    public void agentDetailsDisplaySuccessfully(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.agentDetailsDisplaySuccessfully(agentModelClass);
    }

    @And("{string} agent information display successfully")
    public void agentInformationDisplaySuccessfully(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.agentInformationDisplaySuccessfully(agentModelClass);
    }

    @And("{string} agent personal information display successfully")
    public void agentPersonalInformationDisplaySuccessfully(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.agentPersonalInformationDisplaySuccessfully(agentModelClass);
    }

    @And("{string} agent address information display successfully")
    public void agentAddressInformationDisplaySuccessfully(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.agentAddressInformationDisplaySuccessfully(agentModelClass);
    }

    @And("{string} agent roles display successfully")
    public void agentSensitiveDataDisplaySuccessfully(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.agentRolesDisplaySuccessfully(agentModelClass);
    }

    @And("{string} update agent information")
    public void updateAgentInformation(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.updateAgentInformation(agentModelClass);
    }

    @And("{string} update personal information")
    public void updatePersonalInformation(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.updateAgentPersonalInformation(agentModelClass);
    }

    @And("{string} update address information")
    public void updateAddressInformation(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.updateAgentAddressInformation(agentModelClass);
    }

    @Then("{string} update roles of agent")
    public void updateRolesOfAgent(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.updateAgentRolesInformation(agentModelClass);
    }

    @And("{string} add secondary email to agent profile")
    public void addSecondaryEmailToAgentProfile(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.addSecondaryEmail(agentModelClass);
    }

    @Then("{string} agent secondary email is added successfully")
    public void secondaryEmailIsAddedSuccessfully(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.secondaryEmailAddedSuccessfully(agentModelClass);
    }

    @And("{string} add secondary phone to agent profile")
    public void addSecondaryPhoneToAgentProfile(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.addSecondaryPhone(agentModelClass);
    }

    @Then("{string} agent secondary phone is added successfully")
    public void agentSecondaryPhoneIsAddedSuccessfully(String arg0, List<Map<String, String>> data) {
        AgentsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        AgentModelClass agentModelClass = objectMapper.convertValue(data.get(0), AgentModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new AgentsBrokerPage();
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.secondaryPhoneAddedSuccessfully(agentModelClass);
    }
}
