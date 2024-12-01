package runner.step_definitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import enums.product.Actors;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import model_classes.carriers.CarriersModelClass;
import model_classes.products.ProductsModelClass;
import page_objects.carriers.actors.CarriersActors;
import page_objects.carriers.pages.CarriersAgentPage;
import page_objects.carriers.pages.CarriersBrokerPage;
import page_objects.products.actors.ProductsActors;
import page_objects.products.pages.ProductsAgentPage;
import page_objects.products.pages.ProductsBrokerPage;

import java.util.List;
import java.util.Map;

public class ProductSteps {

    @And("{string} navigate to product page")
    public void navigateToProductPage(String arg0) {
        ProductsActors actors = null;
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new ProductsBrokerPage();
        } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
            actors = new ProductsAgentPage();
        } else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.navigate();
    }

    @Then("{string} products display successfully")
    public void productsDisplaySuccessfully(String arg0, List<Map<String, String>> data ) {
        ProductsActors actors = null;
        ObjectMapper objectMapper = new ObjectMapper();
        ProductsModelClass productsModelClass = objectMapper.convertValue(data.get(0), ProductsModelClass.class);
        if(arg0.equalsIgnoreCase(Actors.BROKER.label)){
            actors = new ProductsBrokerPage();
        } else if (arg0.equalsIgnoreCase(Actors.AGENT.label)) {
            actors = new ProductsAgentPage();
        } else {
            throw new UnsupportedOperationException("Cannot find a matched actor type: " + arg0);
        }
        actors.productCreatedSuccessfully(productsModelClass);
    }


}
