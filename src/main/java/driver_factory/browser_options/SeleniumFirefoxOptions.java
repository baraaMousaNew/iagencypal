package driver_factory.browser_options;

import enums.BrowserArgs;
import org.openqa.selenium.firefox.FirefoxOptions;
import properties.Platform;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeleniumFirefoxOptions implements BrowserOptions<FirefoxOptions>{

    @Override
    public FirefoxOptions getBrowserOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setScriptTimeout(
                        Duration.ofMillis(Platform.PlatformProperties.scriptTimeoutSeconds)).
                setPageLoadTimeout(Duration.ofMillis(Platform.PlatformProperties.setPageLoadTimeout))
                .setImplicitWaitTimeout(Duration.ofMillis(Platform.PlatformProperties.setImplicitWaitTimeout))
                .addArguments(this.arguments(new ArrayList<String>()));
        return firefoxOptions;
    }

    @Override
    public List<String> arguments(List<String> list) {
        HashMap<BrowserArgs, Boolean> args = new HashMap<>();
        args.put(BrowserArgs.HEADLESS, Platform.PlatformProperties.headless);
        args.put(BrowserArgs.MAXIMIZED, Platform.PlatformProperties.maximized);
        for(BrowserArgs key: args.keySet()){
            if(args.get(key)){
                list.add(key.label);
            }
        }
        return list;
    }
}
