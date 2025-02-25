package stepDefinitions;

import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepository.LoginPage;
import pageObjectRepository.LogoutPage;

public class LogoutStep {
	
	LogoutPage logout = new LogoutPage(DriverFactory.getDriver());
	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());


	@Given("Admin is in home page")
	public void admin_is_in_home_page() {
	    
		logout.getTitle();
		
	}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
	    
		logout.clickLogout();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		
		String title = logout.getTitle();
		Assert.assertEquals(title, "LMS");
	  
	}

	@Given("Admin is logged out of the application")
	public void admin_is_logged_out_of_the_application() {
		
		boolean isvisible = logout.logoutbutton();
		Assert.assertTrue(isvisible);
	    
	}

	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		
		String title = logout.getTitle();
		Assert.assertEquals(title, "LMS");
		
	  
	}

	@When("Admin clicks browser back button")
	public void admin_clicks_browser_back_button() {
	    
		logout.navigateBack();
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
		
		Assert.assertEquals(false, true);
	   
	}

}

