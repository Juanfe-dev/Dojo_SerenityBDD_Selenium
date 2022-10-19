package serenityswag.cart;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;
import serenityswag.cart.CartActions;
import serenityswag.cart.ShoppingCartIcon;
import serenityswag.inventory.ProductList;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@RunWith(SerenityRunner.class)
public class WhenAddingAnItemToTheCart {


    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;

    @Before
    public void login(){
        login.as(STANDARD_USER);
    }

    ShoppingCartIcon shoppingCartIcon;

    @Steps
    CartActions cart;

    @Test
    public void theCorrectItemCountShouldBeShown(){
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
    public void allTheItemsShouldAppearInTheCart(){
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

    private List<String> firstThreeProductTitlesDisplayed() {
        return productList.titles().subList(0,3); // == 3 titles, [0, 1 ,2, 3) -> [0,1,2]
    }

}
