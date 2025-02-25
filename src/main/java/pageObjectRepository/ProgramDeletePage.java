package pageObjectRepository;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilitities.ExcelDataReader;

public class ProgramDeletePage {

	WebDriver driver;
	Properties prop;
	WebDriverWait wait;
	ExcelDataReader exceldatareader;
	

	public ProgramDeletePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//table//tbody/tr//button[@id='deleteProgram'][1]")
	private WebElement deletefirstprogramoption;
	@FindBy(xpath = "//span[contains(text(),'Confirm')]")
	private WebElement deletepopupconfirm;
	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	private WebElement yesbutton;
	@FindBy(xpath = "//div[contains(@class,'p-toast-message')]")
	private WebElement successMessage;
	@FindBy(xpath = "//input[@placeholder='Search...']")
	private WebElement searchBox;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr") // "//tbody/tr")
	private List<WebElement> programRows;
	@FindBy(xpath = "//table/thead/tr")
	private List<WebElement> searchRows;
	@FindBy(xpath = "//span[contains(text(),'No')]")
	private WebElement deletepopupnooption;
	// @FindBy(xpath="//span[contains(@class,'pi pi-times ng)]")
	@FindBy(xpath = "//div[contains(@class,'p-dialog-header-icons ng')]")
	private WebElement xbuttonoption;
	@FindBy(xpath = "//span[contains(@class,'p-button-icon pi pi-trash') and @aria-hidden='true'][1]")
	private WebElement multipledeleteicon;
	@FindBy(xpath = "//tbody/tr/td[1]//div/div[2][@role='checkbox' and @aria-checked='true']")
	private List<WebElement> selectedProgramCheckboxes;
	@FindBy(xpath = "//table//tr//div[@role='checkbox']")
	private List<WebElement> programCheckboxes;
	@FindBy(xpath = "//tbody/tr/td[2]")
	private List<WebElement> programNameList;

	public void verifyDeleteOption() {
		deletefirstprogramoption.click();
	}

	public boolean verifyDeletePopUpConfirm() {
		return deletepopupconfirm.isDisplayed();
	}

	public void verifyYesButton() {
		yesbutton.click();
	}

	public String verifySuccessDeleteMessage() {

		wait.until(ExpectedConditions.visibilityOf(successMessage));
		String messageText = successMessage.getText().trim().replaceAll("\\s+", " ");
		System.out.println("Captured Success Message: " + messageText);
		return messageText;

	}

	public void searchWithDeletedProgramName(String sheetName, int rowNumber)
			throws IOException, InvalidFormatException {
		exceldatareader = new ExcelDataReader();
		List<Map<String, String>> excelData = ExcelDataReader.DataFromExcel(sheetName);
		System.out.println("excelData is " + excelData);
		String DeletedprogramName = excelData.get(rowNumber).get("DeletedprogramName");
		System.out.println("partialname is " + DeletedprogramName);
		wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
		searchBox.sendKeys(DeletedprogramName);

	}

	public void searchProgram(String programName) {
		wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
		searchBox.sendKeys(programName);
	}

	public int getSearchResultsCount() {
	  
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		 // Custom wait using a lambda expression: keep checking until programRows.size() is 0
		wait.until(driver -> programRows.size() == 0);
		//wait.until(ExpectedConditions.visibilityOfAllElements(programRows));
		return programRows.size();
	}

	public void clickNoButton() {
		deletepopupnooption.click();
	}

	public boolean isdeleteDetailsFormInvisible() {
		String FORM_XPATH = "//p-confirmdialog/div/div/div/span[contains(text(),'Confirm')]";
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(FORM_XPATH)));
	}

	public void verifyXButton() {
		xbuttonoption.click();
	}

	public void selectMultiplePrograms(int count) {
		wait.until(ExpectedConditions.visibilityOfAllElements(programCheckboxes));

		System.out.println("DEBUG: Number of checkboxes found - " + programCheckboxes.size());

		if (programCheckboxes.isEmpty()) {
			throw new RuntimeException("No checkboxes found. Ensure there are programs available in the table.");
		}

		for (int i = 1; i <= count && i < programCheckboxes.size(); i++) {
			WebElement checkbox = programCheckboxes.get(i);
			System.out.println("print i " + i);
			wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
		}

	}

	public List<String> getSelectedPrograms() {
		wait.until(ExpectedConditions.visibilityOfAllElements(selectedProgramCheckboxes));
		List<String> selectedPrograms = new ArrayList<>();
		System.out.println("selectedPrograms is " + selectedPrograms);

		for (WebElement checkbox : selectedProgramCheckboxes) {
			int index = programCheckboxes.indexOf(checkbox);
			selectedPrograms.add(programNameList.get(index).getText().trim());
		}

		return selectedPrograms;
	}

	public boolean isProgramPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfAllElements(programCheckboxes)).size() > 0;
	}

	public int getProgramCount() {
		wait.until(ExpectedConditions.visibilityOfAllElements(programRows));
		return programRows.size();
	}

	public void clickMultipleDeleteIcon() {
		multipledeleteicon.click();
	}

}
