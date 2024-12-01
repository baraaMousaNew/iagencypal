package enums;

public enum ThreadVariables {

    BEARER_TOKEN("Authorization"),

    FORM_LINK("form link");

    public final String label;

    private ThreadVariables(String label){
        this.label = label;
    }
}
