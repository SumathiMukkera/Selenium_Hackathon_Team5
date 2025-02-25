package stepDefinitions;

import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepository.LoginPage;
import pageObjectRepository.LogoutPage;
import pageObjectRepository.ProgramPaginationPage;
import pageObjectRepository.ProgramValidation;

public class ProgramPagination {
	
	ProgramPaginationPage pagination = new ProgramPaginationPage(DriverFactory.getDriver());
	ProgramValidation ProgramPage = new ProgramValidation(DriverFactory.getDriver());
	LogoutPage logout = new LogoutPage(DriverFactory.getDriver());
	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private int rowcount;
			
//	@Given("Admin is logged into application")
//	public void admin_is_logged_into_application() {
//		
//		logout.login();
//		loginpage.selectrole();
//		loginpage.clicklogin();
//	  
//	}

	@When("Admin click program button")
	public void admin_click_program_button() throws InterruptedException {
	    
		pagination.clickProgram();
		
	}

//
//	@Given("Admin is on Program page")
//	public void admin_is_on_program_page() {
//		
//
//		String title = loginpage.getpagetitle();
//		Assert.assertEquals(title,"LMS");
//	   
//	}

	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
		
		pagination.clickNext();
	    
	}

	@Then("Admin should see the Pagination has Next active link")
	public void admin_should_see_the_pagination_has_next_active_link() {
	    
		
		String isenable =	pagination.Nextisactive();
		Assert.assertEquals(isenable, "true");
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() {
		
		pagination.doubleNext();
	    
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
		
		String isdisble =	pagination.disableNextcheck();
		Assert.assertEquals(isdisble, "true");
	    
	}

	@Given("Admin is on last page of Program page table")
	public void admin_is_on_last_page_of_program_page_table() {
		ProgramPage.program();
		
		pagination.goToLastPageUsingNextButton();
			    
	}

	@When("Admin clicks Previous page link")
	public void admin_clicks_previous_page_link() {
		
		pagination.clickPrevious();
	   
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
		
		int pagenumber = pagination.getCurrentPageNumber(10);
		System.out.println(pagenumber);
		int previouspage = pagination.getTotalPages(10);
		System.out.println(previouspage);
		Assert.assertTrue(pagenumber == previouspage-1);
	    
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {
	    
		String title = loginpage.getpagetitle();
		Assert.assertEquals(title , "LMS");
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
		
		pagination.clickFirst();
	    
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
		
		String isenable = pagination.checkPreviousbutton();
		System.out.println(isenable);
		Assert.assertEquals(isenable ,"true");
	   
	}


	@Then("Admin should not see any pagination icons and message {string}")
	public void admin_should_not_see_any_pagination_icons_and_message(String Expectedtext) {
		
		if (rowcount == 0) {
			System.out.println(rowcount);
		String isdisable =	pagination.disableNextcheck();
		    Assert.assertEquals(isdisable , true);
			Assert.assertTrue(false , Expectedtext);	
		}else
			
			Assert.fail("Test failed because rows exist when they shouldn't.");
	
		
		
	}
	@Then("Admin should see pagination icons disabled")
	public void admin_should_see_pagination_icons_disabled() {
	    
		//rowcount = pagination.getRows();
		if(rowcount < 5) {
			String isdisable =	pagination.disableNextcheck();
		    Assert.assertEquals(isdisable , "true");
		    isdisable =pagination.Nextisactive();
		    Assert.assertEquals(isdisable , "true");
		    
		}
		
		Assert.fail("Test failed because rows count is > 5");
	}


}
