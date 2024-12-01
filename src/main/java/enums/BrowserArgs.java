package enums;

public enum BrowserArgs {

    HEADLESS("--headless"),
    INCOGNITO("--incognito"),
    MAXIMIZED("--start-maximized");

    public final String label;

    BrowserArgs(String label){
        this.label = label;
    }
}
