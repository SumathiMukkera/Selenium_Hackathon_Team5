package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassSearchPage {

	By searchBar = By.id("filterGlobal");

	private WebDriver driver;

	public ClassSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterInsearchBar(String Text) {
		driver.findElement(searchBar).sendKeys(Text);
	}

	public boolean checkClsDetailsSearchdByBatName(String batchName) throws InterruptedException {
		Thread.sleep(2000);
		String batName = driver.findElement(By.xpath("//p-table/div/div[1]/table/tbody/tr[1]/td[2]")).getText();
		String clsTopic = driver.findElement(By.xpath("//p-table/div/div[1]/table/tbody/tr[1]/td[3]")).getText();
		String stfName = driver.findElement(By.xpath("//p-table/div/div[1]/table/tbody/tr[1]/td[7]")).getText();
		if (batName.contains(batchName) && clsTopic != null && stfName != null) {
			return true;
		}
		return false;
	}

	public boolean checkClsDetailsSearchdByclsTopic(String classTopic) {
		String batName = driver.findElement(By.xpath("//p-table/div/div[1]/table/tbody/tr[1]/td[2]")).getText();
		String clsTopic = driver.findElement(By.xpath("//p-table/div/div[1]/table/tbody/tr[1]/td[3]")).getText();
		String stfName = driver.findElement(By.xpath("//p-table/div/div[1]/table/tbody/tr[1]/td[7]")).getText();
		if (batName != null && clsTopic.contains(classTopic) && stfName != null) {
			return true;
		}
		return false;
	}

	public boolean checkClsDetailsSearchdByclsStaff() {
		WebElement pagntn = driver.findElement(By.xpath("//span[@class='p-paginator-current ng-star-inserted']"));
		String pagntnText = pagntn.getText();
		String[] pageNum = pagntnText.split(" ");
		int startNum = Integer.parseInt(pageNum[1]);
		if (startNum > 0) {
			return true;
		}
		return false;
	}
}
