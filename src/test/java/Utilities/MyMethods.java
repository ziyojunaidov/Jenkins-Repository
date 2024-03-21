package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MyMethods {
    private WebDriverWait wait = new WebDriverWait(DriveClass.getDriver(), Duration.ofSeconds(15));
    public  void waitUntilVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void myClick(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void mySendKeys(WebElement element, String text){
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }
    public void waitForNumberElementsToBe(By locator, int num){
        wait.until(ExpectedConditions.numberOfElementsToBe(locator,num));
    }
    public void waitUntilInvisible(List<WebElement> elementList){
        wait.until(ExpectedConditions.invisibilityOfAllElements(elementList));
    }
    public void waitUntilInvisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));

        //Method overloading = Having multiple methods with the same but different parameters. Code can be different as well.
        //Method overriding = Modifying a method from the super class. Parameters are the same, method name is the same but hte code is different
    }
}
