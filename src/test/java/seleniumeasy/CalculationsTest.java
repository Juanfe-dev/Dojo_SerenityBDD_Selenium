package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.TwoInputFieldForm;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent
public class CalculationsTest {

    private final String a;
    private final String b;
    private final String total;

    @Managed(driver = "chrome", options = "--headless")
    WebDriver driver;

    public CalculationsTest(String a, String b, String total) {
        this.a = a;
        this.b = b;
        this.total = total;
    }

    TwoInputFieldForm twoInputFieldForm;

    @TestData(columnNames = "A, B, Total")
    public static Collection<Object[]> testData() {
        return Arrays.asList(
            new Object[][] {
                    {"1","2","3"},
                    {"10","20","30"},
                    {"10","0","10"},
                    {"0","10","10"},
                    {"10000","20000","30000"},
            }
        );
    }
    @Qualifier
    public String qualifier() {return a +" + "+ b +" should equal "+ total;}

    @Test
    public void shouldCalculateTheCorrectTotal(){
        twoInputFieldForm.open();
        twoInputFieldForm.enterA(a);
        twoInputFieldForm.enterB(b);
        twoInputFieldForm.getTotal();
        assertThat(twoInputFieldForm.displayedTotal()).isEqualTo(total);
    }

}
