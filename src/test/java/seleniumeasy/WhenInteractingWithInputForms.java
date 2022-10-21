package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.CheckboxForm;
import seleniumeasy.pageobjects.SingleInputFieldForm;
import seleniumeasy.pageobjects.TwoInputFieldForm;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * This is a series of exercises designed to explore how to use
 * Serenity BDD to test various kinds of HTML elements
 */
@RunWith(SerenityRunner.class)
public class WhenInteractingWithInputForms {

    @Managed(driver = "chrome", uniqueSession = true)
    WebDriver driver;

    /**
     * Basic form fields:
     * Enter a message and check that the message is correctly displayed
     * https://demo.seleniumeasy.com/basic-first-form-demo.html
     */

    SingleInputFieldForm singleInputFieldForm;
    @Test
    public void basicForms() {
        singleInputFieldForm.open();
        singleInputFieldForm.enterMessage("Hi there");
        singleInputFieldForm.showMessage();

        assertThat(singleInputFieldForm.displayedMessage()).isEqualTo("Hi there");
    }

    /**
     * Basic form fields (part 2)
     * Enter two values and calculate the result
     * https://demo.seleniumeasy.com/basic-first-form-demo.html
     */

    TwoInputFieldForm twoInputFieldForm;
    @Test
    public void basicFormsWithMultipleFields() {
        twoInputFieldForm.open();
        twoInputFieldForm.enterA("2");
        twoInputFieldForm.enterB("3");
        twoInputFieldForm.getTotal();

        assertThat(twoInputFieldForm.displayedTotal()).isEqualTo("5");
    }

    /**
     * Checkboxes
     * Check that a message appears when you click the checkbox
     * https://demo.seleniumeasy.com/basic-checkbox-demo.html
     */

    CheckboxForm checkboxForm;
    @Test
    public void singleCheckbox() {
        checkboxForm.open();
        checkboxForm.setAgeSelected();

        assertThat(checkboxForm.ageText()).isEqualTo("Success - Check box is checked");
    }

    private static final List<String> ALL_THE_OPTIONS = asList("Option 1", "Option 2", "Option 3", "Option 4");
    @Test
    public void multipleCheckboxes() {

        checkboxForm.open();

        assertThat(ALL_THE_OPTIONS).allMatch(
                option -> !checkboxForm.optionIsCheckedFor(option)
        );

        checkboxForm.checkAll();
        assertThat(ALL_THE_OPTIONS).allMatch(
                option -> checkboxForm.optionIsCheckedFor(option)
        );

       /* assertThat(checkboxForm.optionIsCheckedFor("Option 1")).isFalse();
        assertThat(checkboxForm.optionIsCheckedFor("Option 2")).isFalse();
        assertThat(checkboxForm.optionIsCheckedFor("Option 3")).isFalse();
        assertThat(checkboxForm.optionIsCheckedFor("Option 4")).isFalse();

        checkboxForm.checkAll();
        assertThat(checkboxForm.optionIsCheckedFor("Option 1")).isTrue();
        assertThat(checkboxForm.optionIsCheckedFor("Option 2")).isTrue();
        assertThat(checkboxForm.optionIsCheckedFor("Option 3")).isTrue();
        assertThat(checkboxForm.optionIsCheckedFor("Option 4")).isTrue();*/
    }

    /**
     * Radio buttons
     * Check that a message appears when you click the radio button
     * https://demo.seleniumeasy.com/basic-radiobutton-demo.html
     */
    @Test
    public void radioButtons() {
    }

    @Test
    public void multipleRadioButtons() {
    }

    /**
     * Dropdown lists
     * https://demo.seleniumeasy.com/basic-select-dropdown-demo.html
     */
    @Test
    public void selectList() {
    }

    /**
     * Multi-Select Dropdown lists
     * https://demo.seleniumeasy.com/basic-select-dropdown-demo.html
     */
    @Test
    public void multiSelectList() {
    }
}
