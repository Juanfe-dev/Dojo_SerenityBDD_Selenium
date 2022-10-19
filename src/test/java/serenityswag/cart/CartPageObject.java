package serenityswag.cart;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {
    public List<CartItem> items() {
        return null;
    }
}
