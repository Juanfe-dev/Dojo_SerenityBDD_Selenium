package serenityswag.authentication;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenLogginOn {

        @Managed
        private WebDriver driver;

        @Test
        public void usersCanLogOnViaTheHomePage(){
        driver.get("https://www.saucedemo.com/");

        //Login as standard user
                driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
                driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
                driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        //Should see product catalog

                assertThat(driver.findElement(By.cssSelector(".title")).getText())
                        .isEqualToIgnoringCase("Products");
                //.isEqualToIgnoringCase hace que sea indiferente de mayuscula-minuscula la comparacion


               // driver.findElement(By.cssSelector("//*[@alt='Sauce Labs Backpack']")).click();

        //Add to cart
        }
}
