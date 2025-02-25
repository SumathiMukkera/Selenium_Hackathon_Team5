package pageObjectRepository;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilitities.ExcelDataReader;

public class ProgramSearchPage {

	WebDriver driver;
	WebDriverWait wait;
	ExcelDataReader exceldatareader;
	String programname;

	public ProgramSearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Search...']")
	private WebElement searchBox;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr/td[2]")
	private WebElement programName;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr/td[3]")
	private WebElement programDescription;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr/td[4]")
	private WebElement programStatus;
	@FindBy(xpath = "//table//tr/th[2]//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	private WebElement arrownexttoprogramname;
	@FindBy(xpath = "//table//tr/th[3]//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	private WebElement arrownexttoprogramdescription;
	@FindBy(xpath = "//table//tr/th[4]//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	private WebElement arrownexttoprogramstatus;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr/td[2]")
	// @FindBy(xpath =
	// "//th[@psortablecolumn='programName']//span[contains(@class,'p-sortable-column-icon')]")
	private List<WebElement> programNameCells;
	@FindBy(xpath = "//table//tr/th[@aria-sort='ascending']")
	private WebElement ascendingarrow;
	@FindBy(xpath = "//table//tr/th[@aria-sort='descending']")
	private WebElement descendingarrow;

	public void clicksearch() {
		searchBox.click();
	}

	public void searchWithProgramName(String sheetName, int rowNumber) throws IOException, InvalidFormatException {
		exceldatareader = new ExcelDataReader();
		List<Map<String, String>> excelData = ExcelDataReader.DataFromExcel(sheetName);
		System.out.println("excelData is " + excelData);
		programname = excelData.get(rowNumber).get("ProgramNames");
		System.out.println("programName is " + programname);
		wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
		searchBox.sendKeys(programname);

	}

	public boolean isProgramNameDisplayed() {
		return programName.isDisplayed();
	}

	public boolean isProgramDescriptionDisplayed() {
		return programDescription.isDisplayed();
	}

	public boolean isProgramStatusDisplayed() {
		return programStatus.isDisplayed();
	}

	public void searchWithProgramDescription(String sheetName, int rowNumber)
			throws IOException, InvalidFormatException {
		exceldatareader = new ExcelDataReader();
		List<Map<String, String>> excelData = ExcelDataReader.DataFromExcel(sheetName);
		System.out.println("excelData is " + excelData);
		String programdescription = excelData.get(rowNumber).get("ProgramDescription");
		System.out.println("programdescription is " + programdescription);
		wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
		searchBox.sendKeys(programdescription);

	}

	public void searchWithProgramNotExist(String sheetName, int rowNumber) throws IOException, InvalidFormatException {
		exceldatareader = new ExcelDataReader();
		List<Map<String, String>> excelData = ExcelDataReader.DataFromExcel(sheetName);
		System.out.println("excelData is " + excelData);
		String Programthatdoesnotexist = excelData.get(rowNumber).get("Programthatdoesnotexist");
		System.out.println("programdoesnotexist is " + Programthatdoesnotexist);
		wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
		searchBox.sendKeys(Programthatdoesnotexist);

	}

	public void searchWithPartialProgramName(String sheetName, int rowNumber)
			throws IOException, InvalidFormatException {
		exceldatareader = new ExcelDataReader();
		List<Map<String, String>> excelData = ExcelDataReader.DataFromExcel(sheetName);
		System.out.println("excelData is " + excelData);
		String PartialName = excelData.get(rowNumber).get("PartialName");
		System.out.println("partialname is " + PartialName);
		wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
		searchBox.sendKeys(PartialName);

	}

	public List<String> getProgramNames() {
		wait.until(ExpectedConditions.visibilityOfAllElements(programNameCells));
		List<String> names = new ArrayList<>();
		for (WebElement cell : programNameCells) {
			names.add(cell.getText().trim());
		}
		return names;
	}

	public boolean areProgramNamesSorted(String sortOrder) {
		List<String> actualNames = getProgramNames();
		List<String> expectedNames = new ArrayList<>(actualNames);

		if (sortOrder.equalsIgnoreCase("Ascending")) {
			Collections.sort(expectedNames);
		} else if (sortOrder.equalsIgnoreCase("Descending")) {
			Collections.sort(expectedNames, Collections.reverseOrder());
		} else {
			throw new IllegalArgumentException("Invalid sort order: " + sortOrder);
		}

		return actualNames.equals(expectedNames);
	}

	public boolean verifyAscending() {
		return ascendingarrow.isDisplayed();
	}

	public void clickAscending() {
		ascendingarrow.click();
	}

	public boolean verifyDescending() {
		return descendingarrow.isDisplayed();
	}

	public void clickArrowNextToProgramName() {
		arrownexttoprogramname.click();
	}

	public void clickArrowNextToProgramDescription() {
		arrownexttoprogramdescription.click();
	}

	public void clickArrowNextToProgramStatus() {
		arrownexttoprogramstatus.click();
	}

}
