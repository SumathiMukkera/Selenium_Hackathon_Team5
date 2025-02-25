package pageObjectRepository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilitities.UtilityMethods;

public class ClassAddPage {
	By classBtn = By.xpath("//span[text()='Class']");
	By addNewClass = By.xpath("//button[text()='Add New Class']");
	By newClassPopUp = By.xpath("//div[@role='dialog']");
	By inputFields = By.xpath("//div/div/div[2]/div/input");
	By saveBtn = By.xpath("//button[@label='Save']");
	By cancelBtn = By.xpath("//button[@label='Cancel']");
	By batchNameDrpdwn = By.xpath("//p-dropdown[@id='batchName']/div/div[2]");
	By batchNameOptns = By.xpath("//ul[@role='listbox']/p-dropdownitem/li");
	By classTopic = By.xpath("//input[@id='classTopic']");
	By datePicker = By.xpath("//span[@class='p-button-icon pi pi-calendar']");
	By monthYear = By.xpath("//div[starts-with(@class,'p-datepicker-header')]");
	By monYrArrow = By.xpath("//span[starts-with(@class,'p-datepicker-next-icon pi pi-chevron-right')]");
	By dates = By.xpath("//table[starts-with(@class,'p-datepicker-calendar')]/tbody/tr/td");
	By noOfClasses = By.xpath("//input[@id='classNo']");
	By staffNameDrpdwn = By.xpath("//p-dropdown[@id='staffId']/div/div[2]");
	By staffNameOptions = By.xpath("//ul[@role='listbox']/p-dropdownitem/li");
	By status = By.xpath("//p-radiobutton[@id='category']/div/div[2]");
	By successMsg = By.xpath("//div[starts-with(@class,'p-toast-message-text')]");
	By sunWeekend = By.xpath("//div[3]/div/div/div[2]/table/tbody/tr/td[1]/span");
	By satWeekend = By.xpath("//div[3]/div/div/div[2]/table/tbody/tr/td[7]/span");
	By clsDescrptn = By.xpath("//input[@id='classDescription']");
	By clsComents = By.xpath("//input[@id='classComments']");
	By clsNotes = By.xpath("//input[@id='classNotes']");
	By clsRecordng = By.xpath("//input[@id='classRecordingPath']");
	By errMsgInFields = By.xpath("//p-dialog/div/div/div[2]/div/small");
	By goToNxtPage = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	By numOfRowsInEachPage = By.xpath("//table/tbody/tr");
	By pagintn = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	private WebDriver driver;
	private UtilityMethods utiMethods = new UtilityMethods();

	public ClassAddPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddNewClass() {
		driver.findElement(addNewClass).click();
	}

	public boolean validateClassDetailsPopUpWindow() {
		try {
			boolean popUpWndw = driver.findElement(newClassPopUp).isDisplayed();
			boolean save = driver.findElement(saveBtn).isEnabled();
			boolean cancel = driver.findElement(cancelBtn).isEnabled();
			if (popUpWndw && save && cancel) {
				return true;
			}
		} catch (Exception e) {
			driver.findElement(classBtn).click();
			driver.findElement(addNewClass).click();
		}
		boolean popUpWndw = driver.findElement(newClassPopUp).isDisplayed();
		boolean save = driver.findElement(saveBtn).isEnabled();
		boolean cancel = driver.findElement(cancelBtn).isEnabled();
		if (popUpWndw && save && cancel) {
			return true;
		}
		return false;
	}

	public boolean validateInputFields() {
		List<WebElement> fields = driver.findElements(inputFields);
		for (WebElement field : fields) {
			if (!field.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public void admnIsOnPopUpWndow() {
		try {
			driver.findElement(newClassPopUp).isEnabled();
		} catch (Exception e) {
			driver.findElement(classBtn).click();
			driver.findElement(addNewClass).click();
			driver.findElement(newClassPopUp).isEnabled();
		}
	}

	public void enterMandtryFields(String batchNameOptn, String clsTopic, String clsDesc, String month, String year,
			String date, String staff) throws InterruptedException {
		fillNewClassForm(batchNameOptn, clsTopic, clsDesc, month, year, date, staff);
		driver.findElement(saveBtn).click();
	}

	public boolean verifySuccessfullyClsCreatd() {
		String msg = driver.findElement(successMsg).getText();
		return msg.contains("Successful") || msg.contains("Class Created");
	}

	public void selectClassDate(String month, String year, String date) {
		driver.findElement(datePicker).click();
		String monthYr = driver.findElement(monthYear).getText();
		if (monthYr.isEmpty()) {
			// retry mechanism
			int attempts = 0;
			while (attempts < 3) {
				try {
					monthYr = driver.findElement(monthYear).getText();
					break;
				} catch (Exception e) {
					attempts++;
				}
			}
		}
		List<WebElement> allDates = driver.findElements(dates);
		WebElement arrow = driver.findElement(monYrArrow);
		utiMethods.datePicker(monthYr, month, year, date, arrow, allDates);
		driver.findElement(datePicker).click();
	}

	public boolean checkClsValueAdded() {
		WebElement inputField = driver.findElement(noOfClasses);
		if (inputField.getDomAttribute("class").contains("p-filled")) {
			return true;
		} else {
			return false;
		}
	}

	public void clickDatePickr() throws InterruptedException {
		driver.findElement(datePicker).click();
	}

	public boolean verifyWeekndsDisables() {
		List<WebElement> satWeekndCells = driver.findElements(satWeekend);
		List<WebElement> sunWeekndCells = driver.findElements(sunWeekend);
		boolean satWeeknd = false;
		boolean sunWeeknd = true;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOfAllElements(satWeekndCells));
		for (int i = 0; i < satWeekndCells.size(); i++) {
			WebElement cell = satWeekndCells.get(i);
			if (cell.getDomAttribute("class").contains("p-disabled")) {
				satWeeknd = true;
			}
		}
		wait.until(ExpectedConditions.visibilityOfAllElements(sunWeekndCells));
		for (int i = 0; i < sunWeekndCells.size(); i++) {
			WebElement cell = sunWeekndCells.get(i);
			if (cell.getDomAttribute("class").contains("p-disabled")) {
				sunWeeknd = true;
			}
		}
		if (satWeeknd && sunWeeknd) {
			return true;
		} else {
			return false;
		}
	}

	public void enterOptnalFields(String clsDesc, String clsComnts, String clsNots, String clsRec) {
		driver.findElement(clsDescrptn).sendKeys(clsDesc);
		driver.findElement(clsComents).sendKeys(clsComnts);
		driver.findElement(clsNotes).sendKeys(clsNots);
		driver.findElement(clsRecordng).sendKeys(clsRec);
		driver.findElement(saveBtn).click();
	}

	public boolean verifyFieldErrMsgAndErrTextColor() {
		List<WebElement> fieldsErr = driver.findElements(errMsgInFields);
		boolean flag = true;
		for (int i = 0; i < fieldsErr.size(); i++) {
			WebElement ele = fieldsErr.get(i);
			String expColor = "rgba(255, 0, 0, 1)";
			String actColor = ele.getCssValue("color");
			if (!ele.getText().contains("is required") || !expColor.equals(actColor)) {
				flag = false;
				break;
			}
		}
		if (flag)
			return true;
		else
			return false;
	}

	public void enterInvalidDatas(String batchNameOptn, String clsTopic, String clsDesc, String month, String year,
			String date, String staff) throws InterruptedException {
		fillNewClassForm(batchNameOptn, clsTopic, clsDesc, month, year, date, staff);
		driver.findElement(saveBtn).click();
	}

	public boolean verifyErrMsg() {
		String msg = driver.findElement(successMsg).getText();
		return msg.contains("Class Not Created");
	}

	public void clickSaveBtn() {
		driver.findElement(saveBtn).click();
	}

	public boolean checkAdminGetsErrMsg() {
		List<WebElement> fieldsErr = driver.findElements(errMsgInFields);
		boolean flag = true;
		for (int i = 0; i < fieldsErr.size(); i++) {
			WebElement ele = fieldsErr.get(i);
			if (!ele.getDomAttribute("class").contains("p-invalid")) {
				flag = false;
				break;
			}
		}
		if (flag) {
			return true;
		} else {
			return false;
		}
	}

	public void clickCancelBtn(String batchNameOptn, String clsTopic, String clsDesc, String month, String year,
			String date, String staff) throws InterruptedException {
		fillNewClassForm(batchNameOptn, clsTopic, clsDesc, month, year, date, staff);
		driver.findElement(cancelBtn).click();
	}

	public boolean verifyValuesNotSaved(String batchName, String clsTopic, String clsDesc, String status,
			String clsDate, String staff) {
		if (!checkInputValuesSaved(batchName, clsTopic, clsDesc, status, clsDate, staff)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickSaveIcon(String batchNameOptn, String clsTopic, String clsDesc, String month, String year,
			String date, String staff) throws InterruptedException {
		fillNewClassForm(batchNameOptn, clsTopic, clsDesc, month, year, date, staff);
		driver.findElement(saveBtn).click();
	}

	public boolean verifyValuesSaved(String batchName, String clsTopic, String clsDesc, String status, String clsDate,
			String staff) {
		if (checkInputValuesSaved(batchName, clsTopic, clsDesc, status, clsDate, staff)) {
			return true;
		} else {
			return false;
		}
	}

	public void fillNewClassForm(String batchNameOptn, String clsTopic, String clsDesc, String month, String year,
			String date, String staff) throws InterruptedException {
		driver.findElement(batchNameDrpdwn).click();
		List<WebElement> batNameOptns = driver.findElements(batchNameOptns);
		utiMethods.drpDwn(batNameOptns, batchNameOptn);
		driver.findElement(classTopic).sendKeys(clsTopic);
		driver.findElement(clsDescrptn).sendKeys(clsDesc);
		driver.findElement(datePicker).click();
		String monthYr = driver.findElement(monthYear).getText();
		if (monthYr.isEmpty()) {
			// retry mechanism
			int attempts = 0;
			while (attempts < 3) {
				try {
					monthYr = driver.findElement(monthYear).getText();
					break;
				} catch (Exception e) {
					attempts++;
				}
			}
		}
		WebElement arrow = driver.findElement(monYrArrow);
		List<WebElement> allDates = driver.findElements(dates);
		Thread.sleep(2000);
		utiMethods.datePicker(monthYr, month, year, date, arrow, allDates);
		driver.findElement(datePicker).click();
		driver.findElement(staffNameDrpdwn).click();
		List<WebElement> stfNameOptns = driver.findElements(staffNameOptions);
		utiMethods.drpDwn(stfNameOptns, staff);
		driver.findElement(status).click();
	}

	public boolean checkInputValuesSaved(String batchName, String clsTopic, String clsDesc, String status,
			String clsDate, String staff) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean flag = false;
		List<String> inputValues = Arrays.asList(batchName, clsTopic, clsDesc, status, clsDate, staff);
		while (!flag) {
			int row = driver.findElements(numOfRowsInEachPage).size();
			for (int r = 1; r <= row; r++) {
				List<WebElement> valuesInEachRow = driver.findElements(By.xpath("//tbody/tr[" + r + "]/td"));
				List<String> inpValues = new ArrayList<>();
				for (int j = 1; j < valuesInEachRow.size() - 1; j++) {
					WebElement value = valuesInEachRow.get(j);
					String input = value.getText();
					inpValues.add(input);
				}
				if (inputValues.equals(inpValues)) {
					flag = true;
					break;
				}
			}

			WebElement paginatn = driver.findElement(pagintn);
			String paginatnText = paginatn.getText();
			String[] pagintnParts = paginatnText.split(" ");
			int endPageNum = Integer.parseInt(pagintnParts[3]);
			int totalPageNum = Integer.parseInt(pagintnParts[5]);
			if (endPageNum == totalPageNum) {
				break;
			} else {
				WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(goToNxtPage));
				ele.click();
			}
		}
		return flag;
	}

}