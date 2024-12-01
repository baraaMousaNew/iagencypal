package elements.string_handler;

import org.openqa.selenium.By;

public class LinkTextStrategy implements StringLocatorStrategy{

    @Override
    public boolean matches(String locator) {

        if(locator.startsWith("linkText=")){
            return true;
        }
        return false;
    }

    @Override
    public By getByLocator(String locator) {
        return By.linkText(locator);
    }
}
