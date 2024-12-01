package driver_factory;

import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import rest_assured.PayLoadHelper;

import java.util.Map;

public class DriverCollection {

    private WebDriver webDriver;
    private SoftAssertions softAssertions;
    private PayLoadHelper payLoadHelper;
    private Map<String, String> threadVariables;

    public PayLoadHelper getpayLoadHelper() {
        return payLoadHelper;
    }

    public Map<String, String> getThreadVariables() {
        return threadVariables;
    }

    public void setThreadVariables(Map<String, String> threadVariables) {
        this.threadVariables = threadVariables;
    }

    public void setPayLoadHelper(PayLoadHelper payLoadHelper) {
        this.payLoadHelper = payLoadHelper;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public SoftAssertions getSoftAssertions() {
        return softAssertions;
    }

    public void setSoftAssertions(SoftAssertions softAssertions) {
        this.softAssertions = softAssertions;
    }
}
