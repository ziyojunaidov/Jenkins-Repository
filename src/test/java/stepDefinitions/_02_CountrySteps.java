package stepDefinitions;

import Utilities.DriveClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.Dialog;
import pages.Navigate;

import java.time.Duration;

public class _02_CountrySteps {
    Navigate navigate = new Navigate();
    Dialog dialog = new Dialog();

    @And("Navigate to countries page")
    public void navigateToCountriesPage() {
        navigate.myClick(navigate.setupButton);
        navigate.myClick(navigate.parameters);
        navigate.myClick(navigate.countries);
    }

    @And("Click on add button")
    public void clickOnAddButton() {
        dialog.myClick(dialog.addButton);
    }

    @And("Enter country name and country code")
    public void enterCountryNameAndCountryCode() throws InterruptedException {
        dialog.mySendKeys(dialog.formNameInput, "Batch1000");
        dialog.mySendKeys(dialog.formCodeInput,"qwerty0000");
    }

    @When("Click on save button")
    public void clickOnSaveButton() {
        dialog.myClick(dialog.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dialog.waitUntilVisible(dialog.successMessage);
        Assert.assertTrue(dialog.successMessage.isDisplayed());
    }

    @And("Search for the country")
    public void searchForTheCountry() {
        dialog.mySendKeys(dialog.searchNameInput,"Batch1000");
        dialog.myClick(dialog.searchButton);
    }

    @And("Click on edit button")
    public void clickOnEditButton() throws InterruptedException {
        dialog.waitForNumberElementsToBe(By.cssSelector("ms-edit-button[class=\"ng-star-inserted\"]"),1);
        dialog.myClick(dialog.editButton);
    }

    @And("Change the country code")
    public void changeTheCountryCode() {
        dialog.mySendKeys(dialog.formCodeInput,"qwerty");
    }

    @And("Click on delete button")
    public void clickOnDeleteButton() {
        dialog.waitForNumberElementsToBe(By.cssSelector("ms-delete-button[class=\"ng-star-inserted\"]"),1);
        dialog.myClick(dialog.deleteButton);
    }

    @When("Click on delete confirm")
    public void clickOnDeleteConfirm() {
        dialog.myClick(dialog.deleteConfirmButton);
    }

    @And("Enter {string} as country name and {string} as country code")
    public void enterAsCountryNameAndAsCountryCode(String countryName, String countryCode) {
        dialog.mySendKeys(dialog.formNameInput,countryName);
        dialog.mySendKeys(dialog.formCodeInput,countryCode);
    }
}
