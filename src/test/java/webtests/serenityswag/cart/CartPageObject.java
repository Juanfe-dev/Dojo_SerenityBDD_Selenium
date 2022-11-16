package webtests.serenityswag.cart;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {

    //@FindBy(css = "[data-test=checkout]")
    /*@FindBy(id = "checkout")
    WebElementFacade checkoutButton;

    @FindBy(css = ".title")
    WebElementFacade title;

    @FindBy(className = "cart_item")
    List<WebElementFacade> cartItemsElements;*/

    //Chapter8.3.0
    private static By CHECKOUT_BUTTON = By.id("checkout");
    private static By TITLE = By.cssSelector(".title");
    private static By CART_ITEM = By.cssSelector(".cart_item");


    public void checkout(){
        $(CHECKOUT_BUTTON).click();
    }

    public String getTitleText(){
        return $(TITLE).getText();
    }

    public List<CartItem> items() {
        return findAll(CART_ITEM).map(
                item -> new CartItem(
                        item.findBy(".inventory_item_name").getText(),
                        item.findBy(".inventory_item_desc").getText(),
                        priceFrom(item.findBy(".inventory_item_price").getText()))
        );

        /* Otra forma menos limpia y menos practica
        List<CartItem> cartItems = new ArrayList<>();
        for(WebElementFacade cartItemElement : findAll(CART_ITEM)){
            String name = cartItemElement.findBy(".inventory_item_name").getText();
            String description = cartItemElement.findBy(".inventory_item_desc").getText();
            Double price = priceFrom(cartItemElement.findBy(".inventory_item_price").getText());
            cartItems.add(new CartItem(name, description, price));
        }
        return cartItems;
        */


    }

    private Double priceFrom(String textValue) {
        return Double.parseDouble(textValue.replace("$", ""));
    }
}
