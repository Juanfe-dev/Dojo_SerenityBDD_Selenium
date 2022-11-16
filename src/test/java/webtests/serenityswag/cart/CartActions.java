package webtests.serenityswag.cart;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import webtests.serenityswag.inventory.ProductList;

import java.util.List;

public class CartActions extends UIInteractionSteps {

    //Lo uso si (link()) no fuera un metodo static pero como si es static puedo
    //acceder a esa instancia directamente en la clase ShoppingCartIcon
    //ShoppingCartIcon shoppingCartIcon;

    @Step("Add {0} to the cart")
    public void addItem(String itemName) {
        $(ProductList.addToCartButtonFor(itemName)).click();

    }

    @Step("Add {0} to the cart")
    public void addItems(List<String> items) {
        items.forEach(this::addItem);
       }

    @Step("Open the shopping cart")
   public void openCart(){
        $(ShoppingCartIcon.link()).click();
   }
    //findAll recorre los localizadores que compartan esa clase y luego
    //retornamos los textos de ellos
    public List<String> displayedItems() {
        return findAll(".inventory_item_name").texts();
    }
}
