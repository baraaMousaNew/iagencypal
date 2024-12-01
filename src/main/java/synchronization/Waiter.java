package synchronization;

import driver_factory.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.Platform;

import java.time.Duration;

public class Waiter {

    public static WebElement waitForElementPresent(By element){
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        return webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(element)));
    }

    public static boolean waitForFieldBeEmpty(WebElement element){
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        return webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.textToBePresentInElementValue(element, "")));
    }

    public static WebElement waitForElementVisible(By element){
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        return webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(element)));
    }

    public static WebElement waitForElementClickable(By element){
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        return webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }

    public static WebElement waitForElementClickable(WebElement element) {
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        return webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }

    public static WebElement waitForElementVisible(WebElement element){
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        return webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }

    public static Boolean waitForElementInvisible(By element){
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        return webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(element)));
    }

    public static Boolean waitForElementInvisible(WebElement element){
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        return webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(element)));
    }

    public static Boolean waitForAttributeValue(WebElement element, String attributeName, String attributeValue){
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        return webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.attributeToBe(element, attributeName, attributeValue)));
    }

    public static Boolean waitForAttributeValue(By element, String attributeName, String attributeValue){
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        return webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.attributeToBe(element, attributeName, attributeValue)));
    }

    public static Boolean waitForAttributeValueContain(WebElement element, String attributeName, String attributeValue){
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        return webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.attributeContains(element, attributeName, attributeValue)));
    }

    public static Boolean waitForAttributeContain(By element, String attributeName, String attributeValue){
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        return webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.attributeContains(element, attributeName, attributeValue)));
    }

    private static boolean isAngularPresent() {
        String angularPresentScript =
                "return !!(window.getAllAngularTestabilities || " +
                        "document.querySelector('.ng-app-element, [ng-version]') || " +
                        "document.querySelector('script[src*=\"angular.js\"], script[src*=\"angular.min.js\"]'))";
        return (Boolean) ((JavascriptExecutor) DriverManager.getDriver()).executeScript(angularPresentScript);
    }

    public static void waitForAngularLoad() {

        if (!isAngularPresent()) {
            System.out.println("Angular is not detected on this page. Skipping Angular-specific wait.");
            return;
        }
        WebDriver webDriver = DriverManager.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,
                Duration.ofMillis(Platform.PlatformProperties.explicitWaitTimeout));
        String angularReadyScript =
                "var callback = arguments[arguments.length - 1];" +
                        "if (window.getAllAngularTestabilities) {" +
                        "var testabilities = window.getAllAngularTestabilities();" +
                        "var count = testabilities.length;" +
                        "var decrement = function() {" +
                        "count--;" +
                        "if (count === 0) {" +
                        "callback(true);" +
                        "}" +
                        "};" +
                        "testabilities.forEach(function(testability) {" +
                        "testability.whenStable(decrement);" +
                        "});" +
                        "} else {" +
                        "callback(true);" +
                        "}";

        webDriverWait.until((ExpectedCondition<Boolean>) driver ->
                (Boolean) ((JavascriptExecutor) driver).executeAsyncScript(angularReadyScript));
    }

}
