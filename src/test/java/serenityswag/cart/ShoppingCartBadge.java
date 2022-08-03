package serenityswag.cart;

import net.serenitybdd.core.pages.PageObject;

public class ShoppingCartBadge extends PageObject {

    public String count(){
        return $(".shopping_cart_link").getText();
    }
}
