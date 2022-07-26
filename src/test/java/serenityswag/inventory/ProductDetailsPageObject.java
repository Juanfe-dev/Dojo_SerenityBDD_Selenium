package serenityswag.inventory;

import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductDetailsPageObject extends PageObject {


    public String productName() {
        //Recordar que el "." hace referencia al atributo class
        return $((".inventory_details_name")).getText();
    }

    public WebElementState productImageWithAltValueOf(String firstItemName) {
        //Por buenas practicas esta manera permite que alt dependa del elemento
        //return $(By.cssSelector(".inventory_details_container img[alt='"+firstItemName+"']"));
        //Version resumida:
            return $(("css:img[alt='"+firstItemName+"']"));
        //return $(By.cssSelector(".inventory_details_container img[alt='Sauce Labs Backpack']"));
    }
}
