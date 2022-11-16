package webtests.serenityswag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class ViewProductDetailsActions extends UIInteractionSteps {

    ProductDetails productList;
    @Step("View product details for product '{0}'")
    public void forProductWithName(String firstItemName){
        $(ProductList.productDetailsLinkFor(firstItemName)).click();
    }
}
