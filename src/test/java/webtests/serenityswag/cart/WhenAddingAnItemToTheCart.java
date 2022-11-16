package webtests.serenityswag.cart;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import webtests.serenityswag.authentication.LoginActions;
import webtests.serenityswag.inventory.ProductList;
import webtests.serenityswag.authentication.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WhenAddingAnItemToTheCart {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;

    @BeforeEach
    public void login(){
        login.as(User.STANDARD_USER);
    }

    ShoppingCartIcon shoppingCartIcon;

    @Steps
    CartActions cart;

    @Test
    void theCorrectItemCountShouldBeShown(){
        //Check that the shopping cart badge is empty
        Serenity.reportThat("The shopping cart badge should be empty",
                () ->    assertThat(shoppingCartIcon.badgeCount()).isEmpty()
        );

        //Add 1 items to the cart
        cart.addItem("Sauce Labs Backpack");

        //The shopping cart should be 1
        Serenity.reportThat("The shopping cart should now be '1' item",
                () -> assertThat(shoppingCartIcon.badgeCount()).isEqualTo("1")
        );
    }

    ProductList productList;
    @Test
    void allTheItemsShouldAppearInTheCart(){
        //Add several items to the cart
        List<String> selectedItems = firstThreeProductTitlesDisplayed();

        //Open the shopping cart page
        cart.addItems(selectedItems);

        String cartBadgeCount = Integer.toString(selectedItems.size());
        Serenity.reportThat("The shopping cart should now be "+cartBadgeCount+" items",
                () -> assertThat(shoppingCartIcon.badgeCount()).isEqualTo(cartBadgeCount)
        );

        cart.openCart();
        Serenity.reportThat("Should see all off the items listed",
            () -> assertThat(cart.displayedItems()).containsExactlyElementsOf(selectedItems)
        );
    }

    CartPageObject cartPage;

    //Test creado en el capitulo 8.1.0
    @Test
    void  pricesForEachItemShouldBeShownInTheCart(){

        // Add items to the shopping cart
        cart.addItems(firstThreeProductTitlesDisplayed());

        // Open the cart page
        cartPage.open();

        // Check that each item in the cart has a price
        List<CartItem> items = cartPage.items();

        assertThat(items).hasSize(3)
                .allMatch(item -> item.price() > 0.0);
    }

    private List<String> firstThreeProductTitlesDisplayed() {
        return productList.titles().subList(0,3); // == 3 titles, [0, 1 ,2, 3) -> [0,1,2]
    }

}
