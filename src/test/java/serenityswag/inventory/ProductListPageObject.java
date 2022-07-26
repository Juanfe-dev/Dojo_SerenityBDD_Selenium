package serenityswag.inventory;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPageObject extends PageObject {


    public List<String> titles() {
        //Metodo para el Ch4.4.0
        // el "." hace referencia al classname en el pom
        //Podemos usar cualquier de las siguientes dos lineas de codigo

        // return findAll(By.className("inventory_item_name")).textContents();
        return findAll((".inventory_item_name")).textContents();

    }
}
