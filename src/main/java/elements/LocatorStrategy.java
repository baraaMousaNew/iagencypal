package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface LocatorStrategy<T> {

    WebElement locate(T locator);

}
