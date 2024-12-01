package enums.product;

public enum Actors {

    CLIENT("Client"),

    AGENT("Agent"),

    BROKER("Broker");

    public final String label;

    Actors(String label){
        this.label = label;
    }
}
