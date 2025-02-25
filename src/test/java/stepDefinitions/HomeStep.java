package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import driverFactory.DriverFactory;
import pageObjectRepository.HomePage;

public class HomeStep 
{
	HomePage hp=new HomePage(DriverFactory.getDriver());
	//WebDriver driver=new ChromeDriver();
//	@Given("Admin is on login Page")
//	public void admin_is_on_login_page() 
//	{
//		hp.landOnloginpage();   
//	    
//	}

//	@When("Admin enter valid data in all field and clicks login button")
//	public void admin_enter_valid_data_in_all_field_and_clicks_login_button() 
//	{
//  hp.login();
//	      
//	}

	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() 
	{
		
		hp.validateLmsTitle();
	      
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() 
	{
   hp.verifyTitlePosition();
	      
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() 
	{
   hp.verifyNevigationbarTextSpelling();
	      
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
  
	      hp.veryfyTitleSpelling();
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
  hp.check_AlignmentOfTextField();
	      
	}

	@Then("Admin should see home in the 1st place")
	public void admin_should_see_home_in_the_1st_place() throws InterruptedException {
		hp.checkTextPosition("Home");
	      
	}

	@Then("Admin should see program in the 2nd place")
	public void admin_should_see_program_in_the_2nd_place() throws InterruptedException {
		hp.checkTextPosition("Program");
	      
	}

	@Then("Admin should see batch in the 3rd place")
	public void admin_should_see_batch_in_the_3rd_place() throws InterruptedException {
		hp.checkTextPosition("Batch");
	      
	}

	@Then("Admin should see class in the 4th place")
	public void admin_should_see_class_in_the_4th_place() throws InterruptedException {
		hp.checkTextPosition("Class");
	      
	}

	@Then("Admin should see logout in the 5th place")
	public void admin_should_see_logout_in_the_5th_place() throws InterruptedException {
		hp.checkTextPosition("Logout");
	      
	}

	@Then("Admin should see piechart")
	public void admin_should_see_piechart() 
	{
    hp.pieChartisAvailable();
	      
	}

	@Then("Admin should see welcome message with user name and role")
	public void admin_should_see_welcome_message_with_user_name_and_role() 
	{
    hp.verifyEelcomeMessageAndRole();
	      
	}

	@Then("Admin should see bar chart for Active and inactive user")
	public void admin_should_see_bar_chart_for_active_and_inactive_user() {
  
		hp.barChartisAvailable();
	}

	@Then("Admin should see user count Note : count includes Active and inactive")
	public void admin_should_see_user_count_note_count_includes_active_and_inactive() 
	{
  
	      hp.count("User");
	}

	@Then("Admin should see staff count Note : count includes Active and inactive")
	public void admin_should_see_staff_count_note_count_includes_active_and_inactive() {
		 hp.count("Staff");
	      
	}

	@Then("Admin should see Program count Note : count includes Active and inactive")
	public void admin_should_see_program_count_note_count_includes_active_and_inactive() {
		hp.count("Programs");
	      
	}

	@Then("Admin should see batch couNote : count includes Active and inactive")
	public void admin_should_see_batch_cou_note_count_includes_active_and_inactive() {
		 hp.count("Batches");
	      
	}

	@Then("Admin should see staff table with pagination icons")
	public void admin_should_see_staff_table_with_pagination_icons() 
	{
	hp.verifyPaginationIcons();
	      
	}

	@Then("Admin should see {int} staff data in a page")
	public void admin_should_see_staff_data_in_a_page(Integer int1) {
  hp.verifyFiveStaffdata();
	      
	}

	@Then("admin should see previous page icon disabled")
	public void admin_should_see_previous_page_icon_disabled() {
		 hp.verifyPreviouspageDisable();
	      
	}

	@Then("admin should see first page icon disabled")
	public void admin_should_see_first_page_icon_disabled() {
  
		hp.verifyFirstpageDisable();
	}
}











