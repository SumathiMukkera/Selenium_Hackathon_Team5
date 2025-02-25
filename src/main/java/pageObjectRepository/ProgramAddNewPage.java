package pageObjectRepository;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilitities.ExcelDataReader;

public class ProgramAddNewPage {
	WebDriver driver;
	WebDriverWait wait;
	ExcelDataReader exceldatareader;

	public ProgramAddNewPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[contains(text(),'Add New Program')]")
	WebElement addnewprogram;
	@FindBy(xpath = "//div[@role='dialog']")
	WebElement newprogrampopupbox;
	@FindBy(id = "pr_id_3-label")
	WebElement popuptitle;
	@FindBy(xpath = "//label[@for='programName']/span")
	WebElement redastrickbesidename;
	@FindBy(id = "saveProgram")
	WebElement popupsavebutton;
	@FindBy(xpath = "//small[contains(@class,'p-invalid ng-star-inserted')]")
	WebElement filedrequired;
	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	WebElement cancel;
	@FindBy(id = "programName")
	WebElement nameTextBox;
	@FindBy(id = "programDescription")
	WebElement descriptionTextBox;
	@FindBy(xpath = "//input[@id='Active']/ancestor::p-radiobutton")
	private WebElement activeRadioButtonContainer;
	@FindBy(xpath = "//input[@id='Inactive']/ancestor::p-radiobutton")
	private WebElement inactiveRadioButtonContainer;
	@FindBy(xpath = "//div[contains(@class,'p-toast-message')]")
	// @FindBy(xpath = "//div[contains(@class,'p-toast-message-content') and
	// contains(text(),'Successful Program created')]")
	private WebElement successMessage;
	@FindBy(xpath = "//input[@placeholder='Search...']")
	private WebElement searchBox;
	@FindBy(xpath = "//tbody/tr")
	private List<WebElement> programNameList;
	@FindBy(xpath = "//span[contains(@class,'p-dialog-header')]")
	private WebElement x;

	public void addNewProgram() {
		addnewprogram.click();
	}

//	public String getTextOfAddNewProgram() {
//
//		wait.until(ExpectedConditions.visibilityOf(addnewprogram));
//
//		try {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("var overlays = document.querySelectorAll('div.cdk-overlay-backdrop');"
//					+ "for(var i=0; i<overlays.length; i++) { overlays[i].parentNode.removeChild(overlays[i]); }");
//		} catch (Exception e) {
//			System.out.println("No overlay found or could not remove overlay: " + e.getMessage());
//		}
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String text = (String) js.executeScript("return arguments[0].innerText;", addnewprogram);
//		return text;
//	}
	public void clickUsingJavascriptExecutor(WebElement element) {
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", element);
	}
	public WebElement getTextOfAddNewProgram() {
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", addnewprogram);
		return addnewprogram;
		
	}

	public boolean newClassPopUpBox() {

		return newprogrampopupbox.isDisplayed();
	}

	public String popUpTitle() {
		return popuptitle.getText();
	}

	public boolean redAstrickBesideName() {
		return redastrickbesidename.isDisplayed();
	}

	public void popUpSaveButton() {
		popupsavebutton.click();
	}

	public boolean fieldRequired(String fieldName) throws TimeoutException {
		String expectedErrorMessage = fieldName + " is required.";
		String errorXPath = "//small[contains(@class, 'p-invalid') and contains(text(),'" + expectedErrorMessage
				+ "')]";

		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorXPath)));
		return errorMessage.isDisplayed();
	}

	public void verifyCancelButton() {
		cancel.click();
	}

	public boolean isProgramDetailsFormInvisible() {
		String FORM_XPATH = "//p-dialog[contains(@header,'Program Details')]";
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(FORM_XPATH)));
	}

	public void enterTextInField(String fieldName, String text) {
		WebElement field = getFieldElement(fieldName);
		wait.until(ExpectedConditions.visibilityOf(field)).clear();
		field.sendKeys(text);
	}

	public String getEnteredText(String fieldName) {
		return getFieldElement(fieldName).getAttribute("value");
	}

	private WebElement getFieldElement(String fieldName) {
		switch (fieldName) {
		case "Name":
			return nameTextBox;
		case "Description":
			return descriptionTextBox;
		default:
			throw new IllegalArgumentException("Invalid field name: " + fieldName);
		}
	}

	public void selectProgramStatus(String status) {
		WebElement radioButtonContainer = getStatusElement(status);

		wait.until(ExpectedConditions.elementToBeClickable(radioButtonContainer)).click();
	}

	public String getSelectedStatus() {
		if (driver.findElement(By.xpath("//input[@id='Active']")).getAttribute("aria-checked").equals("true")) {
			return "Active";
		} else if (driver.findElement(By.xpath("//input[@id='Inactive']")).getAttribute("aria-checked")
				.equals("true")) {
			return "Inactive";
		} else {
			return "None Selected";
		}
	}

	private WebElement getStatusElement(String status) {
		switch (status.toLowerCase()) {
		case "active":
			return activeRadioButtonContainer;
		case "inactive":
			return inactiveRadioButtonContainer;
		default:
			throw new IllegalArgumentException("Invalid status: " + status);
		}
	}

//	public void searchProgram(String programName) {
//		wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
//		searchBox.sendKeys(programName);
//	}
//
//	public boolean isProgramDisplayed(String generatedName) {
//		wait.until(ExpectedConditions.visibilityOfAllElements(programNameList));
//
//		for (int i = 0; i < programNameList.size(); i++) {
//			String actualProgramName = programNameList.get(i).getText().trim();
//			System.out.println("actualProgramName is" + actualProgramName);
//
//			if (actualProgramName.equals(generatedName)) {
//				return true;
//			}
//		}
//		return false;
//	}
	 public  void searchProgram(String name) {
	        
	        searchBox.clear();
	        searchBox.sendKeys(name);
	        
	    }

	    public  boolean isProgramDisplayed(String name) {
	        try {
	           
	            return driver.findElement(By.xpath("//table//td[contains(text(),'" + name + "')]")).isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }

	public void verifyXButton() {
		x.click();
	}

	public void enterName(String name) {
		nameTextBox.clear();
		nameTextBox.sendKeys(name);
	}

	public void enterDescription(String description) {
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(description);
	}

	public String getNameText() {
		return nameTextBox.getAttribute("value");
	}

	public String getDescriptionText() {
		return descriptionTextBox.getAttribute("value");
	}

	public String getSuccessMessage() {

		wait.until(ExpectedConditions.visibilityOf(successMessage));
		return successMessage.getText().trim().replaceAll("\\s+", " ");
	}

	public void clickActiveRadioButton() {
		activeRadioButtonContainer.click();
	}
}
