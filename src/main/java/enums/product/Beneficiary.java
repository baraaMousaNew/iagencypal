package enums.product;

public enum Beneficiary {

    CLIENT("Client"),

    GROUP("Group");

    public final String label;

    Beneficiary(String label){
        this.label = label;
    }

}
