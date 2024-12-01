package elements.string_handler;

import org.openqa.selenium.By;

public class PartialLinkTextStrategy implements StringLocatorStrategy {


    @Override
    public boolean matches(String locator) {
        if(locator.startsWith("partialLinkText=")){
            return true;
        }
        return false;
    }

    @Override
    public By getByLocator(String locator) {
        return By.partialLinkText(locator);
    }
}
