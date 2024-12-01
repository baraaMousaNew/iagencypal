package assertions.assertion_type;

import static org.assertj.core.api.Assertions.assertThat;

public class HardAssertionType implements AssertionType{

    private boolean condition;

    public HardAssertionType(boolean condition) {
        this.condition = condition;
    }

    @Override
    public String assertIsFalse() {
        assertThat(this.condition).isFalse();
        return "No error!";
    }

    @Override
    public String assertIsTrue() {
        assertThat(this.condition).isTrue();
        return "No error!";
    }
}
