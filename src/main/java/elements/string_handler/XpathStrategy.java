package elements.string_handler;

import org.openqa.selenium.By;

public class XpathStrategy implements StringLocatorStrategy{

    @Override
    public boolean matches(String locator) {
        if(locator.toLowerCase().startsWith("xpath=") ||
                locator.startsWith("//") || locator.startsWith("/") ||
                locator.startsWith("./") || locator.startsWith(".//")){
            return true;
        }
        return false;
    }

    @Override
    public By getByLocator(String locator) {
        return By.xpath(locator);
    }
}
