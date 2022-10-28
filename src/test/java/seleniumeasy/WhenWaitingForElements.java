package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.AlertMessagePage;
import seleniumeasy.pageobjects.ModelDialogPage;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SerenityRunner.class)
public class WhenWaitingForElements {

    @Managed(driver = "chrome")
    WebDriver driver;

    ModelDialogPage modelDialogPage;

    @Test
    public void waitingForAModalDialog() {
        modelDialogPage.open();
        modelDialogPage.saveChangesButton().shouldNotBeVisible();
        modelDialogPage.openModal();
        modelDialogPage.saveChangesButton().shouldBeVisible();
        modelDialogPage.saveChanges();
        modelDialogPage.saveChangesButton().shouldNotBeVisible();
    }

    AlertMessagePage alertMessagePage;
    @Test
    public void waitingForMessageToClose() {

        alertMessagePage.open();
        alertMessagePage.openSuccessMessage();

        assertThat(alertMessagePage.alertSuccessMessageText())
                .contains("I'm an autocloseable success message.");

        alertMessagePage.waitForMessageToDissapear();

        assertThat(alertMessagePage.alertSuccessMessage().shouldNotBeVisible());

    }

    @Test
    public void waitingForElementsToAppear() {
    }
}
