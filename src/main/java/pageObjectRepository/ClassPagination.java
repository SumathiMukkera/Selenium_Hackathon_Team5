package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassPagination {
	By nxtPageLink = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	By pagntn = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	By lastPagLink = By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-right']");
	By firstPageLink = By.xpath("//span[@class='p-paginator-icon pi pi-angle-left']");
	By startPageLink = By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-left']");

	private WebDriver driver;

	public ClassPagination(WebDriver driver) {
		this.driver = driver;
	}

	public void clickNxtPage() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", driver.findElement(nxtPageLink));
	}

	public boolean checkAdminSeeNxtPagRec() {
		WebElement paginatn = driver.findElement(pagntn);
		String pagText = paginatn.getText();
		String[] pages = pagText.split(" ");
		if (pages[1].equals("11")) {
			return true;
		}
		return false;
	}

	public void clickLastPage() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", driver.findElement(lastPagLink));
	}

	public boolean checkAdminSeeLastPage() {
		WebElement paginatn = driver.findElement(pagntn);
		String pagText = paginatn.getText();
		String[] pages = pagText.split(" ");
		if (pages[3].equals(pages[5]) && !driver.findElement(nxtPageLink).isEnabled()) {
			return true;
		}
		return false;
	}

	public void adminOnLastPage() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", driver.findElement(lastPagLink));
		WebElement pagnatn = driver.findElement(pagntn);
		String pagnatnText = pagnatn.getText();
		String[] pages = pagnatnText.split(" ");
		boolean flag = !pages[3].equals(pages[5]);
		while (flag) {
			ex.executeScript("arguments[0].click();", driver.findElement(lastPagLink));
		}
	}

	public void clickFirstPage() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", driver.findElement(firstPageLink));
	}

	public boolean adminSeePreViousPage() {
		WebElement pagnatn = driver.findElement(pagntn);
		String pagntnText = pagnatn.getText();
		String[] pages = pagntnText.split(" ");
		if (!pages[3].equals(pages[5])) {
			return true;
		}
		return false;
	}

	public void clickStartPage() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", driver.findElement(startPageLink));
	}

	public boolean checkAdminSeeFirstPage() {
		WebElement pagnatn = driver.findElement(pagntn);
		String pagntnText = pagnatn.getText();
		String[] pages = pagntnText.split(" ");
		if (pages[1].equals("1")) {
			return true;
		}
		return false;
	}
}
