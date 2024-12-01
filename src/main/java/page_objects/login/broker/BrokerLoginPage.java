package page_objects.login.broker;

import actions.ActionsHelper;
import actions.SeleniumActions;
import assertions.AssertionsContext;
import enums.product.Roles;
import page_objects.login.AbstractLoginPage;
import page_objects.login.LoginBroker;
import properties.Product;
import synchronization.Waiter;

public class BrokerLoginPage extends AbstractLoginPage implements LoginBroker {


    public BrokerLoginPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }


    @Override
    public void navigate() {
        super.navigate();
    }

    @Override
    public void login() {
        super.actions.selectByValue(super.roleDropList, Roles.BROKER.label);
        super.actions.sendKeys(super.usernameField, Product.ProductProps.brokerUsername);
        super.actions.sendKeys(super.passwordField, Product.ProductProps.brokerPassword);
        super.actions.click(super.loginButton);
        Waiter.waitForAngularLoad();
    }

    @Override
    public void logout() {

    }
}
