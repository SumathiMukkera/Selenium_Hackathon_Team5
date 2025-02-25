package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClassLogoutPage {

	By classBtn = By.xpath("//span[text()='Class']");
	By batchBtn = By.xpath("//span[text()='Batch']");
	By logoutBtn = By.xpath("//span[text()='Logout']");

	private WebDriver driver;

	public ClassLogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickClassBtn() throws InterruptedException {
		try {
			driver.navigate().refresh();
			driver.findElement(classBtn).click();
		} catch (Exception e) {
			driver.findElement(classBtn).click();
		}
	}

	public boolean verifyAdminOnClassPage(String expUrl) {
		if (expUrl.equals(driver.getCurrentUrl())) {
			return true;
		}
		return false;
	}

	public void clickBatchBtn() {
		driver.navigate().refresh();
		driver.findElement(batchBtn).click();
	}

	public boolean verifyAdminOnBatchPage(String expUrl) {
		if (expUrl.equals(driver.getCurrentUrl())) {
			return true;
		}
		return false;
	}

	public void clickLogoutBtn() {
		driver.navigate().refresh();
		driver.findElement(logoutBtn).click();
	}

	public boolean verifyAdminOnLoginPage(String expUrl) {
		if (expUrl.equals(driver.getCurrentUrl())) {
			return true;
		}
		return false;
	}
}
