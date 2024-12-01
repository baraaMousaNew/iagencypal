package enums;

public enum AutomationToolsEnum {

    SELENIUM("selenium"),

    REST_ASSURED("rest-assured");

    public final String label;

    private AutomationToolsEnum(String label) {
        this.label = label;
    }
}
