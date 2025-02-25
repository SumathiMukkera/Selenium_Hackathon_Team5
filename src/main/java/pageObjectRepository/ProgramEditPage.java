package pageObjectRepository;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilitities.ExcelDataReader;

public class ProgramEditPage {
	WebDriver driver;
	WebDriverWait wait;
	ExcelDataReader exceldatareader;

	public ProgramEditPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//table//tbody//tr[1]//button[@id='editProgram']")
	private WebElement editfirstprogrambutton;
	@FindBy(xpath = "//span[@id='pr_id_2-label']")
	private WebElement editPageTitle;
	@FindBy(id = "programName")
	private WebElement namefiled;
	@FindBy(id = "programDescription")
	private WebElement descriptionfield;
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	private WebElement saveoption;
	@FindBy(xpath = "//input[@placeholder='Search...']")
	private WebElement searchBox;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr/td[2]")
	private WebElement programName;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr/td[3]")
	private WebElement programDescription;
	//@FindBy(xpath = "//input[@id='Active']/ancestor::p-radiobutton")
	@FindBy(xpath="//*[@id='category']/div/div/input[@id='Active']")
	private WebElement activeRadioButton;
   // @FindBy(xpath = "//input[@id='Inactive']/ancestor::p-radiobutton")
	@FindBy(xpath="//*[@id='category']/div/div/input[@id='Inactive']")
	private WebElement inactiveRadioButton;
	@FindBy(xpath = "//tbody/tr[td[text()]]/td[4]") 
	private WebElement programStatusColumn;

	public void clickEditProgramButton() {

		wait.until(ExpectedConditions.visibilityOfAllElements(editfirstprogrambutton));
		editfirstprogrambutton.click();
	}

	public boolean editPageTitleDisplay() {
		return editPageTitle.isDisplayed();
	}

	public String editPageTitle() {
		return editPageTitle.getText();
	}

	public void editNameFieldAndSearch(String sheetName, int rowNumber) throws IOException, InvalidFormatException {
		exceldatareader = new ExcelDataReader();
		List<Map<String, String>> excelData = ExcelDataReader.DataFromExcel(sheetName);
		System.out.println("excelData is " + excelData);
		String editprogramsname = excelData.get(rowNumber).get("editprogramsname");
		System.out.println("editprogramsname is " + editprogramsname);
		wait.until(ExpectedConditions.visibilityOf(namefiled)).clear();
		namefiled.sendKeys(editprogramsname);
		saveoption.click();
		wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
		searchBox.sendKeys(editprogramsname);
	}

	public void clickSaveOption() {
		saveoption.click();
	}

	public boolean isProgramNameDisplayed() {
		return programName.isDisplayed();
	}

	public void editDescriptionFieldAndSearch(String sheetName, int rowNumber)
			throws IOException, InvalidFormatException {
		exceldatareader = new ExcelDataReader();
		List<Map<String, String>> excelData = ExcelDataReader.DataFromExcel(sheetName);
		System.out.println("excelData is " + excelData);
		String editDescription = excelData.get(rowNumber).get("editDescription");
		System.out.println("editprogramsname is " + editDescription);
		wait.until(ExpectedConditions.visibilityOf(descriptionfield)).clear();
		descriptionfield.sendKeys(editDescription);
		saveoption.click();
		wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
		searchBox.sendKeys(editDescription);

	}

	public boolean isProgramDescriptionDisplayed() {
		return programDescription.isDisplayed();
	}

	public void editProgramEditField(String sheetName, int rowNumber) throws IOException, InvalidFormatException {
		exceldatareader = new ExcelDataReader();
		List<Map<String, String>> excelData = ExcelDataReader.DataFromExcel(sheetName);
		String editprogramsname = excelData.get(rowNumber).get("editprogramsname");
		System.out.println("editprogramsname is " + editprogramsname);
		wait.until(ExpectedConditions.visibilityOf(namefiled)).clear();
		namefiled.sendKeys(editprogramsname);
		String editDescription = excelData.get(rowNumber).get("editDescription");
		System.out.println("editprogramsname is " + editDescription);
		wait.until(ExpectedConditions.visibilityOf(descriptionfield)).clear();
		descriptionfield.sendKeys(editDescription);
	}

	public String getCurrentStatusFromPopup() {
		wait.until(ExpectedConditions.visibilityOf(activeRadioButton)); // Ensure element is visible
		wait.until(ExpectedConditions.visibilityOf(inactiveRadioButton));

		if (activeRadioButton.isSelected()) {
			return "Active";
		} else if (inactiveRadioButton.isSelected()) {
			return "Inactive";
		} else {
			throw new IllegalStateException("No status is currently selected!");
		}
	}

	public void toggleStatus() {
		wait.until(ExpectedConditions.visibilityOf(activeRadioButton)); // Ensure visibility
		wait.until(ExpectedConditions.visibilityOf(inactiveRadioButton));

		if (activeRadioButton.isSelected()) {
			wait.until(ExpectedConditions.elementToBeClickable(inactiveRadioButton)).click(); // Click on Inactive
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(activeRadioButton)).click(); // Click on Active
		}

	}

	public void getProgramName(String sheetName, int rowNumber) throws IOException, InvalidFormatException {
		exceldatareader = new ExcelDataReader();
		List<Map<String, String>> excelData = ExcelDataReader.DataFromExcel(sheetName);
		System.out.println("excelData is " + excelData);
		String programname = excelData.get(rowNumber).get("ProgramNames");
		System.out.println("programName is " + programname);

	}

	public void searchProgram(String sheetName, int rowNumber) throws IOException {
		exceldatareader = new ExcelDataReader();
		List<Map<String, String>> excelData = ExcelDataReader.DataFromExcel(sheetName);
		System.out.println("excelData is " + excelData);
		String programname = excelData.get(rowNumber).get("ProgramNames");
		System.out.println("programName is " + programname);
		wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
		searchBox.sendKeys(programname);
		
	}
	public void clickInActiveRadioButton() {
		inactiveRadioButton.click();
	}
	public void changeStatus() {
		if(inactiveRadioButton.isSelected()) {
			activeRadioButton.click();
		}else if(activeRadioButton.isSelected()){
			inactiveRadioButton.click();
		}
	}

}
