package stepDefinitions;

import Utilities.DriveClass;
import Utilities.ExcelUtilities;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;
import java.time.LocalDateTime;

public class Hooks {
    LocalDateTime startTime;


    @Before //Runs before every scenario
    public void beforeScenario(){
//        System.out.println("Scenario has started");
         startTime = LocalDateTime.now();
    }
    @After
    public void afterScenario(Scenario scenario){
//        System.out.println("Scenario has ended");

        if (scenario.isFailed()) {
            final byte[] byteImage = ((TakesScreenshot) (DriveClass.getDriver())).getScreenshotAs(OutputType.BYTES);
            scenario.attach(byteImage, "image/png", scenario.getName());
        }
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime,endTime);
        //scenario name, scenario id, scenario status, start time, end time, duration
        ExcelUtilities.writeScenarioInfoToExcel(scenario,startTime,endTime,duration);
        DriveClass.quitDriver();
    }
    @BeforeStep
    public void beforeStep(){
//        System.out.println("Step has started");
    }
    @AfterStep
    public void afterStep(){
//        System.out.println("Step has ended");
    }
}
