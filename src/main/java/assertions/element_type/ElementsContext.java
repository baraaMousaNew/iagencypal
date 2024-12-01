package assertions.element_type;


import enums.product.TabularContent;
import org.testng.Assert;

public class ElementsContext<T> {

    Elements element;

    public ElementsContext(TabularContent content) {
        if(content == TabularContent.TEXT){
            element = new Text();
        } else if (content == TabularContent.CHECKBOX) {
            element = new Checkbox();
        } else if (content == TabularContent.IMAGE) {
            element = new Image();
        } else if (content == TabularContent.BUTTON) {
            element = new Button();
        } else {
            Assert.fail("Cannot find a matched type for: " + content);
        }
    }

    public Elements getElement(){
        return element;
    }

}
