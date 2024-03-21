package stepDefinitions;

import Utilities.DriveClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.Dialog;
import pages.Navigate;

import java.time.Duration;

public class _01_LoginSteps {
    Dialog dialog = new Dialog();
    Navigate navigate = new Navigate();
    WebDriverWait wait = new WebDriverWait(DriveClass.getDriver(), Duration.ofSeconds(10));

    @Given("Navigate to campus website")
    public void navigate_to_campus_website() {
        System.out.println("Navigating to campus");
        DriveClass.getDriver().get("https://test.mersys.io/");

    }
    @Given("Enter username and password")
    public void enter_username_and_password() {
        System.out.println("Entering username and password");
//        wait.until(ExpectedConditions.visibilityOf(dialog.username));
        dialog.waitUntilVisible(dialog.username);
        dialog.username.sendKeys("turkeyts");
        dialog.password.sendKeys("TechnoStudy123");
    }
    @When("Click on login button")
    public void click_on_login_button() {
        System.out.println("Clicking on login button");
        dialog.loginButton.click();
    }
    @Then("User should login successfully")
    public void user_should_login_successfully() {
        System.out.println("User is logged in");
        navigate.waitUntilVisible(navigate.dashboard);
//        wait.until(ExpectedConditions.visibilityOf(navigate.dashboard));
        Assert.assertTrue(navigate.dashboard.isDisplayed());
    }
}
