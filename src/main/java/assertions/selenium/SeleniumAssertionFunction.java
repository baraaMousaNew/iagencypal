package assertions.selenium;

import actions.SeleniumActions;
import assertions.assertion_type.AssertionType;
import assertions.assertion_type.AssertionTypeContext;
import assertions.element_type.ElementsContext;
import com.google.common.base.Strings;
import driver_factory.DriverManager;
import elements.ElementLocatorContext;
import enums.AssertType;
import enums.product.TabularContent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import synchronization.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeleniumAssertionFunction<T,U> implements WebAssertionFunction<T,U>{

    @Override
    public AssertionType isPresent(T elementLocator, AssertType assertType) {
        ElementLocatorContext context = new ElementLocatorContext();
        boolean condition;
        try{
            WebElement webElement = context.applyStrategy(elementLocator);
            condition = true;
        }catch (TimeoutException e){
            condition = false;
        }
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType isVisible(T elementLocator, AssertType assertType) {
        ElementLocatorContext context = new ElementLocatorContext();
        boolean condition;
        try{
            WebElement webElement = context.applyStrategy(elementLocator);
            condition = true;
        }catch (TimeoutException e){
            condition = false;
        }
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType isEditable(T elementLocator, AssertType assertType) {
        ElementLocatorContext context = new ElementLocatorContext();
        boolean condition;
        WebElement webElement = context.applyStrategy(elementLocator);
        condition = webElement.isEnabled();
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType isClickable(T elementLocator, AssertType assertType) {
        ElementLocatorContext context = new ElementLocatorContext();
        boolean condition;
        WebElement webElement = context.applyStrategy(elementLocator);
        try{
            Waiter.waitForElementClickable(webElement);
            condition = true;
        }catch (TimeoutException e){
            condition = false;
        }
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType hasText(T elementLocator, String text, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        condition = webElement.getText().trim().contains(text);
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType equalText(T elementLocator, String text, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        condition = webElement.getText().trim().equals(text);
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType valueEqual(T elementLocator, String value, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        condition = webElement.getAttribute("value").equals(value);
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType divContainElement(T elementLocator, String elementString, AssertType assertType) {
        boolean condition = false;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        List<WebElement> elements = webElement.findElements(By.tagName("div"));
        if(!elementString.isEmpty()){
            for(WebElement element: elements){
                if(element.getText().trim().equalsIgnoreCase(elementString)){
                    condition = true;
                    break;
                }
            }
        }else {
            condition = elements.isEmpty();
        }
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType selectValueEqual(T elementLocator, String value, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
//        String optionValue = webElement.getAttribute("value");
//        String option = webElement.findElement(
//                By.xpath("//option[@value='" + optionValue + "']")).getText().trim();
        Select select = new Select(webElement);
        String option = select.getFirstSelectedOption().getText().trim();
        condition = option.equals(value);
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType containValue(T elementLocator, String value, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        condition = webElement.getAttribute("value").contains(value);
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType gridValue(T elementLocator, String header, String value, int row, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        String script = "return arguments[0].nextSibling.nodeValue.trim();";
        int headerIndex = -1;
        List<WebElement> headers;
        headers = webElement.findElement(By.tagName("thead"))
                .findElements(By.tagName("th"));
        for(int i=0 ; i < headers.size() ; i++){
            WebElement div = headers.get(i).
                    findElement(By.cssSelector("div[class='ipal_table_header_action']"));
            String textBelowDiv = (String) executor.executeScript(script, div);
            //String headerValue = headers.get(i).findElement(By.xpath("//div")).getText();
            if(textBelowDiv.equals(header)){
                headerIndex = i;
                break;
            }
        }
        if(headerIndex < 0){
            Assert.fail("Header isn't found in grid: " + header);
        }

        WebElement targetRow = webElement.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(row-1);
        WebElement column = targetRow.findElements(By.tagName("td")).get(headerIndex);
        try{
            condition = column.findElement(By.tagName("label")).getText().trim().equals(value);
        }catch (NoSuchElementException e){
            condition = column.findElement(By.tagName("div")).getText().trim().equals(value);
        }

        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType summaryGridValue(T elementLocator, String header, String value, int row, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        List<WebElement> headers = webElement.findElement(By.tagName("thead")).findElements(By.tagName("th"));
        int headerIndex = -1;
        for(WebElement headerElement: headers){
            headerIndex++;
            String caption = headerElement.findElement(By.tagName("div")).getText().trim();
            if(caption.equalsIgnoreCase(header)){
                break;
            }
        }
        if(headerIndex < 0){
            Assert.fail("Cannot find the header: " + header);
        }
        String actualValue = webElement.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(row - 1).
                findElements(By.tagName("td")).get(headerIndex).findElement(By.tagName("div")).getText().trim();
        condition = actualValue.equalsIgnoreCase(value);
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType gridValueMatch(T elementLocator, String header, String regex, int row, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        String script = "return arguments[0].nextSibling.nodeValue.trim();";
        int headerIndex = -1;
        List<WebElement> headers;
        headers = webElement.findElement(By.tagName("thead")).findElement(By.tagName("tr"))
                .findElements(By.tagName("th"));
        for(int i=0 ; i < headers.size() ; i++){
            WebElement div = headers.get(i).
                    findElement(By.cssSelector("div[class='ipal_table_header_action']"));
            String textBelowDiv = (String) executor.executeScript(script, div);
            //String headerValue = headers.get(i).findElement(By.xpath("//div")).getText();
            if(textBelowDiv.equals(header)){
                headerIndex = i;
                break;
            }
        }
        if(headerIndex < 0){
            Assert.fail("Header isn't found in grid: " + header);
        }

        WebElement targetRow = webElement.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(row-1);
        WebElement column = targetRow.findElements(By.tagName("td")).get(headerIndex);
        Pattern pattern = Pattern.compile(regex);

        try{
            condition = pattern.matcher(column.findElement(By.tagName("label")).getText().trim()).matches();
        }catch (NoSuchElementException e){
            condition = pattern.matcher(column.findElement(By.tagName("div")).getText().trim()).matches();
        }

        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType fieldTextMatch(T elementLocator, String regex, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        Pattern pattern = Pattern.compile(regex);
        condition = pattern.matcher(webElement.getText().trim()).matches();
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType fieldValueMatch(T elementLocator, String regex, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        Pattern pattern = Pattern.compile(regex);
        condition = pattern.matcher(webElement.getAttribute("value").trim()).matches();
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType elementAttribute(T elementLocator, String attribute, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        String attributeResult = webElement.getAttribute(attribute);
        condition = attributeResult != null;
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType radioButtonValue(T elementLocator, String value, AssertType assertType) {
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        new SeleniumActions<>().scrollToElementAPI(webElement);
        List<WebElement> options = webElement.findElements(By.className("form-check"));
        boolean selected = false;
        for (WebElement option : options) {
            String label = option.findElement(By.tagName("label")).getText().trim();
            if (label.equalsIgnoreCase(value)) {
                WebElement input = Waiter.waitForElementVisible(option.findElement(By.tagName("input")));
                selected = input.isSelected();
                break;
            }
        }
        return new AssertionTypeContext(selected, assertType).getAssertionType();
    }

    @Override
    public AssertionType formBoxValue(T elementLocator, int formBoxOrder, String label, String value, AssertType assertType) {
        boolean condition = false;
        String formBoxItem = elementLocator + "//div[contains(@class,'item')]" + "[" + formBoxOrder + "]";
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement element = context.applyStrategy(formBoxItem);
        List<WebElement> rows = element.findElements(By.cssSelector("div[class*='row']"));
        for(WebElement row : rows){
            List<WebElement> columns = row.findElements(By.cssSelector("div[class*='col']"));
            for(WebElement column : columns){
                if(column.findElements(By.tagName("h6")).get(0).getText().trim().equalsIgnoreCase(label)){
                    condition = column.findElements(By.tagName("h6")).get(1).getText().trim().equalsIgnoreCase(value);
                }
            }
        }
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType gridElementSelected(T elementLocator, String header, String radioLabel, AssertType assertType) {
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement table = context.applyStrategy(elementLocator);
        WebElement thead = table.findElement(By.tagName("thead"));
        WebElement tr = thead.findElement(By.tagName("tr"));
        List<WebElement> headers = tr.findElements(By.tagName("th"));
        int headerIndex = -1;
        for(int i=0; i<headers.size();i++){
            if(headers.get(i).findElement(By.tagName("h5")).getText().trim().equalsIgnoreCase(header)){
                headerIndex = i;
                break;
            }
        }
        if(headerIndex < 0){
            Assert.fail("Couldn't find the index of the header: " + header + " in the table");
        }
        boolean condition = false;
        WebElement inputField = null;
        List<WebElement> bodyRows = table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        for(WebElement bodyRow : bodyRows){
            String label = bodyRow.findElements(By.tagName("td")).get(headerIndex).findElement(By.tagName("label")).getText().trim();
            if(radioLabel.equalsIgnoreCase(label)){
                inputField = bodyRow.findElements(By.tagName("td")).get(headerIndex).findElement(By.tagName("input"));
                condition = inputField.isSelected();
                break;
            }
        }
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType inputBoxValue(T elementLocator, int inputBoxOrder, String value, AssertType assertType) {
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement inputBoxDiv = context.applyStrategy(elementLocator);
        List<WebElement> inputBoxes = inputBoxDiv.findElements(By.cssSelector("div[class*='input_box']"));
        boolean condition = inputBoxes.get(inputBoxOrder - 1).findElement(By.tagName("h6")).getText().trim().equalsIgnoreCase(value);
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType checkboxChecked(T elementLocator, AssertType assertType) {
        boolean condition = false;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement inputBoxDiv = context.applyStrategy(elementLocator);
        condition = inputBoxDiv.isSelected();
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType tabPanelHas(T tabPanel, TabularContent contentType, String header, U value, int row, AssertType assertType) {
        boolean condition = false;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement tabPanelWebElement = context.applyStrategy(tabPanel);
        List<WebElement> headers = tabPanelWebElement.findElement(By.xpath("./div[contains(@class,'tab-container')]")).
                findElement(By.xpath("./div[contains(@class,'tab-container-head')]"))
                .findElements(By.xpath("./div[contains(@class,'tab-container-head-item')]"));
        int headerIndex = -1;
        int headerCounter = 0;
        for(WebElement headerElement: headers){
            if(headerElement.findElement(By.tagName("h6")).
                    getText().trim().equalsIgnoreCase(header)){
                headerIndex = headerCounter;
            }
            headerCounter++;
        }
        if(headerIndex<0){
            Assert.fail("Couldn't find the index of the header: " + header + " in the tab panel");
        }
        WebElement rowContainingValue = tabPanelWebElement.findElement(By.
                xpath("./div[contains(@class,'tab-container')]")).
                findElements(By.xpath
                        ("./div[contains(@class,'tab-container-row')]")).get(row - 1);
        WebElement valueRowColumn = rowContainingValue.findElements(By.
                xpath("./div[contains(@class,'tab-container-row-item')]")).get(headerIndex);
        condition = new ElementsContext<>(contentType).getElement().is(valueRowColumn, value);
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType gridRadioSelected(T elementLocator, String header, boolean selected, int row, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        String script = "return arguments[0].nextSibling.nodeValue.trim();";
        int headerIndex = -1;
        List<WebElement> headers;
        headers = webElement.findElement(By.tagName("thead")).findElement(By.tagName("tr"))
                .findElements(By.tagName("th"));
        for(int i=0 ; i < headers.size() ; i++){
            WebElement div = headers.get(i).
                    findElement(By.cssSelector("div[class='ipal_table_header_action']"));
            String textBelowDiv = (String) executor.executeScript(script, div);
            //String headerValue = headers.get(i).findElement(By.xpath("//div")).getText();
            if(textBelowDiv.equals(header)){
                headerIndex = i;
                break;
            }
        }
        if(headerIndex < 0){
            Assert.fail("Header isn't found in grid: " + header);
        }
        WebElement targetRow = webElement.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(row-1);
        WebElement column = targetRow.findElements(By.tagName("td")).get(headerIndex);
        condition = column.findElement(By.cssSelector("div[class='form-check form-switch']")).findElement(By.cssSelector("input[type='checkbox']")).isSelected();
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

    @Override
    public AssertionType gridButtonLabel(T elementLocator, String header, String label, int row, AssertType assertType) {
        boolean condition;
        ElementLocatorContext context = new ElementLocatorContext();
        WebElement webElement = context.applyStrategy(elementLocator);
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        String script = "return arguments[0].nextSibling.nodeValue.trim();";
        int headerIndex = -1;
        List<WebElement> headers;
        headers = webElement.findElement(By.tagName("thead")).findElement(By.tagName("tr"))
                .findElements(By.tagName("th"));
        for(int i=0 ; i < headers.size() ; i++){
            WebElement div = headers.get(i).
                    findElement(By.cssSelector("div[class='ipal_table_header_action']"));
            String textBelowDiv = (String) executor.executeScript(script, div);
            //String headerValue = headers.get(i).findElement(By.xpath("//div")).getText();
            if(textBelowDiv.equals(header)){
                headerIndex = i;
                break;
            }
        }
        if(headerIndex < 0){
            Assert.fail("Header isn't found in grid: " + header);
        }
        WebElement targetRow = webElement.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(row-1);
        WebElement column = targetRow.findElements(By.tagName("td")).get(headerIndex);
        condition = column.findElement(By.tagName("button")).getText().trim().equalsIgnoreCase(label);
        return new AssertionTypeContext(condition, assertType).getAssertionType();
    }

}
