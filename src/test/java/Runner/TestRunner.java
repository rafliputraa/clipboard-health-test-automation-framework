package Runner;

import Base.TestBase;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

@CucumberOptions(features="src/test/resources/Features/Amazon",
        glue ={"StepDefinitions/Amazon", "Hooks/Hooks"},
        monochrome=true,
        plugin= {"html:target/cucumber.html", "json:target/cucumber.json"
                })
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
    public void setup() throws MalformedURLException {
        TestBase.driver = TestBase.initilize();
        TestBase.logger.debug("Test Base Initialized");
    }

    @AfterTest
    public void teardown()
    {
        TestBase.quit();
        TestBase.logger.debug("Test Finished");
    }
}
