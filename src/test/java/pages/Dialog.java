package pages;

import Utilities.DriveClass;
import Utilities.MyMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dialog extends MyMethods {
    public Dialog(){
        PageFactory.initElements(DriveClass.getDriver(),this);
    }

    @FindBy(css = "input[placeholder=\"Username\"]")
    public WebElement username;

    @FindBy(css = "input[placeholder=\"Password\"]")
    public WebElement password;

    @FindBy(xpath = "//span[normalize-space()=\"LOGIN\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//div[text()=\"Cannot read properties of null (reading 'lang')\"]\n")
    public List<WebElement> errorMessages;

    @FindBy(css = "ms-add-button[class=\"ng-star-inserted\"]")
    public WebElement addButton;

    @FindBy(xpath = "(//input[@data-placeholder=\"Name\"])[2]")
    public WebElement formNameInput;

    @FindBy(xpath = "(//input[@data-placeholder=\"Code\"])[2]")
    public WebElement formCodeInput;

    @FindBy(xpath = "//span[text()=\"Save\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "(//input[@data-placeholder=\"Name\"])[1]")
    public WebElement searchNameInput;

    @FindBy(xpath = "//span[text()=\"Search\"]")
    public WebElement searchButton;

    @FindBy(css = "ms-edit-button[class=\"ng-star-inserted\"]")
    public WebElement editButton;

    @FindBy(css = "ms-delete-button[class=\"ng-star-inserted\"]")
    public WebElement deleteButton;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement deleteConfirmButton;

    @FindBy(xpath = "(//input[@data-placeholder=\"Short Name\"])[2]")
    public WebElement shortNameInput;

    @FindBy(css = "input[data-placeholder=\"Integration Code\"]")
    public WebElement integrationCode;

    @FindBy(xpath = "(//input[@data-placeholder=\"Priority\"])[2]")
    public WebElement priority;

    @FindBy(xpath = "(//ms-save-button[@class='ng-star-inserted'])[2]")
    public WebElement saveAndExitButton;

    @FindBy(xpath = "(//input[@data-placeholder=\"Code\"])[1]")
    public WebElement searchCodeInput;

    @FindBy(xpath = "(//input[@data-placeholder=\"Priority\"])[1]")
    public WebElement searchPriorityInput;


    @FindBy(css = "mat-select[formcontrolname=\"academicPeriod\"]")
    public WebElement academicPeriodDropDown;

    @FindBy(css = "mat-option[role=\"option\"]")
    public WebElement academicPeriodOption;

    @FindBy(xpath = "(//mat-select[@role=\"combobox\"])[2]")
    public WebElement gradeLevelDropDown;

    @FindBy(xpath = "//span[text()=\" violet _ i \"]")
    public WebElement gradeLevelOption;

    @FindBy(xpath = "//span[text()=\"Description\"]")
    public WebElement description;

    @FindBy(css = "iframe[title=\"Rich Text Area\"]")
    public WebElement descriptionAndNotesIframe;

    @FindBy(xpath = "//body[@id=\"tinymce\"]//p")
    public WebElement descriptionAndNotesTextArea;

    @FindBy(xpath = "//span[text()=\"Notes\"]")
    public WebElement notes;

    @FindBy(xpath = "//td[contains(@class,'column-name')]")
    public List<WebElement> stateList;
}
