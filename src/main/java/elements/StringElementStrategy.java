package elements;

import actions.SeleniumActions;
import auxiliary.StaticAuxiliary;
import elements.string_handler.StringLocatorContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import synchronization.Waiter;

public class StringElementStrategy implements LocatorStrategy<String>{

    @Override
    public WebElement locate(String locator) {
        By byLocator = new StringLocatorContext().matchLocator(locator);
        return StaticAuxiliary.highLight(Waiter.waitForElementVisible(byLocator));
    }
}
