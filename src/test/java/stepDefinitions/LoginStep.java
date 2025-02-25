package stepDefinitions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepository.LoginPage;

public class LoginStep {
	
	private LoginPage login = new LoginPage(DriverFactory.getDriver());
	
	private String title;
	
	@Given("The browser is open")
	public void the_browser_is_open() {
		
		DriverFactory.getDriver();
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		
		 title = login.getpagetitle();
		Assert.assertEquals(title, "LMS");
	   
	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		
		login.invalidurl();
	}

	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() {
		
	    title = login.getinvalidurlalert();
	    Assert.assertEquals(title, "There's nothing here, yet.");
		
	}

	@Then("HTTP response >= {int}. then the link is broken")
	public void http_response_then_the_link_is_broken(Integer code) throws IOException {
		
	   int responseCode =	login.getBrokenLinks();
	
		Assert.assertEquals("Link Response code is: " + responseCode, responseCode >= code);
   
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
		
		String userlabel = login.getusernamelabel();
		  Assert.assertEquals(userlabel, "User");
		  
		  String Passwordlabel = login.getPasswordlabel();
		  Assert.assertEquals(Passwordlabel, "Password");
	}

	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() throws Exception {
		
		 List<String> extractedText = login.applicationText();
		 System.out.println(extractedText);
		 String expectedText = "LMS - Learning Management System";
	        	for (String line : extractedText) {
	        		
	            if (line.contains(expectedText)) {
	            	
	                Assert.assertEquals(line, expectedText);
	            }
	            
	            Assert.fail("Expected text '" + expectedText + "' not found in extracted lines: " + extractedText);
	            }
	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() throws Exception {
		
		 List<String> extractedText = login.applicationText();
            // Define the expected company name
            String expectedText = "NumpyNinja"; 
            boolean found = false;
            for (String line : extractedText) {
                if (line.contains(expectedText)) {
                        Assert.assertEquals(line, expectedText);
                    found = true;
                    break;
                }
            }

            // Fail the test if the expected text is not found
            if (!found) {
                Assert.fail("Expected text '" + expectedText + "' not found in extracted lines: " + extractedText);
            }
	}

	@Then("Admin should see {string}")
	public void admin_should_see(String header) {
		
		title = login.getLoginHeader();
		 Assert.assertEquals(title, header);
		
	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		
		Assert.assertTrue(login.userfieldspresent());
		Assert.assertTrue(login.passwordfieldpresent());

	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
		
		String userlabel = login.getusernamelabel();
		  Assert.assertEquals(userlabel, string);
	}

	@Then("Admin should see asterisk mark symbol next to text for mandatory fields")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_mandatory_fields() {
		
		String text = login.userreqired();
		Assert.assertEquals(text, "*");
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String string) {
		
		 String Passwordlabel = login.getPasswordlabel();
		  Assert.assertEquals(Passwordlabel, string);
	}

	@Then("Admin should see asterisk mark symbol next to password text")
	public void admin_should_see_asterisk_mark_symbol_next_to_password_text() {
		
		String text = login.passwordrequired();
		Assert.assertEquals(text, "*");
	}

	@Then("Admin should see one dropdown")
	public void admin_should_see_one_dropdown() {
		
		Assert.assertTrue(login.Dropdowndisplay());
	}

	@Then("Admin should see {string} placeholder in dropdown")
	public void admin_should_see_placeholder_in_dropdown(String string) {
		
		String text = login.dropdownLabel();
		Assert.assertEquals(text, string);
	}
	
	@Then("Admin should see the following {string}, {string}, {string} in the dropdown")
	public void admin_should_see_the_following_in_the_dropdown(String option1, String option2, String option3){
      
		List<String> expectedOptions = Arrays.asList(option1, option2, option3);
		 List<String> actualDropdownValues = login.dropdownitems();
			Assert.assertEquals(expectedOptions, actualDropdownValues);
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
		
		Assert.assertTrue(login.inputfields_centeralignment());
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	   
		Assert.assertTrue(login.loginbutton());
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
		
		String color = login.getuserfieldcolor();
		Assert.assertEquals(color, "rgba(128, 128, 128, 1)");
	   
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		
		String color = login.getPasswordcolor();
		Assert.assertEquals(color, "rgba(128, 128, 128, 1)");
	}

}
