package page_objects.carriers.pages;

import actions.ActionsHelper;
import assertions.AssertionsContext;
import page_objects.carriers.actors.CarriersBroker;

public class CarriersBrokerPage extends AbstractCarriersPage implements CarriersBroker {

    public CarriersBrokerPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }
}
