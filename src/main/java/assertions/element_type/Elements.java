package assertions.element_type;

import org.openqa.selenium.WebElement;

public interface Elements<T> {

    boolean is(WebElement locator, T value);
}
