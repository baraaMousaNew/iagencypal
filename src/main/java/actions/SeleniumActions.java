package actions;

import driver_factory.DriverManager;
import elements.ElementLocatorContext;
import io.cucumber.java.en_old.Ac;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import properties.Platform;
import synchronization.Waiter;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SeleniumActions<T> implements WebActions<T> {

    @Override
    public void click(T elementLocator) {
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        try{
            //webElement.click();
            clickAPI(webElement);
        }catch (ElementClickInterceptedException e){
            clickJs(webElement);
        }

    }

    @Override
    public void click(WebElement webElement) {
        webElement.click();
    }

    @Override
    public void clickJs(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("'arguments[0].click();'", element);
    }

    private void clickAPI(WebElement element){
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element).pause(Platform.PlatformProperties.actionsPauseMilli).click().perform();
    }

    @Override
    public void clickJs(T elementLocator) {
        WebElement webElement = new ElementLocatorContext().applyStrategy(elementLocator);
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("'arguments[0].click();'", webElement);
    }

    private void sendKeysJS(WebElement element, String value){
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].value = '" + value + "';", element );
    }

    @Override
    public void sendKeys(T elementLocator, String value) {
        if(Objects.nonNull(value)){
            ElementLocatorContext context = new ElementLocatorContext();
            Actions actions = new Actions(DriverManager.getDriver());
            WebElement webElement = context.applyStrategy(elementLocator);
            if(!webElement.getAttribute("class").contains("p-autocomplete-input")) {
                if(webElement.getAttribute("type") != null &&
                        webElement.getAttribute("type").equalsIgnoreCase("file")){
                    actions.pause(Platform.PlatformProperties.actionsPauseMilli)
                            .build().perform();
                    webElement.sendKeys(value);
                }else{
//                    webElement.clear();
                    webElement.sendKeys(Keys.CONTROL + "a"); // Select all text
                    webElement.sendKeys(Keys.DELETE);        // Delete selected text
                    actions.pause(Platform.PlatformProperties.actionsPauseMilli).
                            sendKeys(webElement,value)
                            .build().perform();
                }

            }else {
                this.sendKeysAutoComplete(webElement, value);
            }
        }
    }

    private void sendKeysAutoComplete(WebElement element, String value){
        if(Objects.nonNull(value)){
            Actions actions = new Actions(DriverManager.getDriver());
            element.sendKeys(value);
            element.sendKeys(Keys.ARROW_DOWN);
            WebElement panel = null;
            try{
                panel = Waiter.waitForElementVisible(element.findElement(By.xpath("./following-sibling::div[contains(@class,'p-autocomplete-panel')]")));
            }catch (NoSuchElementException e){
                actions.pause(Duration.ofMillis(500)).sendKeys(element, Keys.ARROW_DOWN).perform();
                panel = Waiter.waitForElementVisible(element.findElement(By.xpath("./following-sibling::div[contains(@class,'p-autocomplete-panel')]")));
            }
            WebElement option = panel.findElement(By.tagName("ul")).findElement(By.tagName("li")).findElement(By.tagName("div"));
            actions.pause(Duration.ofMillis(500)).click(option).perform();
        }
    }

    @Override
    public void selectByValue(T elementLocator, String value) {
        if(Objects.nonNull(value)){
            ElementLocatorContext context = new ElementLocatorContext();
            WebElement webElement = context.applyStrategy(elementLocator);
            Select select = new Select(webElement);
            select.selectByVisibleText(value);
        }
    }

    @Override
    public void selectByIndex(T elementLocator, int index) {
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        Select select = new Select(webElement);
        select.selectByIndex(index);
    }

    @Override
    public void navigate(String url, boolean addBase) {
        if(addBase) {
            DriverManager.getDriver().get(Platform.PlatformProperties.environment + url);
        }else {
            DriverManager.getDriver().get(url);
        }
    }

    //https://stackoverflow.com/questions/12729265/switch-tabs-using-selenium-webdriver-with-java
    @Override
    public void switchToTab(String url) {
        WebDriver driver = DriverManager.getDriver();
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(url);
    }

    @Override
    public void checkbox(T elementLocator, boolean check) {
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        boolean checked = webElement.isSelected();
        if(check && !checked){
//            webElement.click();
            new Actions(DriverManager.getDriver()).pause(Platform.PlatformProperties.
                    actionsPauseMilli).click(webElement).build().perform();
        } else if (!check && checked) {
//            webElement.click();
            new Actions(DriverManager.getDriver()).pause(Platform.PlatformProperties.
                    actionsPauseMilli).click(webElement).build().perform();
        }
    }

    @Override
    public void reloadPage() {
        DriverManager.getDriver().navigate().refresh();
    }

    @Override
    public void hover(T elementLocator) {
        WebElement webElement = new ElementLocatorContext().applyStrategy(elementLocator);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(webElement).pause(Platform.PlatformProperties.actionsPauseMilli).
                build().perform();
    }

    @Override
    public void clearCache() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.localStorage.clear();");
    }

    @Override
    public void executeJSCommand(WebElement element, String command) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(command, element);
    }

    @Override
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Override
    public void scrollToElementAPI(WebElement element) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element).pause(Platform.PlatformProperties.actionsPauseMilli);
        actions.build().perform();
    }

    @Override
    public void fillSignField(T elementLocator) {
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement sign_field = context.applyStrategy(elementLocator);
        int fieldWidth = sign_field.getSize().getWidth();
        int fieldHeight = sign_field.getSize().getHeight();
        Actions actions = new Actions(DriverManager.getDriver());
        this.scrollToElement(sign_field);
        actions.moveToElement(sign_field, fieldWidth/2,fieldHeight/2).
                pause(Duration.ofMillis(500)).
                clickAndHold(sign_field).moveByOffset(50, 50).
            moveByOffset(100, -50).release().perform();
        this.executeJSCommand(sign_field, "arguments[0].dispatchEvent(new Event('change'));");
    }

    @Override
    public WebElement getCellOfGrid(T grid, int row, int column) {
        return null;
    }

    @Override
    public WebElement getLastCellOfGrid(T grid, int row) {
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement table = context.applyStrategy(grid);
        List<WebElement> columns = table.
                findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(row - 1)
                .findElements(By.tagName("td"));
        return columns.get(columns.size() - 1);
    }

    @Override
    public void fillDateField(T elementLocator, String date) {

    }

    @Override
    public void selectRadioButtonGrid(T grid, String value) {
        if(Objects.nonNull(value)){
            ElementLocatorContext context = new ElementLocatorContext();
            WebElement webElement = context.applyStrategy(grid);
            List<WebElement> rows = webElement.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
            boolean found = false;
            for(WebElement row: rows){
                WebElement locator = row.findElement(By.xpath("//td//div//label"));
                if(locator.getText().trim().equals(value)){
                    WebElement radio = locator.findElement(By.xpath("//preceding-sibling::input"));
                    found = true;
                    this.click(radio);
                    break;
                }
            }
            if(!found){
                Assert.fail("Couldn't find the radio button");
            }
        }
    }

    @Override
    public String getClipboardValue() {
        String value = null;
        try{
            value = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
        }catch (UnsupportedFlavorException | IOException e){
            Assert.fail("Cannot get value from clipboard");
        }
         return value;
    }

    @Override
    public void switchCurrentTab(int tabOrder) {
        Set<String> handles = DriverManager.getDriver().getWindowHandles();
        DriverManager.getDriver().switchTo().window((String)handles.toArray()[tabOrder]);
    }

    @Override
    public void selectRadioButton(T elementLocator, String option) {
        if(Objects.nonNull(option)){
            ElementLocatorContext context = new ElementLocatorContext();
            WebElement webElement = context.applyStrategy(elementLocator);
            List<WebElement> options = webElement.findElements(By.className("form-check"));
            for(int i = 0;i < options.size();i++){
                String label = options.get(i).findElement(By.tagName("label")).getText().trim();
                if(label.equalsIgnoreCase(option)){
                    WebElement input = Waiter.waitForElementClickable(options.get(i).findElement(By.tagName("input")));
                    this.scrollToElementAPI(input);
                    if(!input.isSelected()){
                        this.click(input);
                    }
                    break;
                } else if (i == options.size() - 1) {
                    Assert.fail("Invalid option: " + option);
                }
            }
        }
    }

    @Override
    public void sendKeysSetKeys(T elementLocator, Keys[] keys) {
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        Actions actions = new Actions(DriverManager.getDriver());
        for(Keys key: keys){
            actions = actions.sendKeys(webElement, key);
        }
        actions.build().perform();
    }

    @Override
    public void sendKeysAndClick(T fieldLocator, T buttonLocator, String value) {
        this.sendKeys(fieldLocator, value);
        this.click(buttonLocator);
    }

    @Override
    public String getValueOfField(T fieldLocator) {
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(fieldLocator);
        return webElement.getAttribute("value");
    }
}
