package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demo.seleniumeasy.com/basic-first-form-demo.html")
public class SingleInputFieldForm extends SeleniumEasyForm {

    public void enterMessage(String message) {
        $("#user-message").type(message);
        /*//Clasic in selenium
        $("#user-message").sendKeys(message); */
    }

    public void showMessage() {
        //$("//button[.='Show Message']").click();
        $(FormButton.withLabel("Show Message")).click();
    }

    public String displayedMessage() {
            return $("//span[@id='display']").getText();
    }
}
