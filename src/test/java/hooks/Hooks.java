package hooks;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utilitities.ConfigReader;
import utilitities.LoggerLoad;


public class Hooks {

	public WebDriver driver;
	private DriverFactory driverFactory;
	private static Properties prop;

	@Before
	public void beforeScenario(Scenario scenario) {
		
		driverFactory = new DriverFactory();
		prop = ConfigReader.initializeprop();
		String browser = prop.getProperty("browser");
		//String browser = ConfigReader.getBrowserType();
		driver = driverFactory.initializeBrowser(browser);
		driver.get(prop.getProperty("URL"));
		LoggerLoad.info("Scenario passed: " + scenario.getName() + " =====");
	}

	@After(order = 0)
	public void quitBrowser() {
		if (DriverFactory.getDriver() != null) {
			DriverFactory.getDriver().quit();
			DriverFactory.removeDriver();
		}
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
			Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
			 LoggerLoad.error("Scenario Failed: " + scenario.getName());
		}
	}

}
