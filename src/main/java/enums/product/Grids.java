package enums.product;

public enum Grids {

    FORM_TYPE("Form Type"),

    CLIENT("Client"),

    YEAR("Year"),

    SENT_DATE("Sent Date"),

    ACTION("Action"),

    STATUS("Status"),

    SUBMITTED_AGENT("Submitted Agent"),

    SUBMITTED_DATE("Submitted Date"),

    FORM_NAME("Form Name"),

    HOUSEHOLD_SIZE("#Household Size"),

    DOCTOR_HOSPITALS("Doctors/ Hospitals"),

    DOCTOR_HOSPITALS_NO("No."),

    PRESCRIPTIONS("Prescriptions"),

    DOSAGE_PRESCRIPTION("Dosage Description"),

    FULL_NAME("Full Name"),

    SERVING_AGENT("Serving Agent"),

    CONTACT_EMAIL("Contact Email"),

    EMAIL("Email"),

    INDEPENDENT_AGENT("Independent Agent"),

    PHONE("Phone"),

    ACTIVE_STATUS("Active Status"),

    CARRIER_NAME("Carrier Name"),

    TOTAL_PRODUCTS("Total Products"),

    PRODUCT_NAME("Product Name"),

    PRODUCT_EFFECTIVE_DATE("Product Effective Date"),

    POLICY_NUMBER("Policy Number"),

    POLICY_HOLDER("Policy Holder"),

    POLICY_EFFECTIVE_DATE("Effective Date");

    public final String label;

    Grids(String label){
        this.label = label;
    }
}
