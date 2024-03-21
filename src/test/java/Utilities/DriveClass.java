package Utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;

public class DriveClass {
//    private static WebDriver driver;

    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static WebDriver getDriver() {
//        if (driver == null) {
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
        if (threadBrowserName.get() == null) {
            threadBrowserName.set("chrome");
        }
        if (threadDriver.get() == null) {
            switch (threadBrowserName.get()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    if(!runningOnIntelliJ()){
                        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");
                    }
                    threadDriver.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                case "safari":
                    threadDriver.set(new SafariDriver());
                    break;
            }
        }
        threadDriver.get().manage().window().maximize();

        return threadDriver.get();
    }

    public static void quitDriver() {
        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.set(null);
            closePreviousDrivers();
        }
    }
    public static boolean runningOnIntelliJ(){ // checks if the test is being run by intellij
        String classpath = System.getProperty("java.class.path");
        return classpath.contains("idea_rt.jar");

    }

    public static void closePreviousDrivers() {
        try {
            if (Platform.getCurrent().is(Platform.MAC)) {
                Runtime.getRuntime().exec("pkill -f chromedriver");
            } else if (Platform.getCurrent().is(Platform.WINDOWS)) {
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
