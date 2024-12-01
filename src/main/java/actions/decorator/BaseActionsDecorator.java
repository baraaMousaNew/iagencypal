package actions.decorator;

import actions.WebActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseActionsDecorator<T> implements WebActions<T> {

    private WebActions<T> actions;

    public BaseActionsDecorator(WebActions<T> actions) {
        this.actions = actions;
    }

    @Override
    public void click(T elementLocator) {
        this.actions.click(elementLocator);
    }

    @Override
    public void click(WebElement webElement) {
        this.actions.click(webElement);
    }

    @Override
    public void clickJs(WebElement element) {
        this.actions.clickJs(element);
    }

    @Override
    public void clickJs(T elementLocator) {
        this.actions.clickJs(elementLocator);
    }

    @Override
    public void sendKeys(T elementLocator, String value) {
        this.actions.sendKeys(elementLocator, value);
    }

    @Override
    public void selectByValue(T elementLocator, String value) {
        this.actions.selectByValue(elementLocator, value);
    }

    @Override
    public void selectByIndex(T elementLocator, int index) {
        this.actions.selectByIndex(elementLocator, index);
    }

    @Override
    public void navigate(String url, boolean addBase) {
        this.actions.navigate(url, addBase);
    }

    @Override
    public void switchToTab(String url) {
        this.actions.switchToTab(url);
    }

    @Override
    public void checkbox(T elementLocator, boolean check) {
        this.actions.checkbox(elementLocator, check);
    }

    @Override
    public void reloadPage() {
        this.actions.reloadPage();
    }

    @Override
    public void hover(T elementLocator) {
        this.actions.hover(elementLocator);
    }

    @Override
    public void clearCache() {
        this.actions.clearCache();
    }

    @Override
    public void executeJSCommand(WebElement element, String command) {
        this.actions.executeJSCommand(element, command);
    }

    @Override
    public void scrollToElement(WebElement element) {
        this.actions.scrollToElement(element);
    }

    @Override
    public void fillSignField(T elementLocator) {
        this.actions.fillSignField(elementLocator);
    }

    @Override
    public WebElement getCellOfGrid(T grid, int row, int column) {
        return this.actions.getCellOfGrid(grid, row, column);
    }

    @Override
    public WebElement getLastCellOfGrid(T grid, int row) {
        return this.actions.getLastCellOfGrid(grid, row);
    }

    @Override
    public void fillDateField(T elementLocator, String date) {
        this.actions.fillDateField(elementLocator, date);
    }

    @Override
    public void selectRadioButtonGrid(T grid, String value) {
        this.actions.selectRadioButtonGrid(grid, value);
    }

    @Override
    public String getClipboardValue() {
        return this.actions.getClipboardValue();
    }

    @Override
    public void switchCurrentTab(int tabOrder) {
        this.actions.switchCurrentTab(tabOrder);
    }

    @Override
    public void selectRadioButton(T elementLocator, String option) {
        this.actions.selectRadioButton(elementLocator, option);
    }

    @Override
    public void scrollToElementAPI(WebElement element) {
        this.actions.scrollToElementAPI(element);
    }

    @Override
    public void sendKeysSetKeys(T elementLocator, Keys[] keys) {
        this.actions.sendKeysSetKeys(elementLocator, keys);
    }

    @Override
    public void sendKeysAndClick(T fieldLocator, T buttonLocator, String value) {
        this.actions.sendKeysAndClick(fieldLocator, buttonLocator, value);
    }

    @Override
    public String getValueOfField(T fieldLocator) {
        return this.actions.getValueOfField(fieldLocator);
    }
}
