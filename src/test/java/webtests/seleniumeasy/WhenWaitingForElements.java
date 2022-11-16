package webtests.seleniumeasy;

import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import webtests.seleniumeasy.pageobjects.AlertMessagePage;
import webtests.seleniumeasy.pageobjects.DynamicDataPage;
import webtests.seleniumeasy.pageobjects.ModelDialogPage;

import static org.assertj.core.api.Assertions.assertThat;

 class WhenWaitingForElements {

    @Managed(driver = "chrome")
    WebDriver driver;

    ModelDialogPage modelDialogPage;

    @Test
    void waitingForAModalDialog() {
        modelDialogPage.open();
        modelDialogPage.saveChangesButton().shouldNotBeVisible();
        modelDialogPage.openModal();
        modelDialogPage.saveChangesButton().shouldBeVisible();
        modelDialogPage.saveChanges();
        modelDialogPage.saveChangesButton().shouldNotBeVisible();
    }

    AlertMessagePage alertMessagePage;
    @Test
    void waitingForMessageToClose() {
        alertMessagePage.open();
        alertMessagePage.openSuccessMessage();

        assertThat(alertMessagePage.alertSuccessMessageText())
                .contains("I'm an autocloseable success message.");

        alertMessagePage.waitForMessageToDissapear();
        assertThat(alertMessagePage.alertSuccessMessage().shouldNotBeVisible());
    }

    DynamicDataPage dynamicDataPage;
    @Test
    void waitingForElementsToAppear() {

        dynamicDataPage.open();

        dynamicDataPage.getNewUser();

        assertThat(dynamicDataPage.userDescription())
                .contains("First Name")
                .contains("Last Name");
    }
}
