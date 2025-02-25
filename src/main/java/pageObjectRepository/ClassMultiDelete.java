package pageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassMultiDelete {

	By anyChkBox = By.xpath("//table/tbody/tr[1]/td[1]/p-tablecheckbox");
	By commonDelBtn = By.xpath("//mat-card-title/div[2]/div[1]/button/span[1]");
	By searchBar = By.id("filterGlobal");
	private WebDriver driver;

	public ClassMultiDelete(WebDriver driver) {
		this.driver = driver;
	}

	public void clickChkBox() {
		driver.navigate().refresh();
		driver.findElement(anyChkBox).click();
	}

	public boolean verifyCommonDelBtnEnabld() {
		return driver.findElement(commonDelBtn).isEnabled();
	}

	public void adminIsOnDeltnAlertBox(String text) throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(searchBar).sendKeys(text);
		Thread.sleep(2000);
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement chkBox = driver.findElement(By.xpath("//table/tbody/tr/td[1]/p-tablecheckbox/div/div[2]"));
		ex.executeScript("arguments[0].click();", chkBox);
		WebElement delBtn = driver.findElement(By.xpath("//table/tbody/tr/td[8]/div/span/button[2]/span[2]"));
		ex.executeScript("arguments[0].click();", delBtn);
	}

	public void clickYesBtn() {
		WebElement yesOptn = driver.findElement(By.xpath("//p-confirmdialog/div/div/div[3]/button[2]/span[1]"));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", yesOptn);
	};

	public boolean checkClassIsDeltd() {
		WebElement pagnatn = driver.findElement(By.xpath("//span[@class='p-paginator-current ng-star-inserted']"));
		String pagText = pagnatn.getText();
		if (pagText.contains("Showing 0 to 0 of 0 entries")) {
			return true;
		}
		return false;
	}

	public void clickDelteIcon(String text) throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(searchBar).sendKeys(text);
		Thread.sleep(2000);
		WebElement chkBox = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]/span"));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", chkBox);
		WebElement delBtn = driver.findElement(By.xpath("//table/tbody/tr/td[8]/div/span/button[2]/span[2]"));
		ex.executeScript("arguments[0].click();", delBtn);
	}

	public void clickNoBtn() {
		WebElement noOptn = driver.findElement(By.xpath("//p-confirmdialog/div/div/div[3]/button[1]/span[2]"));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", noOptn);
	}

	public boolean verifyClsIsNotDeltd(String text) {
		driver.findElement(searchBar).clear();
		driver.findElement(searchBar).sendKeys(text);
		WebElement pagnatn = driver.findElement(By.xpath("//span[@class='p-paginator-current ng-star-inserted']"));
		String pagText = pagnatn.getText();
		String[] pages = pagText.split(" ");
		int firstNum = Integer.parseInt(pages[1]);
		if (firstNum > 0) {
			return true;
		}
		return false;
	}

	public void adminIsOnDelAlertBoxForMulDel(String text) {
		driver.navigate().refresh();
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		driver.findElement(searchBar).sendKeys(text);
		List<WebElement> chkBoxes = driver.findElements(By.xpath("//p-tablecheckbox/div/div[2]/span"));
		for (WebElement chkBox : chkBoxes) {
			ex.executeScript("arguments[0].click();", chkBox);
		}
		driver.findElement(By.xpath("//mat-card-title/div[2]/div[1]/button/span[1]")).click();
	}

	public boolean checkMultiClsAreDeltd() {
		WebElement pagnatn = driver.findElement(By.xpath("//span[@class='p-paginator-current ng-star-inserted']"));
		String pagText = pagnatn.getText();
		if (pagText.contains("Showing 0 to 0 of 0 entries")) {
			return true;
		}
		return false;
	}

	public void adminIsOnDelAlertPopUpForMulDel(String text) {
		driver.navigate().refresh();
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		driver.findElement(searchBar).sendKeys(text);
		List<WebElement> chkBoxes = driver.findElements(By.xpath("//p-tablecheckbox/div/div[2]/span"));
		for (WebElement chkBox : chkBoxes) {
			ex.executeScript("arguments[0].click();", chkBox);
		}
		driver.findElement(By.xpath("//mat-card-title/div[2]/div[1]/button/span[1]")).click();
	}

	public boolean verifyMultiClsAreNotDeltd(String text) {
		driver.findElement(searchBar).clear();
		driver.findElement(searchBar).sendKeys(text);
		WebElement pagnatn = driver.findElement(By.xpath("//span[@class='p-paginator-current ng-star-inserted']"));
		String pagText = pagnatn.getText();
		String[] pages = pagText.split(" ");
		int firstNum = Integer.parseInt(pages[1]);
		if (firstNum > 0) {
			return true;
		}
		return false;
	}
}
