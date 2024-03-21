package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.Dialog;
import pages.Navigate;

import java.util.List;

public class _05_FeesSteps {

    Dialog dialog = new Dialog();
    Navigate navigate = new Navigate();

    @And("Navigate to Fees Page")
    public void navigateToFeesPage() {
        navigate.myClick(navigate.setupButton);
        navigate.myClick(navigate.parameters);
        navigate.myClick(navigate.feesButton);
    }

    @And("Fill the form out")
    public void fillTheFormOut(DataTable dataTable) {
        List<String> feeData = dataTable.asList(String.class);
        dialog.mySendKeys(dialog.formNameInput, feeData.get(0));
        dialog.mySendKeys(dialog.formCodeInput, feeData.get(1));
        dialog.mySendKeys(dialog.integrationCode, feeData.get(2));
        dialog.priority.clear();
        dialog.mySendKeys(dialog.priority, feeData.get(3));
    }

    @When("Click on save and exit button")
    public void clickOnSaveAndExitButton() {
        dialog.saveAndExitButton.click();
        dialog.myClick(dialog.saveAndExitButton);
    }

    @And("Search for the fee")
    public void searchForTheFee(DataTable dataTable) {
        List<String> feeData = dataTable.asList(String.class);

        dialog.mySendKeys(dialog.searchNameInput, feeData.get(0));
        dialog.mySendKeys(dialog.searchCodeInput, feeData.get(1));
        dialog.mySendKeys(dialog.searchPriorityInput, feeData.get(2));

        dialog.myClick(dialog.searchButton);
    }
}
