package driver_factory.browser_options;

import properties.Platform;

import java.util.List;

public interface BrowserOptions<T> {

    T getBrowserOptions();

    List<String> arguments(List<String> list);

}
