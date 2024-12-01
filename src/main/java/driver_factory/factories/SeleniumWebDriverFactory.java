package driver_factory.factories;

import driver_factory.products.chrome_product.Chrome;
import driver_factory.products.chrome_product.SeleniumChrome;
import driver_factory.products.firefox_product.Firefox;
import driver_factory.products.firefox_product.SeleniumFirefox;

public class SeleniumWebDriverFactory implements WebDriverFactory{

    @Override
    public SeleniumChrome createChrome() {
        return new SeleniumChrome();
    }

    @Override
    public SeleniumFirefox createFirefox() {
        return new SeleniumFirefox();
    }
}
