package driver_factory;

import driver_factory.browser_options.SeleniumChromeOptions;
import driver_factory.browser_options.SeleniumFirefoxOptions;
import driver_factory.factories.SeleniumWebDriverFactory;
import enums.AutomationToolsEnum;
import enums.WebBrowsersEnum;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import properties.Platform;
import rest_assured.PayLoadHelper;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DriverManager {

    private static ThreadLocal<DriverCollection> drivers = new ThreadLocal<>();

    public synchronized static void setDriver(AutomationToolsEnum tool){
        //String tool = Platform.PlatformProperties.tool;
        String browser = Platform.PlatformProperties.browser;
        if(tool == AutomationToolsEnum.SELENIUM) {
            if (browser.equalsIgnoreCase(WebBrowsersEnum.CHROME.label)) {
                DriverCollection driverCollection = new DriverCollection();
                driverCollection.setWebDriver(new SeleniumWebDriverFactory().createChrome().createInstance(new SeleniumChromeOptions()));
                driverCollection.setSoftAssertions(new SoftAssertions());
                driverCollection.setThreadVariables(new HashMap<>());
                drivers.set(driverCollection);
            } else if (browser.equalsIgnoreCase(WebBrowsersEnum.FIREFOX.label)) {
                DriverCollection driverCollection = new DriverCollection();
                driverCollection.setWebDriver(new SeleniumWebDriverFactory().createFirefox().createInstance(new SeleniumFirefoxOptions()));
                driverCollection.setSoftAssertions(new SoftAssertions());
                driverCollection.setThreadVariables(new HashMap<>());
                drivers.set(driverCollection);
            } else {
                throw new RuntimeException("The browser " + browser + " is not supported");
            }
        } else if (tool == AutomationToolsEnum.REST_ASSURED) {
            DriverCollection driverCollection = new DriverCollection();
            driverCollection.setPayLoadHelper(new PayLoadHelper());
            driverCollection.setSoftAssertions(new SoftAssertions());
            driverCollection.setThreadVariables(new HashMap<>());
            drivers.set(driverCollection);
        }else {
            throw new RuntimeException("Unsupported tool: " + tool.toString());
        }
    }

    public static WebDriver getDriver(){
        return drivers.get().getWebDriver();
    }

    public static SoftAssertions getSoftAssertion(){
        return drivers.get().getSoftAssertions();
    }

    public static PayLoadHelper getRestAssured(){
        return drivers.get().getpayLoadHelper();
    }

    public static Map<String, String> getThreadVariables(){
        return drivers.get().getThreadVariables();
    }


}
