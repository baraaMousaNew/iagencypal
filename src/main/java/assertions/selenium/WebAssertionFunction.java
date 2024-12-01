package assertions.selenium;

import assertions.assertion_type.AssertionType;
import enums.AssertType;
import enums.product.TabularContent;
import io.cucumber.java.bs.A;
import org.testng.Assert;

public interface WebAssertionFunction<T,U> {

    AssertionType isPresent(T elementLocator, AssertType assertType);

    AssertionType isVisible(T elementLocator, AssertType assertType);

    AssertionType isEditable(T elementLocator, AssertType assertType);

    AssertionType isClickable(T elementLocator, AssertType assertType);

    AssertionType hasText(T elementLocator, String text, AssertType assertType);

    AssertionType equalText(T elementLocator, String text, AssertType assertType);

    AssertionType valueEqual(T elementLocator, String value, AssertType assertType);

    AssertionType divContainElement(T elementLocator, String elementString, AssertType assertType);

    AssertionType selectValueEqual(T elementLocator, String value, AssertType assertType);

    AssertionType containValue(T elementLocator, String value, AssertType assertType);

    AssertionType gridValue(T elementLocator, String header, String value, int row, AssertType assertType);

    AssertionType gridRadioSelected(T elementLocator, String header, boolean selected, int row, AssertType assertType);

    AssertionType gridButtonLabel(T elementLocator, String header, String label, int row, AssertType assertType);

    AssertionType summaryGridValue(T elementLocator, String header, String value, int row, AssertType assertType);

    AssertionType gridElementSelected(T elementLocator, String header, String radioLabel, AssertType assertType);

    AssertionType gridValueMatch(T elementLocator, String header, String regex, int row, AssertType assertType);

    AssertionType fieldTextMatch(T elementLocator, String regex, AssertType assertType);

    AssertionType fieldValueMatch(T elementLocator, String regex, AssertType assertType);

    AssertionType elementAttribute(T elementLocator, String attribute, AssertType assertType);

    AssertionType radioButtonValue(T elementLocator, String value, AssertType assertType);

    AssertionType formBoxValue(T elementLocator, int formBoxOrder, String label, String value, AssertType assertType);

    AssertionType inputBoxValue(T elementLocator, int inputBoxOrder, String value, AssertType assertType);

    AssertionType checkboxChecked(T elementLocator, AssertType assertType);

    AssertionType tabPanelHas(T tabPanel, TabularContent contentType, String header, U value, int row, AssertType assertType);
}
