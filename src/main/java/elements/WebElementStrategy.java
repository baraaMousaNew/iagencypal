package elements;

import actions.SeleniumActions;
import auxiliary.StaticAuxiliary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementStrategy implements LocatorStrategy<WebElement> {

    @Override
    public WebElement locate(WebElement locator) {
        return StaticAuxiliary.highLight(locator);
    }
}
