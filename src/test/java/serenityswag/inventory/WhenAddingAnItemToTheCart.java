package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;
import serenityswag.cart.AddToCartAction;
import serenityswag.cart.ShoppingCartBadge;

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

    ShoppingCartBadge shoppingCartBadge;
    @Steps

    AddToCartAction addToCart;

    @Test
    public void theCorrectItemCountShouldBeShown(){
        //Check that the shopping cart badge is empty

        Serenity.reportThat("The shopping cart badge should be empty",
                () ->    assertThat(shoppingCartBadge.count()).isEmpty()
        );

        //Add 1 items to the cart

        addToCart.item("Sauce Labs Backpack");

        //The shopping cart should be 1

        Serenity.reportThat("The shopping cart should now be '1' item",
                () -> assertThat(shoppingCartBadge.count()).isEqualTo("1")
        );


    }

    @Test
    public void allTheItemsShouldAppearInTheCart(){
        login.as(STANDARD_USER);

    }

}
