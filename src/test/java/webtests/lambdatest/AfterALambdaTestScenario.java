package webtests.lambdatest;

import net.serenitybdd.core.webdriver.enhancers.AfterAWebdriverScenario;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.model.TestResult;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AfterALambdaTestScenario implements AfterAWebdriverScenario {
    @Override
    public void apply(EnvironmentVariables environmentVariables,
                      TestOutcome testOutcome,
                      WebDriver webDriver) {

        //In this class we can do anything we need to do a capability after of any test
        if (testOutcome.getResult() == TestResult.FAILURE) {
            ((JavascriptExecutor) webDriver).executeScript("lambda-status=failed");
        }
    }
}
