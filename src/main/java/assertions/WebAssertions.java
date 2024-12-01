package assertions;

import enums.AssertType;
import enums.product.TabularContent;

public interface WebAssertions<T,U> {

    String assertElementIsPresent(T elementLocator, AssertType assertType);

    String assertElementNotPresent(T elementLocator, AssertType assertType);

    String assertElementIsVisible(T elementLocator, AssertType assertType);

    String assertElementIsClickable(T elementLocator, AssertType assertType);

    String assertElementNotVisible(T elementLocator, AssertType assertType);

    String assertElementIsEditable(T elementLocator, AssertType assertType);

    String assertElementNotEditable(T elementLocator, AssertType assertType);

    String assertElementHasText(T elementLocator, String text, AssertType assertType);

    String assertElementHasNoText(T elementLocator, String text, AssertType assertType);

    String assertElementEqualText(T elementLocator, String text, AssertType assertType);

    String assertElementEqualNoText(T elementLocator, String text, AssertType assertType);

    String assertFieldValueEqual(T elementLocator, String expectedValue, AssertType assertType);

    String assertDivContains(T elementLocator, String elementString, AssertType assertType);

    String assertFieldValueNotEqual(T elementLocator, String expectedValue, AssertType assertType);

    String assertSelectValueEqual(T elementLocator, String expectedValue, AssertType assertType);

    String assertContainValue(T elementLocator, String expectedValue, AssertType assertType);

    String assertContainNoValue(T elementLocator, String expectedValue, AssertType assertType);

    String assertGridValue(T elementLocator, String header, String value, int row, AssertType assertType);

    String assertSummaryGridValue(T elementLocator, String header, String value, int row, AssertType assertType);

    String assertGridValueMatch(T elementLocator, String header, String regex, int row, AssertType assertType);

    String assertGridRadioSelected(T elementLocator, String header, boolean selected, int row, AssertType assertType);

    String assertGridRadioNotSelected(T elementLocator, String header, boolean selected, int row, AssertType assertType);

    String assertGridButtonLabel(T elementLocator, String header, String label, int row, AssertType assertType);

    String assertGridCheckboxSelected(T elementLocator, String header, String radioLabel, AssertType assertType);

    String assertElementTextMatch(T elementLocator, String regex, AssertType assertType);

    String assertElementValueMatch(T elementLocator, String regex, AssertType assertType);

    String assertElementAttribute(T elementLocator, String attribute, AssertType assertType);

    String assertRadioSelection(T elementLocator, String value, AssertType assertType);

    String assertFormBoxValue(T elementLocator, int formBoxOrder, String label, String value, AssertType assertType);

    String assertInputBoxValue(T elementLocator, int inputBoxOrder, String value, AssertType assertType);

    String assertCheckboxChecked(T elementLocator, AssertType assertType);

    String assertCheckboxStatus(T elementLocator, boolean selected, AssertType assertType);

    String assertTabPanel(T tabPanel, TabularContent contentType, String header, U value, int row,AssertType assertType);

}
