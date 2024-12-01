package enums;

public enum AssertType {

    HARD("hard"),

    SOFT("soft");

    public final String label;

    AssertType(String label){
        this.label = label;
    }
}
