package stepDefinitions;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import pageObjectRepository.ProgramPage;

public class CommonBackgroundStep {
	
	WebDriver driver = DriverFactory.getDriver();
	ProgramPage ProgramPage = new ProgramPage(driver);


	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() {
		ProgramPage.userName();
		ProgramPage.password();
		ProgramPage.selectTheRole();
		ProgramPage.admin();
		ProgramPage.logIn();


}
}
