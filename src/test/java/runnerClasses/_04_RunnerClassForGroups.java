package runnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featureFiles",
        glue = "stepDefinitions",
        tags = "@SmokeTest" // Name of the group we want to run
)
public class _04_RunnerClassForGroups extends AbstractTestNGCucumberTests {
}
