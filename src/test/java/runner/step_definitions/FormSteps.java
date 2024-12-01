package runner.step_definitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import driver_factory.DriverManager;
import enums.ThreadVariables;
import enums.product.Actors;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import model_classes.forms.SearchFormModel;
import model_classes.forms.SendFormModel;
import model_classes.forms.SignFormModel;
import org.testng.Assert;
import page_objects.forms.actors.FormsActors;
import page_objects.forms.actors.FormsAgent;
import page_objects.forms.actors.FormsBroker;
import page_objects.forms.actors.FormsClient;
import page_objects.forms.customs.aca.ACACustom;
import page_objects.forms.customs.aca.ClientACACustom;
import page_objects.forms.customs.review_application.ClientReviewApplicationCustom;
import page_objects.forms.pages.aca.ACAAgentFormPage;
import page_objects.forms.pages.aca.ACABrokerFormPage;
import page_objects.forms.pages.aca.ACAClientFormPage;
import page_objects.forms.pages.credit_card.CreditCardAgentFormPage;
import page_objects.forms.pages.credit_card.CreditCardBrokerFormPage;
import page_objects.forms.pages.credit_card.CreditCardClientFormPage;
import page_objects.forms.pages.pii.PIIAgentFormPage;
import page_objects.forms.pages.pii.PIIBrokerFormPage;
import page_objects.forms.pages.pii.PIIClientFormPage;
import page_objects.forms.pages.review_application.ReviewAgentFormPage;
import page_objects.forms.pages.review_application.ReviewBrokerFormPage;
import page_objects.forms.pages.review_application.ReviewClientFormPage;
import properties.Product;
import rest_assured.PayLoadHelper;
import rest_assured.ResponseHelper;
import rest_assured.variables.ApiFilePath;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FormSteps {

    //https://github.com/cucumber/cucumber-jvm/tree/main/datatable
    @When("{string} send form")
    public void sendForm(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SendFormModel sendFormModel = objectMapper.convertValue(data.get(0), SendFormModel.class);
        if (arg0.equalsIgnoreCase(Actors.AGENT.label)){
            if(sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
                actor = new ACAAgentFormPage();
            } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
                actor = new PIIAgentFormPage();
            } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
                actor = new CreditCardAgentFormPage();
            } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
                actor = new ReviewAgentFormPage();
            } else {
                throw new UnsupportedOperationException("Cannot find a matched form type: " + sendFormModel.getFormType());
            }
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            if(sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
                actor = new ACABrokerFormPage();
            } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
                actor = new PIIBrokerFormPage();
            } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
                actor = new CreditCardBrokerFormPage();
            } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)){
                actor = new ReviewBrokerFormPage();
            } else {
                throw new UnsupportedOperationException("Cannot find a matched form type: " + sendFormModel.getFormType());
            }
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.send(sendFormModel);
    }

    @Then("{string} form is sent")
    public void formIsSent(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SearchFormModel searchFormModel = objectMapper.convertValue(data.get(0), SearchFormModel.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            if(searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
                actor = new ACAAgentFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
                actor = new PIIAgentFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
                actor = new CreditCardAgentFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
                actor = new ReviewAgentFormPage();
            } else {
                throw new UnsupportedOperationException("Cannot find a matched form type: " + searchFormModel.getFormType());
            }
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            if(searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
                actor = new ACABrokerFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
                actor = new PIIBrokerFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
                actor = new CreditCardBrokerFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
                actor = new ReviewBrokerFormPage();
            } else {
                throw new UnsupportedOperationException("Cannot find a matched form type: " + searchFormModel.getFormType());
            }
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.formSent(searchFormModel);
    }

    @Then("{string} form is not sent")
    public void formIsNotSent(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SearchFormModel searchFormModel = objectMapper.convertValue(data.get(0), SearchFormModel.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            if(searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
                actor = new ACAAgentFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
                actor = new PIIAgentFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
                actor = new CreditCardAgentFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
                actor = new ReviewAgentFormPage();
            } else {
                throw new UnsupportedOperationException("Cannot find a matched form type: " + searchFormModel.getFormType());
            }
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            if(searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
                actor = new ACABrokerFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
                actor = new PIIBrokerFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
                actor = new CreditCardBrokerFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
                actor = new ReviewBrokerFormPage();
            } else {
                throw new UnsupportedOperationException("Cannot find a matched form type: " + searchFormModel.getFormType());
            }
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.formNotSent(searchFormModel);
    }

    @When("Agent send ACA form with API")
    public void agentSendACAFormWithAPI(List<Map<String, String>> data) {
        PayLoadHelper payLoadHelper = DriverManager.getRestAssured();
        String token = DriverManager.getThreadVariables().get(ThreadVariables.BEARER_TOKEN.label);
        payLoadHelper.buildRequest(ApiFilePath.ADD_ACA_FORM).getUrl().
                replaceInHeaders(ThreadVariables.BEARER_TOKEN.label, token)
                .addFormData(data.get(0)).send(Method.POST);
    }

    @Then("Agent ACA Form is sent with API successfully")
    public void agentACAFormIsSentWithAPISuccessfully() {
        ResponseHelper responseHelper = new ResponseHelper();
        PayLoadHelper payLoadHelper = DriverManager.getRestAssured();
        responseHelper.assertResponseCode(payLoadHelper.getResponse() ,200);
        responseHelper.assertValue(payLoadHelper.getResponse().jsonPath().get("strMessage"), "");
    }


    @When("Broker send form")
    public void brokerSendForm(List<Map<String, String>> data) {
        FormsBroker form = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SendFormModel sendFormModel = objectMapper.convertValue(data.get(0), SendFormModel.class);
        if(sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
            form = new ACABrokerFormPage();
        } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
            form = new PIIBrokerFormPage();
        }else {
            Assert.fail("Cannot find a matched form type");
        }
        form.send(sendFormModel);
    }


    @Then("Client {string} form is signed")
    public void clientFormIsSigned(String arg0) {
        FormsClient client = null;
        if(arg0.equalsIgnoreCase(Product.ProductProps.acaForm)){
            client = new ACAClientFormPage();
        } else if (arg0.equalsIgnoreCase(Product.ProductProps.piiForm)) {
            client = new PIIClientFormPage();
        }else{
            Assert.fail("Cannot find a matched form type");
        }
        client.formSigned(null);
    }


    @And("{string} navigate to {string} form page")
    public void agentNavigateToFormPage(String arg0, String arg1) {
        FormsActors actor = null;
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            if(arg1.equalsIgnoreCase(Product.ProductProps.acaForm)){
                actor = new ACAAgentFormPage();
            } else if (arg1.equalsIgnoreCase(Product.ProductProps.piiForm)) {
                actor = new PIIAgentFormPage();
            } else if (arg1.equalsIgnoreCase(Product.ProductProps.creditCard)) {
                actor = new CreditCardAgentFormPage();
            } else if (arg1.equalsIgnoreCase(Product.ProductProps.reviewForm)) {
                actor = new ReviewAgentFormPage();
            } else{
                throw new UnsupportedOperationException("Cannot find a matched form type: " + arg1);
            }
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            if(arg1.equalsIgnoreCase(Product.ProductProps.acaForm)){
                actor = new ACABrokerFormPage();
            } else if (arg1.equalsIgnoreCase(Product.ProductProps.piiForm)) {
                actor = new PIIBrokerFormPage();
            } else if (arg1.equalsIgnoreCase(Product.ProductProps.creditCard)) {
                actor = new CreditCardBrokerFormPage();
            } else if (arg1.equalsIgnoreCase(Product.ProductProps.reviewForm)) {
                actor = new ReviewBrokerFormPage();
            } else{
                throw new UnsupportedOperationException("Cannot find a matched form type: " + arg1);
            }
        } else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.navigate();
    }

    @And("Broker navigate to {string} form page")
    public void brokerNavigateToFormPage(String arg0) {
        FormsBroker form = null;
        if(arg0.equalsIgnoreCase(Product.ProductProps.acaForm)){
            form = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Product.ProductProps.piiForm)) {
            form = new PIIBrokerFormPage();
        }else{
            Assert.fail("Cannot find a matched form type");
        }
        form.navigate();
    }

    @Then("Broker form is sent")
    public void brokerFormIsSent(List<Map<String, String>> data) {
        FormsBroker agent = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SearchFormModel searchFormModel = objectMapper.convertValue(data.get(0), SearchFormModel.class);
        if(searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
            agent = new ACABrokerFormPage();
        } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
            agent = new PIIBrokerFormPage();
        }else {
            Assert.fail("Cannot find a matched form type");
        }
        agent.formSent(searchFormModel);
    }

    @And("Client sign {string} form")
    public void clientUserSignForm(String arg0, List<Map<String, String>> data) {
        FormsClient client = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SignFormModel signFormModel = objectMapper.convertValue(data.get(0), SignFormModel.class);
        if(arg0.equalsIgnoreCase(Product.ProductProps.acaForm)){
            client = new ACAClientFormPage();
        } else if (arg0.equalsIgnoreCase(Product.ProductProps.piiForm)) {
            client = new PIIClientFormPage();
        }else {
            Assert.fail("Cannot find a matched form type");
        }
        client.sign(signFormModel);
    }

    @And("Agent form is signed")
    public void agentFormIsSigned(List<Map<String, String>> data) {
        FormsAgent agent = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SearchFormModel searchFormModel = objectMapper.convertValue(data.get(0), SearchFormModel.class);
        if(searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
            agent = new ACAAgentFormPage();
        } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
            agent = new PIIAgentFormPage();
        }else {
            Assert.fail("Cannot find a matched form type");
        }
        agent.formSigned(searchFormModel);
    }

    @Then("{string} sign form")
    public void signForm(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SignFormModel signFormModel = objectMapper.convertValue(data.get(0), SignFormModel.class);
        if(signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ACAClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new ACAAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new ACABrokerFormPage();
            } else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new PIIClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new PIIAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new PIIBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new CreditCardClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new CreditCardAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new CreditCardBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ReviewClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new ReviewAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new ReviewBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else {
            Assert.fail("Cannot find a matched form type");
        }
        actor.sign(signFormModel);
    }

    @Then("{string} form is signed")
    public void formIsSigned(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SearchFormModel searchFormModel = objectMapper.convertValue(data.get(0), SearchFormModel.class);
        if(searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ACAClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new ACAAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new ACABrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new PIIClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new PIIAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new PIIBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new CreditCardClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new CreditCardAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new CreditCardBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ReviewClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new ReviewAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new ReviewBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else {
            throw new UnsupportedOperationException("Cannot find a matched form type: " + searchFormModel.getFormType());
        }
        actor.formSigned(searchFormModel);
    }

    @Then("{string} form cannot be signed")
    public void formCannotBeSigned(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SignFormModel signFormModel = objectMapper.convertValue(data.get(0), SignFormModel.class);
        if(signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                throw new UnsupportedOperationException("Unqualified action for actor: " + arg0);
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new ACAAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new ACABrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                throw new UnsupportedOperationException("Unqualified action for actor: " + arg0);
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new PIIAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new PIIBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                throw new UnsupportedOperationException("Unqualified action for actor: " + arg0);
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new CreditCardAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new CreditCardBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else {
            throw new UnsupportedOperationException("Cannot find a matched form type: " + signFormModel.getFormType());
        }
        actor.noSign(signFormModel);
    }

    @Then("{string} resign form")
    public void resignForm(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SignFormModel signFormModel = objectMapper.convertValue(data.get(0), SignFormModel.class);
        if(signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ACAClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new PIIClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new CreditCardClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ReviewClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else {
            throw new UnsupportedOperationException("Cannot find a matched form type: " + signFormModel.getFormType());
        }
        actor.formResign(signFormModel);
    }

    @Then("{string} form is already signed")
    public void formIsAlreadySigned(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SearchFormModel searchFormModel = objectMapper.convertValue(data.get(0), SearchFormModel.class);
        if(searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ACAClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new PIIClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new CreditCardClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ReviewClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                throw new UnsupportedOperationException("Unsupported actor");
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else {
            throw new UnsupportedOperationException("Cannot find a matched form type: " + searchFormModel.getFormType());
        }
        actor.formAlreadySigned(searchFormModel);
    }

    @And("{string} view the form")
    public void viewTheForm(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SearchFormModel searchFormModel = objectMapper.convertValue(data.get(0), SearchFormModel.class);
        if(searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ACAClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new ACAAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new ACABrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new PIIClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new PIIAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new PIIBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new CreditCardClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new CreditCardAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new CreditCardBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ReviewClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new ReviewAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new ReviewBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else {
            throw new UnsupportedOperationException("Cannot find a matched form type: " + searchFormModel.getFormType());
        }
        actor.viewForm(searchFormModel);
    }

    @Then("{string} form is viewed successfully")
    public void formIsViewedSuccessfully(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SignFormModel signFormModel = objectMapper.convertValue(data.get(0), SignFormModel.class);
        if(signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ACAClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new ACAAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new ACABrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new PIIClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new PIIAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new PIIBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new CreditCardClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new CreditCardAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new CreditCardBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ReviewClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new ReviewAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new ReviewBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else {
            throw new UnsupportedOperationException("Cannot find a matched form type: " + signFormModel.getFormType());
        }
        actor.formViewed(signFormModel);
    }

    @And("{string} fill basic information of {string} ACA form")
    public void fillBasicInformationOfForm(String arg0, String arg1, List<Map<String, String>> data) {
        ACACustom customs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SignFormModel signFormModel = objectMapper.convertValue(data.get(0), SignFormModel.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        if(arg1.equals("2025")){
            customs.fillBasicInformation2025(signFormModel);
        }else {
            throw new UnsupportedOperationException("Unsupported form year: " + arg1);
        }
    }

    @And("{string} click proceed to next step of form")
    public void clickProceedToNextStepOfForm(String arg0) {
        ACACustom customs = null;
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
            throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        customs.proceedNext();
    }

    @And("{string} add relative of {string} ACA form")
    public void addRelativeOfACAForm(String arg0, String arg1, List<Map<String, String>> data) {
        ACACustom customs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
            throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        if(arg1.equals("2025")){
            for (Map<String, String> datum : data) {
                SignFormModel signFormModel = objectMapper.convertValue(datum, SignFormModel.class);
                customs.addRelative2025(signFormModel);
            }
        }else {
            throw new UnsupportedOperationException("Unsupported form year: " + arg1);
        }
    }

    @And("{string} add household information of {string} ACA form")
    public void addHouseholdInformationOfACAForm(String arg0, String arg1, List<Map<String, String>> data) {
        ACACustom customs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SignFormModel signFormModel = objectMapper.convertValue(data.get(0), SignFormModel.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
            throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        if(arg1.equals("2025")){
            customs.addHouseHoldSize2025(signFormModel);
        }else {
            throw new UnsupportedOperationException("Unsupported form year: " + arg1);
        }
    }

    @And("{string} add doctor information of {string} ACA form")
    public void addDoctorInformationOfACAForm(String arg0, String arg1, List<Map<String, String>> data) {
        ACACustom customs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
            throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        if(arg1.equals("2025")){
            for(Map<String, String> info: data){
                SignFormModel signFormModel = objectMapper.convertValue(info, SignFormModel.class);
                customs.addDoctorInfo2025(signFormModel);
            }

        }else {
            throw new UnsupportedOperationException("Unsupported form year: " + arg1);
        }
    }

    @And("{string} add prescription information of {string} ACA form")
    public void addPrescriptionInformationOfACAForm(String arg0, String arg1, List<Map<String, String>> data) {
        ACACustom customs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
            throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        if(arg1.equals("2025")){
            for(Map<String, String> info: data){
                SignFormModel signFormModel = objectMapper.convertValue(info, SignFormModel.class);
                customs.addPrescriptionInfo2025(signFormModel);
            }

        }else {
            throw new UnsupportedOperationException("Unsupported form year: " + arg1);
        }
    }

    @And("{string} add file attachments to {string} ACA form")
    public void addFileAttachmentsToACAForm(String arg0, String arg1, List<Map<String, String>> data) {
        ACACustom customs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
            throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        if(arg1.equals("2025")){
            for(Map<String, String> info: data){
                SignFormModel signFormModel = objectMapper.convertValue(info, SignFormModel.class);
                customs.addFileAttachment(signFormModel);
            }

        }else {
            throw new UnsupportedOperationException("Unsupported form year: " + arg1);
        }
    }

    @And("{string} copy and open form")
    public void copyAndOpenForm(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SignFormModel signFormModel = objectMapper.convertValue(data.get(0), SignFormModel.class);
        if(signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ACAClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new ACAAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new ACABrokerFormPage();
            } else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new PIIClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new PIIAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new PIIBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new CreditCardClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new CreditCardAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new CreditCardBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else if (signFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
            if(arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
                actor = new ReviewClientFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
                actor = new ReviewAgentFormPage();
            } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
                actor = new ReviewBrokerFormPage();
            }else {
                throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
            }
        } else {
            Assert.fail("Cannot find a matched form type");
        }
        actor.copyAndOpen(signFormModel);
    }

    @And("{string} fill login information of ACA form")
    public void fillLoginInformation(String arg0, List<Map<String, String>> data) {
        ClientACACustom custom = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SignFormModel signFormModel = objectMapper.convertValue(data.get(0), SignFormModel.class);
        if(arg0.equalsIgnoreCase(Actors.CLIENT.label)){
            custom = new ACAClientFormPage();
        } else {
            throw new UnsupportedOperationException("Unsupported actor: " + arg0);
        }
        custom.fillClientDetails(signFormModel);
    }

    @Then("{string} basic information of {string} ACA form are filled successfully")
    public void basicInformationOfACAFormAreFilledSuccessfully(String arg0, String arg1, List<Map<String, String>> data) {
        ACACustom customs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SignFormModel signFormModel = objectMapper.convertValue(data.get(0), SignFormModel.class);
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
            throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        if(arg1.equals("2025")){
            customs.basicInformationFilled2025(signFormModel);
        }else {
            throw new UnsupportedOperationException("Unsupported form year: " + arg1);
        }
    }

    @And("{string} relatives information of {string} ACA form are filled successfully")
    public void relativesInformationOfACAFormAreFilledSuccessfully(String arg0, String arg1, List<Map<String, String>> data) {
        ACACustom customs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
            throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        if(arg1.equals("2025")){
            int i = 1;
            for (Map<String, String> datum : data) {
                SignFormModel signFormModel = objectMapper.convertValue(datum, SignFormModel.class);
                customs.relativeFilled2025(signFormModel, i);
                i++;
            }
        }else {
            throw new UnsupportedOperationException("Unsupported form year: " + arg1);
        }
    }

    @And("{string} household information of {string} ACA form are filled successfully")
    public void householdInformationOfACAFormAreFilledSuccessfully(String arg0, String arg1, List<Map<String, String>> data) {
        ACACustom customs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
            throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        if(arg1.equals("2025")){
                SignFormModel signFormModel = objectMapper.convertValue(data.get(0), SignFormModel.class);
                customs.houseHoldSizeFilled2025(signFormModel);
        }else {
            throw new UnsupportedOperationException("Unsupported form year: " + arg1);
        }
    }

    @And("{string} doctor information of {string} ACA form are filled successfully")
    public void doctorInformationOfACAFormAreFilledSuccessfully(String arg0, String arg1, List<Map<String, String>> data) {
        ACACustom customs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
            throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        if(arg1.equals("2025")){
            int i = 1;
            for (Map<String, String> datum : data) {
                SignFormModel signFormModel = objectMapper.convertValue(datum, SignFormModel.class);
                customs.doctorInfoFilled2025(signFormModel, i);
                i++;
            }
        }else {
            throw new UnsupportedOperationException("Unsupported form year: " + arg1);
        }
    }

    @And("{string} prescription information of {string} ACA form are filled successfully")
    public void prescriptionInformationOfACAFormAreFilledSuccessfully(String arg0, String arg1, List<Map<String, String>> data) {
        ACACustom customs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
            throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        if(arg1.equals("2025")){
            int i = 1;
            for (Map<String, String> datum : data) {
                SignFormModel signFormModel = objectMapper.convertValue(datum, SignFormModel.class);
                customs.prescriptionInfoFilled2025(signFormModel, i);
                i++;
            }
        }else {
            throw new UnsupportedOperationException("Unsupported form year: " + arg1);
        }
    }

    @And("{string} file attachments of {string} ACA form are added successfully")
    public void fileAttachmentsOfACAFormAreAddedSuccessfully(String arg0, String arg1, List<Map<String, String>> data) {
        ACACustom customs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        if(arg0.equalsIgnoreCase(Actors.AGENT.label)){
            customs = new ACAAgentFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            customs = new ACABrokerFormPage();
        } else if (arg0.equalsIgnoreCase(Actors.CLIENT.label)) {
            customs = new ACAClientFormPage();
        }else {
            throw new UnsupportedOperationException("Unsupported actor type: " + arg0);
        }
        if(arg1.equals("2025")){
            int i = 1;
            for (Map<String, String> datum : data) {
                SignFormModel signFormModel = objectMapper.convertValue(datum, SignFormModel.class);
                customs.fileAttachmentFilled(signFormModel, i);
                i++;
            }
        }else {
            throw new UnsupportedOperationException("Unsupported form year: " + arg1);
        }
    }

    @And("{string} resend the form")
    public void resendTheForm(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SendFormModel sendFormModel = objectMapper.convertValue(data.get(0), SendFormModel.class);
        if (arg0.equalsIgnoreCase(Actors.AGENT.label)){
            if(sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
                actor = new ACAAgentFormPage();
            } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
                actor = new PIIAgentFormPage();
            } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
                actor = new CreditCardAgentFormPage();
            } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
                actor = new ReviewAgentFormPage();
            } else {
                throw new UnsupportedOperationException("Cannot find a matched form type: " + sendFormModel.getFormType());
            }
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            if(sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
                actor = new ACABrokerFormPage();
            } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
                actor = new PIIBrokerFormPage();
            } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
                actor = new CreditCardBrokerFormPage();
            } else if (sendFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)){
                actor = new ReviewBrokerFormPage();
            } else {
                throw new UnsupportedOperationException("Cannot find a matched form type: " + sendFormModel.getFormType());
            }
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.resend(sendFormModel);
    }

    @Then("{string} form is resent")
    public void formIsResent(String arg0, List<Map<String, String>> data) {
        FormsActors actor = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SearchFormModel searchFormModel = objectMapper.convertValue(data.get(0), SearchFormModel.class);
        if (arg0.equalsIgnoreCase(Actors.AGENT.label)){
            if(searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
                actor = new ACAAgentFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
                actor = new PIIAgentFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
                actor = new CreditCardAgentFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)) {
                actor = new ReviewAgentFormPage();
            } else {
                throw new UnsupportedOperationException("Cannot find a matched form type: " + searchFormModel.getFormType());
            }
        } else if (arg0.equalsIgnoreCase(Actors.BROKER.label)) {
            if(searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.acaForm)){
                actor = new ACABrokerFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.piiForm)) {
                actor = new PIIBrokerFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.creditCard)) {
                actor = new CreditCardBrokerFormPage();
            } else if (searchFormModel.getFormType().equalsIgnoreCase(Product.ProductProps.reviewForm)){
                actor = new ReviewBrokerFormPage();
            } else {
                throw new UnsupportedOperationException("Cannot find a matched form type: " + searchFormModel.getFormType());
            }
        }else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actor.formIsResent(searchFormModel);
    }

    @And("{string} fill login information of Review Application form")
    public void fillLoginInformationOfReviewApplicationForm(String arg0, List<Map<String, String>> data) {
        ClientReviewApplicationCustom custom = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SignFormModel signFormModel = objectMapper.convertValue(data.get(0), SignFormModel.class);
        if(arg0.equalsIgnoreCase(Actors.CLIENT.label)){
            custom = new ReviewClientFormPage();
        } else {
            throw new UnsupportedOperationException("Unsupported actor: " + arg0);
        }
        custom.fillClientDetails(signFormModel);
    }

}
