package assertions.assertion_type;

import enums.AssertType;

public class AssertionTypeContext {

    private AssertionType assertionType;

    public AssertionTypeContext(boolean condition, AssertType assertType) {
        switch (assertType){
            case HARD -> this.assertionType = new HardAssertionType(condition);
            case SOFT -> this.assertionType = new SoftAssertionType(condition);
            default -> throw new IllegalArgumentException("Assertion type is invalid");
        }
    }

    public AssertionType getAssertionType() {
        return assertionType;
    }
}
