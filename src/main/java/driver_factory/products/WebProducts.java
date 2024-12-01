package driver_factory.products;

import driver_factory.browser_options.BrowserOptions;

public interface WebProducts<T, U> {

    T createInstance(BrowserOptions<U> browserOptions);
}
