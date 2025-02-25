package pageObjectRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgramPaginationPage {
	
	private WebDriver driver;
	
	public ProgramPaginationPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	private By Next =  By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-right']");
	private By disblednext = By.xpath("//span[contains(@class  , 'p-paginator-current')]");
	private By program = By.xpath("//button//span[text() ='Program']"); 
	private By doublenext = By.xpath("//span[contains(@class  , 'pi pi-angle-double-right')]");
	//private By totalPagestext = By.xpath("//div [text()=' In total there are 76 programs. ']");
	private By firstpage = By.xpath("//p-paginator//button[text()='1']");
	private By doublePrevious = By.xpath("//button[contains(@class , 'p-paginator-first')]");
	private By previous = By.xpath("//button[contains(@class , 'p-paginator-prev')]");
	private By totalentries = By.xpath("//span[contains(text() , 'entries')]");
	private By Tablerows = By.xpath("//tbody[@class='p-datatable-tbody']//tr[@class = 'ng-star-inserted']");
	
	
	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//private JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public void clickProgram() {
		
		driver.findElement(program).click();
		
	}
	
	 public void clickNext() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement next = driver.findElement(Next);
		next.isEnabled();
		js.executeScript("arguments[0].click();", next);
		//next.click();
		
	 }
	 
	 public String Nextisactive() {
		 
		return driver.findElement(Next).getDomProperty("disabled");
		 
	 }
	 
	 public void doubleNext() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement doublenext1 = driver.findElement(doublenext);
		 js.executeScript("arguments[0].click();", doublenext1);
		 
	 }
	 
	 public String disableNextcheck() {
		 
		 WebElement disable = driver.findElement(Next);
		 return disable.getDomAttribute("disabled");
		 }
	 
	 public int gettoatalentries() {
		 
		 String total_Entries = driver.findElement(totalentries).getText();
		 String[] parts = total_Entries.split(" ");
	        return Integer.parseInt(parts[5]);
	 }
	 
	 public int getTotalPages(int entriesPerPage) {
	        int totalEntries = gettoatalentries();
	        return (int) Math.ceil((double) totalEntries / entriesPerPage);
	    } 
	 
	 public void goToLastPageUsingNextButton() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement next =   driver.findElement(Next);
		    while (next.isEnabled()) {
		    	//next.click();
		        js.executeScript("arguments[0].click();", next);
		        if(next.isEnabled() == false)
		        {
		        	System.out.println("print it is eecuting");
		        }
		        break;
		    }
		    
		}
	 
	 public void goToLastPage() {
		    try {
		        int totalPages = getTotalPages(10); // Example: If 10 entries per page
		        By lastPageNumber = By.xpath("//a[text()='" + totalPages + "']");

		        if (driver.findElements(lastPageNumber).size() > 0) {
		            driver.findElement(lastPageNumber).click();  // Click last page directly
		            System.out.println("testing");
		        } else {
		            goToLastPageUsingNextButton();  // Click "Next" until disabled
		        }
		    } catch (Exception e) {
		        System.out.println("Error navigating to last page: " + e.getMessage());
		    }
		}
	 
	 public int getCurrentPageNumber(int entriesPerPage) {
	        String text = driver.findElement(totalentries).getText();  
	        String[] parts = text.split(" ");
	        int firstEntryNumber = Integer.parseInt(parts[1]); // Extracts "61" in "Showing 61 to 70 of 76 entries"
	        return (firstEntryNumber / entriesPerPage) + 1;  // Calculate the current page number
	    }
	 
	 public void Clickprevoiuspage() {
		 
		int currentpage =   getCurrentPageNumber(10);
		int previouspage = currentpage - 1;
		String prviousxpath = String.format("//button[contains(@class, 'p-paginator-page') and text()='%d']", previouspage);
		driver.findElement(By.xpath(prviousxpath)).click();
		 
	 }
	 
	 public String checkPreviousbutton() {
		 
		
		 return  driver.findElement(previous).getDomAttribute("disabled");
		 
		
	 }
	  public void clickFirst() {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement first =  driver.findElement(firstpage);
		 js.executeScript("arguments[0].click();", first);
	  }
	 
	 public  String checkdoubleprevious() {
		 
		return driver.findElement(doublePrevious).getDomAttribute("disabled");
		 
	 }
	 
	 public void clickPrevious() {
		
		 
		WebElement element= driver.findElement(previous);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(previous));
		//element.click();

	 }
	 
	 public int getRows() {
		 
		 List<WebElement> row = driver.findElements(Tablerows);
		int rowCount = row.size();
		return rowCount;
					
	 }
	 
	

	
}