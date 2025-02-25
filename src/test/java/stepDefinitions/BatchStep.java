package stepDefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjectRepository.BatchPage;
import pageObjectRepository.HomePage;
import pageObjectRepository.LoginPage;

import java.util.List;

import static org.testng.AssertJUnit.*;

public class BatchStep {

	WebDriver driver = DriverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	BatchPage batchPage = new BatchPage(driver);

	@Given("Admin is on the home page")
	public void admin_is_on_the_home_page() {
		homePage.navigateToHomePage();
	}

	@When("Admin Clicks on the Batch menu from the header")
	@Given("Admin is on the batch page")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		homePage.navigateToHomePage();
		batchPage.navigateToBatchPage();
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
		assertTrue(batchPage.hasManageBatchLabel());
	}

	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String title) {
	    assertTrue(batchPage.hasPageTitle(title));
	}

	@Then("Admin should see the Manage Batch heading")
	public void admin_should_see_the_manage_batch_heading() {
		assertTrue(batchPage.hasManageBatchLabel());
	}

	@Then("Admin should see the disabled Delete Icon under the header")
	public void admin_should_see_the_disabled_delete_icon_under_the_header() {
		assertTrue(batchPage.hasTopDeleteIconDisabled());
	}

	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
	    assertTrue(batchPage.hasPage1Enabled());
	}

	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		int expectedCount = batchPage.tableRowsCount();
		int actualCount = batchPage.editIconsCount();

		assertEquals(expectedCount, actualCount);
	}

	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		int expectedCount = batchPage.tableRowsCount();
		int actualCount = batchPage.deleteIconsCount();

		assertEquals(expectedCount, actualCount);
	}

	@Then("Admin should see the checkbox in each row")
	public void admin_should_see_the_checkbox_in_each_row() {
		int expectedCount = batchPage.tableRowsCount();
		int actualCount = batchPage.checkBoxesCount();

		assertEquals(expectedCount, actualCount);
	}

	@Then("Admin should see the datatable header with {string}")
	public void admin_should_see_the_datatable_header_with(String title) {
		assertTrue(batchPage.hasHeader(title));
	}

	@Then("Admin should see the checkbox in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		assertTrue(batchPage.hasHeaderCheckBox());
	}

	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		int expectedCount = batchPage.sortableColumnsCount();
		int actualCount = batchPage.sortIconsCount();

		assertEquals(expectedCount, actualCount);
	}
	
	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String menuName) {
		batchPage.openMenu(menuName);
	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String subMenuName) {
		assertTrue(batchPage.hasSubMenu(subMenuName));
	}

	@When("Admin clicks on {string} under the Batch menu bar")
	@Given("Admin is on the Batch Details Pop Up Window by clicking sub menu {string}")
	public void admin_clicks_on_under_the_menu_bar(String subMenuName) {
		batchPage.openMenu("Batch");
		batchPage.openSubMenu(subMenuName);
    }

	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		assertTrue(batchPage.isAddNewEditBatchPopupDisplaying());
	}

	@When("Admin checks the field {string} is enabled")
	public void admin_checks_all_the_fields_are_enabled(String fieldName) {
		assertTrue(batchPage.isFieldEnabled(fieldName));
	}

	@Then("The pop up should include the field {string}")
	public void the_pop_up_should_include_the_field(String fieldName) {
		assertTrue(batchPage.isFieldAndTypeDisplayedAppropriately(fieldName));
	}

	@When("Admin selects program name index {int} present in the dropdown")
	public void admin_selects_program_name_present_in_the_dropdown(Integer programNameIndex) {
		batchPage.selectProgramNameInBatchDetailsPopup(programNameIndex);
	}

	@Then("Admin should see selected program name index {int} in the batch name prefix box")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box(Integer programNameIndex) {
		String expectedProgramName = batchPage.getProgramNameByIndex(programNameIndex);
		assertEquals(expectedProgramName, batchPage.getTextOnBatchNamePrefix());
	}

	@When("Admin enters alphabets in batch name suffix box")
	public void admin_enters_alphabets_in_batch_name_suffix_box() {
	    batchPage.setBatchNameSuffix("abc");
	}

	@Then("Admin should get error message below the text box of respective field")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field() {
		String expectedMsg = "This field accept only numbers and max 5 count.";
		String actualMsg = batchPage.getInputErrorMsg();

		assertEquals(expectedMsg, actualMsg);
	}

	@When("Admin enters alphabets in batch name prefix box")
	public void admin_enters_alphabets_in_batch_name_prefix_box() {
	    batchPage.setBatchNamePrefix("abc");
	}

	@Then("Admin should see empty text box")
	public void admin_should_see_empty_text_box() {
	    String actual = batchPage.getTextOnBatchNamePrefix();
		String expected = "";

		assertEquals(expected, actual);
	}

	@When("Admin enters the data only to the mandatory fields program index: {int} suffix: {string} description: {string} active: {string} noOfClasses: {int} and clicks save button")
	public void admin_enters_the_data_only_to_the_mandatory_fields_and_clicks_save_button(Integer programNameIndex, String batchSuffix, String description, String isActive, Integer noOfClasses) {
	    batchPage.provideMandatoryNewBatchInputs(programNameIndex, batchSuffix, description, isActive, noOfClasses);
		batchPage.clickOnSave();
		batchPage.waitForToastToDisappear();
	}

	@Then("Admin should get a successful message")
	public void admin_should_get_a_successful_message() {
		assertTrue(batchPage.checkIfBatchCreatedSuccessToastDisplayed());
	}

	@When("Admin leaves blank one of the mandatory fields")
	public void admin_leaves_blank_one_of_the_mandatory_fields() {
		batchPage.provideMandatoryNewBatchInputs(1, "", "test", "TRUE", 1);
		batchPage.clickOnSave();
	}

	@Then("Admin should get a error message on the respective mandatory field")
	public void admin_should_get_a_error_message_on_the_respective_mandatory_field() {
		String expectedMsg = "Batch Name is required.";
		String actualMsg = batchPage.getInputErrorMsg();

		assertEquals(expectedMsg, actualMsg);
	}

	@When("Admin enters the valid data to all the mandatory fields and click save button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button() {
		batchPage.provideMandatoryEditBatchInputs("test edit", "TRUE", 5);
		batchPage.clickOnSave();
	}

	@When("Admin enters the valid data to all the mandatory edit fields and click cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_edit_fields_and_click_cancel_button() {
		batchPage.provideMandatoryEditBatchInputs("test edit", "TRUE", 5);
		batchPage.clickOnCancel();
	}

	@When("Admin enters the valid data to all the mandatory fields and click cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button() {
		batchPage.provideMandatoryNewBatchInputs(1, "000", "test", "TRUE", 1);
		batchPage.clickOnCancel();
	}

	@Then("Admin can see the batch details popup closes without creating any batch")
	public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {
		try {
			batchPage.checkIfBatchCreatedSuccessToastDisplayed();
		}
		catch (NoSuchElementException ex) {
			assertTrue(true);
			return;
		}

		fail("Toast message should not be displayed");
	}

	@When("Admin clicks on the close icon")
	public void admin_clicks_on_the_close_icon() throws InterruptedException {
	    batchPage.clickOnClose();
	}

	@Then("batch details pop up closes")
	public void batch_details_pop_up_closes() {
		try {
			batchPage.isAddNewEditBatchPopupDisplaying();
		}
		catch (NoSuchElementException ex)
		{
			assertTrue(true);
			return;
        }

        fail("Add new batch popup should be closed");
	}



	@When("Admin clicks the delete Icon on any row")
	public void admin_clicks_the_delete_icon_on_any_row() {
	    batchPage.deleteABatchByIndex(1);
	}

	@Then("Admin should see the confirm alert box with yes and no button")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button() {
        assertTrue(batchPage.isDeleteConfirmationDialogDisplayed());
	    assertTrue(batchPage.doesConfirmationDialogHasYesButton());
	    assertTrue(batchPage.doesConfirmationDialogHasNoButton());
	}

	@Given("Admin is on the batch confirm popup page")
	public void admin_is_on_the_batch_confirm_popup_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks on the delete icon and click yes button")
	public void admin_clicks_on_the_delete_icon_and_click_yes_button() {
		batchPage.deleteABatchByIndex(1);
		batchPage.confirmDeletion();
	}

	@Then("Admin should see the successful message and the batch should be deleted")
	public void admin_should_see_the_successful_message_and_the_batch_should_be_deleted() {
        assertTrue(batchPage.checkIfBatchDeleteSuccessToastIsDisplayed());
	}

	@When("Admin clicks on the delete icon and click no button")
	public void admin_clicks_on_the_delete_icon_and_click_no_button() {
		batchPage.deleteABatchByIndex(1);
		batchPage.declineDeletion();
	}

	@Then("Admin should see the alert box closed and the batch is not deleted")
	@Then("Admin should see the alert box closed")
	public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted() {
		try {
			batchPage.isDeleteConfirmationDialogDisplayed();
		}
		catch (NoSuchElementException ex) {
			assertTrue(true);
			return;
		}

		fail("The confirmation dialog should close");
	}

	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
		batchPage.editABatchByIndex(1);
	}


	@Then("Admin should see Program name value field is disabled for editing")
	public void admin_should_see_program_name_value_field_is_disabled_for_editing() {
	    assertFalse(batchPage.isFieldEnabled("Program Name"));
	}

	@Then("Admin should see batch name value field is disabled for editing")
	public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
		assertFalse(batchPage.isFieldEnabled("Batch Name"));
	}

	@Given("Admin is on the Batch Details Page")
	public void admin_is_on_the_batch_details_page() {
		admin_clicks_on_the_batch_menu_from_the_header();
		admin_clicks_the_edit_icon();
	}

	@When("Admin Updates any fields with invalid data and click save button")
	public void admin_updates_any_fields_with_invalid_data_and_click_save_button() {
		batchPage.setDescriptionTextOnAddEditPopup("a");
		batchPage.clickOnSave();
	}

	@Then("Admin should get a error message under the respective field")
	public void admin_should_get_a_error_message_under_the_respective_field() {
		String expectedMsg = "This field should start with an alphabet and min 2 character.";
		String actualMsg = batchPage.getInputErrorMsg();

		assertEquals(expectedMsg, actualMsg);
	}

	@Then("Admin should get a successful message for editing the batch")
	public void admin_should_get_a_successful_message_for_editing_the_batch() {
		assertTrue(batchPage.checkIfBatchUpdatedSuccessToastDisplayed());
	}

	
	@Then("Admin can see the batch details popup closes without editing the batch")
	public void admin_can_see_the_batch_details_popup_closes_without_editing_the_batch() {
		try {
			batchPage.checkIfBatchUpdatedSuccessToastDisplayed();
		}
		catch (NoSuchElementException ex) {
			assertTrue(true);
			return;
		}

		fail("Toast message should not be displayed");
	}

	@When("Admin clicks on the logout button")
	public void admin_clicks_on_the_logout_button() {

	}

	@Then("Admin should see the Login screen Page")
	public void admin_should_see_the_login_screen_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	@When("Admin clicks on the delete icon under the Manage batch header")
	public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header() {
        batchPage.clickOnDelete();
		batchPage.confirmDeletion();
	}

	@Then("The respective row in the table should be deleted")
	public void the_respective_row_in_the_table_should_be_deleted() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	@When("Admin clicks next page link on the data table")
	public void admin_clicks_next_page_link_on_the_data_table() {
		batchPage.clickOnNextPageOnPagination();
	}

	@Then("Admin should see the Next page")
	public void admin_should_see_the_next_page() {
		assertTrue(batchPage.isOnPage2());
	}

	@When("Admin clicks last page link on the data table")
	public void admin_clicks_last_page_link_on_the_data_table() {
		batchPage.clickOnLastPageOnPagination();
	}

	@Then("Admin should see the last page link with next page link disabled on the table")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() {
		assertFalse(batchPage.isNextPageEnabled());
	}

	@When("Admin clicks previous page link on the data table")
	public void admin_clicks_previous_page_link_on_the_data_table() {
		batchPage.clickOnPreviousPageOnPagination();
	}

	@Then("Admin should see the previous page on the table")
	@Then("Admin should see the very first page on the data table")
	public void admin_should_see_the_previous_page_on_the_table() {
		assertTrue(batchPage.isOnPage1());
	}

	@When("Admin clicks first page link on the data table")
	public void admin_clicks_first_page_link_on_the_data_table() {
		batchPage.clickOnFirstPageOnPagination();
	}

	@When("Admin enters the batch name {string} in the search text box")
	public void admin_enters_the_batch_name_in_the_search_text_box(String searchText) {
		batchPage.enterSearchText(searchText);
	}

	@Then("Admin should see the filtered batches containing {string} in the data table")
	public void admin_should_see_the_filtered_batches_in_the_data_table(String searchText) {
		int count = batchPage.getMatchingRowsCount(searchText);
		assertTrue(count > 0);
	}

	// For background, replace this later
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		loginPage.navigateToLoginPage();
	}

	@And("User enters valid credentials {string} and {string}")
	public void user_enters_valid_credentials_and(String userName, String password) {
		loginPage.enterCredentials(userName, password);
	}

	@And("User selects the Admin role")
	public void user_selects_the_role() {
		loginPage.selectAdminRole();
	}

	@And("User clicks on login")
	public void user_clicks_on_login() {
		loginPage.login();
	}

	@When("Admin clicks on the delete icon and click on close icon")
	public void admin_clicks_on_the_delete_icon_and_click_on_close_icon() {
		batchPage.deleteABatchByIndex(1);
		batchPage.closeDeletion();
	}

	@When("Admin selects a batch with description {string}")
	public void admin_selects_a_batch_with_description(String description) {
		batchPage.selectABatchByDescription(description);
    }

	@Then("The respective row with description {string} and batch suffix {string} in the table should be deleted")
	public void the_respective_row_with_description_in_the_table_should_be_deleted(String description, String suffix) {
		batchPage.enterSearchText(suffix);
		int batchCount = batchPage.getCountOfBatchesMatchingByDescription(description);
		assertEquals(0, batchCount);
	}
}