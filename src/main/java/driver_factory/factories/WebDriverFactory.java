package driver_factory.factories;

import driver_factory.products.chrome_product.Chrome;
import driver_factory.products.firefox_product.Firefox;

public interface WebDriverFactory {

    Chrome createChrome();

    Firefox createFirefox();
}
