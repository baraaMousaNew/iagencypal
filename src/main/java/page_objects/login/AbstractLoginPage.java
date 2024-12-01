package page_objects.login;

import actions.ActionsHelper;
import actions.SeleniumActions;
import actions.WebActions;
import assertions.AssertionsContext;
import org.openqa.selenium.By;
import synchronization.Waiter;

public class AbstractLoginPage implements LoginActors {

    protected final String url = "/en/auth/sign-in";

    protected final By profileIcon = By.cssSelector("div[class='ap_header_content-user']");

    protected final By profileOptions = By.cssSelector("ul[aria-labelledby='dropdownMenuUser']");

    protected final By logoutButton = By.cssSelector("button[class*='btn-outline-danger']");

    protected final By usernameField = By.cssSelector("input[formcontrolname='email']");

    protected final By passwordField = By.cssSelector("input[formcontrolname='password']");

    protected final By roleDropList = By.cssSelector("select[formcontrolname='systemRole']");

    protected final By loginButton = By.cssSelector("button[type='submit']");

    protected final By profileImage = By.cssSelector("div[class='user_img']");

    protected WebActions actions;

    protected AssertionsContext assertion;

    public AbstractLoginPage(WebActions actions, AssertionsContext assertion) {
        this.actions = new ActionsHelper<>().getActions();
        this.assertion = assertion;
    }

    public AbstractLoginPage() {
        this.actions = new SeleniumActions();
        this.assertion = new AssertionsContext();
    }

    @Override
    public void navigate() {
        this.actions.navigate(this.url, true);
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

}
