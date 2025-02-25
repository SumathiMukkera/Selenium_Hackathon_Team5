package pageObjectRepository;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilitities.ConfigReader;

public class LogoutPage {
	
	private WebDriver driver;
	private static Properties prop;
	
	public LogoutPage(WebDriver driver) {
		
		this.driver =driver;
	}
	
	//Locators 
	
	private By logOut = By.xpath("//span[text()='Logout']");
	private By userField = By.xpath("//input[@id='username']");
	private By passwordFiled = By.xpath("//input[@id = 'password']");
	
	public void login() {
		
		prop = ConfigReader.initializeprop();
		String Username = prop.getProperty("username");
		String Password = prop.getProperty("password");
		driver.findElement(userField).sendKeys(Username);
		driver.findElement(passwordFiled).sendKeys(Password);
		
		
	}
	
	public String getTitle() {
		
		return driver.getTitle();
	}
	
	public void clickLogout() {
		WebElement element = driver.findElement(logOut);
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", element);
	}
	
	public boolean logoutbutton() {
		
		return driver.findElement(logOut).isDisplayed();
	}

	public void navigateBack() {
		
		driver.navigate().back();
	}
}
