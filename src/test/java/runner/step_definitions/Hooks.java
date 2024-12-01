package runner.step_definitions;

import driver_factory.DriverManager;
import enums.AutomationToolsEnum;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import report.ReportHelper;
import report.Reporter;

import java.io.File;

public class Hooks {

    private static final Reporter reporter = new ReportHelper();

    @Before("@API")
    public void initializeRestAssured(){
        DriverManager.setDriver(AutomationToolsEnum.REST_ASSURED);
    }

    @After("@API")
    public void closeRestAssured(){

    }

    @Before("@Selenium")
    public void initializeSelenium(){
        DriverManager.setDriver(AutomationToolsEnum.SELENIUM);
    }

    @After("@Selenium")
    public void closeSelenium(){
        byte[] image = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        reporter.logImageToReport(image);
        DriverManager.getDriver().quit();
    }



}
