package webtests.lambdatest;

import net.serenitybdd.core.webdriver.enhancers.BeforeAWebdriverScenario;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.SupportedWebDriver;
import org.openqa.selenium.MutableCapabilities;

public class BeforeALambdaTestScenario implements BeforeAWebdriverScenario {
    @Override
    public MutableCapabilities apply(EnvironmentVariables environmentVariables,
                                     SupportedWebDriver supportedWebDriver,
                                     TestOutcome testOutcome,
                                     MutableCapabilities mutableCapabilities) {

        //In this class we can do anything we need to do a capability before of any test
        mutableCapabilities.setCapability("name", testOutcome.getCompleteName());
        return mutableCapabilities;
    }
}
