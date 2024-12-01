package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


/**
 * https://paras301.medium.com/cucumber-bdd-testing-using-testng-framework-with-selenium-webdriver-and-cucumber-reports-28c62724b073
 * https://qaautomation.expert/2023/11/08/integration-of-cucumber-with-selenium-and-testng/
 */
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        features = {"src/test/resources/features/clients"},
        glue = {"runner.step_definitions"},
        tags = "@Selenium"
)
public class ClientRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
