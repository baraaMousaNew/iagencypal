package page_objects.products.pages;

import actions.ActionsHelper;
import assertions.AssertionsContext;
import page_objects.products.actors.ProductsBroker;

public class ProductsBrokerPage extends AbstractProductsPage implements ProductsBroker {

    public ProductsBrokerPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }

}
