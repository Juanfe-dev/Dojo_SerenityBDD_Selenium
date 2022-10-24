package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html")
public class SelectListForm extends SeleniumEasyForm {

    //"#selected-value" could be refactored as a constant
    private static final By DAYS_OF_THE_WEEK = By.id("#selected-value");

    public String selectedDay() {
        //return $("#selected-value").getSelectedValue();
        return $(DAYS_OF_THE_WEEK).getSelectedValue();
    }

    public void selectDay(String day) {
       //$("#selected-value").select().byValue(day);
       $(DAYS_OF_THE_WEEK).select().byValue(day);
    }
}
