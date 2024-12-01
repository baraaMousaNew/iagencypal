package model_classes.forms;

import java.util.Map;

public class SearchFormModel{

    private String formType;

    private String client;

    private String year;

    private String sentDate;

    private String status;

    private String submittedAgent;

    private String submittedDate;

    ///////////////////////////////////////////////////////////////////////////////

    public String getSubmittedDate() {
        return submittedDate;
    }

    public String getSubmittedAgent() {
        return submittedAgent;
    }

    public String getStatus() {
        return status;
    }

    public String getSentDate() {
        return sentDate;
    }

    public String getYear() {
        return year;
    }

    public String getClient() {
        return client;
    }

    public String getFormType() {
        return formType;
    }

    ////////////////////////////////////////////////////////////////////////////////


    public void setFormType(String formType) {
        this.formType = formType;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSubmittedAgent(String submittedAgent) {
        this.submittedAgent = submittedAgent;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }
}
