package seleniumeasy.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class NavigateActions extends UIInteractionSteps {

    @Step
    public void to(FormPage formPage){
        openPageNamed(formPage.name());
    }

    @Step
    public void toTheSingleInputFieldForm() {
        openPageNamed("singleInputFieldForm"); //This url is from serenity.conf file
        //openUrl("https://demo.seleniumeasy.com/basic-first-form-demo.html");
    }

    @Step
    public void toTheTwoInputFieldForm(){
        openPageNamed("twoInputFieldForm");
    }

    @Step
    public void toTheCheckboxForm(){
        openPageNamed("checkboxForm");
    }

    @Step
    public void toTheRadioButtonsForm(){
        openPageNamed("radioButtonsForm");
    }
    @Step
    public void toTheMultipleRadioButtonsForm(){
        openPageNamed("multipleRadioButtonsForm");
    }
    @Step
    public void toTheSelectListForm(){
        openPageNamed("selectListForm");
    }
    @Step
    public void toTheMultiSelectListForm(){
        openPageNamed("selectListForm");
    }
    @Step
    public void toTheHoverPage(){
        openPageNamed("hoverPage");
    }
}
