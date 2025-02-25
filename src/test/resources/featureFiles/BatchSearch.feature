Feature: Search Text box validation

Background: Admin is on the batch page
    Given User is on the login page
    And User enters valid credentials "sdetnumpyninja@gmail.com" and "Feb@2025"
    And User selects the Admin role
    And User clicks on login

    Scenario: validate search box functionality
    Given Admin is on the batch page
    When Admin enters the batch name "test" in the search text box
    Then Admin should see the filtered batches containing "test" in the data table