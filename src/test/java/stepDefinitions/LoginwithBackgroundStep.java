package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepository.LoginPage;

public class LoginwithBackgroundStep {
	
	private LoginPage login = new LoginPage(DriverFactory.getDriver());
	private String title;
	
	@Given("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		
		DriverFactory.getDriver();
	   
	}

	@Given("Admin is on login Page")
	public void admin_is_on_login_page() {
		
		
		title = login.getpagetitle();
		Assert.assertEquals(title, "LMS");
	}

	@When("Admin enter valid data from excel {string} and {int} field and clicks login button")
	public void admin_enter_valid_data_from_excel_and_field_and_clicks_login_button(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		
		login.validLogin(sheetname, rownumber);
	    
	}

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
		
	title =	login.getpagetitle();
	Assert.assertEquals(title , "LMS");
	    
	}

	@When("Admin enter invalid data from {string} and {int} and clicks login button")
	public void admin_enter_invalid_data_from_and_and_clicks_login_button(String sheetname, Integer rownumber) throws InvalidFormatException, IOException  {
		
		login.validLogin(sheetname, rownumber);
	}

	@Then("Error message {string}")
	public void error_message(String error) {
		 
		Assert.assertEquals(login.errormessage() , error);
		
	}

	@When("Admin enter value only in password and clicks login button")
	public void admin_enter_value_only_in_password_and_clicks_login_button() throws InvalidFormatException, IOException {
		
	   login.enterpassword();
		
	}

	@Then("Error message\" Please enter your user name\"")
	public void error_message_please_enter_your_user_name() {
	   
		String alert = login.getuserrequiredmesg();
		
		Assert.assertEquals(alert, "Please enter your user name");
	}

	@When("Admin enter value only in user name and clicks login button")
	public void admin_enter_value_only_in_user_name_and_clicks_login_button() throws InvalidFormatException, IOException {
	    
		login.enterusername();
	}

	@Then("Error message\" Please enter your password \"")
	public void error_message_please_enter_your_password() {
		
		String alert = login.getpasswordrequiredmsg();
		Assert.assertEquals(alert, "Please enter your password");
	    
	}

	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() throws InvalidFormatException, IOException {
	    
		login.validloginwithfunctions();
		login.enterkeys();
	}

	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() throws InvalidFormatException, IOException {
		
	   login.validloginwithfunctions();
	   
	}


}
