package page_objects.forms.customs.aca;

import model_classes.forms.SignFormModel;

public interface ACACustom{

    void fillBasicInformation2025(SignFormModel signFormModel);

    void basicInformationFilled2025(SignFormModel signFormModel);

    void proceedNext();

    void addRelative2025(SignFormModel signFormModel);

    void relativeFilled2025(SignFormModel signFormModel, int row);

    void addHouseHoldSize2025(SignFormModel signFormModel);

    void houseHoldSizeFilled2025(SignFormModel signFormModel);

    void addDoctorInfo2025(SignFormModel signFormModel);

    void doctorInfoFilled2025(SignFormModel signFormModel, int row);

    void addPrescriptionInfo2025(SignFormModel signFormModel);

    void prescriptionInfoFilled2025(SignFormModel signFormModel, int row);

    void addFileAttachment(SignFormModel signFormModel);

    void fileAttachmentFilled(SignFormModel signFormModel, int row);

}
