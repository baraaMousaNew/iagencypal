package properties;

import io.cucumber.java.hu.De;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

import java.time.Duration;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(value={"file:src/main/java/resources/Platform.properties"})
public interface Platform extends Config{

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("selenium")
    String tool();

    @DefaultValue("30000")
    int scriptTimeoutSeconds();

    @DefaultValue("10000")
    int setPageLoadTimeout();

    @DefaultValue("7000")
    int setImplicitWaitTimeout();

    @DefaultValue("true")
    boolean maximized();

    @DefaultValue("6000")
    int explicitWaitTimeout();

    @DefaultValue("")
    String environment();

    @DefaultValue("false")
    boolean headless();

    @DefaultValue("")
    long actionsPauseMilli();

    class PlatformProperties{

        static Platform platform = ConfigFactory.create(Platform.class);

        public static String browser = platform.browser();
        public static String tool = platform.tool();
        public static int scriptTimeoutSeconds = platform.scriptTimeoutSeconds();
        public static int setPageLoadTimeout = platform.setPageLoadTimeout();
        public static int setImplicitWaitTimeout = platform.setImplicitWaitTimeout();
        public static boolean maximized = platform.maximized();
        public static int explicitWaitTimeout = platform.explicitWaitTimeout();
        public static String environment = platform.environment();
        public static boolean headless = platform.headless();
        public static Duration actionsPauseMilli = Duration.ofMillis(platform.actionsPauseMilli());

    }
}
