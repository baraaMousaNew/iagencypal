package enums;

public enum WebBrowsersEnum {

    CHROME("chrome"),

    FIREFOX("firefox");

    public final String label;

    private WebBrowsersEnum(String label) {
        this.label = label;
    }
}
