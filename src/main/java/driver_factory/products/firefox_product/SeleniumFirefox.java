package driver_factory.products.firefox_product;

import driver_factory.browser_options.BrowserOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SeleniumFirefox implements Firefox<FirefoxDriver, FirefoxOptions>{


    @Override
    public FirefoxDriver createInstance(BrowserOptions<FirefoxOptions> browserOptions) {
        return new FirefoxDriver(browserOptions.getBrowserOptions());
    }
}
