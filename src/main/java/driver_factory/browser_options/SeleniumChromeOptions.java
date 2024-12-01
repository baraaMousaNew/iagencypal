package driver_factory.browser_options;

import enums.BrowserArgs;
import org.openqa.selenium.chrome.ChromeOptions;
import properties.Platform;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeleniumChromeOptions implements BrowserOptions<ChromeOptions>{

    /**
     * Check: https://www.selenium.dev/documentation/webdriver/browsers/chrome/
     * && https://peter.sh/experiments/chromium-command-line-switches/
     * @return
     */
    @Override
    public ChromeOptions getBrowserOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setScriptTimeout(
                Duration.ofMillis(Platform.PlatformProperties.scriptTimeoutSeconds)).
                setPageLoadTimeout(Duration.ofMillis(Platform.PlatformProperties.setPageLoadTimeout))
                .setImplicitWaitTimeout(Duration.ofMillis(Platform.PlatformProperties.setImplicitWaitTimeout))
                .addArguments(this.arguments(new ArrayList<String>()));
        return chromeOptions;
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
