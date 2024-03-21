package runnerClasses;

import Utilities.DriveClass;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/java/featureFiles/_02_Country.feature",
        glue = "stepDefinitions",
        tags = "@SmokeTest",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)
public class _08_runnerClassWithDifferentBrowsers extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters(value = "browser")
    public void setUp(@Optional("chrome") String browserName){
        System.out.println("Test is starting");
        DriveClass.threadBrowserName.set(browserName);
    }

    @AfterClass
    public void terminate(){
        System.out.println("Test has ended");

        ExtentService.getInstance().setSystemInfo("Operating System Info",System.getProperty("os.name"));
        //Adds the info about operating info
        ExtentService.getInstance().setSystemInfo("Tester name",System.getProperty("user.name"));
        //Adds the info of the tester
        ExtentService.getInstance().setSystemInfo("Time Zone",System.getProperty("user.timezone"));
        //Adds timezone info of the user
        ExtentService.getInstance().setSystemInfo("Application name","Campus");
        ExtentService.getInstance().setSystemInfo("Department name","QA");
        ExtentService.getInstance().setSystemInfo("Team name","QA Team 1");

    }
}
