package runnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featureFiles",
        glue = "stepDefinitions",
        tags = "@SmokeTest", // Name of the group we want to run
        plugin = {"pretty", "html:target/cucumber-pretty", "json:target/cucumber.json"}
)
public class _04_RunnerClassForGroups extends AbstractTestNGCucumberTests {
}
