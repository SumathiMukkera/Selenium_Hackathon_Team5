package pageObjectRepository;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassPage   {
   By userName = By.id ("username");
   By password = By.id ("password");
   By roleDrpDwn = By.xpath ("//span[text()='Select the role']");
   By adminRole = By.xpath ("//span[text()=' Admin ']");
   By login = By.xpath ("//span[text()='Login']");
   By classBtn = By.xpath("//span[text()='Class']");
   By manageClassHeader = By.xpath("//div[text()=' Manage Class']");
   By searchBar = By.id("filterGlobal");
   By dataTableHeadngs = By.xpath("//table/thead/tr/th");
   By pagnatnText = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
   By pagnatnIcon = By.xpath("//button[@fdprocessedid='xto7tg' or @fdprocessedid='rcnwlu']");
   By sortIcon = By.xpath("//table/thead/tr/th/p-sorticon");
   By delBtn = By.xpath("//div[2][@class='box']//button");
   By numOfClasses = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");
   private WebDriver driver;
   
   public ClassPage (WebDriver driver) {
	   this.driver = driver;
   }
   
   public void clickClass() {
	   driver.findElement(classBtn).click();
   }
   
   public boolean validatemanageClassPage() {
	   String expUrl = "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/session";
	   if (expUrl.equals(driver.getCurrentUrl())) {
		   return true;
	   }
	   return false;
   }
   public String validateManageClassHeader() {
	    String actHeader = driver.findElement(manageClassHeader).getText();
	    return actHeader;
   }
   
   public boolean checkSearchBarVisibility() {
	   return driver.findElement(searchBar).isDisplayed();
   }
   
   public boolean checkDataTableHeading() {
	   List <WebElement> actHeadings = driver.findElements(dataTableHeadngs);
	   String[] expHeadings = {"Batch Name","Class Topic","Class Description",
			                    "Status","Class Date","Staff Name","Edit / Delete"};
	   for (int i=1; i<actHeadings.size(); i++) {
		   if (!expHeadings[i-1].equals(actHeadings.get(i).getText())) {
			   return false;
		   }
	   }
	   return true;
    }
   
   public boolean checkPagnatnText() {
	   String pagntnText = driver.findElement(pagnatnText).getText();
	   Pattern pattern = Pattern.compile("Showing \\d+ to \\d+ of \\d+ entries");
	   return pattern.matcher(pagntnText).matches();
   }
   
   public boolean checkPagntnControls() {
	   List <WebElement> pagntnControls = driver.findElements(pagnatnIcon);
	   for (WebElement control : pagntnControls) {
		   if (!control.isEnabled()) {
			   return false;
		   }
	   }
	   return true;
   }
   
   public boolean checkSortIconsVisibility() {
	   List <WebElement> sortIcons = driver.findElements(sortIcon);
	   for (WebElement sortBtn : sortIcons) {
		   if (!sortBtn.isDisplayed()) {
			   return false;
		   }
	   }
	   return true;
   }
   
   public boolean checkDelBtnVisibility() {
	   return driver.findElement(delBtn).isDisplayed();
   }
   
   public boolean validateTotalNumOfClass() {
	   String expText = "In total there are \\d+ classes.";
	   String actText = driver.findElement(numOfClasses).getText();
	   return actText.matches(expText);
   }
   
}
   
   
