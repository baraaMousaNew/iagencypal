package assertions;

import assertions.selenium.SeleniumAssertionFunction;
import assertions.selenium.WebAssertionFunction;
import enums.AssertType;
import enums.product.TabularContent;

import java.util.Objects;


public class AssertionsContext<T,U> implements WebAssertions<T,U>{

    private WebAssertionFunction<T, U> assertionFunction;

    public AssertionsContext() {
        this.assertionFunction = new SeleniumAssertionFunction<T,U>();
    }

    @Override
    public String assertElementIsPresent(T elementLocator, AssertType assertType) {
        return assertionFunction.isPresent(elementLocator, assertType).assertIsTrue();
    }

    @Override
    public String assertElementNotPresent(T elementLocator, AssertType assertType) {
        return assertionFunction.isPresent(elementLocator, assertType).assertIsFalse();
    }

    @Override
    public String assertElementIsVisible(T elementLocator, AssertType assertType) {
        return assertionFunction.isVisible(elementLocator, assertType).assertIsTrue();
    }

    @Override
    public String assertElementIsClickable(T elementLocator, AssertType assertType) {
        return assertionFunction.isClickable(elementLocator, assertType).assertIsTrue();
    }

    @Override
    public String assertElementNotVisible(T elementLocator, AssertType assertType) {
        return assertionFunction.isVisible(elementLocator, assertType).assertIsFalse();
    }

    @Override
    public String assertElementIsEditable(T elementLocator, AssertType assertType) {
        return assertionFunction.isEditable(elementLocator, assertType).assertIsTrue();
    }

    @Override
    public String assertElementNotEditable(T elementLocator, AssertType assertType) {
        return assertionFunction.isEditable(elementLocator, assertType).assertIsFalse();
    }

    @Override
    public String assertElementHasText(T elementLocator, String text, AssertType assertType) {
        if(Objects.nonNull(text)){
            return assertionFunction.hasText(elementLocator, text, assertType).assertIsTrue();
        }
        return null;
    }

    @Override
    public String assertElementHasNoText(T elementLocator, String text, AssertType assertType) {
        if(Objects.nonNull(text)){
            return assertionFunction.hasText(elementLocator, text, assertType).assertIsFalse();
        }
        return null;
    }

    @Override
    public String assertElementEqualText(T elementLocator, String text, AssertType assertType) {
        if(Objects.nonNull(text)){
            return assertionFunction.equalText(elementLocator, text, assertType).assertIsTrue();
        }
        return null;
    }

    @Override
    public String assertElementEqualNoText(T elementLocator, String text, AssertType assertType) {
        if(Objects.nonNull(text)){
            return assertionFunction.equalText(elementLocator, text, assertType).assertIsFalse();
        }
        return null;
    }


    @Override
    public String assertFieldValueEqual(T elementLocator, String expectedValue, AssertType assertType) {
        if(Objects.nonNull(expectedValue)){
            return assertionFunction.valueEqual(elementLocator, expectedValue, assertType).assertIsTrue();
        }
        return null;
    }

    @Override
    public String assertDivContains(T elementLocator, String elementString, AssertType assertType) {
        if(Objects.nonNull(elementString)){
            return assertionFunction.divContainElement(elementLocator, elementString, assertType).assertIsTrue();
        }
        return null;
    }

    @Override
    public String assertFieldValueNotEqual(T elementLocator, String expectedValue, AssertType assertType) {
        if(Objects.nonNull(expectedValue)){
            return assertionFunction.valueEqual(elementLocator, expectedValue, assertType).assertIsFalse();
        }
        return null;
    }

    @Override
    public String assertSelectValueEqual(T elementLocator, String expectedValue, AssertType assertType) {
        if(Objects.nonNull(expectedValue)){
            return assertionFunction.selectValueEqual(elementLocator, expectedValue, assertType).assertIsTrue();
        }
        return null;
    }

    @Override
    public String assertContainValue(T elementLocator, String expectedValue, AssertType assertType) {
        if(Objects.nonNull(expectedValue)){
            return assertionFunction.containValue(elementLocator, expectedValue, assertType).assertIsTrue();
        }
        return null;
    }

    @Override
    public String assertContainNoValue(T elementLocator, String expectedValue, AssertType assertType) {
        if(Objects.nonNull(expectedValue)){
            return assertionFunction.containValue(elementLocator, expectedValue, assertType).assertIsFalse();
        }
        return null;
    }

    @Override
    public String assertGridValue(T gridTableLocator, String header, String value, int row, AssertType assertType) {
        return assertionFunction.gridValue(gridTableLocator, header, value, row, assertType).assertIsTrue();
    }

    @Override
    public String assertGridValueMatch(T elementLocator, String header, String regex, int row, AssertType assertType) {
        return assertionFunction.gridValueMatch(elementLocator, header, regex, row, assertType).assertIsTrue();
    }

    @Override
    public String assertGridRadioSelected(T elementLocator, String header, boolean selected, int row, AssertType assertType) {
        return assertionFunction.gridRadioSelected(elementLocator, header, selected, row, assertType).assertIsTrue();
    }

    @Override
    public String assertGridRadioNotSelected(T elementLocator, String header, boolean selected, int row, AssertType assertType) {
        return assertionFunction.gridRadioSelected(elementLocator, header, selected, row, assertType).assertIsFalse();
    }

    @Override
    public String assertGridButtonLabel(T elementLocator, String header, String label, int row, AssertType assertType) {
        return assertionFunction.gridButtonLabel(elementLocator, header, label, row, assertType).assertIsTrue();
    }

    @Override
    public String assertGridCheckboxSelected(T elementLocator, String header, String radioLabel, AssertType assertType) {
        return assertionFunction.gridElementSelected(elementLocator, header, radioLabel, assertType).assertIsTrue();
    }

    @Override
    public String assertElementTextMatch(T elementLocator, String regex,  AssertType assertType) {
        return assertionFunction.fieldTextMatch(elementLocator, regex, assertType ).assertIsTrue();
    }

    @Override
    public String assertElementValueMatch(T elementLocator, String regex, AssertType assertType) {
        return assertionFunction.fieldValueMatch(elementLocator, regex, assertType).assertIsTrue();
    }

    @Override
    public String assertElementAttribute(T elementLocator, String attribute, AssertType assertType) {
        return assertionFunction.elementAttribute(elementLocator, attribute, assertType).assertIsTrue();
    }

    @Override
    public String assertRadioSelection(T elementLocator, String value, AssertType assertType) {
        return assertionFunction.radioButtonValue(elementLocator, value, assertType).assertIsTrue();
    }

    @Override
    public String assertFormBoxValue(T elementLocator, int formBoxOrder, String label, String value, AssertType assertType) {
        if(Objects.nonNull(value)){
            return assertionFunction.formBoxValue(elementLocator, formBoxOrder, label, value, assertType).assertIsTrue();
        }
        return null;
    }

    @Override
    public String assertInputBoxValue(T elementLocator, int inputBoxOrder, String value, AssertType assertType) {
        if(Objects.nonNull(value)){
            return assertionFunction.inputBoxValue(elementLocator, inputBoxOrder, value, assertType).assertIsTrue();
        }
        return null;
    }

    @Override
    public String assertSummaryGridValue(T elementLocator, String header, String value, int row, AssertType assertType) {
        return assertionFunction.summaryGridValue(elementLocator, header, value, row, assertType).assertIsTrue();
    }

    @Override
    public String assertCheckboxChecked(T elementLocator, AssertType assertType) {
        return assertionFunction.checkboxChecked(elementLocator, assertType).assertIsTrue();
    }

    @Override
    public String assertCheckboxStatus(T elementLocator, boolean selected, AssertType assertType) {
        if(selected){
            return assertionFunction.checkboxChecked(elementLocator, assertType).assertIsTrue();
        }else {
            return assertionFunction.checkboxChecked(elementLocator, assertType).assertIsFalse();
        }
    }

    @Override
    public String assertTabPanel(T tabPanel, TabularContent contentType, String header, U value, int row,AssertType assertType) {
        return assertionFunction.tabPanelHas(tabPanel, contentType, header, value, row, assertType).assertIsTrue();
    }

}
