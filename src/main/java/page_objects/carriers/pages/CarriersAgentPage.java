package page_objects.carriers.pages;

import actions.ActionsHelper;
import assertions.AssertionsContext;
import page_objects.carriers.actors.CarriersAgent;

public class CarriersAgentPage extends AbstractCarriersPage implements CarriersAgent {

    public CarriersAgentPage() {
        super(new ActionsHelper<>().getActions(), new AssertionsContext());
    }
}
