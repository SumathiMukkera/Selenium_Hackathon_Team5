package pageObjectRepository;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BatchPage {

    WebDriver driver;

	public BatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//button[span/text()='Batch']")
	WebElement batchMenu;  //Clicking Batch after login on Dashboard

	@FindBy (xpath = "//button[text()='Add New Batch']")
	WebElement addNewBatchSubMenu;  //Clicking on sub menu
	
	@FindBy (xpath = "//mat-card-title//button[span/@class=\"p-button-icon pi pi-trash\"]")
	WebElement topDeleteIcon; //  Delete icon in Batch menu under manage batch
	
	@FindBy (xpath = "//*[text()=\" Manage Batch\"]")
	WebElement manageBatchLabel; // Manage batch Heading

	@FindBy (xpath = "//p-paginator//button[text()='1']")
	WebElement page1Button;

	@FindBy (xpath = "//div[@class='action']/span/button[@icon='pi pi-pencil']")
	List<WebElement> editIcons; //edit icon in data table
	
	@FindBy (xpath = "//tbody/tr")
	List<WebElement> tableRows;   //Data table rows

	@FindBy (xpath = "//div[@class='action']/span/button[@icon='pi pi-trash']")
	List<WebElement> deleteIcons;  //Delete icon in data table
	
	@FindBy (xpath = "//tbody//div[@role='checkbox']")
	List<WebElement> checkBoxes; // Check box in data table -- can use aria-checked = 'false' for disable

	@FindBy (xpath = "//th//div[@role='checkbox']")
	WebElement headerCheckBox;

	@FindBy (xpath = "//th[@psortablecolumn='batchName']")
	WebElement batchNameHeader;  //Batch name data table header
	
	@FindBy (xpath = "//th[@psortablecolumn='batchDescription']")
	WebElement batchDescription; //Batch description data table header
	
	@FindBy (xpath = "//th[@psortablecolumn='batchStatus']")
	WebElement batchStatus;  //Batch status data table header
	
	@FindBy (xpath = "//th[@psortablecolumn='batchNoOfClasses']")
	WebElement noOfClasses; // No of classes data table header
	
	@FindBy (xpath = "//th[@psortablecolumn='programName']")
	WebElement programName; //Program name data table header
	
	
	@FindBy (xpath = "//tr[@class='ng-star-inserted']/th[text()=' Edit / Delete ']")
	WebElement editDelete; //Edit and delete data table header
	
	@FindBy (xpath = "//*[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	List<WebElement> sortIcons;  //Sort icon next to headers in data table

	@FindBy (xpath = "//th[@psortablecolumn]")
	List<WebElement> sortableColumnHeaders;

	@FindBy (xpath = "//small[@id='text-danger']")
	WebElement inputErrorMsg; // Error message that shows under input

	@FindBy (xpath = "//*[@id=\"mat-menu-panel-1\"]/div/button")
	WebElement addNewBatchMenu; //Add new batch sub menu

	@FindBy (xpath = "//span[contains(@class, 'p-dialog-title') and text()='Batch Details']")
	WebElement batchDetailsWindow;  //Batch details window after clicking add new batch sub menu
	
	@FindBy (xpath = "//span[contains(@class, 'p-button-label') and text()='Cancel']")
	WebElement cancelButtonInBatchDetails; //Cancel button in batch details window
	
	@FindBy (xpath = "//span[contains(@class, 'p-button-label') and text()='Save']")
	WebElement saveButtonInBatchDetails;  //Save button in batch details window

	@FindBy (xpath = "//span[contains(@class, 'p-dialog-header-close-icon')]")
	WebElement closeButtonInBatchDetails;  //Save button in batch details window

	@FindBy (xpath = "//*[@id='programName']/div/input[@aria-haspopup='listbox' and @type='text' and @placeholder='Select a Program name']")
	WebElement selectProgramNameListBox; //List box for select program name in batch details window

	@FindBy (xpath = "//p-dropdown//span")
	WebElement selectProgramNameDropDown; //List box for select program name in batch details window, for selection

	@FindBy (xpath = "//input[@id='batchProg']")
	WebElement batchNameFirstInputBox;  //1st input box under batch name in batch details window
	
	@FindBy (xpath = "//input[@type = 'text' and @id='batchName']")
	WebElement batchNameSecondInputBox;  //2nd input box under batch name in batch details window
	
	@FindBy (xpath = "//input[@id='batchDescription' and @type = 'text']")
	WebElement batchDescriptionInputBox;  //Batch description input box in batch details window

	@FindBy (xpath = "//p-radiobutton[@id='batchStatus']")
	List<WebElement> batchStatuses;  //Batch status radio buttons in batch details window

	@FindBy(xpath = "//input[@id='ACTIVE']/ancestor::p-radiobutton")
	WebElement activeRadioOnBatchInput;

	@FindBy(xpath = "//input[@id='INACTIVE']/ancestor::p-radiobutton")
	WebElement inActiveRadioOnBatchInput;

	@FindBy(xpath = "//div[contains(@class, 'p-toast-detail') and contains(text(), ' Batch Created Successfully')]")
	WebElement batchCreatedSuccessfulToastMsg;

	@FindBy(xpath = "//div[contains(@class, 'p-toast-detail') and contains(text() , 'batch Updated')]")
	WebElement batchUpdatedSuccessfulToastMsg;

	@FindBy (xpath = "//input[@id='batchNoOfClasses' and @type = 'number']")
	WebElement numberOfClassedInputBox;  //No of classes input box in batch details window

	@FindBy (xpath = "//p-confirmdialog[.//span[text() = 'Confirm']]")
	WebElement confirmDialog;

	@FindBy (xpath = "//p-confirmdialog//button[.//span[text() = 'Yes']]")
	WebElement confirmDialogYesButton;

	@FindBy (xpath = "//p-confirmdialog//button[.//span[text() = 'No']]")
	WebElement confirmDialogNoButton;

	@FindBy (xpath = "//p-confirmdialog//button[contains(@class, 'p-dialog-header-close')]")
	WebElement confirmDialogCloseButton;

	@FindBy (xpath = "//p-toastitem[//div[text() = 'batch Deleted']]")
	WebElement toastSuccessfulDeletion;

	@FindBy (xpath = "//input[@id='filterGlobal']")
	WebElement searchBox; //Search box in main page

	@FindBy (xpath = "//button[span[contains(@class, 'pi-angle-right') and not(@disabled)]]")
	WebElement pageNextButton;   //Pagination ">" button

	@FindBy (xpath = "//button[span[contains(@class, 'pi-angle-left') and not(@disabled)]]")
	WebElement pagePreviousButton;

	@FindBy (xpath = "//button[span[contains(@class, 'pi-angle-double-left') and not(@disabled)]]")
	WebElement pageFirstButton;

	@FindBy (xpath = "//button[span[contains(@class, 'pi-angle-double-right') and not(@disabled)]]")
	WebElement pageLastPageButton;   //Pagination ">" button

	@FindBy (xpath = "//span/button[text() = '2' and contains(@class, 'p-highlight')]")
	WebElement highlightedPage2Button;

	@FindBy (xpath = "//span/button[text() = '1' and contains(@class, 'p-highlight')]")
	WebElement highlightedPage1Button;

    public void navigateToBatchPage() {
		this.openMenu("Batch");
	}
	
	public void clickOnBatchMenu() {
		addNewBatchSubMenu.click();
	}

	public void selectProgramNameInBatchDetailsPopup(Integer programNameIndex) {
		selectProgramNameDropDown.click();
		String programName = this.getProgramNameByIndex(programNameIndex);
		driver.findElement(By.xpath("//p-dropdownitem/li[span[contains(text(), '" + programName + "')]]")).click();
    }
	
	public void clickOnSave() {
		clickUsingJavascriptExecutor(saveButtonInBatchDetails);
	}
	
	public void clickOnCancel() {
		clickUsingJavascriptExecutor(cancelButtonInBatchDetails);
	}

	public boolean hasManageBatchLabel() {
		return manageBatchLabel.isDisplayed();
	}

	public boolean hasPageTitle(String title) {
		return driver.findElement(By.xpath("//app-header[//span/text() = '" + title + "']")).isDisplayed();
	}

	public boolean hasTopDeleteIconDisabled() {
		return topDeleteIcon.getDomAttribute("disabled") != null;
	}

	public boolean hasPage1Enabled() {
		return page1Button.getDomAttribute("disabled") == null;
	}

	public int editIconsCount() {
		return editIcons.size();
	}

	public int tableRowsCount() {
		return tableRows.size();
	}

	public int deleteIconsCount() {
		return deleteIcons.size();
	}

	public int checkBoxesCount() {
		return checkBoxes.size();
	}

	public boolean hasHeader(String title) {
		return driver.findElement(By.xpath("//th[contains(text(), '" + title + "')]")).isDisplayed();
	}

	public int sortableColumnsCount() {
		return sortableColumnHeaders.size();
	}

	public int sortIconsCount() {
		return sortIcons.size();
	}

	public boolean hasHeaderCheckBox() {
		return headerCheckBox.isDisplayed();
	}

	public void openMenu(String menuName) {
		switch (menuName) {
			case "Batch":
				clickUsingJavascriptExecutor(batchMenu);
				break;
		}
	}

	public boolean hasSubMenu(String subMenuName) {
		switch (subMenuName) {
			case "Add New Batch":
				return addNewBatchSubMenu.isDisplayed();
		}

		return false;
	}

	public void openSubMenu(String subMenuName) {
		switch (subMenuName) {
			case "Add New Batch":
				clickUsingJavascriptExecutor(addNewBatchSubMenu);
		}
	}

	public boolean isAddNewEditBatchPopupDisplaying() {
		return batchDetailsWindow.isDisplayed();
	}

	public boolean isFieldAndTypeDisplayedAppropriately(String fieldName) {
		switch (fieldName) {
			case "Batch Name":
				return batchNameSecondInputBox.isDisplayed();
			case "Program Name":
				return selectProgramNameListBox.isDisplayed();
			case "Description":
				return batchDescriptionInputBox.isDisplayed();
			case "Status":
				return batchStatuses.get(0).isDisplayed() && batchStatuses.get(1).isDisplayed();
			case "Number of Classes":
				return numberOfClassedInputBox.isDisplayed();
		}

		return false;
	}

	public boolean isFieldEnabled(String fieldName) {
		switch (fieldName) {
			case "Batch Name":
				return batchNameSecondInputBox.getDomAttribute("disabled") == null;
			case "Program Name":
				return selectProgramNameListBox.getDomAttribute("disabled") == null;
			case "Description":
				return batchDescriptionInputBox.getDomAttribute("disabled") == null;
			case "Status":
				return batchStatuses.get(0).getDomAttribute("disabled") == null
						&& batchStatuses.get(1).getDomAttribute("disabled") == null;
			case "Number of Classes":
				return numberOfClassedInputBox.getDomAttribute("disabled") == null;
		}

		return false;
	}

	public String getTextOnBatchNamePrefix() {
		return batchNameFirstInputBox.getDomProperty("value");
	}

	public String getInputErrorMsg() {
		return inputErrorMsg.getText();
	}

	public void setBatchNameSuffix(String suffix) {
		batchNameSecondInputBox.sendKeys(suffix);
	}

	public void setBatchNamePrefix(String prefix) {
		batchNameFirstInputBox.sendKeys(prefix);
	}

	public void provideMandatoryNewBatchInputs(Integer programNameIndex, String batchSuffix, String description, String isActive, Integer noOfClasses) {
		this.selectProgramNameInBatchDetailsPopup(programNameIndex);
		this.setBatchNameSuffix(batchSuffix);
		batchDescriptionInputBox.sendKeys(description);
		if (isActive.equals("TRUE")) {
            activeRadioOnBatchInput.click();
		}
		else {
			inActiveRadioOnBatchInput.click();
		}
		numberOfClassedInputBox.sendKeys(noOfClasses.toString());
	}

	public String getProgramNameByIndex(Integer programNameIndex) {
		return driver.findElement(By.xpath("(//p-dropdownitem/li/span)[" + programNameIndex + "]")).getText();
	}

	public boolean checkIfBatchCreatedSuccessToastDisplayed() {
		return batchCreatedSuccessfulToastMsg.isDisplayed();
	}

	public boolean checkIfBatchUpdatedSuccessToastDisplayed() {
		return batchUpdatedSuccessfulToastMsg.isDisplayed();
	}

	public void clickOnClose() {
		closeButtonInBatchDetails.click();
		sleepForMillis(500);
	}

	public void deleteABatchByIndex(int index) {
		clickUsingJavascriptExecutor(deleteIcons.get(index - 1));
	}

	public boolean isDeleteConfirmationDialogDisplayed() {
		sleepForMillis(500);
		return confirmDialog.isDisplayed();
	}

	public boolean doesConfirmationDialogHasYesButton() {
		return confirmDialogYesButton.isDisplayed();
	}

	public boolean doesConfirmationDialogHasNoButton() {
		return confirmDialogNoButton.isDisplayed();
	}

	public boolean checkIfBatchDeleteSuccessToastIsDisplayed() {
		return toastSuccessfulDeletion.isDisplayed();
	}

	public void confirmDeletion() {
		clickUsingJavascriptExecutor(confirmDialogYesButton);
	}

	public void declineDeletion() {
		clickUsingJavascriptExecutor(confirmDialogNoButton);
	}

	public void closeDeletion() {
		clickUsingJavascriptExecutor(confirmDialogCloseButton);
	}

	public void editABatchByIndex(int index) {
		clickUsingJavascriptExecutor(editIcons.get(index - 1));
	}

	public void setDescriptionTextOnAddEditPopup(String text) {
		batchDescriptionInputBox.clear();
		batchDescriptionInputBox.sendKeys(text);
	}

	public void clickUsingJavascriptExecutor(WebElement element) {
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", element);
	}

	public void provideMandatoryEditBatchInputs(String description, String isActive, Integer noOfClasses) {
		batchDescriptionInputBox.sendKeys(description);
		if (isActive.equals("TRUE")) {
			clickUsingJavascriptExecutor(activeRadioOnBatchInput);
		}
		else {
			clickUsingJavascriptExecutor(inActiveRadioOnBatchInput);
		}
		numberOfClassedInputBox.sendKeys(noOfClasses.toString());
	}

	public void clickOnDelete() {
		clickUsingJavascriptExecutor(topDeleteIcon);
	}

	public void selectABatchByDescription(String description) {
		WebElement batch = driver.findElement(By.xpath("//tbody/tr[./td[text() = '" + description + "']]/td/p-tablecheckbox//input"));
		clickUsingJavascriptExecutor(batch);
	}

	public int getCountOfBatchesMatchingByDescription(String description) {
		List<WebElement> matchingBatches = driver.findElements(By.xpath("//tbody/tr[./td[text() = '" + description + "']]"));
		return matchingBatches.size();
	}

	public void waitForToastToDisappear() {
		sleepForMillis(5000);
    }

	public void enterSearchText(String searchText) {
		searchBox.clear();
		searchBox.sendKeys(searchText);
		searchBox.sendKeys(Keys.ENTER);
	}

	public int getMatchingRowsCount(String searchText) {
		List<WebElement> batches = driver.findElements(By.xpath("//tbody/tr[./td[contains(text(), '" + searchText + "')]]"));
		return batches.size();
	}

	public void clickOnNextPageOnPagination() {
		sleepForMillis(5000);
        clickUsingJavascriptExecutor(pageNextButton);
	}

	private void sleepForMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

	public boolean isOnPage2() {
		return highlightedPage2Button.isDisplayed();
	}

	public void clickOnLastPageOnPagination() {
		sleepForMillis(500);
		clickUsingJavascriptExecutor(pageLastPageButton);
	}

	public boolean isNextPageEnabled() {
		return pageNextButton.isEnabled();
	}

	public void clickOnPreviousPageOnPagination() {
		sleepForMillis(500);
		clickUsingJavascriptExecutor(pagePreviousButton);
	}

	public boolean isOnPage1() {
		return highlightedPage1Button.isDisplayed();
	}

	public void clickOnFirstPageOnPagination() {
		sleepForMillis(500);
		clickUsingJavascriptExecutor(pageFirstButton);
	}
}