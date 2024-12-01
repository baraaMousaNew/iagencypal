package elements.string_handler;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class StringLocatorContext {

    private final List<StringLocatorStrategy> strategies = new ArrayList<>();

    public StringLocatorContext() {
        this.addStrategy(new IDStrategy());
        this.addStrategy(new ClassNameStrategy());
        this.addStrategy(new NameStrategy());
        this.addStrategy(new XpathStrategy());
        this.addStrategy(new CSSStrategy());
        this.addStrategy(new PartialLinkTextStrategy());
        this.addStrategy(new LinkTextStrategy());
        this.addStrategy(new TagNameStrategy());
    }

    // Method to add strategies dynamically
    private void addStrategy(StringLocatorStrategy strategy) {
        strategies.add(strategy);
    }

    public By matchLocator(String element){

        for (StringLocatorStrategy strategy: strategies) {
            if (strategy.matches(element)) {
                return strategy.getByLocator(element);
            }
        }
        // Fallback or error handling if no strategies match
        throw new IllegalArgumentException("No matching strategy found for locator: " + element);
    }
}
