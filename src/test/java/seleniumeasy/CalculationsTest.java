package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;

import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.TwoInputFieldForm;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent
@UseTestDataFrom("test-data/calculations.csv")
public class CalculationsTest {

    private  String a;
    private  String b;
    private  String total;

    @Managed(driver = "chrome", options = "--headless")
    WebDriver driver;

    @Qualifier
    public String qualifier() {return a +" + "+ b +" should equal "+ total;}

    TwoInputFieldForm twoInputFieldForm;
    @Test
    public void shouldCalculateTheCorrectTotal(){
        twoInputFieldForm.open();
        twoInputFieldForm.enterA(a);
        twoInputFieldForm.enterB(b);
        twoInputFieldForm.getTotal();
        assertThat(twoInputFieldForm.displayedTotal()).isEqualTo(total);
    }
}

/*
    //Used in Chapter 12.0.0
    //Commented for Chapter 12.1.0
    private final String a;
    private final String b;
    private final String total;
    */

    /*
    //Used in Chapter 12.0.0
    //Commented for Chapter 12.1.0
    public CalculationsTest(String a, String b, String total) {
        this.a = a;
        this.b = b;
        this.total = total;
    }*/

    /*
    //Used in Chapter 12.0.0
    //Commented for Chapter 12.1.0
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
    }*/


