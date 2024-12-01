package enums.product;

public enum FormBox {

    // Relations form box

    RELATION("Relation"),

    FULL_NAME("Full Name"),

    GENDER("Gender"),

    DATE_OF_BIRTH("Date Of Birth"),

    SSN("SSN"),

    LEGAL_STATUS("Legal Status"),

    APPLYING_STATUS("Applying Status");

    public final String label;

    FormBox(String label){
        this.label = label;
    }
}
