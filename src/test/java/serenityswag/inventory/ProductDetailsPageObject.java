package serenityswag.inventory;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductDetailsPageObject extends PageObject {


    public String productName() {
        //Recordar que el "." hace referencia al atributo class
        return $((".inventory_details_name")).getText();
    }
}
