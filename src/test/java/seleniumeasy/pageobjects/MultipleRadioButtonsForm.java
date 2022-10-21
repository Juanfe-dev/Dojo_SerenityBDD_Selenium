package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demo.seleniumeasy.com/basic-radiobutton-demo.html")
public class MultipleRadioButtonsForm extends SeleniumEasyForm {

    public void selectGender(String value) {
        inRadioButtonGroup("gender").selectByValue(value);
    }

    public void selectAgeGroup(String value) {
        inRadioButtonGroup("ageGroup").selectByValue(value);
    }

    public void getValues() {
        $(FormButton.withLabel("Get values")).click();
    }

    public String getResult() {
        return $(".groupradiobutton").getText();
    }



   /* public void selectGender(String gender) {
        $("//input[@value='{0}'][@name='gender']",gender).click();
    }

    public void selectAgeGroup() {
        $("//input[@value='5 - 15']").click();
    }

    public void getValues() {
        $("//button[text()='Get values']").click();
    }

    public String getResult() {
        return $("//p[@class='groupradiobutton']").getTextContent();
    }*/
}
