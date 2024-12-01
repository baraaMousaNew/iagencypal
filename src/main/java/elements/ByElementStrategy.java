package elements;

import auxiliary.StaticAuxiliary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import synchronization.Waiter;

public class ByElementStrategy implements LocatorStrategy<By>{

    @Override
    public WebElement locate(By locator) {
        return StaticAuxiliary.highLight(Waiter.waitForElementVisible(locator));
    }
}
