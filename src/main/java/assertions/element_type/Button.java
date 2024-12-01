package assertions.element_type;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Button implements Elements<Boolean>{

    @Override
    public boolean is(WebElement locator, Boolean value) {
        throw new UnsupportedOperationException("Still not implemented");
    }
}
