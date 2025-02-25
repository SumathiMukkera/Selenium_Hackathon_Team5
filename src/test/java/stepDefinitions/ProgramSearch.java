package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepository.ProgramAddNewPage;
import pageObjectRepository.ProgramDeletePage;
import pageObjectRepository.ProgramEditPage;
import pageObjectRepository.*;

public class ProgramSearch {

	WebDriver driver = DriverFactory.getDriver();

	ProgramSearchPage programSearchPage = new ProgramSearchPage(driver);

	@When("Admin enter the program to search By program name {string} and {int}")
	public void admin_enter_program_to_search_by_program_name(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException {
		driver.navigate().refresh();

		programSearchPage.searchWithProgramName(sheetName, rowNumber);

	}

	@Then("Admin should able to see Program name, description, and status for searched program name")
	public void admin_should_see_program_name_description_and_status() {
		Assert.assertTrue(programSearchPage.isProgramNameDisplayed(), "Program name is not displayed!");
		Assert.assertTrue(programSearchPage.isProgramDescriptionDisplayed(), "Program description is not displayed!");
		Assert.assertTrue(programSearchPage.isProgramStatusDisplayed(), "Program status is not displayed!");
	}

	@When("Admin enter the program to search By program description {string} and {int}")
	public void admin_enter_program_to_search_by_program_description(String sheetName, int rowNumber) {
		driver.navigate().refresh();
		try {
			programSearchPage.searchWithProgramDescription(sheetName, rowNumber);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Then("Admin should able to see Program name, description, and status for searched program description")
	public void admin_should_see_program_name_description_and_status_for_description() {
		Assert.assertTrue(programSearchPage.isProgramNameDisplayed(), "Program name is not displayed!");
		Assert.assertTrue(programSearchPage.isProgramDescriptionDisplayed(), "Program description is not displayed!");
		Assert.assertTrue(programSearchPage.isProgramStatusDisplayed(), "Program status is not displayed!");
	}

	@When("Admin enter the program to search By program name that does not exist {string} and {int}")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist(String sheetName, int rowNumber) {
		driver.navigate().refresh();
		try {
			programSearchPage.searchWithProgramNotExist(sheetName, rowNumber);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@When("Admin enter the program to search By partial name of program {string} and {int}")
	public void admin_enter_the_program_to_search_by_partial_name(String sheetName, int rowNumber) {
		driver.navigate().refresh();
		try {
			programSearchPage.searchWithPartialProgramName(sheetName, rowNumber);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// -----------------Sorting------------------------

	@When("Admin clicks on Arrow next to programName")
	public void admin_clicks_on_arrow_next_to_program_name() {
		driver.navigate().refresh();
		programSearchPage.clickArrowNextToProgramName();
	}

	@Then("ProgramName is sorted in ascending order")
	public void program_name_is_sorted_in_ascending_order() {

		Assert.assertTrue(programSearchPage.verifyAscending());
	}

	@When("Admin clicks on the arrow next to ProgramName again")
	public void admin_clicks_on_the_arrow_next_to_program_name() {
		programSearchPage.clickAscending();
	}

	@Then("ProgramName is sorted in descending order")
	public void program_name_is_sorted_in_descending_order() {
		Assert.assertTrue(programSearchPage.verifyDescending());
	}

	@When("Admin clicks on Arrow next to programDescription")
	public void admin_clicks_on_arrow_next_to_program_description() {
		driver.navigate().refresh();
		programSearchPage.clickArrowNextToProgramDescription();
	}

	@Then("ProgramDescription is sorted in ascending order")
	public void program_description_is_sorted_in_ascending_order() {
		Assert.assertTrue(programSearchPage.verifyAscending());
	}

	@When("Admin clicks on the arrow next to ProgramDescription again")
	public void admin_clicks_on_the_arrow_next_to_program_description_again() {
		programSearchPage.clickAscending();
	}

	@Then("ProgramDescription is sorted in descending order")
	public void program_description_is_sorted_in_descending_order() {
		Assert.assertTrue(programSearchPage.verifyDescending());
	}

	@When("Admin clicks on Arrow next to programStatus")
	public void admin_clicks_on_arrow_next_to_program_status() {
		driver.navigate().refresh();
		programSearchPage.clickArrowNextToProgramStatus();
	}

	@Then("ProgramStatus is sorted in ascending order")
	public void program_status_is_sorted_in_ascending_order() {
		Assert.assertTrue(programSearchPage.verifyAscending());
	}

	@When("Admin clicks on the arrow next to ProgramStatus again")
	public void admin_clicks_on_the_arrow_next_to_program_status_again() {
		programSearchPage.clickAscending();
	}

	@Then("ProgramStatus is sorted in descending order")
	public void program_status_is_sorted_in_descending_order() {
		Assert.assertTrue(programSearchPage.verifyDescending());
	}

}
