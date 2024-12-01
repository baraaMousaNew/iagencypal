package page_objects.products.pages;

import actions.ActionsHelper;
import assertions.AssertionsContext;
import page_objects.products.actors.ProductsActors;
import page_objects.products.actors.ProductsAgent;

public class ProductsAgentPage extends AbstractProductsPage implements ProductsAgent {

    public ProductsAgentPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }
}
