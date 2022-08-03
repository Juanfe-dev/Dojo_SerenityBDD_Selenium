package serenityswag.cart;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.inventory.ProductList;

public class AddToCartAction extends UIInteractionSteps {

    @Step("Add {0} to the cart")
    public void item(String itemName) {

        $(ProductList.addToCartButtonFor(itemName)).click();

    }
}
