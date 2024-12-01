package elements;

import driver_factory.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ElementLocatorContext {

    public <T> WebElement applyStrategy(T locator){
        LocatorStrategy locatorStrategy;
        if(locator instanceof WebElement){
            locatorStrategy = new WebElementStrategy();
        } else if (locator instanceof By) {
            locatorStrategy = new ByElementStrategy();
        } else if (locator instanceof String) {
            locatorStrategy = new StringElementStrategy();
        }else {
            throw new RuntimeException("locator type cannot be recognized");
        }
        return locatorStrategy.locate(locator);
    }

}
