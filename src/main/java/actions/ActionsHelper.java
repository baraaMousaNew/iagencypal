package actions;

import actions.decorator.AfterActionsDecorator;
import actions.decorator.BeforeActionsDecorator;

public class ActionsHelper<T> {

    private WebActions<T> actions;

    public WebActions<T> getActions() {
        this.actions = new BeforeActionsDecorator<T>(new AfterActionsDecorator<T>(new SeleniumActions<T>()));
        return this.actions;
    }
}
