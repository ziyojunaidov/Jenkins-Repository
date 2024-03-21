package runnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/java/featureFiles/_01_Login.feature",
                "src/test/java/featureFiles/_02_Country.feature",
        },
        glue = "stepDefinitions",
        dryRun = true // Only checks if we have all necessary step definitions for our features
        //dryRun = false is default value. It runs scenarios regularly
)
public class _02_RunnerClassForMultipleFeature extends AbstractTestNGCucumberTests {
}
