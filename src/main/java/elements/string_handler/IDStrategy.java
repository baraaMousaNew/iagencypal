package elements.string_handler;

import org.openqa.selenium.By;

public class IDStrategy implements StringLocatorStrategy{

    @Override
    public boolean matches(String locator) {
        if(locator.toLowerCase().startsWith("id=")){
            return true;
        }
        return false;
    }

    @Override
    public By getByLocator(String locator) {
        return By.id(locator);
    }
}
