package serenityswag.authentication;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.inventory.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenLogginOn extends UIInteractionSteps {

        @Managed
        private WebDriver driver;

        @Steps
        LoginActions login;

        InventoryPage inventoryPage;
        @Test
        public void usersCanLogOnViaTheHomePage(){

               /* assertThat($(".title").getText()).isEqualToIgnoringCase("Products");*/

                login.as(User.STANDARD_USER);
                Serenity.reportThat("The inventory page should be displayed with the correct title",
                        () -> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products")
                );
        }
}
