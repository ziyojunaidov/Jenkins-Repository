package runnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featureFiles/_01_Login.feature", // The path of feature file we want to run
        glue = "stepDefinitions" // Where to find stepDefinitions of our scenarios
)
public class _01_runnerClassForSingleFeature extends AbstractTestNGCucumberTests {
}
