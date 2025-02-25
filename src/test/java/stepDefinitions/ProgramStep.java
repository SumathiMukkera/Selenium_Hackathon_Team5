package stepDefinitions;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepository.ProgramPage;

public class ProgramStep {

	WebDriver driver = DriverFactory.getDriver();
	ProgramPage ProgramPage = new ProgramPage(driver);


	@When("Admin clicks Program on the navigation bar")
	public void admin_clicks_on_the_navigation_bar() {
		ProgramPage.program();
	}

	@Then("Admin should be navigated to Program page")
	public void admin_should_be_navigated_to_program_page() {
		Assert.assertTrue(ProgramPage.textDisplayOfProgramPage());
	}

//TC2		
	@Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {
		Assert.assertTrue(ProgramPage.logOut());
	}

//TC3
	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String expectedtext) {
		String actualtext = ProgramPage.lmsTextDisplayOnMenuBar();
		Assert.assertEquals(actualtext, expectedtext, "Text Did Not Matched");
	}

//TC4
	@Then("Admin should see the page names as in order {string}")
	public void admin_should_see_the_page_names_as_in_order(String expectedorder) {
		List<String> expectedOrderList = Arrays.asList(expectedorder.split(" "));
		List<String> actualorder = ProgramPage.verifyMenuBarOrder();
		System.out.println("Actual Menu Order: " + actualorder);
		System.out.println("Expected Menu Order: " + expectedOrderList);
		Assert.assertEquals(actualorder, expectedOrderList, "Text Did Not Matched");
	}

//TC5
	@Then("Admin should see the heading as {string}")
	public void admin_should_see_the_heading_as(String expectedtext) {
		String actualtext = ProgramPage.textDisplayManageProgram();
		Assert.assertEquals(actualtext, expectedtext, "Text Did Not Matched");

	}

//TC6
	@Then("Admin should able to see Program name, description, and status for each program")
	public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {
		Assert.assertTrue(ProgramPage.verifyManageProgramthreeColumns());

	}

//TC7
	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
		// Assert.assertTrue(ProgramPage.multipleDeleteButton());
		Assert.assertFalse(ProgramPage.multipleDeleteButton(),
				"The Delete button should be disabled, but it is enabled!");
	}

//TC8
	@Then("Admin should see Search bar displayed with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String expectedtext) {
		String actualtext = ProgramPage.verifySearchBarText();
		System.out.println("actualtext is" + actualtext);
		Assert.assertEquals(actualtext, expectedtext, "Text Did Not Matched");
	}

//TC9
	@Then("Admin should see data table with column header on the Manage Program Page as {string}")
	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete(
			String expectedtext) {
		List<String> expectedHeaderList = Arrays.asList(expectedtext.split(", "));
		List<String> actualtext = ProgramPage.manageTableColumnHeaders();
		System.out.println("actualtext is" + actualtext);
		Assert.assertEquals(actualtext, expectedHeaderList, "Headers Did Not Matched");
	}

//TC10
	@Then("Admin should see checkbox default state as unchecked beside Program Name column header")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header() {
		Assert.assertFalse(ProgramPage.verifyCheckboxUnchecked());
	}

//TC11
	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		Assert.assertTrue(ProgramPage.verifyCheckboxStatusBesideAllPrograms());
	}

//TC12
	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		Assert.assertTrue(ProgramPage.arrowBesideEachColumn());
	}

//TC13
	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		Assert.assertTrue(ProgramPage.verifyEditAndDeleteButtonForEachRow());
	}

//TC14
	@Then("Admin should see the text as {string} along with Pagination icon below the table. x- starting record number on that pagey-ending record number on that pagez-Total number of records")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table_x_starting_record_number_on_that_pagey_ending_record_number_on_that_pagez_total_number_of_records(
			String expectedtext) throws TimeoutException {
		Assert.assertTrue(ProgramPage.paginationIconAndText());
	}

//TC15
	@Then("Admin should see the footer as In total there are z programs.z- Total number of records")
	public void admin_should_see_the_footer_as_z_total_number_of_records() {

		Assert.assertTrue(ProgramPage.verifyfootermessage());
	}
	
	
	

}
