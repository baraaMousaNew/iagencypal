package driver_factory.products.chrome_product;

import driver_factory.browser_options.BrowserOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumChrome implements Chrome<ChromeDriver, ChromeOptions>{


    @Override
    public ChromeDriver createInstance(BrowserOptions<ChromeOptions> browserOptions) {
        return new ChromeDriver(browserOptions.getBrowserOptions());
    }
}
