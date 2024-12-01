package assertions.assertion_type;

import driver_factory.DriverManager;
import org.assertj.core.api.SoftAssertions;

public class SoftAssertionType implements AssertionType{

    private boolean condition;
    private SoftAssertions softAssertions;
    private int lastErrorIndex;

    public SoftAssertionType(boolean condition) {
        this.condition = condition;
        this.softAssertions = DriverManager.getSoftAssertion();
    }

    @Override
    public String assertIsFalse() {
        this.getIndexLastErrorCollected();
        this.softAssertions.assertThat(this.condition).isFalse();
        return this.returnProducedError();
    }

    @Override
    public String assertIsTrue() {
        this.getIndexLastErrorCollected();
        this.softAssertions.assertThat(this.condition).isTrue();
        return this.returnProducedError();
    }

    private void getIndexLastErrorCollected(){
        this.lastErrorIndex = this.softAssertions.errorsCollected().size();
    }
    private String returnProducedError(){
        int newErrorIndex = this.softAssertions.errorsCollected().size();
        if(newErrorIndex > this.lastErrorIndex){
            return this.softAssertions.errorsCollected().get(newErrorIndex - 1).toString();
        }
        return "No errors!";
    }
}
