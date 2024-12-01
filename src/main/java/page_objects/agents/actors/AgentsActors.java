package page_objects.agents.actors;

import model_classes.agents.AgentModelClass;

public interface AgentsActors {

    void navigate();

    void proceedNext();

    void viewAgentProfile();

    void addAgentBasicInformation(AgentModelClass agentModelClass);

    void addAgentAddressInformation(AgentModelClass agentModelClass);

    void addAgentRolesInformation(AgentModelClass agentModelClass);

    // assertions

    void agentCreatedSuccessfully(AgentModelClass agentModelClass);

    void agentDetailsDisplaySuccessfully(AgentModelClass agentModelClass);

    void agentInformationDisplaySuccessfully(AgentModelClass agentModelClass);

    void agentPersonalInformationDisplaySuccessfully(AgentModelClass agentModelClass);

    void agentAddressInformationDisplaySuccessfully(AgentModelClass agentModelClass);

    void agentRolesDisplaySuccessfully(AgentModelClass agentModelClass);

    void secondaryEmailAddedSuccessfully(AgentModelClass agentModelClass);

    void secondaryPhoneAddedSuccessfully(AgentModelClass agentModelClass);

    // update

    void updateAgentInformation(AgentModelClass agentModelClass);

    void updateAgentPersonalInformation(AgentModelClass agentModelClass);

    void updateAgentAddressInformation(AgentModelClass agentModelClass);

    void updateAgentRolesInformation(AgentModelClass agentModelClass);

    void addSecondaryEmail(AgentModelClass agentModelClass);

    void addSecondaryPhone(AgentModelClass agentModelClass);

}
