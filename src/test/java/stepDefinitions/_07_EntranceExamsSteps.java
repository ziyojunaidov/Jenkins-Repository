package stepDefinitions;

import Utilities.DriveClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pages.Dialog;
import pages.Navigate;

import javax.xml.crypto.Data;
import java.util.List;

public class _07_EntranceExamsSteps {

    Dialog dialog = new Dialog();
    Navigate navigate = new Navigate();

    @And("Navigate to Entrance Exams page")
    public void navigateToEntranceExamsPage() {
        navigate.myClick(navigate.entranceExams);
        navigate.myClick(navigate.setupButton2);
        navigate.myClick(navigate.entranceExamsPage);
    }

    @And("Fill the create exam form")
    public void fillTheCreateExamForm(DataTable dataTable) {
        dialog.waitUntilVisible(dialog.description);
       List<String> dataList = dataTable.asList(String.class);
       dialog.mySendKeys(dialog.searchNameInput,dataList.get(0));
       dialog.myClick(dialog.academicPeriodDropDown);
       dialog.myClick(dialog.academicPeriodOption);
       dialog.myClick(dialog.gradeLevelDropDown);
       dialog.myClick(dialog.gradeLevelOption);
    }

    @And("Add a description")
    public void addADescription(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        dialog.myClick(dialog.description);
        dialog.waitUntilVisible(dialog.descriptionAndNotesIframe);
        DriveClass.getDriver().switchTo().frame(dialog.descriptionAndNotesIframe);
        dialog.mySendKeys(dialog.descriptionAndNotesTextArea,dataList.get(0));
        DriveClass.getDriver().switchTo().defaultContent();
    }

    @And("Add a note")
    public void addANote(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        dialog.myClick(dialog.notes);
        dialog.waitUntilVisible(dialog.descriptionAndNotesIframe);
        DriveClass.getDriver().switchTo().frame(dialog.descriptionAndNotesIframe);
        dialog.mySendKeys(dialog.descriptionAndNotesTextArea,dataList.get(0));
        DriveClass.getDriver().switchTo().defaultContent();

    }
}
