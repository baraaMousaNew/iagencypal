package actions.decorator;

import actions.WebActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import synchronization.Waiter;

import java.util.List;

public class AfterActionsDecorator<T> extends BaseActionsDecorator<T>{

    public AfterActionsDecorator(WebActions<T> actions) {
        super(actions);
    }

    @Override
    public void click(T elementLocator) {
        super.click(elementLocator);
    }

    @Override
    public void click(WebElement webElement) {
        super.click(webElement);
    }

    @Override
    public void clickJs(WebElement element) {
        super.clickJs(element);
    }

    @Override
    public void clickJs(T elementLocator) {
        super.clickJs(elementLocator);
    }

    @Override
    public void sendKeys(T elementLocator, String value) {
        super.sendKeys(elementLocator, value);
    }

    @Override
    public void selectByValue(T elementLocator, String value) {
        super.selectByValue(elementLocator, value);
    }

    @Override
    public void selectByIndex(T elementLocator, int index) {
        super.selectByIndex(elementLocator, index);
    }

    @Override
    public void navigate(String url, boolean addBase) {
        super.navigate(url, addBase);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void switchToTab(String url) {
        super.switchToTab(url);
    }

    @Override
    public void checkbox(T elementLocator, boolean check) {
        super.checkbox(elementLocator, check);
    }

    @Override
    public void reloadPage() {
        super.reloadPage();
        Waiter.waitForAngularLoad();
    }

    @Override
    public void hover(T elementLocator) {
        super.hover(elementLocator);
    }

    @Override
    public void clearCache() {
        super.clearCache();
    }

    @Override
    public void executeJSCommand(WebElement element, String command) {
        super.executeJSCommand(element, command);
    }

    @Override
    public void scrollToElement(WebElement element) {
        super.scrollToElement(element);
    }

    @Override
    public void fillSignField(T elementLocator) {
        super.fillSignField(elementLocator);
    }

    @Override
    public WebElement getCellOfGrid(T grid, int row, int column) {
        return super.getCellOfGrid(grid, row, column);
    }

    @Override
    public WebElement getLastCellOfGrid(T grid, int row) {
        return super.getLastCellOfGrid(grid, row);
    }

    @Override
    public void fillDateField(T elementLocator, String date) {
        super.fillDateField(elementLocator, date);
    }

    @Override
    public void selectRadioButtonGrid(T grid, String value) {
        super.selectRadioButtonGrid(grid, value);
    }

    @Override
    public String getClipboardValue() {
        return super.getClipboardValue();
    }

    @Override
    public void switchCurrentTab(int tabOrder) {
        super.switchCurrentTab(tabOrder);
    }

    @Override
    public void selectRadioButton(T elementLocator, String option) {
        super.selectRadioButton(elementLocator, option);
    }

    @Override
    public void scrollToElementAPI(WebElement element) {
        super.scrollToElementAPI(element);
    }

    @Override
    public void sendKeysSetKeys(T elementLocator, Keys[] keys) {
        super.sendKeysSetKeys(elementLocator, keys);
    }

    @Override
    public void sendKeysAndClick(T fieldLocator, T buttonLocator, String value) {
        super.sendKeysAndClick(fieldLocator, buttonLocator, value);
    }

    @Override
    public String getValueOfField(T fieldLocator) {
        return super.getValueOfField(fieldLocator);
    }
}
