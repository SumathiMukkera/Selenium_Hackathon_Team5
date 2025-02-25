Feature: Search Text box validation

Background: Admin is on the batch page
  	Given Admin is on home page after Login

    Scenario: validate search box functionality
    Given Admin is on the batch page
    When Admin enters the batch name "test" in the search text box
    Then Admin should see the filtered batches containing "test" in the data table