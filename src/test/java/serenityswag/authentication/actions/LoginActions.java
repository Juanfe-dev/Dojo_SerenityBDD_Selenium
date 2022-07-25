package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.authentication.User;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as {0}")
    public void as(User user){
        openUrl("https://www.saucedemo.com/");
        $("[data-test='username']").sendKeys(user.getUsername());
        $("[data-test='password']").sendKeys(user.getPassword());
        $("[data-test='login-button']").click();
    }

    /*@Step("Log in as a standar user")
    public void asAStandarUser(){

        openUrl("https://www.saucedemo.com/");
        $("[data-test='username']").sendKeys("standard_user");
        $("[data-test='password']").sendKeys("secret_sauce");
        $("[data-test='login-button']").click();
    }
    @Step("Log in as a locked out user")
    public void asALockedOutUser(){

        openUrl("https://www.saucedemo.com/");
        $("[data-test='username']").sendKeys("locked_out_user");
        $("[data-test='password']").sendKeys("secret_sauce");
        $("[data-test='login-button']").click();
    }*/

}
