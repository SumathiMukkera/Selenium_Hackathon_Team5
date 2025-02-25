Feature: Batch Functionality
Background: Add New Batch details pop up
  Given Admin is on home page after Login
  
    Scenario Outline: Validate all the fields exist in pop up
    Given Admin clicks on "Add New Batch" under the Batch menu bar
    When Admin checks the field "<fieldName>" is enabled
    Then The pop up should include the field "<fieldName>"
        Examples:
            |fieldName|
            |Batch Name|
            |Program Name|
            |Description|
            |Status|
            |Number of Classes|

    Scenario: Validate batchname prefix selected program name
    Given Admin is on the Batch Details Pop Up Window by clicking sub menu "Add New Batch"
    When Admin selects program name index 1 present in the dropdown
    Then Admin should see selected program name index 1 in the batch name prefix box

    Scenario: Validate batch name suffix box should accept only numbers
    Given Admin is on the Batch Details Pop Up Window by clicking sub menu "Add New Batch"
    When Admin enters alphabets in batch name suffix box
    Then Admin should get error message below the text box of respective field

    Scenario: Validate batch name prefix box is not editable
    Given Admin is on the Batch Details Pop Up Window by clicking sub menu "Add New Batch"
    When Admin enters alphabets in batch name prefix box
    Then Admin should see empty text box

    Scenario: Validate input data only for mandatory fields
    Given Admin is on the Batch Details Pop Up Window by clicking sub menu "Add New Batch"
    When Admin enters the data only to the mandatory fields program index: 1 suffix: "777" description: "Test" active: "TRUE" noOfClasses: 1 and clicks save button
    Then Admin should get a successful message

    Scenario: validate input data missing for mandatory fields
    Given Admin is on the Batch Details Pop Up Window by clicking sub menu "Add New Batch"
    When Admin leaves blank one of the mandatory fields
    Then Admin should get a error message on the respective mandatory field

    Scenario: validate save button in Batch details pop up
    Given Admin is on the Batch Details Pop Up Window by clicking sub menu "Add New Batch"
    When Admin enters the data only to the mandatory fields program index: 1 suffix: "555" description: "Test" active: "TRUE" noOfClasses: 2 and clicks save button
    Then Admin should get a successful message

    Scenario: validate cancel button in Batch details pop up
    Given Admin is on the Batch Details Pop Up Window by clicking sub menu "Add New Batch"
    When Admin enters the valid data to all the mandatory fields and click cancel button
    Then Admin can see the batch details popup closes without creating any batch

    Scenario: validate close icon on the batch details pop up
    Given Admin is on the Batch Details Pop Up Window by clicking sub menu "Add New Batch"
    When Admin clicks on the close icon
    Then batch details pop up closes