package elements.string_handler;

import org.openqa.selenium.By;

public class NameStrategy implements StringLocatorStrategy{

    @Override
    public boolean matches(String locator) {
        if(locator.toLowerCase().startsWith("name=")){
            return true;
        }
        return false;
    }

    @Override
    public By getByLocator(String locator) {
        return By.name(locator);
    }
}
