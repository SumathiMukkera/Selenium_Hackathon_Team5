Feature: Delete multiple batches with checkbox

Background: Admin is on the batch page
    Given User is on the login page
    And User enters valid credentials "sdetnumpyninja@gmail.com" and "Feb@2025"
    And User selects the Admin role
    And User clicks on login

    Scenario: Validate single row delete with checkbox
    Given Admin is on the batch page
        And Admin is on the Batch Details Pop Up Window by clicking sub menu "Add New Batch"
        And Admin enters the data only to the mandatory fields program index: 1 suffix: "105" description: "TestDescToDelete01" active: "TRUE" noOfClasses: 2 and clicks save button
    When Admin enters the batch name "105" in the search text box
        And Admin selects a batch with description "TestDescToDelete01"
        And Admin clicks on the delete icon under the Manage batch header
    Then The respective row with description "TestDescToDelete01" and batch suffix "105" in the table should be deleted

    Scenario: Validate multiple row delete with checkbox
    Given Admin is on the batch page
        And Admin is on the Batch Details Pop Up Window by clicking sub menu "Add New Batch"
        And Admin enters the data only to the mandatory fields program index: 1 suffix: "1011" description: "TestDescToDelete0011" active: "TRUE" noOfClasses: 2 and clicks save button
        And Admin is on the Batch Details Pop Up Window by clicking sub menu "Add New Batch"
        And Admin enters the data only to the mandatory fields program index: 1 suffix: "2011" description: "TestDescToDelete2011" active: "TRUE" noOfClasses: 2 and clicks save button
    When Admin enters the batch name "011" in the search text box
        And Admin selects a batch with description "TestDescToDelete0011"
        And Admin selects a batch with description "TestDescToDelete2011"
        And Admin clicks on the delete icon under the Manage batch header
    Then The respective row with description "TestDescToDelete0011" and batch suffix "011" in the table should be deleted
        And The respective row with description "TestDescToDelete2011" and batch suffix "011" in the table should be deleted