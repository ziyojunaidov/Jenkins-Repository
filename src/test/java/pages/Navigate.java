package pages;

import Utilities.DriveClass;
import Utilities.MyMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Navigate extends MyMethods {
    public Navigate(){
        PageFactory.initElements(DriveClass.getDriver(), this);

    }
    @FindBy(xpath = "//span[text()=\"Dashboard \"]")
    public WebElement dashboard;

    @FindBy(xpath = "(//span[text()=\"Setup\"])[1]")
    public WebElement setupButton;

    @FindBy(xpath = "//span[text()=\"Parameters\"]")
    public WebElement parameters;

    @FindBy(xpath = "(//span[text()=\"Countries\"])[1]")
    public WebElement countries;

    @FindBy(xpath = "(//span[text()=\"Citizenships\"])[1]")
    public WebElement citizenshipsButton;

    @FindBy(xpath = "//span[text()=\"Fees\"]")
    public WebElement feesButton;

    @FindBy(xpath = "(//span[text()=\"Entrance Exams\"])[1]")
    public WebElement entranceExams;

    @FindBy(xpath = "(//span[text()=\"Setup\"])[2]")
    public WebElement setupButton2;

    @FindBy(xpath = "(//span[text()=\"Entrance Exams\"])[2]")
    public WebElement entranceExamsPage;

    @FindBy(xpath = "(//span[text()='States'])[1]\n")
    public WebElement StatesButton;


}
