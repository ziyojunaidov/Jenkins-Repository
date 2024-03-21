package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class _04_DataTableSteps {
    @Given("Go to the website")
    public void goToTheWebsite() {
        System.out.println("Going to the website");
    }

    @And("Fill the form with valid information")
    public void fillTheFormWithValidInformation(DataTable dataTable) {
      List<String> dataList = dataTable.asList(String.class);
        System.out.println(dataList.get(0));
        System.out.println(dataList.get(1));
        System.out.println(dataList.get(2));
        System.out.println(dataList.get(3));
        System.out.println(dataList.get(4));
        System.out.println(dataList.get(5));
        System.out.println(dataList.get(6));
        System.out.println(dataList.get(7));
        System.out.println(dataList.get(8));
    }

    @Then("Save the form")
    public void saveTheForm() {
        System.out.println("Form is saved");
    }

    @And("Enter valid data")
    public void enterValidData(DataTable dataTable) {
       List<List<String>> dataList = dataTable.asLists(String.class);

//        System.out.println(dataList.get(0).get(0)+": " +dataList.get(0).get(1));
//        System.out.println(dataList.get(1).get(0)+": "+dataList.get(1).get(1));
//        System.out.println(dataList.get(2).get(0)+": "+dataList.get(2).get(1));
//        System.out.println(dataList.get(3).get(0)+": "+dataList.get(3).get(1));
//        System.out.println(dataList.get(4).get(0)+": "+dataList.get(4).get(1));
//        System.out.println(dataList.get(5).get(0)+": "+dataList.get(5).get(1));
//        System.out.println(dataList.get(6).get(0)+": "+dataList.get(6).get(1));
//        System.out.println(dataList.get(7).get(0)+": "+dataList.get(7).get(1));
//        System.out.println(dataList.get(8).get(0)+": "+dataList.get(8).get(1));

        for (List<String> row : dataList){
            System.out.println(row.get(0)+": "+row.get(1));
        }
    }
}
