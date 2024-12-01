package page_objects.forms.actors;

import model_classes.forms.SearchFormModel;
import model_classes.forms.SendFormModel;
import model_classes.forms.SignFormModel;

public interface FormsActors {

    void navigate();

    void sign(SignFormModel signFormModel);

    void noSign(SignFormModel signFormModel);

    void send(SendFormModel sendFormModel);

    void resend(SendFormModel sendFormModel);

    void formIsResent(SearchFormModel searchFormModel);

    void formSigned(SearchFormModel searchFormModel);

    void formResign(SignFormModel signFormModel);

    void formSent(SearchFormModel searchFormModel);

    void formNotSent(SearchFormModel searchFormModel);

    void formAlreadySigned(SearchFormModel searchFormModel);

    void viewForm(SearchFormModel searchFormModel);

    void formViewed(SignFormModel signFormModel);

    void copyAndOpen(SignFormModel signFormModel);

}
