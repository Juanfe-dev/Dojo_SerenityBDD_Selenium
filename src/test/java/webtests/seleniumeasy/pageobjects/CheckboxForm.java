package webtests.seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demo.seleniumeasy.com/basic-checkbox-demo.html")
public class CheckboxForm extends SeleniumEasyForm {



    public void setAgeSelected() {
        $("#isAgeSelected").click();
    }
    public String ageText() {
        return $("#txtAge").getText();
    }

    public Boolean optionIsCheckedFor(String option) {
        return $("//label[contains(.,'"+option+"')]/input").isSelected();
    }

    public void checkAll() {
        $("#check1").click();
    }
}
