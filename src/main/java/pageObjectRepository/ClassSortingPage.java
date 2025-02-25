package pageObjectRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassSortingPage {
	By batnameSortIcon = By.xpath("//table/thead/tr/th[2]/p-sorticon/i");
	By clsTopicSortIcon = By.xpath("//table/thead/tr/th[3]/p-sorticon/i");
	By clsDescSortIcon = By.xpath("//table/thead/tr/th[4]/p-sorticon/i");
	By clsStatusSortIcon = By.xpath("//table/thead/tr/th[5]/p-sorticon/i");
	By clsDateSortIcon = By.xpath("//table/thead/tr/th[6]/p-sorticon/i");
	By clsStafSortIcon = By.xpath("//table/thead/tr/th[7]/p-sorticon/i");
	By delBtn = By.xpath("//table/tbody/tr[1]/td[8]/div/span/button[2]/span[1]");
	By deletnAlertBox = By.xpath("//p-confirmdialog/div/div");
	By yesOptn = By.xpath("//p-confirmdialog/div/div/div[3]/button[2]/span[2]");
	By clsDeltdSuccesMsg = By.xpath("//div[starts-with(@class,'p-toast-message-text')]");
	By noOptn = By.xpath("//p-confirmdialog/div/div/div[3]/button[1]/span[2]");
	By closeBtn = By.xpath("//span[@class='pi pi-times ng-tns-c118-6']");
	By rowsNum = By.xpath("//table/tbody/tr");

	private WebDriver driver;

	public ClassSortingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickBatNameSortIcon() {
		driver.navigate().refresh();
		driver.findElement(batnameSortIcon).click();
	}

	public boolean checkDetilsSortedByBatName() {
		List<WebElement> batNameVAlues = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		if (checkDetilsSorted(batNameVAlues)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickClsTopicSortIcon() {
		driver.navigate().refresh();
		driver.findElement(clsTopicSortIcon).click();
	}

	public boolean checkDetilsSortedByclsTopic() {
		List<WebElement> clsTopicValues = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
		if (checkDetilsSorted(clsTopicValues)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickClsDescSortIcon() {
		driver.navigate().refresh();
		driver.findElement(clsDescSortIcon).click();
	}

	public boolean checkDetilsSortedByclsDescrptn() {
		List<WebElement> clsDescValues = driver.findElements(By.xpath("//table/tbody/tr/td[4]"));
		if (checkDetilsSorted(clsDescValues)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickClsStatusSortIcon() {
		driver.navigate().refresh();
		driver.findElement(clsStatusSortIcon).click();
	}

	public boolean checkDetailsSortedByclsStatus() {
		List<WebElement> clsStatus = driver.findElements(By.xpath("//table/tbody/tr/td[5]"));
		if (checkDetilsSorted(clsStatus)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickClsDateSortIcon() {
		driver.navigate().refresh();
		driver.findElement(clsDateSortIcon).click();
	}

	public boolean checkDetailsSortedByClsDate() {
		List<WebElement> clsDate = driver.findElements(By.xpath("//table/tbody/tr/td[6]"));
		if (checkDetilsSorted(clsDate)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickClsStafSortIcon() {
		driver.navigate().refresh();
		driver.findElement(clsStafSortIcon).click();
	}

	public void clickDelIcon() {
		driver.navigate().refresh();
		driver.findElement(delBtn).click();
	}

	public boolean checkDeltnAlertBox() {
		boolean flag = driver.findElement(deletnAlertBox).isDisplayed();
		WebElement confirmMsg = driver.findElement(By.xpath("//p-confirmdialog/div/div/div[1]/span"));
		boolean flag1 = confirmMsg.getText().contains("Confirm");
		WebElement noMsg = driver.findElement(By.xpath("//p-confirmdialog/div/div/div[3]/button[1]/span[2]"));
		boolean flag2 = noMsg.getText().contains("No");
		WebElement yesMsg = driver.findElement(By.xpath("//p-confirmdialog/div/div/div[3]/button[2]/span[2]"));
		boolean flag3 = yesMsg.getText().contains("Yes");
		if (flag && flag1 && flag2 && flag3) {
			return true;
		}
		return false;

	}

	public void clickYesOptn() {
		driver.findElement(yesOptn).click();
	}

	public boolean verifyClsDelSuccesMsg() {
		WebElement delSuccMsg = driver.findElement(clsDeltdSuccesMsg);
		if (delSuccMsg.getText().contains("Class Deleted")) {
			return true;
		}
		return false;
	}

	public void clickNoOptn() {
		driver.findElement(noOptn).click();
	}

	public boolean deltnAlertBoxDisappear() {
		return !driver.findElement(deletnAlertBox).isDisplayed();
	}

	public void clickCloseBtn() {
		driver.findElement(closeBtn).click();
	}

	public boolean deltnAlertBoxClosed() throws InterruptedException {
		Thread.sleep(1000);
		try {
			driver.findElement(deletnAlertBox);
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean checkDetilsSorted(List<WebElement> values) {
		List<String> clsBforeSorting = new ArrayList<>();
		List<String> clsAftrSorting = new ArrayList<>();
		for (WebElement value : values) {
			String Text = value.getText();
			clsBforeSorting.add(Text);
		}
		for (WebElement value : values) {
			String Text = value.getText();
			clsAftrSorting.add(Text);
		}
		Collections.sort(clsAftrSorting);
		if (clsBforeSorting.equals(clsAftrSorting)) {
			return true;
		}
		return false;
	}
}
