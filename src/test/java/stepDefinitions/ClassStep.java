package stepDefinitions;

import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.*;
import pageObjectRepository.ClassAddPage;
import pageObjectRepository.ClassEditPage;
import pageObjectRepository.ClassLogoutPage;
import pageObjectRepository.ClassMultiDelete;
import pageObjectRepository.ClassPage;
import pageObjectRepository.ClassPagination;
import pageObjectRepository.ClassSearchPage;
import pageObjectRepository.ClassSortingPage;

public class ClassStep {

	private ClassPage classMod = new ClassPage(DriverFactory.getDriver());
	private ClassAddPage classAdd = new ClassAddPage(DriverFactory.getDriver());
	private ClassEditPage classEdit = new ClassEditPage(DriverFactory.getDriver());
	private ClassPagination classPage = new ClassPagination(DriverFactory.getDriver());
	private ClassSortingPage classSort = new ClassSortingPage(DriverFactory.getDriver());
	private ClassSearchPage classSearch = new ClassSearchPage(DriverFactory.getDriver());
	private ClassMultiDelete classMulDel = new ClassMultiDelete(DriverFactory.getDriver());
	private ClassLogoutPage classLogout = new ClassLogoutPage(DriverFactory.getDriver());

	@When("Admin clicks the Class Navigation bar in the Header")
	public void admin_clicks_the_class_navigation_bar_in_the_header() {
		classMod.clickClass();
	}

	@Then("Admin should land on the Manage class page")
	public void admin_should_land_on_the_manage_class_page() {
		Assert.assertTrue(classMod.validatemanageClassPage());
	}

	@Then("Admin should see the {string} Header")
	public void admin_should_see_the_header(String expHeader) {
		String actHeader = classMod.validateManageClassHeader();
		Assert.assertEquals(actHeader, expHeader);
	}

	@Then("Admin should see the Search Bar in Manage class page")
	public void admin_should_see_the_search_bar_in_manage_class_page() {
		Assert.assertTrue(classMod.checkSearchBarVisibility());
	}

	@Then("Admin should see the datatable heading like Batchname,class topic,class description,status,class Date,staff name,Edit\\/Delete")
	public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_description_status_class_date_staff_name_edit_delete() {
		Assert.assertTrue(classMod.checkDataTableHeading());
	}

	@Then("Admin should see the {string} and enabled pagination controls under the data table")
	public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table(String string) {
		Assert.assertTrue(classMod.checkPagnatnText());
		Assert.assertTrue(classMod.checkPagntnControls());
	}

	@Then("Admin should see the Sort icon of all the field in the datatable.")
	public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable() {
		Assert.assertTrue(classMod.checkSortIconsVisibility());
	}

	@Then("Admin should see the Delete button under the Manage class page header.")
	public void admin_should_see_the_delete_button_under_the_manage_class_page_header() {
		Assert.assertTrue(classMod.checkDelBtnVisibility());
	}

	@Then("Admin should see Total no of classes in below of the data table.")
	public void admin_should_see_total_no_of_classes_in_below_of_the_data_table() {
		Assert.assertTrue(classMod.validateTotalNumOfClass());
	}

	@When("Admin clicks a add new class under the class menu bar")
	public void admin_clicks_a_add_new_class_under_the_class_menu_bar() throws InterruptedException {
		classAdd.clickAddNewClass();
	}

	@Then("Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_class_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		Assert.assertTrue(classAdd.validateClassDetailsPopUpWindow());
	}

	@Then("Admin should see few input fields and their respective text boxes in the class details window")
	public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {
		Assert.assertTrue(classAdd.validateInputFields());
	}

	@Given("Admin is on the Class Popup window")
	public void admin_is_on_the_class_popup_window() {
		classAdd.admnIsOnPopUpWndow();
	}

	@When("Admin enters mandatory fields in the form and clicks on save button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button() throws InterruptedException {
		classAdd.enterMandtryFields("Python101", "yewret", "Testing", "February", "2025", "25", "Saranya M");
	}

	@Then("Admin gets message Class added Successfully")
	public void admin_gets_message_class_added_successfully() {
		Assert.assertTrue(classAdd.verifySuccessfullyClsCreatd());
	}

	@When("Admin selects class date in date picker")
	public void admin_selects_class_date_in_date_picker() {
		classAdd.selectClassDate("February", "2025", "25");
	}

	@Then("Admin should see no of class value is added automatically")
	public void admin_should_see_no_of_class_value_is_added_automatically() {
		classAdd.checkClsValueAdded();
	}

	@When("Admin clicks date picker")
	public void admin_clicks_date_picker() throws InterruptedException {
		classAdd.clickDatePickr();
	}

	@Then("Admin should see weekends dates are disabled to select")
	public void admin_should_see_weekends_dates_are_disabled_to_select() {
		Assert.assertTrue(classAdd.verifyWeekndsDisables());
	}

	@When("Admin skips to add value in mandatory field and enter only the optional field")
	public void admin_skips_to_add_value_in_mandatory_field_and_enter_only_the_optional_field() {
		classAdd.enterOptnalFields("Advanced Java", "Class daily", "Yes", "Provide");
	}

	@Then("Admin should see error message below the test field and the field will be highlighted in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighted_in_red_color() {
		Assert.assertTrue(classAdd.verifyFieldErrMsgAndErrTextColor());
	}

	@When("Admin enters invalid data in all of the fields in the form and clicks on save button")
	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_save_button()
			throws InterruptedException {
		classAdd.enterInvalidDatas("Python101", "1234", "12356", "February", "2025", "25", "Kevin Thomas");
	}

	@Then("Admin gets error message and class is not created")
	public void admin_gets_error_message_and_class_is_not_created() {
		Assert.assertTrue(classAdd.verifyErrMsg());
	}

	@When("Admin clicks on save button without entering data in the class pop up window")
	public void admin_clicks_on_save_button_without_entering_data_in_the_class_pop_up_window() {
		classAdd.clickSaveBtn();
	}

	@Then("class will not be created and Admin gets error message")
	public void class_will_not_be_created_and_admin_gets_error_message() {
		classAdd.checkAdminGetsErrMsg();
	}

	@When("Admin clicks Cancel Icon on Admin Details form")
	public void admin_clicks_cancel_icon_on_admin_details_form() throws InterruptedException {
		classAdd.clickCancelBtn("Python101", "reewret", "KK-Testing", "February", "2025", "25", "Kevin  Thomas");
	}

	@Then("Class Details popup window should be closed without saving")
	public void class_details_popup_window_should_be_closed_without_saving() {
		Assert.assertTrue(classAdd.verifyValuesNotSaved("Python101", "reewret", "KK-Testing", "Active", "2/25/25",
				"Kevin  Thomas"));
	}

	@When("Admin clicks save button in the class pop up window")
	public void admin_clicks_save_button_in_the_class_pop_up_window() throws InterruptedException {
		classAdd.clickSaveIcon("Micro service-01", "qeeret", "Testing", "February", "2025", "25", "arunasel S");
	}

	@Then("Admin can see the class details popup closed and adding new class")
	public void admin_can_see_the_class_details_popup_closed_and_adding_new_class() {
		Assert.assertTrue(
				classAdd.verifyValuesSaved("Micro service-01", "qeeret", "Testing", "Active", "2/25/25", "arunasel S"));
	}

//===========================================Class Edit===============================================	

	@Given("Admin is on the Manage Class page")
	public void admin_is_on_the_manage_class_page() {
		String expHeader = "Manage Class";
		String actHeader = classEdit.validateManageClassPage();
		Assert.assertEquals(actHeader, expHeader);
	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
		classEdit.clickEditIcon("Micro service-01", "JJ-Github", "Testing", "Active", "2/25/25", "arunasel S");
	}

	@Then("A new pop up with class details appears")
	public void a_new_pop_up_with_class_details_appears() {
		Assert.assertTrue(classEdit.checkClsDtilsAppears());
	}

	@Then("Admin should see batch name field is disabled")
	public void admin_should_see_batch_name_field_is_disabled() {
		Assert.assertTrue(classEdit.verifyBatNameDisabled());
	}

	@Then("Admin should see class topic field is disabled")
	public void admin_should_see_class_topic_field_is_disabled() {
		Assert.assertTrue(classEdit.verifyClsTopicDisabled());
	}

	@Given("Admin is on the Edit Class Popup window")
	public void admin_is_on_the_edit_class_popup_window() {
		classEdit.adminIsOnEditPopUpWndw("viewret");
	}

	@When("Update the fields with valid data and click save")
	public void update_the_fields_with_valid_data_and_click_save() {
		classEdit.updateFields("Testing-WW");
	}

	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
		Assert.assertTrue(classEdit.verifyUpdatdSuccesMsg());
	}

	@When("Update the fields with invalid values and click save")
	public void update_the_fields_with_invalid_values_and_click_save() {
		classEdit.updateWithInvalidValues("12er34ffg");
	}

	@Then("Admin should get Error message")
	public void admin_should_get_error_message() {
		Assert.assertTrue(classEdit.verifyUpdateErrMsg());
	}

	@When("Update the mandatory fields with valid values and click save")
	public void update_the_mandatory_fields_with_valid_values_and_click_save() {
		classEdit.updateMandatryFields("Kevin Thomas");
	}

	@When("Update the optional fields with valid values and click save")
	public void update_the_optional_fields_with_valid_values_and_click_save() {
		classEdit.updateOptionalFields("About Testing", "Kevin Thomas");
	}

	@When("Admin enters only numbers or special char in the text fields")
	public void admin_enters_only_numbers_or_special_char_in_the_text_fields() {
		classEdit.updateWithNumOrSpecialChar("123%%", "456&&**", "Kevin Thomas");
	}

	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		classEdit.clickCancelBtn();
	}

	@Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
	public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_class()
			throws InterruptedException {
		Assert.assertTrue(classEdit.checkPopupWindowDisappears());
	}

//============================================Pagination==============================================

	@When("Admin clicks Next page link on the class table")
	public void admin_clicks_next_page_link_on_the_class_table() throws InterruptedException {
		classPage.clickNxtPage();
	}

	@Then("Admin should see the next page record on the table with Pagination has next active link enabled")
	public void admin_should_see_the_next_page_record_on_the_table_with_pagination_has_next_active_link_enabled() {
		Assert.assertTrue(classPage.checkAdminSeeNxtPagRec());
	}

	@When("Admin clicks Last page link in the class manage page")
	public void admin_clicks_last_page_link_in_the_class_manage_page() {
		classPage.clickLastPage();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
		classPage.checkAdminSeeLastPage();
	}

	@Given("Admin is on last page of class table")
	public void admin_is_on_last_page_of_class_table() throws InterruptedException {
		classPage.adminOnLastPage();
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
		classPage.clickFirstPage();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link enabled")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link_enabled() {
		Assert.assertTrue(classPage.adminSeePreViousPage());
	}

	@Given("Admin is on Previous class page")
	public void admin_is_on_previous_class_page() throws InterruptedException {
		classPage.clickNxtPage();
	}

	@When("Admin clicks Start page link")
	public void admin_clicks_start_page_link() {
		classPage.clickStartPage();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled in the class manage page")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled_in_the_class_manage_page() {
		Assert.assertTrue(classPage.checkAdminSeeFirstPage());
	}

//===========================================Sorting==================================================

	@When("Admin clicks on the Batchname sort icon")
	public void admin_clicks_on_the_batchname_sort_icon() {
		classSort.clickBatNameSortIcon();
	}

	@Then("Admin should see Class details are sorted by Batch Name")
	public void admin_should_see_class_details_are_sorted_by_batch_name() {
		Assert.assertTrue(classSort.checkDetilsSortedByBatName());
	}

	@When("Admin clicks on the Class topic sort icon")
	public void admin_clicks_on_the_class_topic_sort_icon() {
		classSort.clickClsTopicSortIcon();
	}

	@Then("Admin should see Class details are sorted by Class Topic")
	public void admin_should_see_class_details_are_sorted_by_class_topic() {
		Assert.assertTrue(classSort.checkDetilsSortedByclsTopic());
	}

	@When("Admin clicks on the Class description sort icon in class manage page")
	public void admin_clicks_on_the_class_description_sort_icon_in_class_manage_page() {
		classSort.clickClsDescSortIcon();
	}

	@Then("Admin should see Class details are sorted by Class Description in class manage page")
	public void admin_should_see_class_details_are_sorted_by_class_description_in_class_manage_page() {
		Assert.assertTrue(classSort.checkDetilsSortedByclsDescrptn());
	}

	@When("Admin clicks on the Status sort icon")
	public void admin_clicks_on_the_status_sort_icon() {
		classSort.clickClsStatusSortIcon();
	}

	@Then("Admin should see Class details are sorted by Status")
	public void admin_should_see_class_details_are_sorted_by_status() {
		Assert.assertTrue(classSort.checkDetailsSortedByclsStatus());
	}

	@When("Admin clicks on the Class Date sort icon")
	public void admin_clicks_on_the_class_date_sort_icon() {
		classSort.clickClsDateSortIcon();
	}

	@Then("Admin should see Class details are sorted by Class Date")
	public void admin_should_see_class_details_are_sorted_by_class_date() {
		Assert.assertTrue(classSort.checkDetailsSortedByClsDate());
	}

	@When("Admin clicks on the Staff Name sort icon")
	public void admin_clicks_on_the_staff_name_sort_icon() {
		classSort.clickClsStafSortIcon();
	}

	@Then("Admin should see Class details are sorted by Staff name")
	public void admin_should_see_class_details_are_sorted_by_staff_name() {
		Assert.assertTrue(classSort.checkDetailsSortedByclsStatus());
	}

	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
		classSort.clickDelIcon();
	}

	@Then("Admin should see a alert open with heading {string} along with <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
		Assert.assertTrue(classSort.checkDeltnAlertBox());
	}

	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
		classSort.clickDelIcon();

	}

	@When("Admin clicks yes option")
	public void admin_clicks_yes_option() {
		classSort.clickYesOptn();
	}

	@Then("Admin gets a message {string} alert and do not see that Class in the data table")
	public void admin_gets_a_message_alert_and_do_not_see_that_class_in_the_data_table(String string) {
		Assert.assertTrue(classSort.verifyClsDelSuccesMsg());
	}

	@When("Admin clicks No option")
	public void admin_clicks_no_option() {
		classSort.clickNoOptn();
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
		classSort.deltnAlertBoxDisappear();
	}

	@When("Admin clicks on close button")
	public void admin_clicks_on_close_button() {
		classSort.clickCloseBtn();
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() throws InterruptedException {
		Assert.assertTrue(classSort.deltnAlertBoxClosed());
	}

//=================================================Class Search=======================================

	@When("Admin enter the Batch Name in search textbox")
	public void admin_enter_the_batch_name_in_search_textbox() {
		classSearch.enterInsearchBar("Python101");
	}

	@Then("Admin should see Class details are searched by Batch Name")
	public void admin_should_see_class_details_are_searched_by_batch_name() throws InterruptedException {
		Assert.assertTrue(classSearch.checkClsDetailsSearchdByBatName("Python101"));
	}

	@When("Admin enter the Class topic in search textbox")
	public void admin_enter_the_class_topic_in_search_textbox() {
		classSearch.enterInsearchBar("zewret");
	}

	@Then("Admin should see Class details are searched by Class topic")
	public void admin_should_see_class_details_are_searched_by_class_topic() {
		classSearch.checkClsDetailsSearchdByclsTopic("zewret");
	}

	@When("Admin enter the Staff Name in search textbox")
	public void admin_enter_the_staff_name_in_search_textbox() {
		classSearch.enterInsearchBar("Getha Takur");
	}

	@Then("Admin should see Class details are searched by Staff name")
	public void admin_should_see_class_details_are_searched_by_staff_name() {
		Assert.assertTrue(classSearch.checkClsDetailsSearchdByclsStaff());
	}

//============================================Multiple Delete=========================================

	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() {
		classMulDel.clickChkBox();
	}

	@Then("Admin should see common delete option enabled under header Manage class")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_class() {
		Assert.assertTrue(classMulDel.verifyCommonDelBtnEnabld());
	}

	@Given("Admin is on Confirm Deletion alert box")
	public void admin_is_on_confirm_deletion_alert_box() throws InterruptedException {
		classMulDel.adminIsOnDeltnAlertBox("yewret");
	}

	@When("Admin clicks <YES> button on the class deletion alert")
	public void admin_clicks_yes_button_on_the_on_the_class_deletion_alert() {
		classMulDel.clickYesBtn();
	}

	@Then("Admin should land on Manage class page and can see the selected class is deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_deleted_from_the_data_table() {
		Assert.assertTrue(classMulDel.checkClassIsDeltd());
	}

	@Given("Admin is on Confirm Deletion alert pop up")
	public void admin_is_on_confirm_deletion_alert_pop_up() throws InterruptedException {
		classMulDel.clickDelteIcon("High");
	}

	@When("Admin clicks <NO> button on the class deletion alert")
	public void admin_clicks_no_button_on_the_class_deletion_alert() {
		classMulDel.clickNoBtn();
	}

	@Then("Admin should land on Manage class page and can see the selected class is not deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_not_deleted_from_the_data_table() {
		classMulDel.verifyClsIsNotDeltd("High");
	}

	@Given("Admin is on Confirm Deletion alert after clicks multiple check boxes in the class manage page")
	public void admin_is_on_confirm_deletion_alert_after_clicks_multiple_check_boxes_in_the_class_manage_page() {
		classMulDel.adminIsOnDelAlertBoxForMulDel("reewret");
	}

	@Then("Admin should land on Manage class page and can see the selected class are deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_are_deleted_from_the_data_table() {
		Assert.assertTrue(classMulDel.checkMultiClsAreDeltd());
	}

	@Given("Admin is on Confirm Deletion alert box after clicks multiple check boxes")
	public void admin_is_on_confirm_deletion_alert_box_after_clicks_multiple_check_boxes() {
		classMulDel.adminIsOnDelAlertPopUpForMulDel("qeeret");
	}

	@Then("Admin should land on Manage class page and can see the selected class are not deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_are_not_deleted_from_the_data_table() {
		classMulDel.verifyMultiClsAreNotDeltd("qeeret");
	}

//=============================================Class LogOut===========================================

	@When("Admin clicks on Class link on Manage Class page")
	public void admin_clicks_on_class_link_on_manage_class_page() throws InterruptedException {
		classLogout.clickClassBtn();
	}

	@Then("Admin is redirected to class page")
	public void admin_is_redirected_to_class_page() {
		String expUrl = "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/session";
		Assert.assertTrue(classLogout.verifyAdminOnClassPage(expUrl));
	}

	@When("Admin clicks on any page link on Manage Class page")
	public void admin_clicks_on_any_page_link_on_manage_class_page() {
		classLogout.clickBatchBtn();
	}

	@Then("Admin is redirected to which page link they clicked.")
	public void admin_is_redirected_to_which_page_link_they_clicked() {
		String expUrl = "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/batch";
		Assert.assertTrue(classLogout.verifyAdminOnBatchPage(expUrl));
	}

	@When("Admin clicks on Logout link on Manage class page")
	public void admin_clicks_on_logout_link_on_manage_class_page() {
		classLogout.clickLogoutBtn();
	}

	@Then("Admin is redirected to Login page")
	public void admin_is_redirected_to_login_page() {
		String expUrl = "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/login";
		Assert.assertTrue(classLogout.verifyAdminOnLoginPage(expUrl));
	}

}
