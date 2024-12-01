package enums;

public enum TestVariables {

    RELATION("relation"),
    FIRST_NAME("first name"),
    LAST_NAME("last name"),
    GENDER("gender"),
    DATE_OF_BIRTH("date of birth"),
    SSN("ssn"),
    LEGAL_STATUS("legal status");

    public final String label;

    private TestVariables(String label){
        this.label = label;
    }
}
