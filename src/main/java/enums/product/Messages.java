package enums.product;

public enum Messages {

    PENDING_FORM("Form cannot be sent as there is already a pending form for this client."),

    SUCCESS_FORM("Client form sent successfully."),

    SUCCESS_AGENT_CREATION("Agent Added Successfully And Email Sent To The Agent"),

    SUCCESS_CLIENT_SUBMIT("Form Submitted Successfully"),

    SENT_ALREADY("The form you are trying to access has already been successfully submitted. If you need any assistance or have further questions, please contact your serving agent."),

    EMAIL_ADDED("Contact Email Added Successfully"),

    PHONE_ADDED("Phone Number Added Successfully"),

    CARRIER_ADDED("Carrier Added Successfully"),

    PRODUCT_ADDED("Product Added Successfully"),

    POLICY_ADDED("Policy Added Successfully"),

    CLIENT_SUCCESS("Congratulations! Your new Client has been successfully created.");

    public final String label;

    Messages(String label){
        this.label = label;
    }
}
