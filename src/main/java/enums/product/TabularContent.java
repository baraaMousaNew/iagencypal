package enums.product;

public enum TabularContent {

    TEXT("String Text"),

    BUTTON("Button Element"),

    IMAGE("Image Element"),

    CHECKBOX("Checkbox Element");


    public final String label;

    TabularContent(String label){
        this.label = label;
    }
}
