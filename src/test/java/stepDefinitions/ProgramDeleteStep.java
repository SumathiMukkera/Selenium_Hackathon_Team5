package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepository.*;
import utilitities.ExcelDataReader;

public class ProgramDeleteStep {

	WebDriver driver = DriverFactory.getDriver();
	ProgramPage ProgramPage = new ProgramPage(driver);
	ProgramDeletePage ProgramDeletePage = new ProgramDeletePage(driver);
	List<String> programnames;
	

	@When("Admin clicks on delete button for a program")
	public void admin_clicks_on_delete_button_for_a_program() {
		driver.navigate().refresh();
		ProgramDeletePage.verifyDeleteOption();
	}

	@Then("Admin will get confirm deletion popup")
	public void admin_will_get_confirm_deletion_popup() {
		Assert.assertTrue(ProgramDeletePage.verifyDeletePopUpConfirm());
	}

	@Given("Admin is on Confirm deletion form")
	public void admin_is_on_confirm_deletion_form() {
		ProgramPage.program();
		driver.navigate().refresh();
		ProgramDeletePage.verifyDeleteOption();
	}

	@When("Admin clicks on Yes button")
	public void admin_clicks_on_button() {
		ProgramDeletePage.verifyYesButton();
	}

	@Then("Admin can see message {string}")
	public void admin_can_see_message(String expectedText) {
		String actualText = ProgramDeletePage.verifySuccessDeleteMessage();
		System.out.println("actualText is " + actualText);
		Assert.assertEquals(actualText, expectedText, "Text did not match!");
	}

	@When("Admin searches for Deleted Program Name {string} and {int}")
	public void admin_searches_for_deleted_program(String sheetName, int rowNumber) {
		driver.navigate().refresh();
		try {
			ProgramDeletePage.searchWithDeletedProgramName(sheetName, rowNumber);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Then("There should be zero results")
	public void there_should_be_zero_results() throws InterruptedException {
	   
		int resultCount =(ProgramDeletePage.getSearchResultsCount());
		System.out.println("resultCount is " + resultCount);
		Assert.assertEquals(resultCount, 0, "Deleted program still appears in the search results!");
	}

	@When("Admin clicks on No button")
	public void admin_clicks_on_no_button() {
		ProgramDeletePage.clickNoButton();
	}

	@Then("Admin can see Confirmation form disappears")
	public void Admin_can_see_Confirmation_form_disappears() {
		Assert.assertTrue(ProgramDeletePage.isdeleteDetailsFormInvisible(),
				"Program Details form did not disappear after clicking Cancel");
	}

	@When("Admin Clicks on X button")
	public void admin_clicks_on_X_button() {
		ProgramDeletePage.verifyXButton();
	}

	@When("Admin selects more than one program by clicking on the checkbox")
	public void admin_selects_multiple_programs() {
		driver.navigate().refresh();
		int programCount = ProgramDeletePage.getProgramCount();
		System.out.println("DEBUG: Total programs available - " + programCount);

		if (programCount < 2) {
			Assert.fail("Not enough programs available to select. Test cannot proceed.");
		}

		ProgramDeletePage.selectMultiplePrograms(2);
	}

	@Then("Programs get selected")
	public void programs_get_selected() {

		List<String> selectedPrograms = ProgramDeletePage.getSelectedPrograms();
		Assert.assertTrue(selectedPrograms.size() > 1);
	}

	@When("Admin clicks on the delete button on the left top of the program page")
	public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page() {
		driver.navigate().refresh();
		int programCount = ProgramDeletePage.getProgramCount();
		System.out.println("DEBUG: Total programs available - " + programCount);

		if (programCount < 2) {
			Assert.fail("Not enough programs available to select. Test cannot proceed.");
		}

		ProgramDeletePage.selectMultiplePrograms(2);
		programnames = ProgramDeletePage.getSelectedPrograms();
		System.out.println(programnames);

		ProgramDeletePage.clickMultipleDeleteIcon();
	}

	@Then("Admin lands on Confirmation form")
	public void admin_lands_on_confirmation_form() {
		Assert.assertTrue(ProgramDeletePage.verifyDeletePopUpConfirm());
	}

	@Then("Admin see message {string}")
	public void Admin_clicks_yes_and_see_message(String expectedText) {
		ProgramDeletePage.verifyYesButton();
		String actualText = ProgramDeletePage.verifySuccessDeleteMessage();
		System.out.println("actualText is " + actualText);
		Assert.assertEquals(actualText, expectedText, "Text did not match!");
	}

	@When("Admin deletes the Programs Names")
	public void Admin_deletes_the_Programs_Names() {
		driver.navigate().refresh();
		int programCount = ProgramDeletePage.getProgramCount();
		System.out.println("DEBUG: Total programs available - " + programCount);

		if (programCount < 2) {
			Assert.fail("Not enough programs available to select. Test cannot proceed.");
		}
		ProgramDeletePage.selectMultiplePrograms(2);
		ProgramDeletePage.clickMultipleDeleteIcon();
		programnames = ProgramDeletePage.getSelectedPrograms();
		System.out.println(programnames);
		ProgramDeletePage.verifyDeletePopUpConfirm();
		ProgramDeletePage.verifyYesButton();
	}

	@When("Admin Searches for Deleted Program names")
	public void admin_searches_for_deleted() {
		driver.navigate().refresh();

		for (String programName : programnames) {
			ProgramDeletePage.searchProgram(programName);
			int resultCount = ProgramDeletePage.getSearchResultsCount();
			System.out.println("resultCount is " + resultCount);
			System.out.println("DEBUG: Searching for " + programName + " - Found results: " + resultCount);
			Assert.assertEquals(0, resultCount);
		}
	}

	@Then("Admin see Programs are still selected and not deleted")
	public void admin_clicks_no_and_see_programs_are_still_selected_and_not_deleted() {
		ProgramDeletePage.clickNoButton();
		for (String programName : programnames) {
			ProgramDeletePage.searchProgram(programName);
			int resultCount = ProgramDeletePage.getSearchResultsCount();
			System.out.println("DEBUG: Searching for " + programName + " - Found results: " + resultCount);
			Assert.assertTrue(resultCount > 0, "Program " + programName + " was deleted, but it should still exist!");
		}
	}

}
