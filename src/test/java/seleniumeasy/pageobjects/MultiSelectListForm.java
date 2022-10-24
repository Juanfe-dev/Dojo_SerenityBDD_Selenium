package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html")
public class MultiSelectListForm extends SeleniumEasyForm {

    private static final By STATE = By.id("multi-select");

    //"#multi-select" could be refactored as a constant
    public List<String> selectedStates() {
        //return $("#multi-select").getSelectedValues();
        return $(STATE).getSelectedValues();
    }

    public void selectStates(String... states) {
        for(String state : states){
            //$("#multi-select").select().byValue(state);
            $(STATE).select().byValue(state);
        }
    }
}
