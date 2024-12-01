package elements.string_handler;

import org.openqa.selenium.By;

public class ClassNameStrategy implements StringLocatorStrategy{
    @Override
    public boolean matches(String locator) {

        if(locator.toLowerCase().startsWith("class=")){
            return true;
        }
        return false;
    }

    @Override
    public By getByLocator(String locator) {
        return By.className(locator);
    }
}
