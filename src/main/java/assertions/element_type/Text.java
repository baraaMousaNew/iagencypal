package assertions.element_type;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Text implements Elements<String>{

    @Override
    public boolean is(WebElement locator, String value) {
        String actualValue = locator.getText().trim();
        if(actualValue.isEmpty()) {
            List<WebElement> childElements = locator.findElements(
                    By.xpath(".//*"));
            for (WebElement element : childElements) {
                if (!element.getText().isEmpty()) {
                    actualValue = element.getText().trim();
                }
            }
            if (actualValue.isEmpty()) {
                Assert.fail("Cannot find any text in the element or child elements: " + locator);
            }
        }
        return actualValue.equalsIgnoreCase(value);
    }
}
