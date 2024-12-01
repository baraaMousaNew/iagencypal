package runner.step_definitions;

import driver_factory.DriverManager;
import enums.ThreadVariables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.Method;
import org.testng.Assert;
import page_objects.login.LoginActors;
import page_objects.login.agent.AgentLoginPage;
import page_objects.login.broker.BrokerLoginPage;
import properties.Product;
import rest_assured.PayLoadHelper;
import rest_assured.variables.ApiFilePath;
import rest_assured.variables.GlobalVariables;

public class LoginSteps {

    @Given("Agent login with API")
    public void agentLoginWithAPI() {
        PayLoadHelper payLoadHelper = DriverManager.getRestAssured();
        payLoadHelper.buildRequest(ApiFilePath.LOGIN_API).getUrl().getHeaders().
                replaceInBody("email", GlobalVariables.AGENT_EMAIL)
                .replaceInBody("password", GlobalVariables.AGENT_PASS).send(Method.POST);
        String token = payLoadHelper.getResponse().jsonPath().get("obj.accessToken");
        DriverManager.getThreadVariables().put(ThreadVariables.BEARER_TOKEN.label, "Bearer " + token);
    }

    @Given("{string} navigate to login page")
    public void navigateToLoginPage(String arg0) {
        LoginActors actors = null;
        if(arg0.equalsIgnoreCase(Product.ProductProps.agent)){
            actors = new AgentLoginPage();
        } else if (arg0.equalsIgnoreCase(Product.ProductProps.broker)) {
            actors = new BrokerLoginPage();
        }else{
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.navigate();
    }

    @And("{string} login")
    public void login(String arg0) {
        LoginActors actors = null;
        if(arg0.equalsIgnoreCase(Product.ProductProps.agent)){
            actors = new AgentLoginPage();
        } else if (arg0.equalsIgnoreCase(Product.ProductProps.broker)) {
            actors = new BrokerLoginPage();
        }else{
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.login();
    }

    @And("{string} logout")
    public void logout(String arg0) {
        LoginActors actors = null;
        if(arg0.equalsIgnoreCase(Product.ProductProps.agent)){
            actors = new AgentLoginPage();
        } else if (arg0.equalsIgnoreCase(Product.ProductProps.broker)) {
            actors = new BrokerLoginPage();
        }else{
            Assert.fail("User type is not recognized");
        }
        actors.login();
    }
}
