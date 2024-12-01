package elements.string_handler;

import org.openqa.selenium.By;

public interface StringLocatorStrategy {

    boolean matches(String locator);

    By getByLocator(String locator);
}
