package page_objects.forms.customs.review_application;

import model_classes.forms.SignFormModel;

public interface ClientReviewApplicationCustom extends ReviewApplicationCustom{

    void fillClientDetails(SignFormModel signFormModel);
}
