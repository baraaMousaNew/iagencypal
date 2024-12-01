package model_classes.forms;

import java.util.Map;

public class SendFormModel{

    private String servicingAgent;

    private String client;

    private String clientEmail;

    private String clientMobile;

    private String formYear;

    private String formType;

    private String clientInstructions;

    private String prePopulate;

    private String customForms;

    private String attachments;

    ////////////////////////////////////////////////////////////////////////////////////

    public String getAttachments() {
        return attachments;
    }

    public String getCustomForms() {
        return customForms;
    }

    public String getPrePopulate() {
        return prePopulate;
    }

    public String getClientInstructions() {
        return clientInstructions;
    }

    public String getFormType() {
        return formType;
    }

    public String getFormYear() {
        return formYear;
    }

    public String getClientMobile() {
        return clientMobile;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getClient() {
        return client;
    }

    public String getServicingAgent() {
        return servicingAgent;
    }

    //////////////////////////////////////////////////////////////////////////


    public void setServicingAgent(String servicingAgent) {
        this.servicingAgent = servicingAgent;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setClientMobile(String clientMobile) {
        this.clientMobile = clientMobile;
    }

    public void setFormYear(String formYear) {
        this.formYear = formYear;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public void setClientInstructions(String clientInstructions) {
        this.clientInstructions = clientInstructions;
    }

    public void setPrePopulate(String prePopulate) {
        this.prePopulate = prePopulate;
    }

    public void setCustomForms(String customForms) {
        this.customForms = customForms;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }
}
