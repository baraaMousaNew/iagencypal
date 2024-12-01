package page_objects.agents.actors;

import model_classes.agents.AgentModelClass;

public interface AgentsBroker extends AgentsActors{

    @Override
    void addAgentBasicInformation(AgentModelClass agentModelClass);

    @Override
    void addAgentAddressInformation(AgentModelClass agentModelClass);

    @Override
    void addAgentRolesInformation(AgentModelClass agentModelClass);

    @Override
    void agentDetailsDisplaySuccessfully(AgentModelClass agentModelClass);

    @Override
    void agentInformationDisplaySuccessfully(AgentModelClass agentModelClass);

    @Override
    void agentPersonalInformationDisplaySuccessfully(AgentModelClass agentModelClass);

    @Override
    void agentAddressInformationDisplaySuccessfully(AgentModelClass agentModelClass);

    @Override
    void agentRolesDisplaySuccessfully(AgentModelClass agentModelClass);

    @Override
    void updateAgentInformation(AgentModelClass agentModelClass);

    @Override
    void updateAgentPersonalInformation(AgentModelClass agentModelClass);

    @Override
    void updateAgentAddressInformation(AgentModelClass agentModelClass);

    @Override
    void updateAgentRolesInformation(AgentModelClass agentModelClass);

    @Override
    void addSecondaryEmail(AgentModelClass agentModelClass);

    @Override
    void secondaryEmailAddedSuccessfully(AgentModelClass agentModelClass);

    @Override
    void addSecondaryPhone(AgentModelClass agentModelClass);

    @Override
    void secondaryPhoneAddedSuccessfully(AgentModelClass agentModelClass);
}
