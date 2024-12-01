package elements.string_handler;

import org.openqa.selenium.By;

public class TagNameStrategy implements StringLocatorStrategy{
    @Override
    public boolean matches(String locator) {

        if( locator.matches("^[a-zA-Z]+=('[^']*'|\"[^\"]*\")$")){
            return true;
        }
        return false;
    }

    @Override
    public By getByLocator(String locator) {
        return By.tagName(locator);
    }
}
