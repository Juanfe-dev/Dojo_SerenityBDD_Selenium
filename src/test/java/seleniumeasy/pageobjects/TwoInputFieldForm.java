package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demo.seleniumeasy.com/basic-first-form-demo.html")
public class TwoInputFieldForm extends SeleniumEasyForm {

    public void enterA(String value) {
        $("#sum1").type(value);
    }

    public void enterB(String value) {
        $("#sum2").type(value);
    }

    public void getTotal() {
        $(FormButton.withLabel("Get Total")).click();
    }

    public String displayedTotal() {
        return $("#displayvalue").getText();
    }
}
