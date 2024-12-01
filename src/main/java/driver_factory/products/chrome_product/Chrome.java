package driver_factory.products.chrome_product;

import driver_factory.browser_options.BrowserOptions;
import driver_factory.products.WebProducts;

public interface Chrome<T,U> extends WebProducts<T,U> {

    @Override
    T createInstance(BrowserOptions<U> browserOptions);
}
