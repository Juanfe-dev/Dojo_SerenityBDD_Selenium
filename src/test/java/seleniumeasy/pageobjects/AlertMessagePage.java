package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.time.Duration;

@DefaultUrl("https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html")
public class AlertMessagePage extends SeleniumEasyForm {

    private final static By ALERT_SUCCESS_MESSAGE = By.cssSelector(".alert-autocloseable-success");

    public void openSuccessMessage() {
        $("#autoclosable-btn-success").click();
    }

    public String alertSuccessMessageText() {
        return $(ALERT_SUCCESS_MESSAGE).getText();
    }

    public void waitForMessageToDissapear() {
        //Using fluentwait in serenity.conf
        //waitForRenderedElementsToDisappear(ALERT_SUCCESS_MESSAGE);

        //Using explicit fluent wait in this method
        withTimeoutOf(Duration.ofSeconds(10)).waitForElementsToDisappear(ALERT_SUCCESS_MESSAGE);
    }

    public WebElementFacade alertSuccessMessage() {
        return $(ALERT_SUCCESS_MESSAGE);
    }
}
