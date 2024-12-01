package assertions.element_type;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Objects;

public class Image implements Elements<Boolean>{


    @Override
    public boolean is(WebElement locator, Boolean value) {
        boolean present = false;
        if(locator.getTagName().equals("img")){
            present = true;
        }else{
            WebElement imageLocator = locator.findElement(By.tagName("img"));
            if(Objects.isNull(imageLocator)){
                Assert.fail("Cannot find the image locator in the locator of the child elements: " + locator);
            }else {
                present = true;
            }
        }
        return present == value;
    }
}
