package page_objects.products.actors;

import model_classes.products.ProductsModelClass;

public interface ProductsActors {

    void navigate();

    void productCreatedSuccessfully(ProductsModelClass productsModelClass);
}
