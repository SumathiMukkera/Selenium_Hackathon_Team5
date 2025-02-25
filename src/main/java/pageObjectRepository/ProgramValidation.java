package pageObjectRepository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilitities.ConfigReader;

public class ProgramValidation {

	WebDriver driver;
	Properties prop;
	WebElement editButton;
	WebElement deleteButton;

	public ProgramValidation(WebDriver driver) {
		this.driver = driver;
		this.prop = ConfigReader.initializeprop();
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//*[@id='mat-select-0']")
	WebElement selecttherole;
	@FindBy(id = "mat-option-0")
	WebElement admin;
	@FindBy(id = "login")
	WebElement login;
	@FindBy(id = "program")
	WebElement program;
	@FindBy(xpath = "//*[@psortablecolumn='programName']")
	WebElement textdisplayofprogrampage;
	@FindBy(id = "logout")
	WebElement logout;
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	WebElement lmstextdisplayonmenubar;
	@FindBy(xpath = "//*[text()=' Manage Program']")
	WebElement textdisplaymanageprogram;
	@FindBy(xpath = "//span[contains(@class,'p-button-icon pi pi-trash')][1]")
	WebElement multipledeletebutton;
	@FindBy(xpath = "//input[contains(@class, 'p-inputtext') and @placeholder='Search...']")
	WebElement searchbarwithtextdisplay;
	@FindBy(xpath = "//div[contains(@class,'p-d-flex p-ai-center')]")
	WebElement footmessage;

	public void userName() {
		username.sendKeys(prop.getProperty("username"));
	}

	public void password() {
		password.sendKeys(prop.getProperty("password"));
	}

	public void selectTheRole() {
		selecttherole.click();
	}

	public void admin() {
		admin.click();
	}

	public void logIn() {
		login.click();
	}

	public void program() {
		program.click();
	}

	public boolean textDisplayOfProgramPage() {
		return textdisplayofprogrampage.isDisplayed();
	}

	public boolean logOut() {
		return logout.isDisplayed();
	}

	public String lmsTextDisplayOnMenuBar() {
		return lmstextdisplayonmenubar.getText();
	}

	public List<String> verifyMenuBarOrder() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//mat-toolbar//button[contains(@class, 'mat-button')]")));

		List<WebElement> menuItems = driver
				.findElements(By.xpath("//mat-toolbar//button[contains(@class, 'mat-button')]"));

		List<String> actualMenuItems = new ArrayList<>();
		for (WebElement item : menuItems) {
			String text = item.getText().trim();
			if (!text.isEmpty() && !text.equals("Logout")) {
				actualMenuItems.add(text);
			}
		}
		return actualMenuItems;

	}

	public String textDisplayManageProgram() {
		return textdisplaymanageprogram.getText();
	}

	public boolean verifyManageProgramthreeColumns() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> rows = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@role='grid']//tbody/tr")));

		boolean allProgramsValid = true;

		for (WebElement row : rows) {

			List<WebElement> columns = row.findElements(By.xpath(".//td"));

			if (columns.size() < 3) {
				System.out.println("Row does not have all required details");
				allProgramsValid = false;
				continue;
			}

			String programName = columns.get(1).getText().trim();
			String description = columns.get(2).getText().trim();
			String status = columns.get(3).getText().trim();

			System.out.println("Program Name: " + programName);
			System.out.println("Description: " + description);
			System.out.println("Status: " + status);

			if (programName.isEmpty() || description.isEmpty() || status.isEmpty()) {
				allProgramsValid = false;
				System.out.println("Missing details in row");
			}
		}
		return allProgramsValid;

	}

	public boolean multipleDeleteButton() {
		return multipledeletebutton.isEnabled();
	}

	public String verifySearchBarText() {

		return searchbarwithtextdisplay.getAttribute("placeholder");

	}

	public List<String> manageTableColumnHeaders() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> headers = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//thead//th[not(.//input[@type='checkbox'])]")));

		List<String> actualHeaders = new ArrayList<>();
		for (WebElement header : headers) {
			String text = header.getText().trim();
			if (!text.isEmpty()) {
				actualHeaders.add(text);
			}

			System.out.println("Actual Table Headers: " + actualHeaders);

		}
		return actualHeaders;

	}

	public boolean verifyCheckboxUnchecked() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//th[contains(text(), 'Program Name')]/preceding-sibling::th//div[@role='checkbox']")));

		boolean isChecked = checkbox.isSelected();

		System.out.println("Checkbox Default State: " + isChecked);
		return isChecked;

	}

	public boolean verifyCheckboxStatusBesideAllPrograms() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> checkboxes = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//tbody/tr/td[1]//div[@role='checkbox']")));
		boolean allUnchecked = true;

		for (WebElement checkbox : checkboxes) {
			if (checkbox.isSelected()) {
				allUnchecked = false;
				System.out.println("Found a checked checkbox!");
				break;
			}
		}
		System.out.println("Total Checkboxes Found: " + checkboxes.size());
		return allUnchecked;
	}

	public boolean arrowBesideEachColumn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> sortableHeaders = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@role='grid']//th[@role='columnheader']")));

		boolean allColumnsHaveSortIcon = true;

		// Iterate through each column header and check if a sort icon is present
		for (WebElement header : sortableHeaders) {
			WebElement sortIcon;
			try {
				sortIcon = header.findElement(
						By.xpath("//table[@role='grid']//th//i[contains(@class,'p-sortable-column-icon')]"));
				System.out.println("Sort icon found beside: " + header.getText().trim());
			} catch (NoSuchElementException e) {
				System.out.println("Sort icon NOT found beside: " + header.getText().trim());
				allColumnsHaveSortIcon = false;
			}
		}
		return allColumnsHaveSortIcon;

	}

	public boolean verifyEditAndDeleteButtonForEachRow() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> rows = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@role='grid']//tbody/tr")));

		boolean allRowsHaveIcons = true;
		for (WebElement row : rows) {

			editButton = row.findElement(By.xpath("//table[@role='grid']//tbody/tr//button[@id='editProgram']"));
			deleteButton = row.findElement(By.xpath("//table[@role='grid']//tbody/tr//button[@id='deleteProgram']"));

			System.out.println("Edit and Delete icons found in row.");

		}
		return allRowsHaveIcons;
	}

	public boolean paginationIconAndText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//tbody/tr"), 0));
		WebElement paginationTextElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'p-paginator-current')]")));
		String actualPaginationText = paginationTextElement.getText().trim();
		System.out.println("Actual Pagination Text: " + actualPaginationText);
		boolean matchesFormat = actualPaginationText.matches("Showing \\d+ to \\d+ of \\d+ entries");

//		 boolean iconsExist = false;
//	        List<WebElement> paginationIcons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//			        By.xpath("//div[contains(@class, 'p-paginator-pages')]//button")));
//			System.out.println("Total Pagination Icons Found: " + paginationIcons.size());
//			iconsExist = !paginationIcons.isEmpty();
//
//	        // Return true only if both pagination text and icons exist correctly
//	        return matchesFormat && actualPaginationText.equals(expectedPaginationText) && iconsExist;
		return matchesFormat;
	}

	public boolean verifyfootermessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//tbody/tr"), 0));

		WebElement footerElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class,'p-d-flex p-ai-center')]")));
		String actualFooterText = footerElement.getText().trim();
		System.out.println("Actual Footer Text: " + actualFooterText);
		boolean matchesFormat = actualFooterText.matches("In total there are \\d+ programs\\.");
		return matchesFormat;
	}
}
