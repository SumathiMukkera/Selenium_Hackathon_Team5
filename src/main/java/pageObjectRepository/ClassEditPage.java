package pageObjectRepository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilitities.UtilityMethods;

public class ClassEditPage {
	By manageClass = By.xpath("//div[text()=' Manage Class']");
	By goToNxtPage = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	By numOfRowsInEachPage = By.xpath("//table/tbody/tr");
	By pagintn = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	By inputFields = By.xpath("//p-dialog/div/div/div[2]/div/input");
	By addClsPopUp = By.xpath("//div[@role='dialog']");
	By editIcon = By.xpath("//table/tbody/tr[1]/td[8]/div/span/button[1]/span[1]");
	By batName = By.xpath("//p-dropdown[@id='batchName']/div");
	By clsTopic = By.xpath("//input[@id='classTopic']");
	By clsDesc = By.xpath("//input[@id='classDescription']");
	By searchBar = By.id("filterGlobal");
	By saveBtn = By.xpath("//span[text()='Save']");
	By updatdSuccessMsg = By.xpath("//div[starts-with(@class,'p-toast-message-text')]");
	By staffNameDrpdwn = By.xpath("//p-dropdown[@id='staffId']/div/div[2]");
	By staffNameOptions = By.xpath("//ul[@role='listbox']/p-dropdownitem/li");
	By comments = By.xpath("//input[@id='classComments']");
	By notes = By.xpath("//input[@id='classNotes']");
	By cancelBtn = By.xpath("//p-dialog/div/div/div[3]/button[1]/span[1]");

	private WebDriver driver;
	private UtilityMethods utiMethods = new UtilityMethods();

	public ClassEditPage(WebDriver driver) {
		this.driver = driver;
	}

	public String validateManageClassPage() {
		String actHeader = driver.findElement(manageClass).getText();
		return actHeader;
	}

	public void clickEditIcon(String batchName, String clsTopic, String clsDesc, String status, String clsDate,
			String staff) {
		WebElement editBtn = driver.findElement(editIcon);
		Actions act = new Actions(driver);
		act.moveToElement(editBtn).click().perform();
		driver.findElement(editIcon).click();
		// findEditButton(batchName, clsTopic, clsDesc, status, clsDate, staff);
	}

	public boolean checkClsDtilsAppears() {
		List<WebElement> fields = driver.findElements(inputFields);
		boolean flag = false;
		for (int i = 0; i < 3; i++) {
			WebElement field = fields.get(i);
			if (field.getDomAttribute("class").contains("p-filled")) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public boolean verifyBatNameDisabled() {
		return driver.findElement(batName).getDomAttribute("class").contains("p-disabled");
	}

	public boolean verifyClsTopicDisabled() {
		return driver.findElement(clsTopic).getDomAttribute("disabled") != null;
	}

	public void adminIsOnEditPopUpWndw(String text) {
		driver.findElement(searchBar).sendKeys(text);
		WebElement editBtn = driver.findElement(By.xpath("//table/tbody/tr/td[8]/div/span/button[1]/span[1]"));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", editBtn);
	}

	public void updateFields(String text) {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		driver.findElement(clsDesc).clear();
		driver.findElement(clsDesc).sendKeys(text);
		WebElement saveButton = driver.findElement(saveBtn);
		ex.executeScript("arguments[0].click();", saveButton);
	}

	public boolean verifyUpdatdSuccesMsg() {
		WebElement succesMsg = driver.findElement(updatdSuccessMsg);
		String msg = succesMsg.getText();
		if (msg.contains("Class Updated")) {
			return true;
		}
		return false;
	}

	public void updateWithInvalidValues(String text) {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		driver.findElement(clsDesc).clear();
		driver.findElement(clsDesc).sendKeys(text);
		WebElement saveButton = driver.findElement(saveBtn);
		ex.executeScript("arguments[0].click();", saveButton);
	}

	public boolean verifyUpdateErrMsg() {
		WebElement succesMsg = driver.findElement(updatdSuccessMsg);
		String msg = succesMsg.getText();
		if (!msg.contains("Class Updated")) {
			return true;
		}
		return false;
	}

	public void updateMandatryFields(String staff) {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement stfDrpDwn = driver.findElement(staffNameDrpdwn);
		ex.executeScript("arguments[0].click();", stfDrpDwn);
		List<WebElement> stfNameOptns = driver.findElements(staffNameOptions);
		utiMethods.drpDwn(stfNameOptns, staff);
		WebElement saveButton = driver.findElement(saveBtn);
		ex.executeScript("arguments[0].click();", saveButton);
	}

	public void updateOptionalFields(String text, String staff) {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement stfDrpDwn = driver.findElement(staffNameDrpdwn);
		ex.executeScript("arguments[0].click();", stfDrpDwn);
		List<WebElement> stfNameOptns = driver.findElements(staffNameOptions);
		utiMethods.drpDwn(stfNameOptns, staff);
		driver.findElement(comments).clear();
		driver.findElement(comments).sendKeys(text);
		WebElement saveButton = driver.findElement(saveBtn);
		ex.executeScript("arguments[0].click();", saveButton);
	}

	public void updateWithNumOrSpecialChar(String text1, String text2, String staff) {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement stfDrpDwn = driver.findElement(staffNameDrpdwn);
		ex.executeScript("arguments[0].click();", stfDrpDwn);
		List<WebElement> stfNameOptns = driver.findElements(staffNameOptions);
		utiMethods.drpDwn(stfNameOptns, staff);
		driver.findElement(comments).clear();
		driver.findElement(comments).sendKeys(text1);
		driver.findElement(notes).sendKeys(text2);
		WebElement saveButton = driver.findElement(saveBtn);
		ex.executeScript("arguments[0].click();", saveButton);
	}

	public void clickCancelBtn() {
		WebElement cancelButton = driver.findElement(cancelBtn);
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", cancelButton);
	}

	public boolean checkPopupWindowDisappears() throws InterruptedException {
		Thread.sleep(2000);
		try {
			driver.findElement(cancelBtn).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public void findEditButton(String batchName, String clsTopic, String clsDesc, String status, String clsDate,
			String staff) {
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
					WebElement editBtn = driver
							.findElement(By.xpath("//table/tbody/tr[" + r + "/td[8]/div/span/button[1]/span[1]"));
					editBtn.click();
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
	}
}
