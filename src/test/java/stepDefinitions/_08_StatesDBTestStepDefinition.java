package stepDefinitions;

import Utilities.DBUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Dialog;
import pages.Navigate;

import java.util.List;

public class _08_StatesDBTestStepDefinition {
    Dialog dialog = new Dialog();
    Navigate navigate = new Navigate();

    @And("Navigate to States page")
    public void navigateToStatesPage() {
        navigate.myClick(navigate.setupButton);
        navigate.myClick(navigate.parameters);
        navigate.myClick(navigate.StatesButton);
    }
    List<List<String>> data;
    @When("Send {string} as query")
    public void sendAsQuery(String query) {
         data = DBUtilities.getData(query);
    }

    @Then("Check if the result from UI are in the database")
    public void checkIfTheResultFromUIAreInTheDatabase() {
        List<WebElement> statesUI = dialog.stateList;
        for (int i = 0; i < statesUI.size(); i++) {
            int count = 0;
            for (int j = 0; j < data.size(); j++) {
                if (data.get(j).contains(statesUI.get(i).getText())){
                    count++;
                }
            }
            Assert.assertEquals(count,1);
        }
    }
}
