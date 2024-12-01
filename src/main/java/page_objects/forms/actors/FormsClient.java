package page_objects.forms.actors;

import model_classes.forms.SearchFormModel;
import model_classes.forms.SendFormModel;
import model_classes.forms.SignFormModel;

public interface FormsClient extends FormsActors{

    @Override
    void navigate();

    @Override
    void sign(SignFormModel signFormModel);

    @Override
    void formSigned(SearchFormModel searchFormModel);

    @Override
    void formResign(SignFormModel signFormModel);

    @Override
    void formAlreadySigned(SearchFormModel searchFormModel);

    @Override
    void viewForm(SearchFormModel searchFormModel);

    @Override
    void formViewed(SignFormModel signFormModel);

    @Override
    void copyAndOpen(SignFormModel signFormModel);
}
