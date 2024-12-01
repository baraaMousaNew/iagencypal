package enums.product;

public enum Roles {

    BROKER("Broker"),

    AGENT("Agent");

    public final String label;

    Roles(String label){
        this.label = label;
    }
}
