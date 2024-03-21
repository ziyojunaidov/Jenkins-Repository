package stepDefinitions;

import Utilities.DriveClass;
import Utilities.ExcelUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.Dialog;
import pages.Navigate;

import java.util.List;

public class _03_Citizenship {

    Dialog dialog = new Dialog();
    Navigate navigate = new Navigate();

    @And("Navigate to Citizenship page")
    public void navigateToCitizenshipPage() {
        navigate.myClick(navigate.setupButton);
        navigate.myClick(navigate.parameters);
        navigate.myClick(navigate.citizenshipsButton);
    }

    @And("Enter {string} and {string}")
    public void enterAnd(String CitizenshipName, String CitizenshipShortName) {
        dialog.mySendKeys(dialog.formNameInput,CitizenshipName);
        dialog.mySendKeys(dialog.shortNameInput,CitizenshipShortName);

    }


    @And("Search for the {string}")
    public void searchForThe(String citizenshipName) {
        dialog.mySendKeys(dialog.searchNameInput,citizenshipName);
        dialog.myClick(dialog.searchButton);
    }

    @Then("Create a citizenship by using Apache POI")
    public void createACitizenshipByUsingApachePOI() {
      List<List<String>> citizenshipData = ExcelUtilities.getDataFromExcel("C:\\Users\\jdjun\\OneDrive\\ApacheExcel2 (1).xlsx","testCitizen");
        for (int i = 0; i < citizenshipData.size(); i++) {
            dialog.myClick(dialog.addButton);
            dialog.mySendKeys(dialog.formNameInput,citizenshipData.get(0).get(0));
            dialog.mySendKeys(dialog.shortNameInput,citizenshipData.get(0).get(1));
            dialog.myClick(dialog.saveButton);
            dialog.waitUntilVisible(dialog.successMessage);
            Assert.assertTrue(dialog.successMessage.getText().contains("successfully"));
            dialog.waitUntilVisible(dialog.successMessage);
        }
    }
}
