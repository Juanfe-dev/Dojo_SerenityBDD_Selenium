package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.ModelDialogPage;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

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

    @Test
    public void waitingForAMessageToClose() {
    }

    @Test
    public void waitingForElementsToAppear() {
    }
}
