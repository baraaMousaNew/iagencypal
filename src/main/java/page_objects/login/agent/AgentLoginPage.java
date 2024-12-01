package page_objects.login.agent;

import actions.ActionsHelper;
import actions.SeleniumActions;
import assertions.AssertionsContext;
import enums.product.Roles;
import org.openqa.selenium.By;
import page_objects.login.AbstractLoginPage;
import page_objects.login.LoginAgent;
import properties.Product;
import synchronization.Waiter;

public class AgentLoginPage extends AbstractLoginPage implements LoginAgent {

    private final By selectBroker = By.cssSelector("input[formcontrolname='selectedBroker']");

    public AgentLoginPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }

    @Override
    public void login() {
        super.actions.selectByValue(super.roleDropList, Roles.AGENT.label);
        super.actions.sendKeys(super.usernameField, Product.ProductProps.agentUsername);
        super.actions.sendKeys(super.passwordField, Product.ProductProps.agentPassword);
        super.actions.click(super.loginButton);
        Waiter.waitForAngularLoad();
        super.actions.click(this.selectBroker);
        super.actions.click(this.loginButton);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void logout() {

    }

    @Override
    public void navigate() {
        super.navigate();
    }
}
