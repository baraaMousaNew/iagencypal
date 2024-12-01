package assertions.element_type;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Objects;

public class Checkbox implements Elements<Boolean>{

    @Override
    public boolean is(WebElement locator, Boolean value) {
        boolean checked = false;
        if(locator.getAttribute("type").equals("checkbox")){
            checked = locator.isSelected();
        }else {
            WebElement checkboxElement = locator.findElement(By.
                    xpath(".//input[@type='checkbox']"));
            if(Objects.isNull(checkboxElement)){
                Assert.fail("Cannot find the checkbox element in the locator or the child elements" + locator);
            }else {
                checked = checkboxElement.isSelected();
            }
        }
        return checked == value;
    }
}
