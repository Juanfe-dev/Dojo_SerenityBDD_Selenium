package webtests.seleniumeasy.pageobjects;


import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

@DefaultUrl("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html")
public class DynamicDataPage extends SeleniumEasyForm {

    private static final By USER_DETAILS_PANE = By.id("loading");
    public String userDescription() {
        return $(USER_DETAILS_PANE).getText();
    }

    public void getNewUser() {
        $(FormButton.withLabel("Get New User")).click();

        //A few different ways to do that
        // 1.
            withTimeoutOf(Duration.ofSeconds(30)).
            waitFor(
                    ExpectedConditions
                            .invisibilityOfElementWithText(USER_DETAILS_PANE,
                            "loading...")
            );
        // 2. using the serenity.conf fluentwait
            //waitFor((ExpectedConditions.)...
        // 3. using the serenity.conf fluentwait
            //waitFor()...
    }
}
