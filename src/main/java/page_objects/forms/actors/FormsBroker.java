package page_objects.forms.actors;

import model_classes.forms.SearchFormModel;
import model_classes.forms.SendFormModel;
import model_classes.forms.SignFormModel;

public interface FormsBroker  extends FormsActors{

    @Override
    void navigate();

    @Override
    void sign(SignFormModel signFormModel);

    @Override
    void send(SendFormModel sendFormModel);

    void bulkSend();

    @Override
    void noSign(SignFormModel signFormModel);

    @Override
    void copyAndOpen(SignFormModel signFormModel);

    @Override
    void resend(SendFormModel sendFormModel);


    // assertions

    @Override
    void formSent(SearchFormModel searchFormModel);

    @Override
    void formIsResent(SearchFormModel searchFormModel);

    @Override
    void formNotSent(SearchFormModel searchFormModel);

    @Override
    void formSigned(SearchFormModel searchFormModel);

    @Override
    void viewForm(SearchFormModel searchFormModel);

    @Override
    void formViewed(SignFormModel signFormModel);

}
