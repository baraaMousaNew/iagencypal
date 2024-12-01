package enums.product;

public enum DateTime {


    DATE_TIME_I("dd/MM/yyyy"),

    DATE_TIME_II("dd/MM/yyyy HH:mm");

    public final String label;

    DateTime(String label){
        this.label = label;
    }
}
