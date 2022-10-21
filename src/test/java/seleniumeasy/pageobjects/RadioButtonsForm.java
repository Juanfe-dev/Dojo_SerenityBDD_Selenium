package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demo.seleniumeasy.com/basic-radiobutton-demo.html")
public class RadioButtonsForm extends SeleniumEasyForm {


    public void selectOption(String value) {
        $("//input[@name='optradio'][@value='{0}']",value).click();
    }
    public void getCheckedValue() {
        $("#buttoncheck").click();
    }

    public String getResult() {
        return $("//p[@class='radiobutton']").getText();
    }
}
