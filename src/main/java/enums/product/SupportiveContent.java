package enums.product;

public enum SupportiveContent {

    TEST_IMAGE_PATH("src/main/resources/test_image.jpg"),

    TEST_IMAGE_FILE_NAME("test_image.jpg");

    public final String label;

    SupportiveContent(String label){
        this.label = label;
    }
}
