package runnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featureFiles",
        glue = "stepDefinitions",
        tags = "@SmokeTest", // Name of the group we want to run
        plugin = "html:target/site/cucumber-pretty.html" // Generates a html report for us
)
public class _06_RunnerClassWithPlugin extends AbstractTestNGCucumberTests {
}
