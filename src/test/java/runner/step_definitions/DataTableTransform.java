package runner.step_definitions;

import io.cucumber.java.DataTableType;

public class DataTableTransform {

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }

}
