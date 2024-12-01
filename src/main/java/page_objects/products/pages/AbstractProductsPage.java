package page_objects.products.pages;

import actions.ActionsHelper;
import actions.WebActions;
import assertions.AssertionsContext;
import enums.AssertType;
import enums.product.Grids;
import model_classes.products.ProductsModelClass;
import org.openqa.selenium.By;
import page_objects.products.actors.ProductsActors;

public class AbstractProductsPage implements ProductsActors {

    protected final String url = "/en/system/new/new-product";

    protected final By grid = By.xpath("//app-new-product//app-new-data-table//table");


    protected WebActions actions;
    protected AssertionsContext assertion;

    protected AbstractProductsPage(WebActions actions, AssertionsContext assertion){
        this.actions = actions;
        this.assertion = assertion;
    }

    public AbstractProductsPage(){
        this.actions = new ActionsHelper<>().getActions();
        this.assertion = new AssertionsContext();
    }

    @Override
    public void navigate() {
        this.actions.navigate(this.url, true);
    }

    @Override
    public void productCreatedSuccessfully(ProductsModelClass productsModelClass) {
        this.assertion.assertGridValue(this.grid, Grids.PRODUCT_NAME.label, productsModelClass.getProductName(), 1, AssertType.HARD);
        this.assertion.assertGridValue(this.grid, Grids.CARRIER_NAME.label, productsModelClass.getCarrierName(), 1, AssertType.HARD);
        this.assertion.assertGridValue(this.grid, Grids.PRODUCT_EFFECTIVE_DATE.label, productsModelClass.getEffectiveDate(), 1, AssertType.HARD);
        this.assertion.assertGridRadioSelected(this.grid, Grids.ACTIVE_STATUS.label, true, 1, AssertType.HARD);
    }

}
