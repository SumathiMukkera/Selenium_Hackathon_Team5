package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepository.*;

public class ProgramEditStep {
	WebDriver driver = DriverFactory.getDriver();
	ProgramPage ProgramPage = new ProgramPage(driver);
	ProgramEditPage ProgramEditPage = new ProgramEditPage(driver);
	ProgramAddNewPage ProgramAddNewPage = new ProgramAddNewPage(driver);

	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program() {
		driver.navigate().refresh();
		ProgramEditPage.clickEditProgramButton();
	}

	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form() {
		Assert.assertTrue(ProgramEditPage.editPageTitleDisplay());
	}

	@Then("Admin should see editwindow title as {string}")
	public void admin_should_see_editwindow_title_as(String expectedtext) {
		String actualtext = ProgramEditPage.editPageTitle();
		Assert.assertEquals(actualtext, expectedtext, "Text did not match");
	}

	@When("Admin edits {string} in the {string} text box and click on save button")
	public void admin_edits_in_the_text_box_and_click_on_save_button(String fieldName, String fieldValue) {
		driver.navigate().refresh();
		ProgramEditPage.clickEditProgramButton();
		ProgramAddNewPage.enterTextInField(fieldName, fieldValue);
	}

	@When("Admin edits the program name and click on save button {string} and {int}")
	public void admin_edits_the_program_name_and_click_on_save_button_and(String sheetName, int rowNumber) {
		driver.navigate().refresh();
		ProgramEditPage.clickEditProgramButton();
		try {
			ProgramEditPage.editNameFieldAndSearch(sheetName, rowNumber);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Then("Updated program name is seen by the Admin")
	public void updated_program_name_is_seen_by_the_admin() {
		Assert.assertTrue(ProgramEditPage.isProgramNameDisplayed());
	}

	@When("Admin edits the program description and click on save button {string} and {int}")
	public void admin_edits_the_program_description_and_click_on_save_button_and(String sheetName, int rowNumber) {
		driver.navigate().refresh();
		ProgramEditPage.clickEditProgramButton();
		try {
			ProgramEditPage.editDescriptionFieldAndSearch(sheetName, rowNumber);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Then("Updated program description is seen by the Admin")
	public void updated_program_description_is_seen_by_the_admin() {
		Assert.assertTrue(ProgramEditPage.isProgramDescriptionDisplayed());
	}

	@When("Admin edits editprogram form and click on save button {string} and {int}")
	public void admin_edits_editprogram_form_and_click_on_save_button_and(String sheetName, int rowNumber) {
		driver.navigate().refresh();
		ProgramEditPage.clickEditProgramButton();
		try {
			ProgramEditPage.editProgramEditField(sheetName, rowNumber);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ProgramEditPage.clickSaveOption();
	}

	@Then("Admin can see the updated program details")
	public void admin_can_see_the_updated_program_details() {
		Assert.assertTrue(ProgramEditPage.isProgramNameDisplayed());
		Assert.assertTrue(ProgramEditPage.isProgramDescriptionDisplayed());
	}
	@When("Admin can change the status of the program and click on save button {string} and {int}")
	public void admin_can_change_the_status_of_the_program_and_click_on_save_button_and(String string, Integer int1) {
	   driver.navigate().refresh();
	   ProgramEditPage.clickEditProgramButton();
	   ProgramEditPage.changeStatus();
	   ProgramEditPage.clickSaveOption();
	}
	@Then("Status updated can be viewed by the Admin")
	public void status_updated_can_be_viewed_by_the_admin() {
	    
	}

	

}
