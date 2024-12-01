package elements.string_handler;

import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSSStrategy implements StringLocatorStrategy{

    @Override
    public boolean matches(String locator) {
        /*String pattern = "^[^\\[]+\\["; */    /* Example "abc[def" */
        String pattern = "^[A-Za-z]+\\[[^@]+$"; /* Example "abc[def" */
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(locator);
        if(matcher.find() || locator.contains("#") ||
                (locator.contains(".") && !locator.startsWith("./")) ){
            return true;
        }
        return false;
    }

    @Override
    public By getByLocator(String locator) {
        return By.cssSelector(locator);
    }
}
