package serenityswag.inventory;


import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.User;
import serenityswag.authentication.actions.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
    public class WhenViewingHighlightedProducts extends UIInteractionSteps {

        @Managed(driver = "chrome")
        private WebDriver driver;

        @Steps
        LoginActions login;

        ProductListPageObject productList;

        ProductDetailsPageObject productDetails;

        @Test
        public void shouldDisplayHighlightedProductsOnTheWelcomePage() {
            login.as(User.STANDARD_USER);
            List<String> productsOnDisplay = productList.titles();
            assertThat(productsOnDisplay).hasSize(6)
                    .contains("Sauce Labs Backpack");
        }
        @Test
    public void shouldDisplayCorrectProductDetailsPage(){
            login.as(User.STANDARD_USER);
            String firstItemName = productList.titles().get(0);

            //En vez de ejecutar un clic en el link aqui, crearemos un metodo
            //Que pida como parametro el nombre visible en
            //el explorador del item deseado, de clic en el
            //e ingrese a los detalles de ese item (openProductDetailsFor)
            productList.openProductDetailsFor(firstItemName);

            assertThat(productDetails.productName()).isEqualTo(firstItemName);
        }
    }
