package model_classes.forms;

import java.util.Map;

public class VerifyFormModel extends AbstractModel{

    private String year;

    private String lastName;

    ///////////////////////////////////////////////////////////////////////////////

    public String getYear() {
        return year;
    }

    public String getLastName() {
        return lastName;
    }

    ///////////////////////////////////////////////////////////////////////////////


    public void setYear(String year) {
        this.year = year;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
