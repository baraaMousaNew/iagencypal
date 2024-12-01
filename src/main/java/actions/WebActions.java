package actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface WebActions<T> {

    void click(T elementLocator);

    void click(WebElement webElement);

    void clickJs(WebElement element);

    void clickJs(T elementLocator);

    void sendKeys(T elementLocator, String value);

    void sendKeysSetKeys(T elementLocator, Keys[] keys);

    void selectByValue(T elementLocator, String value);

    void selectByIndex(T elementLocator, int index);

    void navigate(String url, boolean addBase);

    void switchToTab(String url);

    void checkbox(T elementLocator, boolean check);

    void reloadPage();

    void hover(T elementLocator);

    void clearCache();

    void executeJSCommand(WebElement element, String command);

    void scrollToElement(WebElement element);

    void scrollToElementAPI(WebElement element);

    void fillSignField(T elementLocator);

    WebElement getCellOfGrid(T grid, int row, int column);

    WebElement getLastCellOfGrid(T grid, int row);

    void fillDateField(T elementLocator, String date);

    void selectRadioButtonGrid(T grid, String value);

    String getClipboardValue();

    void switchCurrentTab(int tabOrder);

    void selectRadioButton(T elementLocator, String option);

    void sendKeysAndClick(T fieldLocator, T buttonLocator, String value);

    String getValueOfField(T fieldLocator);
}
