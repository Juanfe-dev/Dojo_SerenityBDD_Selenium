package webtests.seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://the-internet.herokuapp.com/hovers")
public class HoverPage extends PageObject {

    public static final String FIGURE_IMAGE = "(//div[@class='figure']/img)[{0}]";
    public static final String FIGURE_CAPTION = "(//div[@class='figcaption'])[{0}]";

    public void hoverOverFigure(int number) {
        //WebElementFacade figure = $("(//div[@class='figure']/img)[{0}]", number);
        WebElementFacade figure = $(FIGURE_IMAGE, number);

        //new Actions(getDriver()) //is equals "to withAction()"

        //withAction().dragAndDrop($(FIGURE_IMAGE,1), $(FIGURE_CAPTION,2)).perform();
        withAction().moveToElement(figure).perform();
    }

    public WebElementState captionForFigure(int number) {
        //return $("(//div[@class='figcaption'])[{0}]", number);
        return $(FIGURE_CAPTION, number);
    }
}
